/*Sam Lee
  6/10/2018
  CSC 130
  Project #2
*/
import java.util.Comparator;
public class BinarySearchTree<T extends Comparable<T>> {
   protected BinaryNode<T> root;

   public BinarySearchTree() {
      root = null;
   }

   public boolean isEmpty() {
      return root == null;
   }

   public void insert(T data) {
      root = insert(root,data);
   }

   protected BinaryNode<T> insert(BinaryNode<T> root, T data) {
      if(root == null) {
         return new BinaryNode<>(data);
      }
      
      int compareResult = root.getData().compareTo(data);
      
      if(compareResult > 0) {
         root.setLeft(insert(root.getLeft(),data));
      }
      else if(compareResult<0) {
         root.setRight(insert(root.getRight(),data));
      }  
      return root;
   }
   
   public void delete(T data) {
      root = delete(root, data);
   }
   
   protected BinaryNode<T> delete(BinaryNode<T> root, T data) {
      if(root == null) {
         return null;
      }
      
      int compareResult = root.getData().compareTo(data);
      
      if(compareResult > 0) {
         root.setLeft(delete(root.getLeft(),data));
      }
      else if(compareResult<0) {
         root.setRight(delete(root.getRight(),data));
      } 
      else if (root.getLeft() != null && root.getRight() != null) {
         root.setData(findMin(root.getRight()).getData());
         root.setRight(delete( root.getRight(), root.getData()));
      } 
      else {
         root = root.getLeft() != null ? root.getLeft() : root.getRight();
      }
      return root;
   }
   public int height() {
      return height(root);
   }
   protected int height(BinaryNode<T> root) {
      if(root == null) {
         return -1;
      }
      else {
         return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
      }   
   }
   public void printTree() {
      printTree(root);
   }
   public void printTree(BinaryNode<T> root) {
      if(root != null) {
         printTree(root.getLeft());
         printTree(root.getRight());
      }
   }
   public BinaryNode<T> getRoot() {
      return root;
   }
   public T findMin() {
      BinaryNode<T> node = findMin(root);
      return node == null ? null : node.getData();
   }
   public BinaryNode<T> findMin(BinaryNode<T> root) {
      if(root == null) {
         return null;
      }
      else if (root.getLeft() == null) {
         return root;
      }
      else
         return findMin(root.getLeft());
   }
}