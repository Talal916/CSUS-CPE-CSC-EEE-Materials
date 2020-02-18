/*
CSC139
Fall 2018
First Assignment
Last Name, First Name
Section #
OSs Tested on: such as Linux, Mac, etc.
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <unistd.h>
#include <sys/types.h>
// Size of shared memory block
// Pass this to ftruncate and mmap
#define SHM_SIZE 4096
// Global pointer to the shared memory block
// This should receive the return value of mmap
// Don't change this pointer in any function
void* gShmPtr;
// You won't necessarily need all the functions below
void Producer(int, int, int);
void InitShm(int, int);
void SetBufSize(int);
void SetItemCnt(int);
void SetIn(int);
void SetOut(int);
void SetHeaderVal(int, int);
int GetBufSize();
int GetItemCnt();
int GetIn();
int GetOut();
int GetHeaderVal(int);
void WriteAtBufIndex(int, int);
int ReadAtBufIndex(int);
int GetRand(int, int);
int main(int argc, char* argv[])
{
pid_t pid;
int bufSize; // Bounded buffer size
int itemCnt; // Number of items to be produced
int randSeed; // Seed for the random number generator
if(argc != 4){
printf("Invalid number of command-line arguments\n");
exit(1);
}
bufSize = atoi(argv[1]);
itemCnt = atoi(argv[2]);
randSeed = atoi(argv[3]);
// Write code to check the validity of the command-line arguments
// Function that creates a shared memory segment and initializes its header
InitShm(bufSize, itemCnt);

/* fork a child process */
pid = fork();
if (pid < 0) { /* error occurred */
fprintf(stderr, "Fork Failed\n");
exit(1);
}
else if (pid == 0) { /* child process */
printf("Launching Consumer \n");
execlp("./consumer","consumer",NULL);
}
else { /* parent process */
/* parent will wait for the child to complete */
printf("Starting Producer\n");
// The function that actually implements the production
Producer(bufSize, itemCnt, randSeed);
printf("Producer done and waiting for consumer\n");
wait(NULL);
printf("Consumer Completed\n");
}
return 0;
}
void InitShm(int bufSize, int itemCnt)
{
int in = 0;
int out = 0;
const char *name = "OS_HW1_yourName"; // Name of shared memory 
object to be passed to shm_open
// Write code here to create a shared memory block and map it to 
gShmPtr
 // Use the above name.
 // **Extremely Important: map the shared memory block for both 
reading and writing
 // Use PROT_READ | PROT_WRITE
// Write code here to set the values of the four integers in the 
header
// Just call the functions provided below, like this
SetBufSize(bufSize); 
}
void Producer(int bufSize, int itemCnt, int randSeed)
{
int in = 0;
int out = 0;
srand(randSeed);
// Write code here to produce itemCnt integer values in the range [0-
3000]
// Use the functions provided below to get/set the values of shared variables "in" and "out"
// Use the provided function WriteAtBufIndex() to write into the bounded buffer 
// Use the provided function GetRand() to generate a random number in the specified range
// **Extremely Important: Remember to set the value of any shared variable you change locally
// Use the following print statement to report the production of an item:
// printf("Producing Item %d with value %d at Index %d\n", i, val, in);
// where i is the item number, val is the item value, in is its index in the bounded buffer

printf("Producer Completed\n");
}
// Set the value of shared variable "bufSize"
void SetBufSize(int val)
{
SetHeaderVal(0, val);
}
// Set the value of shared variable "itemCnt"
void SetItemCnt(int val)
{
SetHeaderVal(1, val);
}
// Set the value of shared variable "in"
void SetIn(int val)
{
SetHeaderVal(2, val);
}
// Set the value of shared variable "out"
void SetOut(int val)
{
SetHeaderVal(3, val);
}
// Set the value of the ith value in the header
void SetHeaderVal(int i, int val)
{
void* ptr = gShmPtr + i*sizeof(int);
memcpy(ptr, &val, sizeof(int));
}
// Get the value of shared variable "bufSize"
int GetBufSize()
{
return GetHeaderVal(0);
}
// Get the value of shared variable "itemCnt"
int GetItemCnt()
{
return GetHeaderVal(1);
}
// Get the value of shared variable "in"
int GetIn()
{
return GetHeaderVal(2);
}
// Get the value of shared variable "out"
int GetOut()
{
return GetHeaderVal(3);
}
// Get the ith value in the header
int GetHeaderVal(int i)
{
int val;
void* ptr = gShmPtr + i*sizeof(int);
memcpy(&val, ptr, sizeof(int));
return val;
}
// Write the given val at the given index in the bounded buffer
void WriteAtBufIndex(int indx, int val)
{
// Skip the four-integer header and go to the given index
void* ptr = gShmPtr + 4*sizeof(int) + indx*sizeof(int);
    memcpy(ptr, &val, sizeof(int));
}
// Read the val at the given index in the bounded buffer
int ReadAtBufIndex(int indx)
{
int val;
// Skip the four-integer header and go to the given index
void* ptr = gShmPtr + 4*sizeof(int) + indx*sizeof(int);
memcpy(&val, ptr, sizeof(int));
return val;
}
// Get a random number in the range [x, y]
int GetRand(int x, int y)
{
int r = rand();
r = x + r % (y-x+1);
return r;
}
