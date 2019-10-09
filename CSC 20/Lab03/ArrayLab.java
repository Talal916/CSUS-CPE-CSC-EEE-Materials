/*Sam Lee
 9/21/17
 CSC 20
 Professor Wang
 Lab #3
*/

public class ArrayLab {

   //printing out array A and B
   public static void print2D(int[][]A) {
     
      for(int i=0; i<A.length; i++){
         for(int j=0; j<A[i].length; j++){
            System.out.printf("%3d", A[i][j]);
         }
         System.out.println();
      }

   
   //the calculations of A + B
   public static int[][] add2Ds(int[][]A, int[][]B) {
      int C[][] =new int[3][4];
      for(int i=0; i<B.length; i++){
         for(int j=0; j<B[i].length; j++){
           
         }        
      }
      
      for(int i = 0; i < A.length; i++) {
         for(int j = 0; j< A[0].length; j++) {
            C[i][j] = A[i][j] + B[i][j];
         } 
      } 
      
      for (int i = 0; i < C.length; i++) {
         for (int x = 0; x < C[i].length; x++) {       
         }
      }        
      return C;
   }
   
   //the calculations for the scalar array of 5
   public static int[][] MultiScalar2D(int scalar, int[][]A) {
      int J[][] =new int[3][4];
      for(int i = 0; i < A.length; i++) {
         for(int j = 0; j< A[0].length; j++) {
            J[i][j] = A[i][j]*5;
         
         } 
      } 
      
      for (int i = 0; i < J.length; i++) {
         for (int x = 0; x < J[i].length; x++) {        
         }   
      }        
      return J;
   }
   
   //the calculations for the transposed array 
   public static int[][] transpose2D(int[][]A) {
      
      int m = A.length;
      int n = A[0].length;
   
      int[][] transposed = new int[n][m];
   
      for(int x = 0; x < n; x++) {
         for(int y = 0; y < m; y++) {
            transposed[x][y] = A[y][x];
         }
      }
   
      return transposed;
   }

   //displays the array output
   public static void main(String args[]) {
      int A[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
      int B[][] = {{2, 4, 6, 8}, {10, 12, 14, 16}, {18, 20, 22, 24}};
      
      System.out.println("Here are my arrays: ");
      System.out.println();
      
      //displays A
      System.out.println("A = ");
      System.out.println();
      print2D(A);
      System.out.println();
      
      //displays B
      System.out.println("B = ");
      System.out.println();
      print2D(B);
      System.out.println();
      
      //displays A + B
      System.out.println("A + B = ");
      System.out.println();
      print2D(add2Ds(A,B));
      System.out.println();
      
      //displays 5 * A
      System.out.println("5 X A = ");
      System.out.println();
      print2D(MultiScalar2D(5,A));
      System.out.println();
      
      //displays transposition of A
      System.out.println("Transpose of A = ");
      System.out.println();
      print2D(transpose2D(A));
      System.out.println();
   
   }
}
