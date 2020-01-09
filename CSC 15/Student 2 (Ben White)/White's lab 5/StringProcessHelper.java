/**
 * Helper class for StringProcess
 */

import java.util.*;

public class StringProcessHelper {
	/**
	 * This is the menu
	 */
	public static void menu() {
		System.out.println("\nMENU");					//Menu interface
		System.out.println("n - Number of words");
		System.out.println("f - Find text");
		System.out.println("r - Replace acronyms");
		System.out.println("q - Quit");
	}
	
	/**
	 * This method shows the menu and asks the user for choices
	 * @param s			Scanner for user's choice input
	 * @return choice  	User's choice of program 
	 */
	public static String getInput(Scanner s) {
		menu();		
		System.out.print("\nChoose an option: ");	//get user's choice
		String choice = s.nextLine();					
		
		return choice;
	}
	
	/**
	 * This method gets user's text string input and dumps it on the screen
	 * @param s 	Scanner to get user text string input
	 * @return text The user's text string input
	 */
	public static String wordsGet(Scanner s) {
		System.out.print("\nEnter a sample text string: ");						//get text string input
		String text = s.nextLine();												
		System.out.println("===============================================");	//divider
		System.out.println("You entered: " + text);								//output user's text string out to the screen
		
		return text;
	}
	
	/**
	 * This method counts the total number of words in the user input text string
	 * @param text	The user input text string
	 */
	public static void wordsCount(String text) {
		int num = 1;
		for (int i = 0; i < text.length() - 1; i++) {					//loop from the first letter to the next to last letter
			if (text.charAt(i) == ' ' && text.charAt(i+1) != ' ')		//take the white space right before a letter
				num++;
		}
		System.out.printf("Number of words: %d\n", num);				//result
	}
	
	/**
	 * This method finds a string the user wants within the previously input text string
	 * @param s		Scanner to get the user input
	 * @param text	The user input text string
	 */
	public static void wordsFind(Scanner s, String text) {
		System.out.print("Enter a word or a phrase to be found: ");						//get the string in question 
		String find = s.nextLine();
		
		if (text.contains(find))		//cigar
			System.out.printf("\"%s\" is at position %d\n", find, text.indexOf(find));	//also shows position
		else							//no cigar
			System.out.printf("\"%s\" is not in the string.\n", find);
	}
	
	/**
	 * This method replaces the acronyms within the original user input text string (if there's any) 
	 * with the actual meaning
	 * @param text The user input text string
	 */
	public static void wordsReplace(String text) {
		String edited = text;				//initialize the string to be changed
		
		//multiple if-statements in case of multiple acronyms 
		if (edited.contains("TTYL"))
			edited = edited.replace("TTYL", "talk to you later");
		if (edited.contains("IDK"))
			edited = edited.replace("IDK", "I don't know");
		if (edited.contains("IMUHO"))
			edited = edited.replace("IMUHO", "in my utterly humble opinion");
		
		System.out.println("Edited text: " + edited);		//result
	}
}