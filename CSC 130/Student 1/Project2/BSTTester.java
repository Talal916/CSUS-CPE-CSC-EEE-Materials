/*Sam Lee
  6/10/2018
  CSC 130
  Project #2
*/
import java.util.Random;
import java.util.Scanner;
public class BSTTester {
   public static void main(String[] args) {
     
      Scanner kb = new Scanner(System.in);
      Random rand = new Random();
      char ch;
      int input;
      int min = 10;
      int max = 100;
      BinarySearchTree<Integer> binarysearchtree = new BinarySearchTree<>();
      AVLTree<Integer> avl = new AVLTree<>(true);
      do {
         System.out.println("\n");
         System.out.println(" Enter 1 for Part 1 for BST Test(Adding and Deleting): ");
         System.out.println(" Enter 2 for Part 1 for AVL Test(Adding, Deleting, Rotating): ");
         System.out.println(" Enter 3 for Part 2 for time difference: ");
         input = kb.nextInt();   
         switch(input) {
            case 1:
               while(binarysearchtree.height() < 5) {
                  binarysearchtree.insert(rand.nextInt(max - min) + min);
                  new TreePrinter(binarysearchtree).print("BST: ");
               }
               while(!binarysearchtree.isEmpty()) {
                  binarysearchtree.delete(binarysearchtree.getRoot().getData());
                  new TreePrinter(binarysearchtree).print("Removing Root BST: ");
               }
               break;
            case 2:     
               for(int i= 0; i<35; i++) {
                  avl.insert(rand.nextInt(max - min) + min);
                  new TreePrinter(avl).print("AVL Tree");
               } 
               while(!avl.isEmpty()) {
                  avl.delete(avl.getRoot().getData());
                  new TreePrinter(avl).print("Removing Root AVL Tree: ");
               }
               break;
            case 3:
               int[] randomInts = new int[1000000];
               int[] randomIntsToSearch = new int[1000000];
               for(int i = 0; i < 1000000; i++) {
                  randomInts[i] = rand.nextInt(max - min) + min;
                  if(i < 1000000) {
                     randomIntsToSearch[i] = rand.nextInt(max - min) + min;
                  }
               }
        
               BinarySearchTree<Integer> binarysearchtree1 = new BinarySearchTree<>();
               AVLTree<Integer> avl1 = new AVLTree<>();
            
               double result = timeRunnable(
                  () -> {
                     for(int val : randomInts) {
                        binarysearchtree1.insert(val);
                     }
                  });
            
               System.out.println("BST Insertion Time For 1 million nodes: " + result + "ms");
            
               result = timeRunnable(
                  () -> {
                     for(int val : randomInts) {
                        avl1.insert(val);
                     }
                  });
            
               System.out.println("AVL Insertion Time For 1 million nodes: " + result + "ms");
            
               break;
            default:
               break;
               
         }
          
         System.out.println("\n\n\nEnter R or r to repeat the program again: ");
         ch = kb.next().charAt(0);
      }
         while(ch =='R' || ch == 'r');            
   }
   
   public static double timeRunnable(Runnable runnable) {
      long startTime = System.nanoTime();
      runnable.run();
      long endTime = System.nanoTime();
      return (endTime - startTime) / 1000000.0;
   }
}