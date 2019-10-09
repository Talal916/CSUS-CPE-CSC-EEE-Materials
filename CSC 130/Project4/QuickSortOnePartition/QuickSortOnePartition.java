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

public class QuickSortOnePartition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           partition(ar);
           printArray(ar);
    }
    static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
    }
    static void partition(int[] ar) {
        int p=ar[0];
        int[] copy=Arrays.copyOf(ar, ar.length);
        int c=0;
        for(int i=1;i<ar.length;i++){
            if(copy[i]<=p){
                ar[c]=copy[i];
                c++;
            }
        }
        ar[c]=p;
        c++;
        for(int j=0;j<ar.length;j++){
            if(copy[j]>p){
                ar[c]=copy[j];
                c++;
            }
        }
    }   
}
