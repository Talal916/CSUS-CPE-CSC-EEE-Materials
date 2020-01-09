/**
 * CSC 15
 * Prof. White
 * 10/10/2019
 * @author Bleh
 * Program Desciption: This program convert the scores of students from the 0-100 format to 
 * 						the GPA format using nested if-statements
 */

import java.util.*;

public class Grader {

	public static void main(String[] args) {
		GraderHelper.printDescription();		//text description
		
		Scanner s = new Scanner(System.in);
		runProgram(s);
	}
	
	public static void runProgram(Scanner s) {
		int num = GraderHelper.getNumTimes(s);	//get the number of repetition
		
		for (int i = 0; i < num; i++) {
			GraderHelper.getGrade(s);			//get score then convert and print out GPA
			System.out.println();
		}
	}
}