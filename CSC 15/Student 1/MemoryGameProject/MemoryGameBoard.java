
import java.io.*;
import java.util.*;
public class MemoryGameBoard {
   public int BOARD_SIZE = 4;
   private int NUM_SWAPS = 1000;
   private Card[][] gameBoard = new Card[BOARD_SIZE+1][BOARD_SIZE+1];
   public MemoryGameBoard() {
      initializeCards();   
   }
   //calls the method turncardsfacedown
   public void shuffleCards() {
      Random rand = new Random();
      turnCardsFaceDown();
      for (int i = 1; i <= NUM_SWAPS; i++) {
         int num1 = rand.nextInt(BOARD_SIZE) + 1;
         int num2 = rand.nextInt(BOARD_SIZE) + 1;
         int num3 = rand.nextInt(BOARD_SIZE) + 1;
         int num4 = rand.nextInt(BOARD_SIZE) + 1;
         Card temp = gameBoard[num1][num2];
         gameBoard[num1][num2] = gameBoard[num3][num4];
         gameBoard[num3][num4] = temp;
      }
      
   }
   /*calls the method hideboard to hide the previously printed board.
     uses the tostring method to display the current state of the gameboard on the monitor */
   public void showBoard() {
      hideBoard();
      System.out.print(toString());
   }
   /*returns true if the card at gameboard[row1][col1] is equal to the card at gameboard[row2][col2]
     otherwise false is returned*/
   public boolean cardsMatch(int row1, int col1, int row2, int col2) {
      Card s = gameBoard[row1][col1];
      Card t = gameBoard[row2][col2];
      if(s.equals(t)){
         return true;
      } 
      else {         
         return false;
      }   
   }
   /*returns the value of the instance variable faceup for the card at gameboard[row][col]
   this method will call the method isfaceup in the card class*/
   public boolean isFaceUp(int row, int col) {  
      Card s = gameBoard[row][col];
      return s.isFaceUp(); 
   }
   //turns over the card at gameboard[row][col] by calling the flipcard method in the card class
   public void flipCard(int row1, int col1) {
      gameBoard[row1][col1].flipCard();
   }
   /*builds and returns a string that contains the current state of the gameboard in the format shown
     below
     it goes through the gameBoard array using the tostring method from the card class to add
     each of the cards to the string*/
   public String toString() {
      String gamecolumns = "    1 2 3 4\n";
      String gameborder = "   =========\n";
      String game = "";
      
      for (int i = 1; i <= BOARD_SIZE; i++) {
         game += i + " | ";
         for (int j = 1; j <= BOARD_SIZE; j++) {
            game += gameBoard[i][j].toString() + " ";
         }
         game += "|\n";
      }
      return gamecolumns + gameborder + game + gameborder;
   }
   private void initializeCards() {
      int count = 0;
      for (int i = 1; i < gameBoard.length; i++) {
         for (int j = 1; j < gameBoard[i].length; j++) {
            gameBoard[i][j] = new Card((count/2) + 1);
            count++;
         }
      }  
   }
   //hides the last board printed on the screen by scrolling it down using system.out.println() 
   private void hideBoard() {
      for (int i = 1; i <= 10; i++)
      {
         System.out.println();
      }
   }
   /*sets the value of the instance variable faceup to false for all the cards in the gameboard array by
     calling the method setfaceup in the card class*/
   private void turnCardsFaceDown() {
      for (int i = 1; i <= BOARD_SIZE; i++) {
         for (int j = 1; j <= BOARD_SIZE; j++) {
            gameBoard[i][j].setFaceDown();
         }
      }
   }
}//end of code