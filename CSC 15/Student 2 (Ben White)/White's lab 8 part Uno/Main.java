/**
 * CSC 15
 * Prof. White
 * 11/27/2019
 * @author Bleh
 * Program description: This program reads a text file to generates information of fictional "Hokeemons" 
 * 								- Lord of the Ring knock-off toys
 */

/**
 * Client/Driver for testing and printing information
 */
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Hokeemon[] myHokee = Hokeemon.getData();
		
		System.out.println(Arrays.toString(myHokee) + "\n");	//print array
		
		for (int i = 0; i < myHokee.length;i++)					//print intros
			myHokee[i].getBio(myHokee[i], myHokee);
	}
}