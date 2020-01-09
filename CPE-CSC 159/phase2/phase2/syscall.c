//syscall.c
//system service calls for kernel services

#include "const-type.h"

int sys_get_pid(void){
  int pid;
  asm("movl %1, %%eax;  
       int $128;
       movl %%ebx, %0"    //after, copy ebx to return
      : "=g" (pid)        //output from asm()
      : "g" (SYS_GET_PID) //input to asm()
      : "eax", "ebx"      //clobbered registers
  );
  return pid;
}

int sys_get_time(void){
  int time;
  asm("movl %1, %%eax;
       int $128;
       movl %%ebx, %0"
      : "=g" (time)
      : "g" (SYS_GET_TIME)
      : "eax", "ebx"
  );
  return time;
}

void sys_sleep(int sleep_sec){
  asm("movl %0, %%eax;
       movl %1, %%ebx;
       int $128"
      :     //no outputs
      : "g" (SYS_SLEEP), "g" (sleep_sec) //2 inputs to asm()
      : "eax", "ebx"
  );
}

void sys_write(char *write){
  asm("movl %0, %%eax;
       movl %1, %%ebx;
       int $128"
      :
      : "g" (SYS_WRITE), "g" (write)
      : "eax", "ebx"
  );
}

