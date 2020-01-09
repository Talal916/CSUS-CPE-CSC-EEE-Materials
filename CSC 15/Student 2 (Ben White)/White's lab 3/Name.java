import java.util.Scanner;

/**
 * Helper class for Process Name
 */
public class Name {
	/**
	 * Count the number of letters in a name (exclude spaces) 	
	 * @param name The name used for counting
	 * @return	The number of character in such name
	 */
	public static int numCharacter(String name) {
		//extract last, middle, first name
		String firstName = getFirst(name);
		String middleName = getMiddle(name);
		String lastName = getLast(name);
		
		//Add number of char in each part
		int numChar = firstName.length() 
					+ middleName.length() 
					+ lastName.length();
		
		return numChar;
	}
	
	/**
	 * This method extracts the first name from the full name
	 * @param name	The full name 
	 * @return first	The first name from the full name
	 */
	public static String getFirst(String name) {
		Scanner stringScan = new Scanner(name);
		String first = stringScan.next();		//move to next white space
		
		return first;
	}
	
	/**
	 * This method extracts the middle name from the full name
	 * @param name	The full name 
	 * @return middle	The middle name from the full name
	 */
	public static String getMiddle(String name) {
		Scanner stringScan = new Scanner(name);
		stringScan.next();
		String middle = stringScan.next();		//move to next white space
		
		return middle;
	}
	
	/**
	 * This method extracts the last name from the full name
	 * @param name	The full name 
	 * @return last	The last name from the full name
	 */
	public static String getLast(String name) {
		Scanner stringScan = new Scanner(name);
		stringScan.next();
		stringScan.next();
		String last = stringScan.next();		//move to next white space
		
		return last;
	}
	
	/**
	 * This method finds the index of the last name with respect to the full name
	 * @param name	The full name 
	 * @return index+1	The index of the last name in the full name
	 */
	public static int indexName(String name, String last) {
		return name.indexOf(last) + 1;	//because array starts with "0"
	}
	
	/**
	 * This method encrypt the first name by swapping the first letter with the last
	 * @param first	The original first name
	 * @return encrypted	The encrypted first name
	 */
	public static String encryptFirst (String first) {
		String encrypted = first.substring(first.length() - 1, first.length()) 	//rearrangement
				+ first.substring(1, first.length() - 1) 
				+ first.substring(0, 1);
		return encrypted;
	}
	
	/**
	 * This method decrypt the name from encryptFirst
	 * @param encrypted	The encrypted first name
	 * @return decrypted	The decrypted name
	 */
	public static String decryptFirst (String encrypted) {
		String decrypted = encrypted.substring(encrypted.length() - 1, encrypted.length()) 
				+ encrypted.substring(1, encrypted.length() - 1) 
				+ encrypted.substring(0, 1);
		return decrypted;
	}
	
	/**
	 * This method turns all characters of the name to uppercase and in reverse order
	 * @param name	The name of the user 
	 * @return reverse	The reversed order name 
	 */
	public static String reverse(String name) {
		String reverse = new String("");
		for (int i = name.length(); i > 0; i--) {
			reverse += name.charAt(i-1);
		}
		
		return reverse.toUpperCase();
	}
	
	/**
	 * This method calculate the user's age based on the birth year
	 * @param year	The entered birth year of the user
	 * @return age 	The calculated age of the user
	 */
	public static int findAge(int year) {
		int currentyear = 2019;
		return (currentyear - year); 
	}
	
	/**
	 * This method calculates the users' percentage of life left based on their ages and their desired life expectancy
	 * @param age	The age of the users
	 * @param expect	The life expecteancy entered by the user
	 * @return percent	The percentage of life they have left 
	 */
	public static double findPercent(int age, int expect) {
		double percent = (expect - age)*100 / expect;
		return percent;
	}
}