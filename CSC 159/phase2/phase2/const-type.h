// const-type.h, 159, needed constants & types

#ifndef _CONST_TYPE_           // to prevent name mangling recursion
#define _CONST_TYPE_           // to prevent name redefinition

#define TIMER_EVENT 32         // timer interrupt signal code
#define PIC_MASK_REG 0x21      // I/O loc # of PIC mask
#define PIC_MASK_VAL ~0x01     // mask code for PIC
#define PIC_CONT_REG 0x20      // I/O loc # of PIc control
#define TIMER_SERVED_VAL 0x60  // control code sent to PIC
#define VGA_MASK_VAL 0x0f00    // bold face, white on black

#define TIME_MAX 310            // max timer count, then rotate process
#define PROC_MAX 20             // max number of processes
#define STACK_MAX 4096          // process stack in bytes
#define QUE_MAX 20              // capacity of a process queue

#define NONE -1                 // to indicate none
#define IDLE 0                  // Idle thread PID 0
#define DRAM_START 0xe00000     // 14 MB

#define SYSCALL_EVENT 128
#define SYS_GET_PID 129
#define SYS_GET_TIME 130
#define SYS_SLEEP 131
#define SYS_WRITE 132
#define VIDEO_START (unsigned short *)0xb8000
#define VIDEO_END ((unsigned short *)0xb8000 + 25 * 80)

typedef void (*func_p_t)(void); // void-return function pointer type

typedef enum {AVAIL, READY, RUN, SLEEP} state_t;

//define a trapframe type (tf_t) that has these 'unsigned int'

typedef struct{
	unsigned int edi, esi, ebp, esp, ebx, edx, ecx, eax, event, eip, cs, efl;
}tf_t;

typedef struct{
	state_t state;
	tf_t *tf_p;
	unsigned int time_count, total_time, wake_time;
}pcb_t;

typedef struct{
	int tail;
	int que[QUE_MAX];
}que_t;

#endif                          // to prevent name mangling

