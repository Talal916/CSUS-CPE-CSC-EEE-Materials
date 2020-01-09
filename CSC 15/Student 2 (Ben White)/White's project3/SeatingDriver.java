/**
 * CSC 15
 * Prof. White
 * @author Bleh
 * Program description: This program assigns the user an airplane seat and 
 * 						makes that seat unavailable for the next choice.
 * 						Program will loop until there is no more seat left. 
 */
/**
 * Driver class for the program
 */
import java.util.*;

public class SeatingDriver {
	/**
	 * Static classes for numbers of rows and columns in the array 
	 */
	public static final int ROW = 7;
	public static final int COLUMN = 5; 
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		char[][] seat = SeatingAssignment.seatingMap();		// initialize 2D array
		int avail = (COLUMN-1) * ROW;			// first column is only for numbering
		
		run(s, seat, avail);
		
		System.out.println("*********************************************");
		System.out.println("Thank you for using the program!");
		System.out.println("We will make absolutely sure that there is no snake on the plane!");
		System.out.println("That said, Samuel Jackson will ride shotgun, just in case...");
		System.out.println("In hindsight, the only good thing about that movie was Samuel Jackson...");
	}
	
	public static void run(Scanner s, char[][] seat, int avail) {	
		do {
			SeatingAssignment.seatingDisplay(seat);			// print the map
			System.out.println("Please select a seat number (enter Q to quit): ");
			String user = s.nextLine().toUpperCase();		// get user input
		
			if (user.contains("q") || user.contains("Q"))	// quit on q/Q
				break;
			
			//verify input
			while (SeatingAssignment.rowCheck(user, s) || SeatingAssignment.seatCheck(user, s)) {	
				System.out.println("ERROR! Invalid input!");
				System.out.println("Please select a seat number (enter Q to quit): ");
				user = s.nextLine().toUpperCase();	
			}
			
			if (SeatingAssignment.seatingAssign(seat, user, s))	// assign seat (or reject seat choice)
				avail--;
			if (avail == 0)									    // fully booked
				System.out.println("The flight is fully booked! Please try again later.");
			
			System.out.println("=================================");
		} while(avail > 0);		// for as long as seats are available
	}	
}