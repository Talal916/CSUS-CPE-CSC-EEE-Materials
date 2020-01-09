// ext-data.h, 159
// kernel data are all declared in kernel.c during bootstrap
// .c code, if needed these, include this

#ifndef _EXT_DATA_
#define _EXT_DATA_

#include "const-type.h"

extern int run_pid;
extern que_t avail_que, ready_que;
extern pcb_t pcb[PROC_MAX];
extern unsigned int sys_time_count;

#endif
