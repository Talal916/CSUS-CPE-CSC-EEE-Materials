// spede.h, 159, needed spede include

#ifndef _SPEDE_
#define _SPEDE_

#include <spede/stdio.h> // printf(), sprintf(), vprintf(), sscanf(), etc.
#include <spede/flames.h> // IO_DELAY(), breakpoint(), cons_putchar(), cons_getchar(), cons_kbhit(),
#include <spede/sys/cdefs.h> // __BEGIN_DECLS, __END_DECLS, etc.
#include <spede/machine/io.h> // inportb(), outportb(), inportw(), etc.
#include <spede/machine/proc_reg.h> // get_idt_base(), get_cs(), set_cr3(), etc
#include <spede/machine/seg.h> // struct i386_gate, fill_gate(), etc.
#include <spede/machine/asmacros.h> // ASM(), CNAME(), ENTRY(), etc.

#endif

