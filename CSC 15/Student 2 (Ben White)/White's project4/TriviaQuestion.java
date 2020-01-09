/**
 * TriviaQuestion class for an object containing a question, an answer, and a point value
 */
public class TriviaQuestion {
	// private fields
	public String question;
	public String answer;
	public int value;
	
	// Object constructor
	public TriviaQuestion(String question, String answer, int value) {
		this.question = question;
		this.answer = answer;
		this.value = value;
	}
	
	// Accessors
	public String getQuestion() {
		return this.question;
	}
	public String getAnswer() {
		return this.answer;
	}
	public int getValue() {
		return this.value;
	}
}