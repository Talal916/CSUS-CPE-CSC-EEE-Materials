/*Sam Lee
  6/1/18
  CSC 130 
  Professor Chidella
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreadthFirstSearchShortesReach {

    public static void main(String[] args) throws Exception {
        Scanner sn=new Scanner(System.in);
        long T=Long.parseLong(sn.nextLine());
        while(T-->0)
            {
            String data[]=sn.nextLine().split(" ");
            int N=Integer.parseInt(data[0]);
            int M=Integer.parseInt(data[1]);
            int distance[]=new int[N+1];
            for(int i=0;i<N+1;i++)
            {
            	distance[i]=-1;
            }
            final int init=0;
            final int wait=1;
            final int visited=2;
            int state[]=new int[N+1];
            int adj[][]=new int[N+1][N+1];
      // System.out.println("N = "+N+"M ="+M);
            for(int i=0;i<M;i++)
                {
                data=sn.nextLine().split(" ");
               // System.out.println(data[0]+" "+data[1]);
                adj[Integer.parseInt(data[0])][Integer.parseInt(data[1])]=1;
                adj[Integer.parseInt(data[1])][Integer.parseInt(data[0])]=1;
            }
            
            int S=Integer.parseInt(sn.nextLine());
            LinkedList que=new LinkedList();
            que.add(S);
            int ii=0;
            while(que.size()!=0)
            {
            	int SS=(int)(Integer)que.remove(0);
            	state[SS]=visited;
                //System.out.println(SS);
            	 for(int i=1;i<N+1;i++)
            	 {
            	 	if(adj[SS][i]==1 && state[i]==init)
            	 	{
            	 		que.add(i);
            	 		state[i]=wait;
                       // System.out.println(distance[i]);
            	 		if(distance[SS]==-1)
            	 		{
            	 			//System.out.println("DISTANCE -1"+ ii++);
            	 				distance[i]=6;
            	 		}
            	 		else
            	 		{
            	 			distance[i]=distance[SS]+6;
            	 			//System.out.println("XXXXXXXXXXXX");	
            	 		}
            	 		
            	 	}
            	 }
            }
            int c=0;
          //  Arrays.sort(distance);
            for(int i=1;i<N+1;i++)
            {
            	if(i!=S)
            	System.out.print(distance[i]+" ");
            	
            	
               
            }
            
            if(T!=-1)
            System.out.println();
        }
    }
}
