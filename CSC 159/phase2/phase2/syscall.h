//syscall.h
//

#ifndef _SYSCALL_
#define _SYSCALL_

int sys_get_pid(void);
int sys_get_time(void);
void sys_sleep(int sleep_sec);
void sys_write(int write);

#endif 
