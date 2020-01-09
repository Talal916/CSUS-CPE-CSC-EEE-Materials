// kernel.c, 159, phase 1
//
// Team Name: Thanos (Members: Reed Yoshida, Sergio Zavala)

#include "spede.h"
#include "const-type.h"
#include "entry.h"    // entries to kernel (TimerEntry, etc.)
#include "tools.h"    // small handy functions
#include "ksr.h"      // kernel service routines
#include "proc.h"     // all user process code here

// declare kernel data
int run_pid;
que_t avail_que, ready_que;
pcb_t pcb[PROC_MAX];

//declare an unsigned integer: sys_time_count
unsigned int sys_time_count;
struct i386_gate *idt;         // interrupt descriptor table

unsigned short *sys_cursor; 

void BootStrap(void) {         // set up kernel!
   int i;
   sys_time_count = 0;
   *sys_cursor = VIDEO_START;
   Bzero((char *)&avail_que, sizeof(que_t));
   Bzero((char *)&ready_que, sizeof(que_t));
   for(i = 0; i < QUE_MAX;i++){	
	    EnQue(i, &avail_que);
   }
   idt = get_idt_base();
   fill_gate(&idt[TIMER_EVENT],(int)TimerEntry,get_cs(),ACC_INTR_GATE,0);
   fill_gate(&idt[EVENTCALL_EVENT],(int)SyscallEntry,get_cs(), ACC_INTR_GATE,0);
   outportb(PIC_MASK_REG, PIC_MASK_VAL);
}

int main(void) {               // OS starts
   BootStrap();

   SpawnSR(Idle);              // create Idle thread
   SpawnSR(Init);//needs to created Init here(Phase 2 not complete)
   run_pid = IDLE;
   Loader(pcb[run_pid].tf_p);
   
   return 0; // never would actually reach here
}

void Scheduler(void) {              // choose a run_pid to run
   if(run_pid > IDLE) return;       // a user PID is already picked

   if(QueEmpty(&ready_que)) {
      run_pid = IDLE;               // use the Idle thread
   } else {
      pcb[IDLE].state = READY;
      run_pid = DeQue(&ready_que);  // pick a different proc
   }

   pcb[run_pid].time_count = 0;     // reset runtime count
   pcb[run_pid].state = RUN;
}

void Kernel(tf_t *tf_p) {       // kernel runs
   char ch;
   pcb[run_pid].tf_p = tf_p;
   switch(tf_p->event){
     case TIMER_EVENT:
        TimerSR();
        break;
     case SYSCALL_EVENT:
        SyscallSR();
        break;
     default:
        cons_printf("Kernel Panic: no such event!\n");
        breakpoint();
   }
   //if 'b' key on target PC is pressed, goto the GDB prompt
   if(cons_kbhit()) {
      ch = cons_getchar();
	    if(ch == 'b')
        breakpoint();
   }
   Scheduler();
   Loader(pcb[run_pid].tf_p);
}

