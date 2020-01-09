// proc.c, 159
// processes are coded here

#include "const-type.h"
#include "ext-data.h"


void Idle(void){
  int flag = 0;
  unsigned short *top_left = (unsigned short *)0xb8000;
  if(sys_time_count % 100 == 0){
    if(flag == 0){
      *(top_left) = '.' + VGA_MASK_VAL;
      flag =1;
    }
    if(flag == 1){
      *(top_left) = ' ' +VGA_MASK_VAL;
      flag = 0;
    }
  }
}

