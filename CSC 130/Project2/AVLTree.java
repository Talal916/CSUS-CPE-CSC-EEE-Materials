/*Sam Lee
  6/10/2018
  CSC 130
  Project #2
*/
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
   
   private boolean printRotation;
   
   public AVLTree() {
      this(false);
   }
   
   public AVLTree(boolean printRotation) {
      this.printRotation = printRotation;
   }
   public boolean isBalanced() {
      return isBalanced(root);
   }
   private boolean isBalanced(BinaryNode<T> root) {
      if(root == null) {
         return true;
      }
      else {
         int leftH = height(root.getLeft());
         int rightH = height(root.getRight());
         return Math.abs(leftH - rightH) <= 1;
      }
   }
   protected BinaryNode<T> insert(BinaryNode<T> root, T data) {
      return balance(super.insert(root, data));
   }
   
   protected BinaryNode<T> delete(BinaryNode<T> root, T data) {
      return balance(super.delete(root,data));
   }
   
   private BinaryNode<T> balance(BinaryNode<T> root) {
      if(root == null) {
         return null;
      }
      if(height(root.getLeft())- height(root.getRight()) >1 ) {
        
         if(height(root.getLeft().getLeft())>= height(root.getLeft().getRight())) {
            root = singleRightRotation(root);
         }
         else {
            root = doubleLeftRightRotation(root);
         }     
      }
      else if(height(root.getRight())- height(root.getLeft()) >1 ) {
         
         if(height(root.getRight().getRight())>= height(root.getRight().getLeft())) {
            root = singleLeftRotation(root);
         }
         else
            root = doubleRightLeftRotation(root);
      }
      return root;
   }
      
   private BinaryNode<T> singleRightRotation(BinaryNode<T> k2) {
      if(printRotation) {
         System.out.println("Single Right Rotation:" + k2.getData());
      }
      BinaryNode<T> k1 = k2.getLeft();
      k2.setLeft(k1.getRight());
      k1.setRight(k2);
      k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) +1);
      k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) +1);   
      return k1;
   }
      
   private BinaryNode<T> singleLeftRotation(BinaryNode<T> k1) {
      if(printRotation) {
         System.out.println("Single Left Rotation:"+ k1.getData());
      }
   
      BinaryNode<T> k2 = k1.getRight();
      k1.setRight(k2.getLeft());
      k2.setLeft(k1);
      k2.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) +1);
      k1.setHeight(Math.max(height(k2.getRight()), k1.getHeight()) +1);
      return k2;
   }

   private BinaryNode<T> doubleRightLeftRotation(BinaryNode<T> k1) {
      if(printRotation) {
         System.out.println("Double Right Left Rotation:"+ k1.getData());
      }
      k1.setRight(singleRightRotation(k1.getRight()));
      return singleLeftRotation(k1);
   }

   private BinaryNode<T> doubleLeftRightRotation(BinaryNode<T> k3) {
      if(printRotation) {
         System.out.println("Double Right Left Rotation:"+ k3.getData());
      }
   
      k3.setLeft(singleLeftRotation(k3.getLeft()));
      return singleRightRotation(k3);
   }
}
   
