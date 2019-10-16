/*
  CSC 130 Section 2
  Professor Mei Lu
  February 16, 2015

  This program takes an array of integers and runs it
  through a mergesort algorithm.*/

import java.util.*;

public class MergeSort {
   public static void main(String[] args) {
   
      Scanner s=new Scanner(System.in);    //for the number of inputs
      System.out.println("How many elements would you like to enter?");
      int n=s.nextInt();
      int list[]=new int[n];
      System.out.println("Enter the elements (Put a space in between each element):");
      for(int i=0;i<n;i++){    //for reading array
         list[i]=s.nextInt();
      }
        mergeSort(list);
        System.out.println("The sorted result is:  " + Arrays.toString(list));
        //The following is to find the median of the array.
        double median;
            if (list.length % 2 == 0)
               median = ((double)list[list.length/2] + (double)list[list.length/2 - 1])/2;//even array
            else
               median = (double) list[list.length/2];//odd array
        System.out.println("The median is: " + median);//output the median in double
    }

    // Mergesort algorithm sorts the elements from smallest to largest
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            // splits the array in to two
            int[] leftside = leftHalf(arr);
            int[] rightside = rightHalf(arr);
            
            // recursively sort the two split sides
            mergeSort(leftside);
            mergeSort(rightside);
            
            // merges the sorted sides into a sorted whole
            merge(arr, leftside, rightside);
        }
    }
    
    // Returns the first half of the given array.
    public static int[] leftHalf(int[] arr) {
        int length1 = arr.length / 2;
        int[] leftside = new int[length1];
        for (int i = 0; i < length1; i++) {
            leftside[i] = arr[i];
        }
        return leftside;
    }
    
    // Returns the second half of the given array.
    public static int[] rightHalf(int[] arr) {
        int length1 = arr.length / 2;
        int length2 = arr.length - length1;
        int[] rightside = new int[length2];
        for (int i = 0; i < length2; i++) {
            rightside[i] = arr[i + length1];
        }
        return rightside;
    }
    
    // Merges the left side and right side into the final array.
    public static void merge(int[] result, int[] leftside, int[] rightside) {
        int index1 = 0;   // index into left array
        int index2 = 0;   // index into right array
        
        for (int i = 0; i < result.length; i++) {
            if (index2 >= rightside.length || (index1 < leftside.length && leftside[index1] <= rightside[index2])) {
                result[i] = leftside[index1];    // take from left
                index1++;
            } else {
                result[i] = rightside[index2];   // take from right
                index2++;
            }
        }
    }
 }