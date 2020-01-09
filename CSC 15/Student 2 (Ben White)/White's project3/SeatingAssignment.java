/**
 * Helper class for the program
 */

import java.util.*;

public class SeatingAssignment {
	/**
	 * Static classes for numbers of rows and columns in the array 
	 */
	public static final int ROW = 7;
	public static final int COLUMN = 5; 
	
	/**
	 * This method initializes the seating map array
	 * @return seat The seating map
	 */
	public static char[][] seatingMap() {
		char[][] seat = {{'1','A','B','C','D'},
				 		 {'2','A','B','C','D'},
				 		 {'3','A','B','C','D'},
				 		 {'4','A','B','C','D'},
				 		 {'5','A','B','C','D'},
				 		 {'6','A','B','C','D'},
				 		 {'7','A','B','C','D'}};
		return seat;
	}
	
	/**
	 * This method assigns the seat to the user or rejects the input
	 * @param seat	Seating map array
	 * @param user	User's input
	 * @return okflag seat has been assigned or not
	 */
	public static boolean seatingAssign(char[][] seat, String user, Scanner s) {
		boolean okflag = false;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				if (user.charAt(0) == seat[i][0] && user.charAt(1) == seat[i][j]) {
					seat[i][j] = 'X';			// mark the user's seat as taken
					okflag = true;
				}	
			}
		}
		
		if (okflag)
			System.out.println("Seat successfully assigned!");
		else
			System.out.println("Sorry! This seat has ALREADY BEEN CONQUERED BY ALEXANDER THE GREAT!");
		
		return okflag;
	}
	
	/**
	 * This method prints the seating map out to the screen
	 * @param seat The seating map array
	 */
	public static void seatingDisplay(char[][] seat) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				System.out.print(seat[i][j]);
				if (j == 0)
					System.out.print("| ");
				if (j == 2)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * This method check to see if the user input is valid row-wise
	 * @param user User input
	 */
	public static boolean rowCheck(String user, Scanner s) {
		return (user.charAt(0) != '1' && user.charAt(0) != '2' && 
				user.charAt(0) != '3' && user.charAt(0) != '4' &&
				user.charAt(0) != '5' && user.charAt(0) != '6' &&
				user.charAt(0) != '7');
	}
	
	/**
	 * This method check to see if the user input is valid seat-wise
	 * @param user User input
	 */
	public static boolean seatCheck(String user, Scanner s) {
		return (user.charAt(1) != 'A' && user.charAt(1) != 'B' && 
				user.charAt(1) != 'C' && user.charAt(1) != 'D');
	}
}