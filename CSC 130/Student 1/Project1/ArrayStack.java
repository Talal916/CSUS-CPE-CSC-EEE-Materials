/*Sam Lee
  6/4/2018
  CSC 130
  Project #1
*/

import java.util.EmptyStackException;

public class ArrayStack implements DStack
{
   private double[] array = new double[10];
   private int topIdx = 0;       //An index that identifies the top of the stack.
   // Note that topIdx helps point the location of where the new element will be "pushed".
   
   
   // Empty is a loose term, since double data types cannot be assigned to null.
   // In this case, it's 0.00.
   // So, if all of the values are 0.00, return true.
   public boolean isEmpty()
   {
      if (this.topIdx == 0)
         return true;
      for (int i = 0; i < array.length; i++)
      {
         if (array[i] != 0.00);
         {
            return false;
         }   
      }
      return true;      
   }
   
   public void push(double d)
   {
      if (this.topIdx == array.length)
      {
         int newSize = array.length * 2;
         double[] tempArray = new double[newSize];
         for(int i = 0; i < array.length; i++)
         {
            tempArray[i] = array[i];
         }
         array = tempArray;
      }   
      array[this.topIdx] = d;
      this.topIdx++;
   }
   
   public double pop()
   {
      if (isEmpty())
         throw new EmptyStackException();
   
      double popValue = array[this.topIdx-1];
      array[this.topIdx-1] = 0.00;
      this.topIdx--;
      return popValue;
   }
   
   public double peek()
   {
      if (isEmpty())
         throw new EmptyStackException();
         
      return array[this.topIdx-1];
   }
}