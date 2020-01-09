// ksr.c, 159

//need to include spede.h, const-type.h, ext-data.h, tools.h
#include "spede.h"
#include "const-type.h"
#include "ext-data.h"
#include "tools.h"


// to create a process: alloc PID, PCB, and process stack
// build trapframe, initialize PCB, record PID to ready_que
void SpawnSR(func_p_t p) {     // arg: where process code starts
   int pid;

	if(QueEmpty(&avail_que)){
		cons_printf("Panic: out of PID!\n"); 
		breakpoint(); 
	}
	pid = DeQue(&avail_que); 
	Bzero((char *)&pcb[pid], sizeof(pcb_t));   
	pcb[pid].state = READY;  
  if(pid != IDLE) 
    EnQue(pid, &ready_que);
  MemCpy((char *)DRAM_START, (char *)p, STACK_MAX);
  pcb[pid].tf_p = (tf_t *)(DRAM_START + STACK_MAX - sizeof(tf_t));
  pcb[pid].tf_p -> efl = EF_DEFAULT_VALUE|EF_INTR;
  pcb[pid].tf_p -> cs = get_cs();
  pcb[pid].tf_p -> eip = DRAM_START;
}

// count run time and switch if hitting time limit
void TimerSR(void){
   int i;
   outportb(PIC_CONT_REG, TIMER_SERVED_VAL);
   sys_time_count++; 
   pcb[run_pid].time_count++;
   pcb[run_pid].total_time++;
   
   for(i=0; i < PROC_MAX; i++){ //check for any processes that need to be woken
     if((pcb[i].wake_time <= sys_time_count) && pcb[i].state == SLEEP)
       pcb[i].state = READY;
       EnQue(i, &ready_que

   if(run_pid == IDLE)
     return;

   if(pcb[run_pid].time_count == TIME_MAX){
    EnQue(run_pid, &ready_que);
    pcb[run_pid].state = READY;
    run_pid = NONE;
   }
}

void SyscallSR(void){
  switch(pcb[run_pid].tf_p->eax){
    case SYS_GET_PID:
      pcb[run_pid].tf_p ->ebx = run_pid;
      break;
    case SYS_GET_TIME:
      pcb[run_pid].tf_p ->ebx = run_pid;
      break;
    case SYS_SLEEP:
      SysSleep();
      break;
    case SYS_WRITE:
      SysWrite();
      break;
    default:
      cons_printf("Kernel Panic: no such syscall!\n");
      breakpoint();
  }
}

void SysSleep(void){
  int sleep_sec = pcb[run_pid].tf_p->ebx;
  pcb[run_pid].wake_time = (sleep_sec * 100) + sys_time_count;
  pcb[run_pid].state = SLEEP;
  run_pid = NONE;
}

void SysWrite(void){
  char *str = pcb[run_pid].tf_p->ebx;

}
