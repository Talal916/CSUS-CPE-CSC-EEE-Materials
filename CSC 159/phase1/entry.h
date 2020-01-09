// entry.h
// prototypes those in entry.S

#ifndef _ENTRY_
#define _ENTRY_

#ifndef ASSEMBLER  // skip below if ASSEMBLER defined (from an assembly code)
                   // since below is not in assembler syntax
__BEGIN_DECLS

#include "const-type.h"    // tf_t below needs it

void TimerEntry(void);     // coded in entry.S, assembler won't like this syntax
void Loader(tf_t *);       // coded in entry.S

__END_DECLS

#endif // ifndef ASSEMBLER

#endif // ifndef __K_ENTRY__

