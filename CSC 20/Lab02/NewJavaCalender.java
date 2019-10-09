/* Lab Number:  2
   Your Name: Sam Lee
   Section Number: 4
   Professor Wang
   CSC 20  
   09/12/2017 
*/

import java.util.Scanner;

public class NewJavaCalender {
   
   public static void main (String[] args) {
      
      Scanner yr = new Scanner(System.in);
      System.out.print("Please enter the year : ");
      int year = yr.nextInt();
      int month = 1;
      String monthString = "";
      int days = 0;
      JulianDate JD = new JulianDate();
      int date = JD.toJulian(year,1,1);
      int dayOfWeek = (date+1)%7;       
      
      while (month <= 12) {
      //To show what month is which
         switch(month){
            
            case 1: monthString = "Jaunary"; 
               days = 31;
               break;
            
            case 2: monthString = "Febuary";
               if (isLeapYear(year)){
                  days = 29;
               } 
               else {
                  days = 28; 
               }    
               break;
            
            case 3: monthString = "March"; 
               days = 31;
               break;
            
            case 4: monthString = "April";
               days =30;
               break;
            
            case 5: monthString = "May";
               days = 31;
               break;
            
            case 6: monthString = "June";
               days = 30;
               break;
            
            case 7: monthString = "July";
               days = 31;
               break;
            
            case 8: monthString = "August";
               days = 31;
               break;
            
            case 9: monthString = "September";
               days = 30;
               break;
            
            case 10: monthString = "October";
               days = 31;
               break;
            
            case 11: monthString = "November";
               days = 30;
               break;
            
            case 12: monthString = "December";
               days = 31;
               break;                
         }
         //To print out the format of the calendar  
         System.out.println(); 
         System.out.printf("%" + (11 +monthString.length()/2)+"s\n",monthString);
         System.out.println();
         System.out.println("  S  M Tu  W Th  F  S");
         
         if (dayOfWeek > 0){
            System.out.printf("%" + (dayOfWeek * 3) + "c",' ');
         }
         
         for(int d =1; d <= days;++d) {
            System.out.printf("%3d",d);
            dayOfWeek++;
            if(dayOfWeek == 7) {
               dayOfWeek = 0;
               System.out.println();
            }
         }
         
         System.out.println();
         month++;
      }
   }
   //To calculate Leap Year for the month of February
   public static boolean isLeapYear(int year) {
      if (year % 400 == 0 || (year % 4 == 0 && (year % 100 != 0)))
      {
         return true;
      }
      return false;    
   }  

}
