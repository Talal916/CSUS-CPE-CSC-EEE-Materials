public class ShellLab {
   public static void main(String[] args) {
      line();
      top();
      middle();
      bottom();
      line();
   }
   //print the line
   public static void line() {
     
      System.out.print("|");
      for(int s = 0; s <= 9; s++)
         System.out.print("\"");
      System.out.print("|");
      System.out.println("");
   }
   //print the middle
   public static void middle() {
      System.out.println("     ||       ");
   }
   
   public static void top() {
      for(int z = 1; z <= 4; z++) {
         for(int r = 1; r <= z; r++){
            System.out.print(" ");
            }
         System.out.print("\\");
         for(int b = 1; b <= -2*z+10; b++) {
            System.out.print(":");
            }
            System.out.println("/"); 
   }
   }
   public static void bottom() {
      for(int h = 4; h >= 1; h--) {
         for(int m = 4; m >= -1*h+5; m--) {
            System.out.print(" ");
            }
            System.out.print("/");
            for(int g = 9; g >= 2 * h; g--) {
              System.out.print(":");
              }
              System.out.println("\\");
              }
              }
              }
   
      
      
               
   
      
      
      
      
