/*CSC139
Fall 2018
Third Assignment
Monreal, Diana
Section # 1
*/

import java.io.File;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class CPU_Scheduling
{
	public static final String INPUT = "input1.txt";
	public static final String OUTPUT = "output.txt";

	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = getInput();
		PrintStream output = new PrintStream(new File(OUTPUT));
		String type;
		int timeQuantum = 0;
		System.out.println("Output");
		type = input.next();
		if (type.equals("RR")) timeQuantum = input.nextInt();
		input.nextLine();
		int procNum = input.nextInt();
		input.nextLine();
	
		int[][] procInfo = getInfo(procNum, input);
		switch (type){
			case "RR": roundRobin(output, procInfo, timeQuantum);
				break;
			case "SJF": shortestJobFirst(output, procInfo);
				break;
			case "PR_noPREMP": priorityNoPreempt(output, procInfo);
				break;
			case "PR_withPREMP": priorityWithPreempt(output, procInfo);
				break;
			default: System.out.println("Error with input type: " + type + "\nNot a valid type");
		}
	}

	public static Scanner getInput() throws FileNotFoundException{
		File f = new File(INPUT);
		return new Scanner(f);
	}

	public static int[][] getInfo(int procNum, Scanner input){
		int[][] procInfo = new int[procNum][4];
		for (int proc = 0; proc<procNum; proc++){
			procInfo[proc][0] = input.nextInt(); // Get process number
			procInfo[proc][1] = input.nextInt(); // Get Arrival Time
			procInfo[proc][2] = input.nextInt(); // Get CPU burst
			procInfo[proc][3] = input.nextInt(); // Get priority
			if (proc!=procNum-1) input.nextLine();
		}
		return procInfo;
	}
   
   //Round Robin
	public static void roundRobin(PrintStream output, int[][] procInfo, int timeQuantum){
		int[][] readyQueue = new int[procInfo.length][4];
		int nextArrival = 0, timer = 0, numDone = 0, totalWait = 0, timeIncrement = 0, readyQueuePointer = 0;
		sort(procInfo,1);
		System.out.println("RR " + timeQuantum);
		for (int arriving = nextArrival; arriving < procInfo.length && procInfo[arriving][1]<=timer; arriving++){
			readyQueue[readyQueuePointer++] = procInfo[arriving];
			nextArrival++;
		}
		while(numDone != procInfo.length){
			timeIncrement = 0;
			System.out.printf("%d %d\n", timer, readyQueue[0][0]);
			timeIncrement = (readyQueue[0][2] < timeQuantum) ? readyQueue[0][2]:timeQuantum; // Calculate the CPU burst
			timer += timeIncrement;
			readyQueue[0][2] -= timeIncrement;
			totalWait += timeIncrement*(readyQueuePointer-1);
			int[] temp = readyQueue[0];
			readyQueuePointer--;
			for (int proc = 0; proc < readyQueuePointer; proc++)
			{
				readyQueue[proc] = readyQueue[proc+1];
			}
			for (int arriving = nextArrival; arriving < procInfo.length && procInfo[arriving][1]<=timer; arriving++)
			{
				readyQueue[readyQueuePointer++] = procInfo[arriving];
				nextArrival++;
				totalWait += timer - procInfo[arriving][1];
			}
			if (temp[2]!=0) readyQueue[readyQueuePointer++] = temp;
			else numDone++;
		}
		System.out.printf("Average Wait: %.2f\n", (double)totalWait/(procInfo.length));// Calculate the total/average waiting time
	}
   
	// Shortest Job First with no preemption
	public static void shortestJobFirst(PrintStream output, int[][] procInfo){
		int[][] readyQueue = new int[procInfo.length][4];
		int numDone = 0, timer = 0, currProc = 0, nextArrival = 0, timeIncrement = 0, totalWait = 0, readyQueuePointer = 0;
		sort(procInfo, 1);
		System.out.println("SJF");
		while (procInfo[0][1]!=timer) timer++;
		for (int arriving = nextArrival; arriving < procInfo.length && procInfo[arriving][1]<=timer; arriving++){
            readyQueue[readyQueuePointer++] = procInfo[arriving];
			   nextArrival++;
		}
		do{
			timeIncrement = 0;
			currProc = 0;
			for (int proc = 1; proc < readyQueuePointer; proc++){
   				if (readyQueue[currProc][2]>readyQueue[proc][2] || (readyQueue[currProc][2]==readyQueue[proc][2] && readyQueue[currProc][1]>readyQueue[proc][1])){
					      currProc = proc;
               }
			}		
			System.out.printf("%d %d\n", timer, readyQueue[currProc][0]);
			timeIncrement = readyQueue[currProc][2];
			readyQueue[currProc][2] = 0;
			numDone++;
			timer += timeIncrement;
			readyQueue[currProc] = readyQueue[readyQueuePointer-1];
			readyQueuePointer--;
			totalWait += timeIncrement*readyQueuePointer;
			for (int arriving = nextArrival; arriving < procInfo.length && procInfo[arriving][1]<=timer; arriving++){
				readyQueue[readyQueuePointer++] = procInfo[arriving];
				nextArrival++;
				totalWait+= timer - procInfo[arriving][1];
			}
		}
      while (numDone!=procInfo.length);
		System.out.printf("Average Wait: %.2f\n", (double)totalWait/(procInfo.length));		
	}

   //Priority No Preempt
	public static void priorityNoPreempt(PrintStream output, int[][] procInfo){
		int[][] readyQueue = new int[procInfo.length][4];
		int numDone = 0, timer = 0, currProc = 0, nextArrival = 0, timeIncrement = 0, totalWait = 0, readyQueuePointer = 0;
		sort(procInfo, 1); // Sort array of processes by arrival time
		System.out.println("PR_noPREMP");
		while (procInfo[0][1]!=timer) timer++;
		for (int arriving = nextArrival; arriving < procInfo.length && procInfo[arriving][1]<=timer; arriving++){
			readyQueue[readyQueuePointer++] = procInfo[arriving];
			nextArrival++;
		}
		do{
			timeIncrement = 0;
			currProc = 0;
			for (int proc = 1; proc < readyQueuePointer; proc++){
				if (readyQueue[currProc][3]>readyQueue[proc][3]){
					 currProc = proc;
				}
			}		
			System.out.printf("%d %d\n", timer, readyQueue[currProc][0]);
			timeIncrement = readyQueue[currProc][2];
			timer += timeIncrement;
			totalWait += (readyQueuePointer-1)*timeIncrement;
			readyQueue[currProc][2] = 0;
			readyQueue[currProc] = readyQueue[readyQueuePointer-1];
			readyQueuePointer--;
			numDone++;
			for (int arriving = nextArrival; arriving < procInfo.length && procInfo[arriving][1]<=timer; arriving++){
				readyQueue[readyQueuePointer++] = procInfo[arriving];
				nextArrival++;
				totalWait+= timer - procInfo[arriving][1];
			}
		}
      while (numDone!=procInfo.length);
		System.out.printf("Average Wait: %.2f\n", (double)totalWait/(procInfo.length));	
	}

   //Priority With Preempt
	public static void priorityWithPreempt(PrintStream output, int[][] procInfo){
		int[][] readyQueue = new int[procInfo.length][4];
		int numDone = 0, timer = 0, currProc = 0, nextArrival = 0, timeIncrement = 0, totalWait = 0, readyQueuePointer = 0;
		boolean needDecision = true;
		sort(procInfo, 1);
		System.out.println("PR_withPREMP");
		while (procInfo[0][1]!=timer) timer++;
		do{
			timeIncrement = 0;
			for (int arriving = nextArrival; arriving < procInfo.length && procInfo[arriving][1]<=timer; arriving++){
				readyQueue[readyQueuePointer++] = procInfo[arriving];
				if (currProc==-1 || procInfo[arriving][3]<readyQueue[currProc][3]) needDecision = true;
				nextArrival++;
			}
         // If a scheduling decision is needed
			if (needDecision){
				currProc = 0;
				for (int proc = 1; proc < readyQueuePointer; proc++){
					if (readyQueue[currProc][3]>readyQueue[proc][3] || (readyQueue[currProc][2]==readyQueue[proc][2] && readyQueue[currProc][1]>readyQueue[proc][1])){
						currProc = proc;
					}
				}		
				needDecision = false;
				System.out.printf("%d %d\n", timer, readyQueue[currProc][0]);
			}
			if (nextArrival==procInfo.length || (readyQueue[currProc][2]+timer)<=procInfo[nextArrival][1]){
				timeIncrement = readyQueue[currProc][2];
				readyQueue[currProc][2] = 0;
				numDone++;
				readyQueue[currProc] = readyQueue[readyQueuePointer - 1];
				currProc = -1;
				readyQueuePointer--;
                needDecision = true;
			}
			else{
				timeIncrement = procInfo[nextArrival][1] - timer;
				if (readyQueuePointer!=0)  readyQueue[currProc][2] -= timeIncrement;
			}
			timer += timeIncrement;
			for (int waitingProc = 0; waitingProc<readyQueuePointer; waitingProc++){
				if (waitingProc!=currProc){
					totalWait += timeIncrement;
				}
			}
		}
      while (numDone!=procInfo.length);
		System.out.printf("Average Wait: %.2f\n", (double)totalWait/(procInfo.length));	
	}
	
	// Insertion sort
	public static void sort(int[][] procInfo, int sortCategory){
		for (int proc = 1; proc < procInfo.length; proc++){
			int[] temp = procInfo[proc];
			int j = proc;
			while(j>0 && procInfo[j][sortCategory] < procInfo[j-1][sortCategory]){
				procInfo[j] = procInfo[j-1];
				j--;
                procInfo[j] = temp;
			}
			
		}
	}

}