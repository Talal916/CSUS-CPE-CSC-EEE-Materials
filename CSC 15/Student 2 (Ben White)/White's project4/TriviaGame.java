/**
 * TriviaGame class that runs the game
 */
import java.util.*;

public class TriviaGame {
	// private fields
	private TriviaQuestion[] questions;
	private int score = 0;
	private int questionNum = 0;
	
	// (midget) Constructor
	public TriviaGame(TriviaQuestion[] trivia) {
		this.questions = Arrays.copyOf(trivia, trivia.length);
	}
	
	/**
	 * This method runs a question, gets answer, validates, adds score
	 * @return if there are more question or not
	 */
	public boolean askNextQuestion(Scanner s) {
		System.out.println("Question " + (questionNum + 1));						// question index
		System.out.printf("For %d points, %s\n", questions[questionNum].value, 		// ask question
												 questions[questionNum].question);	
		String user = s.nextLine().toLowerCase();									// get user answer
		
		if (user.equalsIgnoreCase(questions[questionNum].getAnswer())) {			// evaluate user answer
			System.out.println("That is correct!");
			score += questions[questionNum].value;			// if correct, add score
		}
		else 												// else, show correct answer
			System.out.println("Wrong, the correct answer is " + questions[questionNum].answer);
		
		questionNum++;															// increment array index
		return (questionNum < questions.length);								// more question or not?
	}
	
	/**
	 * This method shows the current score after the answer has been evaluated, not much more
	 */
	public void showScore() {
		System.out.println("Your score is: " + score + "\n");
	}
	
	/**
	 * This method reset the score and question index if the user wants another go at the game
	 */
	public void restart() {			//KILLER QUEEN BITE ZA DUSTO!!!
		score = 0;
		questionNum = 0;
	}
	
	// Accessor for the field score, meh
	public int getScore() {
		return this.score;
	}
}