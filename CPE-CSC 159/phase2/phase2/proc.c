// proc.c, 159
// processes are coded here

#include "const-type.h"
#include "ext-data.h"


void Idle(void){
  int flag = 0;
  unsigned short *top_left = VIDEO_START;
  while(1){
    if(sys_time_count % 100 == 0){
      if(flag == 0){
        *top_left = '*' + VGA_MASK_VAL;
        flag =1;
      }
      else{
        *top_left = ' ' +VGA_MASK_VAL;
        flag = 0;
      }
    }
  }
}

void Init(void){
  int my_pid, os_time;
  char pid_str[20], time_str[20];
  my_pid = sys_get_pid();
  Number2str(my_pid, pid_str);
  while(1){
    sys_write("my PID is ");
    sys_write(pid_str); //should only need [0] & [1] i think
    sys_write("... ");
    sys_sleep(1);
    os_time = sys_get_time();
    Number2Str(os_time, time_str);
    sys_write("sys time is ");
    sys_write(time_str);
    sys_write("... ");
    sys_sleep(1);
  }
}

