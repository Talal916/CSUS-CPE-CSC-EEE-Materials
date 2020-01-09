import java.util.*;

/**
 * CSC 15
 * Prof. White
 * @author Bleh
 * 11/13/2019
 * Program Description: This program simulate a driver license test, prompting the user to
 * 						input answers, comparing it to the randomly generated answer key, 
 * 						testing to see if the user passed or failed, and prompting for repetition
 */
public class DriverLicenseDriver {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		boolean exitflag = false;
		
		while (!exitflag) {
			exitflag = run(s, rand);
		}
	}

	public static boolean run(Scanner s, Random rand) {
		char[] key = new char[10];
		char [] user = new char[10];
		
		DriverLicense.getKey(rand, key);
		DriverLicense.getUser(s, user);
		DriverLicense.result(key, user);	
		
		System.out.println("Is there another person in line? (Y/N) ");
		char rep = s.next().charAt(0);
		
		return !(rep == 'Y' || rep == 'y');	
	}
}
