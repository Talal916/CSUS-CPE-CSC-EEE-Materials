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

public class IntroToTutorialChallenges {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
           int v = in.nextInt();
           int n = in.nextInt();
        
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt();
           }  
        
           int i=0;
           while (ar[i]<v){
                i++;
           }
           System.out.println(i);
        
    }
}