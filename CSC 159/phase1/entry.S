// entry.S, entries to kernel, build process trapframe

#include <spede/machine/asmacros.h> // do not use/include "spede.h"
#define KSTACK_MAX 16384            // 16 KB should be enough

.comm kstack, KSTACK_MAX, 1         // declare kernel stack by unit of 1 byte
.text

// loads proc trapframe to run it
ENTRY(Loader)
   movl 4(%esp), %ecx       // copy what's above stack pointer
   movl %ecx, %esp          // copy to esp (point esp to trapframe)
   popa                     // pop all: edi esi ebp esp ebx edx ecx eax
   iret                     // pop eip, cs, efl

// build/push trapframe then event/intr occurs, and then go into kernel
ENTRY(TimerEntry)           // push efl, cs, eip by hardware
   pusha                    // push all: eax ecx edx ebx esp ebp esi edi
   movl %esp, %ecx          // copy esp
   movw $0x10, %ax          // put 16 to ax
   mov %ax, %ds             // set kernel data segment registers ds
   mov %ax, %es             // set kernel data segment registers es
   leal kstack+KSTACK_MAX, %esp  // so esp points to top of kernel stack
   push %ecx                // push (proc trapframe addr) there
   cld                      // clear direction flag bit
   call CNAME(Kernel)       // call C function: void Kernel(given ecx value) { 

