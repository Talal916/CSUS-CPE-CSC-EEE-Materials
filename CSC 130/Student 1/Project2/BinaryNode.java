/*Sam Lee
  6/10/2018
  CSC 130
  Project #2
*/
public class BinaryNode<T extends Comparable<T>> {
   private T data;
   private BinaryNode<T> left;
   private BinaryNode<T> right;
   private int height;

   public BinaryNode(T data) {
      this(data,null,null);
   }
   public BinaryNode(T data,BinaryNode<T> left, BinaryNode<T> right) {
      this.right = right; 
      this.left = left;
      this.height = 0;
      this.data = data;
   }
   public void setLeft(BinaryNode<T> n) {
      left = n;
   }
   public void setRight(BinaryNode<T> n) {
      right = n;
   }
   public void setHeight(int d) {
      height = d;
   }
   public BinaryNode<T> getLeft() {
      return left;
   }
   public BinaryNode<T> getRight() {
      return right;
   }
   public int getHeight() {
      return height;
   }
   public T getData() {
      return data;
   }
   public void setData(T data) {
      this.data = data;
   }

}