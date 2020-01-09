import java.util.*;//need this for Scanner method, for user input
import java.io.*;// need this for 'FileNotFoundException' method
import java.nio.file.*;
public class DataLab {
   public static void main(String[] args) throws FileNotFoundException { //'throw' is a warning to the program that                                     //this 'FileNotFoundException'exception can be utilized 
      Scanner inputFile;// variable declared as Scanner means it collects information, in this case for inputFile
      Scanner kb = new Scanner(System.in);
      boolean repeat = true;
      while (repeat) {
      	// call the method getFile
         inputFile = getFile(kb);
      	// call the method inputStats
         inputStats(inputFile);
         System.out.println("****************************** ");     
         System.out.print("Do you have another file: yes/no? ");
         String answer = kb.next();
         kb.nextLine();
         if (answer.equalsIgnoreCase("no")){
            repeat = false;
            System.out.println("Good Bye");
         }      		
      }
   }

	  /*this method asks the user for an output file name creates an object of
	  printstream and returns it*/
	 
   public static PrintStream outputFile() throws FileNotFoundException {
      String outFile = "";
      Scanner kb = new Scanner(System.in);//will have redecalre scanner object due to no arguments being passed in
      System.out.print("Enter the output file name: ");
      outFile = kb.nextLine();
      PrintStream printStream = new PrintStream(outFile);// The print Stream type is what actually outputs the contents of the file   	
      return printStream; 
   }
   public static Scanner getFile(Scanner kb) throws FileNotFoundException {
      File f;
      String fileName;     
      do {
         System.out.print("Enter the input file name: ");
         fileName = kb.next();
         f = new File(fileName);      
      } while (!f.exists());
      Scanner fileScanner = new Scanner(f);
      return fileScanner;        
   }
	
	  /*this method gets the input file name as its parameter call the method
	  outputFile to get the name of the output file as long as there are lines
	  in the input file { read one line print the line in the output file
	  update the line count call the method longestLine call the method
	  countTokens call the method longest output the result on the screen }
	  output the longest line*/
     
   public static void inputStats(Scanner input) throws FileNotFoundException {
      int count = 0;
      int numLines = 0;
      int numwords = 0;
      String maxLine = "";
      String LongestLineinfile = null;
      PrintStream Fileoutput = new PrintStream(System.out);
      Fileoutput = outputFile();//will gather contents of output file
      String words[];//variable declared with array 0
      int longestWord = 0;
      String result = "";
      while (input.hasNextLine()) {
         String next = input.nextLine();
         count = count + 1;
         words = next.split("\\s+");
         numwords = words.length;
         numLines++;
         maxLine = LongLine(maxLine, next);
         longestWord = getLongestWord(words);
         result += next + " Line " + count + " has "+ numwords + " tokens " + "(longest = " + longestWord + ")\n";      	
      } 
      result= result+ "Longest line: "+ maxLine;
      System.out.println(result);
      Fileoutput.println(result);
      Fileoutput.close();
   }
   public static int getLongestWord(String[] words) {
      int max = 0;
      for (int i = 0; i < words.length; i++)
      {
         if (words[i].length() > max)
            max = words[i].length();
      }
      return max;
   }
   public static String LongLine(String longestLine, String line) {
      if (longestLine.length() > line.length()) {
         return longestLine;
      }
      else
      {
         return line;
      }
   }	
   public static int countTokens(String line) {
      int numLines = 0;
      int numwords = 0;
      numwords = line.split(" ").length;
      numLines++;
      return numLines;
   }
   public static int longest(String line) {
      return 0;   
   }
}