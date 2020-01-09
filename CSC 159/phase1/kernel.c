// kernel.c, 159, phase 1
//
// Team Name: ??????? (Members: ??????...)

#include "spede.h"
#include "const-type.h"
#include "entry.h"    // entries to kernel (TimerEntry, etc.)
#include "tools.h"    // small handy functions
#include "ksr.h"      // kernel service routines
#include "proc.h"     // all user process code here

// declare kernel data
int run_pid;// current running PID; if -1, none selected
que_t avail_que, ready_que;// avail PID and those created/ready to run
pcb_t pcb[PROC_MAX];  // Process Control Blocks

unsigned int sys_time_count;//declare an unsigned integer: sys_time_count
struct i386_gate *idt;         // interrupt descriptor table

void BootStrap(void){         // set up kernel!
   int i;
   sys_time_count = 0;//set sys time count to zero
   Bzero((char *)&avail_que, sizeof(que_t));//call tool Bzero() to clear avail queue
   Bzero((char *)&ready_que, sizeof(que_t));//call tool Bzero() to clear ready que
   for(i = 0; i<QUE_MAX; i++){
    EnQue(i, &avail_que);//enqueue all the available PID numbers to avail queue
   }
   idt = get_idt_base();//get IDT location
   fill_gate(&idt[TIMER_EVENT], (int)TimerEntry, get_cs(), ACC_INTR_GATE,0);//addr of TimerEntry is placed into proper IDT entry
   outportb(PIC_MASK_REG, PIC_MASK_VAL);//send PIC control register the mask value for timer handling
}

int main(void) {               // OS starts
   BootStrap();

   SpawnSR(Idle);              // create Idle thread
   run_pid = IDLE;
   Loader(pcb[run_pid].tf_p);

   return 0; // never would actually reach here
}

void Scheduler(void) {              // choose a run_pid to run
   if(run_pid > IDLE) return;       // a user PID is already picked

   if(QueEmpty(&ready_que)) {
      run_pid = IDLE;               // use the Idle thread
   } 
   else{
      pcb[IDLE].state = READY;
      run_pid = DeQue(&ready_que);  // pick a different proc
   }

   pcb[run_pid].time_count = 0;     // reset runtime count
   pcb[run_pid].state = RUN;
}

void Kernel(tf_t *tf_p) {       // kernel runs
  char ch;
  pcb[run_pid].tf_p = tf_p;
  TimerSR();
  if(cons_kbhit()){
    ch = cons_getchar();
    if(ch == 'b')
      breakpoint();
  }
  Scheduler();
  Loader(pcb[run_pid].tf_p);
}

