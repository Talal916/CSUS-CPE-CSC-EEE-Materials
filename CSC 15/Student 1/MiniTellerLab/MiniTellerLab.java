import java.util.Scanner;

public class MiniTellerLab {

/*in the main method you need to call the method validChoice
as long as the user's choice is not Q or q
based on the user's choice call the appropriate methods such as balance, depoist, withdraw and cretate
once the user select Q or q, prompt the user if there is another customer
*/
   public static void main(String[] args) {
   
      Scanner kb = new Scanner(System.in);
      String choice = "";
      double balance = 0;
      description();
      boolean repeat = true;
      String answer = "";
      boolean account = false;
      while (repeat) //as long as there is another user
      {
         balance = 0;
         choice = "";
         account = false;
         while (!choice.equalsIgnoreCase("Q"))// as long as the user has not selected quit
         {
         //your code includes conditional statements
            displayChoices();
            choice = validChoice(kb);
            switch(choice)
            {
               
               case "C":   balance = create(kb, balance);
                  System.out.println("The amount of the money that you have is-->" + balance);
                  System.out.println("Your account has been created successfully"); 
                  System.out.println();
                  break;
               case "D":   balance = deposit(kb, balance);
                  System.out.println("The amount of the money that you have is-->" + balance);
                  System.out.println("Your new balance after deposit is: " + (balance)); 
                  System.out.println();
                  System.out.println("Hit enter key to continue --> ");
                  Scanner me = new Scanner(System.in);
                  me.nextLine();
                  break;
               case "W":   balance = withdraw(kb, balance);
                  System.out.println("The amount of the money that you have is-->" + balance);
                  System.out.println();
                  System.out.println("Hit enter key to continue --> ");
                  Scanner console = new Scanner(System.in);
                  console.nextLine(); 
                  break;
               case "B":   System.out.println("Your balance is --> " + balance);
                  System.out.println();
                  System.out.println("Hit enter key to continue --> ");
                  Scanner you = new Scanner(System.in);
                  you.nextLine(); 
                  break;
               case "Q":   
                  break;
            }
         }
         System.out.println("Thanks for being our loyal customer.");
         System.out.print("Is there another user?yes/no ");
         String str = kb.next();
         if(str.toUpperCase().equals("YES"))
            continue;
         else
            break;     
      }
      System.out.println("The system is about to shut down");
   
   }
/*this method accepts a Scanner object and the balance of the money that the person has as its parameter
prompt the user to enter the amount of the money to withdraw
call the method dataValiation to get the user's input
if the user's input is more than the balance display that the user cannot withdraw that amount
if the balance - the user's input is less than 100 then no withdraw can be done
otherwise the withdraw can be done therefore the user's input must be subtracted from the balance. then return the new balance
*/
   public static double withdraw(Scanner kb, double balance)
   {
   
      double amount = dataValidation("Enter the amount of the withdraw--> ", kb);
      if(amount > balance)
         System.out.println("You do not have enough money to withdraw");
      else if(balance - amount < 100)
      {
         System.out.println("Your balance cannot go below 100 dollars.");
         System.out.println("your balance after withdraw will be : " + (balance-amount));
      }  
      else
      {
         System.out.println("The amount of the money you have--> " + balance);
         balance -= amount;
      }
      return balance;
   
   }
/*this method prompt the user for the amount to deposit
call the method dataValidation to get the user's input
add the amount to the balance, return the new balance*/
   public static double deposit(Scanner kb, double balance)
   {
      double amount = dataValidation("Enter the amount of the money to deposit--> ", kb);
      balance += amount;
      return balance;
   }
/*
this method prompts the user to enter the initial amount of the money to create the account
call the method dataValidation
if the user's input is less than 100, the account cannot be created
otherwise the account will be created and a message will be displayed
indicating that the account has been created, the initial amount of the money will be returned
*/
   public static double create(Scanner kb, double balance)
   {
      double amount;
      while(true)
      {
         if(balance == 0) {
            System.out.print("Enter the initial amount of money--> ");
            amount = kb.nextDouble();
            if(amount < 0)
            {
               System.out.println("You must enter a positive amount of money.");
               return create(kb, balance);
            }
            else if(amount < 100)
            {
               System.out.println("You must deposit 100 or more to create a new account");
               System.out.print("Do you want to create a new account? ");
               String str = kb.next();
               if(str.toUpperCase().equals("YES"))
                  return create(kb, balance);
               else
                  return 0;  
            
            }   
            else
               return amount;
         }
         else 
            System.out.print("You already have an account.");
         break;
      }  
      return 0;
   }

/*
this method outputs Welcome to the Bank of America message including all the back slashes
*/
   public static void description( )
   {
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
      System.out.println("\\\\ Welcome to the Bank of America \\\\");
      System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
   }
/*
this method displays the choices that the user has*/
   public static void displayChoices()
   {
     
      
      System.out.println("Select one of the following options");
      System.out.println("Press C to create a new account");
      System.out.println("Press D to deposit");
      System.out.println("Press W to withdraw");
      System.out.println("Press B for Balance");
      System.out.println("Press Q to quit");
   }
/*this method prompts the user to enter the choice
as long as the user does not have a valid choice, it will keep prompting the user
for a valid choice*/   
   public static String validChoice(Scanner kb)
   {
      while(true)
      {
         System.out.print("Enter your choice ---> ");
         String choice = kb.next().toUpperCase();
         switch(choice)
         {
            case "C":
            case "D":
            case "W":
            case "B":
            case "Q":   
               return choice;
         }
      }
   }
/*this method accepts the scanner object and a message to be displayed on the screen
outputs the prompt on the screen asking the user to enter the amount
as long as the amount is less than zero and as long as the user is entering an invalid
double value, this method should keep prompting the user for a valid amount.
return the valid amount*/
  
   public static double dataValidation(String prompt, Scanner kb)
   {
      while(true)
      {
         System.out.print(prompt);
         double amount = kb.nextDouble();
         if(amount >= 0)
            return amount;
      }   
   }
}