//  DX -> 0x0120 = 288d || AX -> 0x0120 = 288d || BX -> 0x0250 = 592d
#include <iostream>
using namespace std;
 
int main() {
	//first we will initialize registers and content of memory locations
	
	//Registers
	int ax = 0;
	int bx = 0;
	int dx = 0; 
	
	
	//Memory location at 200 = 288
	//					 202 = 592
	int m200 = 288;
	int m202 = 592; 

	// now we will mov DX, 0120, meaning assgining dx to 288
	dx = 288;
	
	//MOV AX, [0200] - AX is assigned to content of memory location at 200
	ax = m200; 
	
	//MOV BX, [0202] - BX is assigned to content of memory location at 202
	bx = m202; 
	
	//SUB AX, BX - the subtraction of AX and BX is stored at AX
	ax = ax - bx;
	
	
	//JGE 0114 - Checking if AX is greater than 0; If yes, the program skips the while loop.
	while (ax < 0){
		
		//If AX is not greater than 0,
		ax = ax + dx;// ADD AX, DX - the addition of AX and DX is stored at AX
		cout << ax << endl; //Print value of ax to track its changes.	
	}
	
	//JMP 010E - If ax is still not greater than 0, the while loop is kept running
	m200 = ax;	// MOV [0200], AX - once AX is greater than 0, its value will be assigned to the content o
	
	//memory location at 200
	return 0; //INT 20 - terminate the program
}

