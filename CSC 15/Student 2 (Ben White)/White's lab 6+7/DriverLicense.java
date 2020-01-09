/**
 * Helper class for the program
 */
import java.util.*;

public class DriverLicense {
	/**
	 * This method gets a random string of ABCD as answer key for the test
	 * @param rand for Random key 
	 * @param key	answer key array
	 * @return ans	answer key array into a string
	 */
	public static void getKey(Random rand, char[] key) {
		String answer = new String("ABCD");
		for (int i = 0; i < key.length; i++)
			key[i] = answer.charAt(rand.nextInt(4));
	}
	
	/**
	 * This method gets user answers to the test questions, validates, and turns them into uppercase
	 * @param s Scanner for user input
	 * @param user	User's answer stored in an array
	 */
	public static void getUser(Scanner s, char[] user) {
		System.out.println("Please read the question carefully in the given booklet.");
		System.out.println("Enter your answer:");
		
		for (int i = 0; i < user.length; i++) {
			System.out.print("answer " + (i+1) + ": ");
			user[i] = s.next().toUpperCase().charAt(0);
			validate(s, i, user);
		}
	}
	
	/**
	 * This method evaluates the user input to get the result
	 * @param key	Answer key
	 * @param user  User input
	 */
	public static void result(char[] key, char[] user) {
		int wrong_size = 0;
		String error = new String();
		
		System.out.println(Arrays.toString(user));
		System.out.println(Arrays.toString(key));
		
		for (int i = 0; i < 10; i++) {
			if (user[i] != key[i]) {
				wrong_size++;
				error += (i+1) + " ";
			}
		}	
		
		System.out.print("Question answered wrong: ");
		System.out.print(error);
		
		System.out.println();
		if (wrong_size >= 3) {
			System.out.println("Sorry you have to take the test again");
			System.out.println("You had more than three questions wrong.");
		}
	}
	
	/**
	 * This methods validate the user input from getUser
	 * @param s	Scanner to get user another input if the previous one is invalid
	 * @param i	current index of the user array
	 * @param user	User's answer array
	 */
	public static void validate(Scanner s, int i, char[] user) {
		while (user[i] != 'A' && user[i] != 'B' && user[i] != 'C' && user[i] != 'D') {
			System.out.println("Invalid answer! ");
			System.out.print("answer " + (i+1) + ": ");
			user[i] = s.next().toUpperCase().charAt(0);
		}
	}
}