/**
 * CSC 15
 * Prof. White
 * 10/8/2019
 * @author Bleh
 * Program description: This program converts decimal numbers into their respective Roman numeral values
 */
import java.util.*;

/**
 * Driver class for the program
 */
public class RomanDriver {
	
	public static void main(String[] args) {
		RomanHelper.description();				//print the description from the helper class
		
		Scanner prompt = new Scanner(System.in);
		runProgram(prompt);
	}
	
	//ask user for the number of decimal numbers need converting
	public static void runProgram(Scanner prompt) {
		System.out.print("How many numbers do you want to convert? ");
		int num = prompt.nextInt();
		if (num <= 0)
			System.out.println("BAHH! GET LOST THEN, YOU WRETCHED HEATHEN!!!");
		else {
			for (int i = 0; i < num; i++) {	
				getNextNumber(prompt);
				System.out.println("\n----------");
			}
			//advertisement and trivia
			System.out.println("Thank you for using the program.");							 
			System.out.println("Remember to attend the stabbing of Caesar on the 15th of March, 44BC! HEY WHERE ARE YOU RUNNING TO GAIUS?");
			System.out.println("MEN, SIEZE HIM! AND FIND ME MARCUS!");
			System.out.println("... Anyway, Free knife-with-Caesar-blood giveaway! 50% off lead-stained wine!\n");
			System.out.println("By the way, friends, did you know that Hercules is a Roman deity \"inspired\" by the Greek's Heracles?");
			System.out.println("Yes, this means that the Disney movie \"Hercules\" was factually incorrect.");
			System.out.println("The same issue with the game \"God of War 3.\"");
			System.out.println("Now that you know, how do you plan on sleeping tonight?");
		}
	}
	
	//get user's numbers, control loop, converting numbers  
	public static void getNextNumber(Scanner prompt) {
		System.out.print("Please enter the number you would like to convert: ");			//get the decimal
		int decimal = prompt.nextInt();
		
		if (decimal <= 0)		//in case of wrong input
			System.out.printf("Sorry, but %d is not a positive number and therefore Carthage must be destroyed.", decimal);
		else 					//call getRoman from the helper class to convert the number
			System.out.printf("%d as a Roman Numeral is %s", decimal, RomanHelper.getRoman(decimal));	
	}
}