import java.io.*;
import java.util.*;

public class WordGameLab
{
   public static void main(String[] args)
   throws FileNotFoundException 
   {
      //declare two arrays of String with a size
      String[] correct = new String[24];
      String[] incorrect = new String[24]; 
      
      //call the method description
      description();
      //call the method fillArray
      fillArray(correct, incorrect); 
      //call the method play
      play(correct, incorrect);
   }
   //prints out the description of the game on how the game works
   public static void description() {
   
      System.out.println("//////////////////////////////");
      System.out.println("///Welcome to the Game////"); 
      System.out.println("//////////////////////////////");
      System.out.println("To play this game, you will be asked to answer whether the words are either spelled ");
      System.out.println("correctly or incorrectly. If correct type a \"y\" and if not type \"n\""); 
   }
   
   //this method reads the file and fills in the array
   public static void fillArray(String[] correct, String[] incorrect) throws FileNotFoundException {
      
      File file1 = new File("correct.txt");//call the correct file
      File file2 = new File("incorrect.txt");//call the incorrect file
      int i=0;
      int h=0; 
      Scanner sc = new Scanner(file1); 
      Scanner bc = new Scanner (file2);
      while (sc.hasNextLine()){
         correct[i] = sc.nextLine(); 
         i++; 
      }   
      while (bc.hasNextLine()){ 
         incorrect[h] = bc.nextLine(); 
         h++;
      }      
   }
   
   public static void play(String[] correct, String[] incorrect) {
      Scanner keyBoard = new Scanner(System.in);
      int point = 0;
      int correctAnswer = 0;
      String answer;
      int randnum;
      int list = 0; //chooses if the word will be from the correct or incorrect list
      String replay = "y";
      int replayCorrect = 0;
      int timesplayed = 0; 
      String repeat = "y";
      Random random = new Random();
      while(repeat.equalsIgnoreCase("y")) {         
         timesplayed++;
            //generate a random number 0 or 1
         int lol= random.nextInt(2); 
         randnum= random.nextInt(20);          
            //if the random number is zero 
         if (lol == 0)
         {
                //generate a random number 0-19
            String k = correct[randnum]; 
            System.out.println("The word is: " + k);
            System.out.print("Misspelled? y/n: " );
            String userInput = keyBoard.next();
          
            if(userInput.equalsIgnoreCase("y")){ 
               point++;
               System.out.println("Correct!");                      
            }
            else { 
               System.out.println("Incorrect");                                    
            }
         }
         else{                
            String i = incorrect[randnum];
            System.out.println("The word is: " + i); 
            System.out.print("Misspelled? y/n: " );
            String userInput = keyBoard.next();
            if(userInput.equalsIgnoreCase("n")){ 
               point++;
               System.out.println("Correct!");                      
            }
            else{ 
               System.out.println("Incorrect"); 
            } 
            while(replay.equals("y") && timesplayed >= 5){   
               System.out.println("Your score is "  +point);
               System.out.println("You've played to much, why don't you give someone else a turn.");               
               String a= "y";
               while (a.equalsIgnoreCase("y")){
                  System.out.println("Would you like to play again? y/n ");
                  String c = keyBoard.next();
                  if (c.equalsIgnoreCase("y")){
                     timesplayed= 0;
                     point=0;
                     repeat= "y";
                     a="n";
                  }
                  else if (c.equalsIgnoreCase("n")){
                     replay = "n";
                     repeat = "n";
                     a = "n";
                     break;                     
                  }
                  else{
                     a = "y";
                  }                 
               }            
            }        
         }   
      }                              
   }
}