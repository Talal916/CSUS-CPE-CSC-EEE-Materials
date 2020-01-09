/**
 * Helper class for Grader
 */

import java.util.Scanner;

public class GraderHelper {
	
	/**
	 * This method get the number of scores that need converting
	 * @param s	The Scanner
	 * @return num 	The number of repetition
	 */
	public static int getNumTimes(Scanner s) {
		System.out.println("How many times you want to run the program? ");
		int num = s.nextInt();
		return num;
	}
	
	/**
	 * This method get and convert the scores to GPA (also have a check for invalid input)
	 * @param s The Scanner
	 */
	public static void getGrade(Scanner s) {
		System.out.println("Please enter a score: ");
		int score = s.nextInt();
		
		double grade;
		
		if (score >= 0 && score <= 100) {
			if (score >= 95)					//95, 96, 97, 98, 99, 100
				grade = 4.0;
			else if (score >= 63 && score <= 94)	//63, 64, 65 ... 92, 93, 94
				grade = 0.1*score - 5.5;
			else if (score >= 60 && score <= 62)	//60, 61, 62
 				grade = 0.7;
			else 							//anything ranging from 0 to 59
				grade = 0.0;
			
			System.out.printf("This student earned a %.1f for score of %d", grade, score);
		}
		else										//if the grade is less than 0 or greater than 100
			System.out.println("You screwed up dude!");
	}
	
	/**
	 * This method prints out a program description
	 */
	public static void printDescription() {
		System.out.println("******************************************************");
		System.out.println("* Hello there, this program calculate the GPAs based *");
		System.out.println("* on the test scores of the students (ranging from 0 *");
		System.out.println("* to 100). Toodle!                                   *");
		System.out.println("******************************************************");
	}
}
