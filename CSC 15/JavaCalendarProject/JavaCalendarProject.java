import java.util.Scanner;

public class JavaCalendarProject
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      int year;
      int month = 0;
      System.out.print("Enter a valid year after 1800? ");
   //prompt the user to enter the year
      boolean repeat = true;
      while (repeat) {
      //repeat as long as the user wants to
         if(kb.hasNextInt()) {
            year = kb.nextInt();
         }
         else {
            while(!kb.hasNextInt()){//if user doesn't input a crrect value
               kb.next();
               System.out.print("Enter a valid year after 1800? ");
            }
            year = kb.nextInt();
         }
         if(year > 1800){ //continues if the user puts a year number that is greater than 1800
            String selection = "e";
            while(!(selection.equalsIgnoreCase("m")|| selection.equalsIgnoreCase("y"))) {
               System.out.println("Select one of the following selections: ");
               System.out.println ("To get the month calendar press m or M ");
               System.out.println ("To get the calendar for the year enter y or Y ");
               System.out.print("Enter your choice: ");
               selection = kb.next();
               if(selection.equalsIgnoreCase("m")) {//continues if user inputs m and if the user doesn't, then it is invalid choice
                  System.out.print("Enter the month of the year from 1...12-->");
                  boolean test = false;
                  while(!test){
                     if(kb.hasNextInt()) {
                        month = kb.nextInt();
                        while(month < 1 || month > 12) { 
                           System.out.print("Enter the month of the year from 1...12-->");//if user doesn't put correct and valid answer
                           while(!kb.hasNextInt()){
                              System.out.println("Invalid choice");//if user doesn't put correct and valid answer
                           }
                           month = kb.nextInt();
                        }
                     }
                     else {
                        while(!kb.hasNextInt()){
                           kb.next();
                           System.out.print("Enter the month of the year from 1...12-->");//if user doesn't put correct and valid answer
                        }
                        System.out.print("Enter the month of the year from 1...12-->");//if user doesn't put correct and valid answer
                        month = kb.nextInt();
                     }
                     if(month >= 1 && month <= 12){
                        test = true;
                     }
                     else{
                        test = false;
                     }
                  }
                  printMonth(year,month);
               }
               else if (selection.equalsIgnoreCase("y")){//if user inputs y
                  int a = 1;
                  while(a <=12){
                     printMonth(year,a);
                     a++; 
                  }
               }
               else {
                  System.out.println("Invalid choice");//if user doesn't put correct and valid answer
               }
            }
         }
         
         else {
            System.out.println("Invalid choice");//if user doesn't put correct and valid answer
            
         }
         System.out.println(" ");
         System.out.println(" ");
         System.out.print("Do you want to have another year to print the calendar: yes/no?-->");
         if(repeat = kb.next().equalsIgnoreCase("yes")){
            System.out.print("Enter a valid year after 1800? ");
         }          
         else{
            System.out.println("Goodbye");//if user says no
         } 
      }
   }   
   /*this method prints the body of the calender for the given month*/
   public static void printMonth(int year, int month) {
      System.out.println(" ");
      System.out.println(" ");
      getMonthName(month,year);
      printTitle(year,month);//call the method printTitle with the values year and month
      printMonthBody(year,month);//call the method printMonthBody with the values year and month
   }
/*this method prints the title of the days in each week(Sun Mon Tues Wed Thur Fir Sat)*/
   public static void printTitle(int year, int month) {
      System.out.println(" Sun Mon Tue Wed Thu Fri Sat");//output the title for each month of the year
   }
