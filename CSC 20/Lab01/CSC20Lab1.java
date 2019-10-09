/*Sam Lee
  9/5/17
  CSC 20
  Professor Wang
  Lab #1*/
import java.util.Scanner;

public class CSC20Lab1 {
   
   public static void main (String[] args) {
      //Use Scanner so user can input the number
      Scanner num= new Scanner(System.in);
      System.out.println("Please enter two numbers of your choice, no words or letters: ");
      int a;
      int b;
      //Just in case the user input a word or letter  
      while(!num.hasNextInt()){
         System.out.println("Sorry. Please enter a valid input, which is a number, not a word or letter.");
         num.next();          
      }
      
      //First Number
      a = num.nextInt();
      
      //Just in case the user input a word or letter  
      while(!num.hasNextInt()){
         System.out.println("Sorrry. Please enter a valid input, which is a number, not a word or letter.");
         num.next();        
      }
      
      //Second Number
      b = num.nextInt();
      
      //To show the spacing of your two inputs
      System.out.printf("%10d\nx%9d\n", a, b);
      //The line
      System.out.println("---------------");
      
      //The formula for multiplying two numbers  
      int x = (b%10) * a;
      int y = (b/10%10) * a;
      int z = (b/100) * a;
      int result = a*b;
      
      //To show the work of the multiplication
      System.out.printf("%10d\n%9d\n%8d\n", x, y, z);
      System.out.println("---------------");
      System.out.printf("%10d", result); 
   }
}