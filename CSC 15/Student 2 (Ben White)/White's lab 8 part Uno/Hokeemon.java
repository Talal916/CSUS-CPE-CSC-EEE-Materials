import java.io.*;
import java.util.Scanner;

/**
 * Hokeemon class to create the Hokeemon object
 */
public class Hokeemon {
	public static final String FILE_NAME = "Data.txt";		//Default .txt file name 
	
	private String name;
	private String type;		
	private int age;
		
	/**
	 * Default (lame) constructor
	 */
	public Hokeemon() {	
		name = "";
		type = "";
		age = 0;
	}
	
	/**
	 * constructor for an object Hokeemon 
	 * @param initName	name
	 * @param initType	type
	 * @param initAge	age
	 */
	public Hokeemon(String initName, String initType, int initAge) {
		name = initName;
		type = initType;
		age = initAge;
	}
	
	// Accessors
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getAge() {
		return age;
	}
	// Mutators
	public void setName(String newName) {
		name = newName;
	}
	public void setType(String newType) {
		type = newType;
	}
	public void setAge(int newAge) {
		age = newAge;
	}
	
	/**
	 * This instance method put the data from text file in a report array
	 * @return result the formated array
	 */
	public String toString() {
		return String.format("\nName: %s, Type: %s, Age: %d", name, type, age);
	}
	
	/**
	 * Static method to create the Hokeemon object
	 * call by Hokeemon.getData()
	 * @return a Hokeemon from Data.txt
	 */
	public static Hokeemon[] getData() {
		Hokeemon[] myHokee = null;					//initialize the array of object
		
		try {
			File f = new File(FILE_NAME);			//get file
			Scanner filescan = new Scanner(f);		//get input from file
			
			int numHokee = filescan.nextInt();		//get array size
			myHokee = new Hokeemon[numHokee];	
			
			for(int i = 0; i < numHokee; i++) {
				String name = filescan.next();
				String type = filescan.next();
				int age = filescan.nextInt();
				
				myHokee[i] = new Hokeemon(name, type, age);
			}
			
		} catch(FileNotFoundException e) {			//if file can't be read
			System.out.println("Error! Could not read input file!");
		}
		return myHokee;
	}	
	
	/**
	 * This instance method finds places where different Hokeemons live in
	 * @return String of where the Hokeemon lives
	 */
	public String liveIn() {
		if (type.equalsIgnoreCase("Hobbit"))
			return "Shire";
		else if (type.equalsIgnoreCase("Fairy"))
			return "Forest";
		else if (type.equalsIgnoreCase("Dwarf"))
			return "Mountain";
		else if (type.equalsIgnoreCase("Elf"))
			return "Dale";
		else
			return "Unknown";
	}
		
	/**
	 * This instance method determines whether or not two Hokeemons are friends based on their types.
	 * @param other the Hokeemon to compare with
	 * @return friends or not friends
	 */
	public boolean areFriends(Hokeemon other) {
		if (type.equalsIgnoreCase(other.type))		//If of the same type
			return true;
		else
			// Otherwise, dwarves and elves are friends and hobbits and faries are friends
			return type.equalsIgnoreCase("Dwarf") && other.type.equalsIgnoreCase("Elf")
					|| type.equalsIgnoreCase("Elf") && other.type.equalsIgnoreCase("Dwarf")
					|| type.equalsIgnoreCase("Hobbit") && other.type.equalsIgnoreCase("Fairy")
					|| type.equalsIgnoreCase("Fairy") && other.type.equalsIgnoreCase("Hobbit");
	}

	/**
	 * This instance method prints a short self-introduction of a Hokeemon
	 * @param Hokee The Hokeemon that needs introduction
	 * @param myHokee The array of Hokeemons from Data.txt
	 */
	public void getBio(Hokeemon Hokee, Hokeemon[] myHokee) {
		System.out.printf("I am %s, I am a %s, and I am %d years old. "
					+ "I live in the %s.\n", Hokee.name, Hokee.type, Hokee.age, Hokee.liveIn());	
			
		System.out.print("\tMy friends are: ");
		for (int j = 0; j < myHokee.length; j++) {			//Scan the array for friends
			if (Hokee.areFriends(myHokee[j])) {
				if (Hokee.name.equals(myHokee[j].name))		//Print nothing if it's the same Hokeemon, despite the fact that you can be friend with yourself, even if it sounds really weird, but it's okay
					System.out.print("");		
				else
					System.out.print(myHokee[j].name + " ");	
			}
		}
		System.out.println();
	}
}