import java.util.Scanner;

public class WebsiteEncryptInvestmentLab {
   public static void main(String[] args) {
      Scanner kb = new Scanner(System.in);//declare Scanner
      //print the methods and statements in the main method
      System.out.print("How many different website do you have > " );
      int count = kb.nextInt();
      kb.nextLine();
      for (int j = 1; j <= count; j++){
         siteName(kb);
         System.out.println();
      }
      System.out.println("*******************");
      System.out.print("How many encrypted words do you have > " );
      int counter = kb.nextInt();
      for (int k = 1; k <= counter; k++){
         decrypt(kb);
      }
      System.out.println();
      System.out.println("*******************");
      kb.nextLine();
      reverse(kb);
      System.out.println();
      System.out.println("*******************");
      System.out.print("How many different investment do you have > " );
      int num = kb.nextInt();
      System.out.println();
      for (int i = 1; i <= num; i++){
         futureValue(kb);
         System.out.println();   
      }
   }
   //for site method
   public static void siteName(Scanner kb)
   {
   //computes the input
      System.out.print("Enter the URL of the website > ");
      String url = kb.nextLine();        
      int dot1 = url.indexOf(".");
      int dot2 = url.lastIndexOf(".");
      String name = url.substring(dot1+1,dot2);
      System.out.println("The name of the website you entered is > " + name);    
   }
   //for the decrypt method
   public static void decrypt(Scanner kb)
   {
   //computes the input
      System.out.print("Enter the encrypted word > ");
      String encrypt = kb.next();
      int len = encrypt.length();
      String decrypt = "";
      for (int i = 0; i < len; i = i + 2){
         decrypt = decrypt + encrypt.charAt(i);
      }
      System.out.println("Here is the decrypted word > " + decrypt);
   } 
   //for the void method
   public static void reverse(Scanner kb){
   //computes the input
      System.out.print("Enter your first and last name separated by a space > " );
      String fullName = kb.nextLine();
      int space = fullName.indexOf(" ");
      String first = fullName.substring(0,space);
      String last = fullName.substring(space);
      System.out.println("Here is your name is reverse order : " + last + " " + first);
   } 
   //for the future method
   public static void futureValue(Scanner kb){
   //computes the input   
      System.out.print("Enter the investment > " );
      double invest = kb.nextDouble();
      System.out.print("End the interest rate > " );
      double rate = kb.nextDouble();
      System.out.print("Enter the number of the years > " );
      int years = kb.nextInt();
      System.out.println();
      System.out.println("With an investment of "  + invest );
      System.out.println("at an interest rate of  " + rate + " compouded annually:");
      System.out.println("the future value in " + years + " is " + Math.round(invest * Math.pow( 1 + rate, years)));
   }
}  

