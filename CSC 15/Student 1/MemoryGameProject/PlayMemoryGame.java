import java.io.*;
import java.util.*;

public class PlayMemoryGame {
   Scanner kb = new Scanner(System.in);
   MemoryGameBoard game = new MemoryGameBoard();
   //run the whole program
   public static void main(String[] args) {
      int bestScore = 500;
      int turnCount;
      int pairsLeft;
      boolean repeat = true;
      MemoryGameBoard game = new MemoryGameBoard();
      Scanner kb = new Scanner(System.in);
      //the directions
      System.out.println("CSC 15 - Sam Lee");
      System.out.println();
      System.out.println();
      System.out.println("Welcome to the Memory Game.");
      System.out.println("The goal is to find all the matching pairs in as few turns as possible.");
      System.out.println("At each turn select two different positions on the board to see if they match.");
      while(repeat) {
         turnCount = 0;
         pairsLeft = 8;
         int minimum = 1;
         int maximum = 4;
         int row1;
         int row2;
         int col1;
         int col2;
         String wordname;
         game.shuffleCards();  
         System.out.println("Are you ready? y/n ");
         String start = kb.next();
         while (!start.equalsIgnoreCase("y") && !start.equalsIgnoreCase("n")) {
            System.out.println("Please enter a valid answer.");
            System.out.println("Are you ready? y/n ");
            start = kb.next();    
         }
         //if player inputs y, then the game starts, if not then the game will end
         if(start.equalsIgnoreCase("y")){
            repeat = true;
         } 
         else {
            System.out.println("Okay, game will end. Thank you!");
            repeat = false;
            break;
         }
         while(pairsLeft > 0) {
            turnCount++;
            //outputs game board   
            game.showBoard();                
            System.out.println("Where is the first card you wish to see?");
         
            wordname = "Row: ";
            row1 = getValidInt(kb,wordname, minimum, maximum);
            wordname = "Col: ";
            col1 = getValidInt(kb,wordname, minimum, maximum);
               
            while(game.isFaceUp(row1, col1)) {
               System.out.println("That card is already face up.\nChoose another.");
               System.out.println("Where is the first card you wish to see?");
            
               wordname = "Row: ";
               row1 = getValidInt(kb, wordname, minimum, maximum);
               wordname = "Col: ";
               col1 = getValidInt(kb, wordname, minimum, maximum);
            }    
            game.flipCard(row1,col1);             
            System.out.println("Where is the second card you wish to see?");
         
            wordname = "Row: ";
            row2 = getValidInt(kb, wordname, minimum, maximum);
            wordname = "Col: ";
            col2 = getValidInt(kb, wordname, minimum, maximum);
            while(game.isFaceUp(row2, col2)) {
               System.out.println("That card is already face up.\nChoose another.");
               System.out.println("Where is the first card you wish to see?");
            
               wordname = "Row: ";
               row2 = getValidInt(kb, wordname, minimum, maximum);
               wordname = "Col: ";
               col2 = getValidInt(kb, wordname, minimum, maximum);
            }
            game.flipCard(row2, col2);
            System.out.print(game.toString());               
            if(game.cardsMatch(row1, col1, row2, col2)) {
               pairsLeft--;
               System.out.println("You found a match");
               System.out.println("Press any key and the enter to continue");
               kb.next();
            } 
            else {
               game.flipCard(row1, col1);
               game.flipCard(row2, col2);
               System.out.println("Sorry, no match");
               System.out.println("Press any key and then enter to continue");
               kb.next();
            }   
         }
         bestScore = turnCount;
         System.out.println("CONGRATULATIONS! You found all the matching pairs!");
         System.out.printf("You did it in %d turns.\n", turnCount);   
         System.out.println("Do you want to start again? y/n ");
         String restart = kb.next();
         //if payers doesn't input y or n
         while (!restart.equalsIgnoreCase("y") && !restart.equalsIgnoreCase("n")) {
            System.out.println("Please enter a valid answer.");
            System.out.println("Are you ready? y/n ");
            restart = kb.next();
         }
         if(restart.equalsIgnoreCase("y")) {
            repeat = true;
         } 
         else {
            System.out.println("Okay, game will end. Thank you!");
            repeat = false;
            break;
         }
      }
   }
   //inputs your value and if your value is invalid it prints a error message
   public static int getValidInt(Scanner kb, String wordname, int min, int max) {
      int number = 0;
      boolean something = true;
      while(something != false) {
         System.out.print(wordname);
         if(kb.hasNextInt()) {
            number = kb.nextInt();
         }
         else
         {
            kb.nextLine();
         }
         if(number > min - 1 && number < max + 1) {
            something = false;
         }
         
         else {
            System.out.print("ERROR: this is not a valid input (1...4)\n\n"); 
            System.out.println("");
            kb.nextLine();
         
         }
      }
      return number;
   }
}