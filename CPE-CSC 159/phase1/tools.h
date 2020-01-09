// tools.h, 159

#ifndef _TOOLS_
#define _TOOLS_

#include "const-type.h" // need definition of 'que_t' below

int QueEmpty(que_t *p);
int QueFull(que_t *p);
int DeQue(que_t *p);
void EnQue(int add, que_t *p);
void Bzero(char *start, unsigned int max);
void MemCpy(char *dst, char *src, unsigned int max);


#endif

