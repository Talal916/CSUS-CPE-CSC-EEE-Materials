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

public class InsertionSortPartOne {
       
          static void insertionSort(int[] ar) {
              boolean changed = false;
              for (int i=ar.length-1; i>=1; i--){
                  int tmp = ar[i];
                  int j = i-1;
                  for (changed = false; j>=0; j--)
                      if (ar[j]>tmp){
                          changed = true;
                          ar[j+1]=ar[j];
                          printArray(ar);
                      }
                      else break;
                  ar[j+1] = tmp;
                  if (changed)
                      printArray(ar);
              }
       }   

 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           insertionSort(ar);
       }    
   }