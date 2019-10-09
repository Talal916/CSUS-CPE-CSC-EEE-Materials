/*Sam Lee
  10/11/17
  CSC 20
  Professor Wang
  Lab #6
*/

package MyStackQueue;

public class Queue {
   private Node Rear = null, Front = null;
   private int size = 0;
   public boolean isEmpty() { 
      return Front==null; }
   public void enqueue(Object Element) {
      Node Tmp = new Node();
      Tmp.Data = Element;
      if (Rear==null) Rear = Front = Tmp;
      else { Rear.Next = Tmp; Rear = Tmp;}
      size++;
   }
   public Object dequeue() {
      Node Tmp = Front;
      Front =  Front.Next; size--;
      if (Front==null) Rear = null;
      return Tmp.Data;
   }
   public String toString() {
      String s = "";
      Node cur = Front;
      while(cur != null) {
         s += cur.Data + " ";
         cur = cur.Next;
      }
   
      return s;
   }
}

class Node {
   Object Data;
   Node Next;
}