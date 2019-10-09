import java.util.*;
import java.io.*;

public class LibraryDriver {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner kb = new Scanner(System.in);
      LibraryBook[] books = new LibraryBook[7];
      books=fillArray(books);
      boolean repeat = true;
      System.out.println("-------WELCOME TO THE LIBRARY-------\n");    
      while (repeat=true) {
         int choice=0;
         while(choice!=1&&choice!=2) {
            System.out.print("Enter 1 to check out a book.\nEnter 2 to return a book.\nEnter your choice---> ");
            choice=kb.nextInt();
         }     
      //display the options to check in or check out a book;
      //get the user's choice
      //if choice is 1
         if(choice==1) {
         //display the books
            displayBooks(books);
            getChoice(books,kb);
         //call the method getChoice
         }
         else
         //else
         {
            displayBooks(books);
            checkIn(books,kb);
         //display the books
         //call the method check in
         }
         System.out.println("Another transaction y/n? ");
         String selection=kb.next();
         if(selection.equalsIgnoreCase("n")) {
            break;
         }     
      //ask the user if there is another transaction  
      }    
   }
   public static void checkIn(LibraryBook[] books, Scanner kb) {
      kb.nextLine();
      System.out.print("Enter the id of the book : ");
      boolean found = false;
      String id = kb.next();
      int founded=0;
      for(int i=0;i<books.length;i++) {
         if(id.equals(books[i].getId())) {
            if(books[i].getReturnedDate()!=books[i].getBorrowedDate()) {
               System.out.println("Your book has been returned to the library. Thanks");
               books[i].setDateNull();
               founded++;
            }
         }
      }           
      if(founded==0) {
         System.out.println("You entered the wrong ID.");
      }    
   }
  //this method reads the info for the books from a file and stores it in the array
   public static LibraryBook[] fillArray(LibraryBook[] books) throws FileNotFoundException {
      File fbooks = new File("books.txt");
      Scanner input= new Scanner(fbooks);
      int i=0;
      while(input.hasNextLine()) {
         String title=input.nextLine();
         String author=input.nextLine();
         String id=input.nextLine();
         LibraryBook lo=new LibraryBook(title,author,id);
         books[i]=lo;
         i++;     
      }     
      return books;  
   } 
  //this method displays the info about the books and their avaiability
   public static void displayBooks(LibraryBook[] books) {
      System.out.println("   LIBRARY OF CALIFORNIA STATE UNIVERSITY<SACRAMENTO");
      System.out.println("-------------------------------------------------------");
      System.out.println("   ID          Title                     Author");
      System.out.println("-------------------------------------------------------");
      for(int i=0;i<=books.length-1;i++) {
         System.out.print((i+1)+". "+books[i].toString()+", ");
         if(books[i].getBorrowedDate()==books[i].getReturnedDate()) {
            System.out.print("Available\n");        
         }
         else
         {
            System.out.print("Not Available\n");
         }     
      }  
   }
  //this method allows the user to choose a book from the list. as long as the selected book is checked out
  //the user will be prompted for a valid book 
   public static void getChoice(LibraryBook[] books, Scanner kb) {
      System.out.println("\nChoose one of the avaible books,");
      System.out.print("Enter the number assosiated with the book: ");
      int num = kb.nextInt();
     //as long as the book is not avaiable
      while(books[num-1].getBorrowedDate()!=books[num-1].getReturnedDate()) {
         System.out.println("The selected book is not available until: "+books[num-1].getReturnedDate());
         System.out.print("Choose another book: ");
         num=kb.nextInt();      
       //display the due date for the selected book
       //ask the user to enter a new book number       
      }
      books[num-1].setDateBorrowed();
      books[num-1].setDateReturned();
      System.out.println("You have checked out:\n"+books[num-1].toString());
      System.out.println("You must return the book by : " +books[num-1].getReturnedDate());
     //call the method setdateBorrowed and setDateReturned
     //display the info the book that the user is boroowing
    // display the return date for the book 
   }
}           
            