/*this method outputs the calender for each month of the year*/
   public static void printMonthBody(int year, int month) {
      int startDay = getStartDay(year, month);
      //call the method getStartDay to get the start day for each month of the year 
      print(startDay,year,month);
      //call the method print to print the calender for the month and pass the first day of the month as the parameter 
   
   }
   /*prints the calendar for the given month*/
   public static void print(int startDay, int year, int month) {
     //call the method getNumberOfdaysInMonth to find out the number of the days in the month 
     //use a for loop to print spaces up to the start day for each month
     //use another for loop to print the rest of the days in the calender
     //if the month is November calculate the thanksgiving day and output            }
      int amount = getNumberOfDaysInMonth(year,month);
      for(int e = 0; e < startDay; e++){//this print outs the spaces for the months and aligns the dates together
         System.out.print("    ");//use a for loop to print spaces up to the start day for each month
      }
      for(int e = 1; e <= amount; e++){//use another for loop to print the rest of the days in the calender
         if(e < 10){
            System.out.print(" " + e + "  ");//for the spaces
         }
         else{
            System.out.print(" " + e + " ");
         }
         if((startDay + e) % 7 == 0){ 
            System.out.println();
         }
      }
      thanks(startDay, month);//call the method thanks so it can work correctly
   }                   	
   public static int thanks(int startDay, int month) //this methods calculates the date for Thanksgiving
   {  
      int thanksDay = (5 + 3 * 7) - startDay;
      switch (month) {
         case 11:
            System.out.println(); 
            System.out.println("**Thanksgiving is on the " + thanksDay);
            break;
      }
      return 0;
   }			 								  		  		  			  		      
   public static int getMonthName(int month, int year) {
      switch(month){ //calls for the months just like the previous lab
         case 1: 
            {
               System.out.println("       January" + "  " + year);//print January
               System.out.println("----------------------------");
               break;
            }
         case 2:
            {
               System.out.println("       February" + "  "+ year);//prints February
               System.out.println("----------------------------");
               break;
            }
         case 3:
            {
               System.out.println("       March" + "  "+ year);//prints March
               System.out.println("-----------------------------");
               break;
            }
         case 4:
            {
               System.out.println("       April" + "  " + year);//prints April
               System.out.println("----------------------------");
               break;
            }
         case 5:
            {
               System.out.println("       May" + "  " + year);//prints May
               System.out.println("----------------------------");
               break;
            }
         case 6:
            {
               System.out.println("       June" + "  " + year);//prints June
               System.out.println(" ----------------------------");
               break;
            }
         case 7:
            {
               System.out.println("       July" + "  " + year);//prints July
               System.out.println("----------------------------");
               break;
            }
         case 8:
            {
               System.out.println("       August" + "  " + year);//prints August
               System.out.println("----------------------------");
               break;
            }
         case 9:
            {
               System.out.println("       September" + "  " + year);//prints September
               System.out.println("----------------------------");
               break;
            }
         case 10:
            {
               System.out.println("       October" + "  " + year);//prints October
               System.out.println("----------------------------");
               break;
            }
         case 11:
            {
               System.out.println("       Novemeber" + "  " + year);//prints November
               System.out.println("----------------------------");
               break;
            }
         case 12:
            {
               System.out.println("       December" + "  "+ year);//prints December
               System.out.println("----------------------------");
               break;
            }
      }
      return month;//returns the given month that the user inputs
   }
  	/*this method returns the start day of the month*/
   public static int getStartDay(int year, int month)
   {
      int startday = 3;//add 3 to the variable start
      int totalamountofdays = getTotalNumberOfDays(year,month);//call the method getTotalNumberOfDays and store it in a variable called start
      return(totalamountofdays + startday) % 7;//return start % 7    
   }
	/*returns the total number of the days up to the given month in the given year */
   public static int getTotalNumberOfDays(int year, int month) { 
      int total=0;
      for(int q = 1800; q < year; q++){
         if(isLeapYear(q)){
            total = total + 366; //leap year
         }
         else{
            total = total + 365;//not leap year or regular year
         }  
      }
      for(int q = 1; q <= month - 1; q++){
         total = total + getNumberOfDaysInMonth(year, q);
      }
      return total;//returns the total    
   }
   /*this method return the number of the days in the given month of the 
   given year; take leap year into consideration*/
   public static int getNumberOfDaysInMonth(int year, int month) {
      if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
         return 31;//the months that have 31 days
      }
      else if(month == 4|| month == 6 || month == 9 || month == 11){
         return 30;//the months that have 30 days
      }
      else if(isLeapYear(year)){
         return 29;//February, leap Year
      }
      else{
         return 28;//Just February with no Leap Year
      }                    
   }
	/*returns true if the given year is leap, false otherwise*/
   public static boolean isLeapYear(int year) {
      if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
         return true;
      }  
      else{
         return false;    
      }     
   }   
}
//end of the program