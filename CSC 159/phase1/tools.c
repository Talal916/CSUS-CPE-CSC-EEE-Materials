// tools.c, 159

#include "spede.h"
#include "const-type.h"
#include "ext-data.h"

int QueEmpty(que_t *p){
  if(p->tail == 0)
    return 1;
  else
    return 0;
}

int QueFull(que_t *p){
  if(p->tail == (QUE_MAX)) //might be QUE_MAX-1
    return 1;
  else
    return 0;
}

int DeQue(que_t *p){
  int temp, i;
  if(QueEmpty(p))
    return NONE;
  temp = p->que[0];
  p->tail--;
  for(i = 0; i < p->tail;i++)
    p->que[i] = p->que[i+1];
  return temp;
}

void EnQue(int add, que_t *p){
  if(QueFull(p)){
    cons_printf("Panic: queue is full, cannot Enque!\n");
    breakpoint();
  }
  p->que[p->tail] = add;
  p->tail++;
}

void Bzero(char *start, unsigned int max){
  int i;
  for(i = 0; i < max; i++){
    *start = (char)0;//sets to NULL
    start++;
  }
}

void MemCpy(char *dst, char *src, unsigned int max){
  int i;
  for(i=0; i < max; i++){
    *dst = *src;
    dst++;
    src++;
  }
}
