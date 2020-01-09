/**
 * CSC 15
 * Prof. White
 * @author Bleh
 * Driver class for Process Name
 * Program Description: This program takes the user input and
 * 						prints out the user information using the helper class Name
 */
import java.util.*;

public class NameDriver {
	
	public static void main(String[] args) {
		run();
	}
	
	// Warning: wall of text
	public static void run() {
		Scanner promptloop = new Scanner(System.in);				
		System.out.print("How many report do you wish to generate? ");				//get the number of reports
		int num = promptloop.nextInt();
		promptloop.nextLine();
		
		System.out.println();
		
		for (int i = 0; i < num; i++) {
			Scanner prompt = new Scanner(System.in);
			
			//get the user's full name and birth year
			System.out.print("Please enter your full name: ");						//get full name
			String username = prompt.nextLine();
			System.out.print("Please enter your birth year: ");						//get birth year
			int year = prompt.nextInt();
			System.out.print("Please enter the life-expectancy year: ");			//get life expectancy
			int expect = prompt.nextInt();
				
			System.out.printf("\n1) %s has %d letters", username, Name.numCharacter(username));								//letters only, no spaces
		
			String last = Name.getLast(username);
			String first = Name.getFirst(username);
			
			System.out.printf("\n2) The index of the last name is %d", Name.indexName(username, last));						//index of last naem
			System.out.printf("\n3) \n\t%s\n\t%s %s\n\t%s, %s", 															//user's name in multiple formats
															username, 
															first, last, 
															last, first);
			System.out.printf("\n4) The middle name is %s and the number of charater in the middle name is %d", 			//number of character in the middle name
															Name.getMiddle(username), 
															(Name.getMiddle(username)).length());
			System.out.printf("\n5) The last name is %s and the number of character in the last name is %d", 				//number of character in the last name
															last, 
															last.length());
			System.out.printf("\n6) The uppercase version of the name is %s", username.toUpperCase());						//change the format into all upper-case
			System.out.printf("\n7) The encrypted first name is %s", Name.encryptFirst(first));								//encrypt the first name
			System.out.printf("\n8) The decrypted first name is %s", 
															Name.decryptFirst(Name.encryptFirst(first)));					//decrypt the encrypted first name
			System.out.printf("\n9) The full name in reverse order is %s", Name.reverse(username));							//get the full name in reverse orer
			System.out.printf("\n10) The age of the person is %d year old", Name.findAge(year));							//get the age of the user
			System.out.printf("\n11) %s has %%%.2f left of the %d-year life expectancy", 									//get the percentage of life left
															username, 
															Name.findPercent(Name.findAge(year), expect), 
															expect);
			System.out.println("\n==================================================================\n");		//divider between reports
		}
	}
}
