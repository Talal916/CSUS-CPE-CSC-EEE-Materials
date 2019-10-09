/*Sam Lee
  6/4/2018
  CSC 130
  Project #1
*/

import java.util.EmptyStackException;

public class ListStack implements DStack
{
   private static class Node
   {
      double current;
      Node next;
   }
   private Node top;
   public void push(double x)
   {
      Node nextTop;
      nextTop = new Node();
   
      nextTop.current = x;
      nextTop.next = top;
      top = nextTop;
   }
   public double pop()
   {
      if (top == null)
      {
         throw new EmptyStackException();
      }
         
      double current = top.current;
      top = top.next;
      return current;
   
   }
   public double peek()
   {
      if (top == null)
      {
         throw new EmptyStackException();
      }
      double current = top.current;
      return current;
   }
   public boolean isEmpty()
   {
      return (top == null);
   }

}