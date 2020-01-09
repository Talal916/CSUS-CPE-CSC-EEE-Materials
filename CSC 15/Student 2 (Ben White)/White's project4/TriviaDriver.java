/**
 * CSC 15
 * Prof. White
 * @author Bleh
 * 12/8/2019
 * Project 4 Description: This program runs a trivia game using two classes.
 */
import java.util.*;

/**
 * Driver (client) class for the program
 */
public class TriviaDriver {
	// Number of trivia questions
	public static final int NUMQUESTIONS = 6;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		playGame(s);
	}
	
	/**
	 * This method runs the trivia game, powered by the TriviaGame class using resources from TriviaQuestion objects
	 * @param s Scanner for user input
	 */
	public static void playGame(Scanner s) {
		boolean repeat = true;		// flag to repeat the game
		int count = 0;				// number of games played
		int tally = 0;				// total score from all games played
		TriviaQuestion[] mygame = populateQuestions();		// initialize array of TriviaQuestion objects
		TriviaGame play = new TriviaGame(mygame);			// badass-constructing the TriviaGame object to start the game
		
		while (repeat) {								// loop until the last question
			boolean moreQuestions = true;				// flag to stop asking questions
			while (moreQuestions) {						//essentially a for loop in disguise
				moreQuestions = play.askNextQuestion(s);	// flag can be raised here
				play.showScore();	
			}
			tally += play.getScore();
			count++;
			
			System.out.println("There is no more question!");
			System.out.println("Do you want to play again? (Y/n)");		// another game or not
			String rep = s.next();								
			if (rep.contains("N") || rep.contains("n"))		// raise flag
				repeat = false;
			else {
				play.restart();								// reset point
				System.out.println("_____________________________________");
			}
		}
		
		double avg = (double)tally / count;								// calculate average score
		
		System.out.println("==========================================");
		System.out.printf("You played %d games and your average score is %.2f.\n", count, avg);
		System.out.print("Thank you for playing.\nBye!");
	}
	
	/**
	 * This method initialize the array of TriviaQuestion objects
	 * @return mygame An initialized array of TriviaQuestion objects
	 */
	public static TriviaQuestion[] populateQuestions() {
		String[] questionArr = {"What is JBL's finisher move?",				// questions to be asked
				   			    "E3 happens in which season of a year?",
				   			    "Does DMV suck?",
				   			    "True or False: Gas price in California is too damn high?",
				   			    "Who is the leader of CSUS's VESPA?",
				   				"What vehicle embarassed Elon Musk recently?"};
		String[] answerArr = {"clothsline",									// corresponding answers
						  	"summer",
						  	"yes",
						  	"true",
						  	"zero",
						  	"truck"};
		int[] valueArr = {1, 2, 3, 4, 5, 6};								// corresponding point values
		
		TriviaQuestion[] mygame = new TriviaQuestion[NUMQUESTIONS];			// declare new array of objects
		
		for (int i = 0; i < mygame.length; i++) {
			String question = questionArr[i];
			String answer = answerArr[i];
			int value = valueArr[i];
			
			mygame[i] = new TriviaQuestion(question, answer, value);		// constructing object
		}
		return mygame;
	}
}