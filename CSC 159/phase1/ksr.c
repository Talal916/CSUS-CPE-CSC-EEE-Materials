// ksr.c, 159

#include "spede.h"
#include "const-type.h"
#include "ext-data.h"
#include "tools.h"
#include "proc.h"

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
   MemCpy((char *)DRAM_START, (char *)Idle, STACK_MAX);
   pcb[pid].tf_p = (tf_t *)(DRAM_START + STACK_MAX - sizeof(tf_t));
   pcb[pid].tf_p -> efl = EF_DEFAULT_VALUE|EF_INTR;
   pcb[pid].tf_p -> cs = get_cs();
   pcb[pid].tf_p -> eip = DRAM_START;
}

// count run time and switch if hitting time limit
void TimerSR(void) {
   outportb(PIC_CONT_REG, TIMER_SERVED_VAL);
   sys_time_count++;
   pcb[run_pid].time_count++;
   pcb[run_pid].total_time++;
   if(pcb[run_pid].time_count == TIME_MAX){
     pcb[run_pid].state = READY;
     EnQue(run_pid, &ready_que);
     run_pid = NONE;
   }
}

