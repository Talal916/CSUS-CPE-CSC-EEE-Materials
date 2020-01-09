/**
 * CSC 15
 * Prof. White
 * @author Bleh
 * 10/30/2019
 * Program description: This program asks the user to input a text string, then
 * 						uses a lopping menu-driven interface to find the number of words, 
 * 						find a specific text string within the user input, and
 * 						replace various acronyms if found. 
 */
/*
 * Driver class for String Process uses StringProcessHelper to run
 */

import java.util.*;

public class StringProcessDriver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);				//new scanner
		
		String text = StringProcessHelper.wordsGet(s);	//get user's string input
		String test = new String("");					//an "exit flag"
	
		do {
			test = run(s, text);						
		} while (!test.contains("q"));			//loop as long as the menu choice is not or does not include "q"
	}
	
	/**
	 * This method run the program using the helper class and return a "flag"
	 * @param s		Scanner for menu input
	 * @param text	User's string input 
	 * @return choice	Used for "exit flag" test
	 */
	public static String run(Scanner s, String text) {
		String choice = StringProcessHelper.getInput(s);	//call the menu
	
		if (choice.contains("n"))				//for finding the number of words in the input
			StringProcessHelper.wordsCount(text);
		else if (choice.contains("f"))			//for finding a specific text string within the input
			StringProcessHelper.wordsFind(s, text);
		else if (choice.contains("r"))			//for replacing the acronyms
			StringProcessHelper.wordsReplace(text);
		else if (choice.contains("q"))			//quits the program, raises "exit flag"
			System.out.println("THANK YOU FOR USING THE PROGRAM!!!");
		else										//invalid input
			System.out.println("Wrong choice pal!");
		
		return choice;						//for the do-while loop
	}
}