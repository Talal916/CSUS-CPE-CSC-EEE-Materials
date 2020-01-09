public class LanternsLab {


   //the next 4 methods are for individual lines in the output that are re-used
   public static void method1() {
      System.out.println("    *****          *****    ");
   }
   public static void method2() {
      System.out.println("  *********      *********  ");
   }   
   public static void method3() {
      System.out.println("*************  *************");
   }   
   public static void method4() {
      System.out.println("* | | | | | *  * | | | | | *");
   }
   //end of output methods   


   //common top image that looks like a triangle      
   public static void top() {
      method1();
      method2();
      method3();
   }      
      

   public static void main(String[] args) {
      //print the first part of the display
      top();
      System.out.println();
   
      //middle section with lantern
      top();
      method4();
      top();
      System.out.println();
      
      //final lantern
      top();   
      method1();
      method4();
      method4();
      method1();
      method1();
   }
}
