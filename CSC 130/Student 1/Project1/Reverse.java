/*Sam Lee
  6/4/2018
  CSC 130
  Project #1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Read a .dat file and reverse it.
 */
public class Reverse {
   public static void main(String[]args) {
      if (args.length != 4) {
         System.err.println(" Incorrect number of arguments");
         System.err.println(" Usage: ");
         System.err.println("\tjava Reverse <list or array> <double or generic> <input file> <output file>");
         System.exit(1);
      }
   
        //
        // process command-line arguments
        //
      boolean useList = false; // properly assigned below
      boolean generic = false; // properly assigned below
        
      if(args[0].compareTo("list")==0)
         useList = true;
      else if(args[0].compareTo("array")==0)
         useList = false;
      else {
         System.err.println("\tSaw "+args[0]+" instead of list or array as first argument");
         System.exit(1);
      }
      if(args[1].compareTo("double")==0)
         generic = false;
      else if(args[1].compareTo("generic")==0)
         generic = true;
      else {
         System.err.println("\tSaw "+args[1]+" instead of double or generic as second argument");
         System.exit(1);
      }
        
      try {
            //
            // Set up the input file to be read, and the output file to be written
            //
         BufferedReader fileIn  = new BufferedReader(new FileReader(args[2]));
         PrintWriter    fileOut = new PrintWriter(new BufferedWriter(new FileWriter(args[3])));
      
            //
            // Read the first line of the .dat file. We want to store the
            // "sample rate" in a variable, but we can ignore the rest 
            // of the line. We step through the first line one token (word)
            // at a time using the StringTokenizer.  The fourth token
            // is the one we want (the sample rate).
            //
         StringTokenizer str;
         String oneLine;
         int sampleRate;
         String strJunk;
      
         oneLine = fileIn.readLine();
      
         str = new StringTokenizer(oneLine);
         strJunk = str.nextToken();  // Read in semicolon
         strJunk = str.nextToken();  // Read in "Sample"
         strJunk = str.nextToken();  // Read in "Rate"
         sampleRate = Integer.parseInt(str.nextToken()); // Read in sample rate
      
            //
            // Read in the file and place values from the second column 
            // in the stack. The first column values are thrown away. 
            // We stop reading if we reach the end of the file.
            //
      
         DStack         s  = null; // changed when not running generic code
            //GStack<Double> gs = null; // changed when running generic code
         if (generic) {
            System.err.println("no support for generics yet");
            System.exit(1);
         } else {
            if (useList)
               s = new ListStack();
            else
               s = new ArrayStack();
         }
         String timestep;
         double data;
      
         int count = 0;
         while ((oneLine = fileIn.readLine()) != null) {
            if (oneLine.charAt(0) == ';') {
               continue;
            }
            str = new StringTokenizer(oneLine);
            timestep = str.nextToken();     // Read in time step value from first column
            data = Double.parseDouble(str.nextToken());     // Read in data value from second column
            if(generic) {
               System.err.println("no support for generics yet");
               System.exit(1);
            } else {
               s.push(data);
                  //System.out.println("Work" + data);
              
            }
            count++;
         }
      
         System.out.println(count+" samples in file");
      
      
            //
            // Now we are ready to output the data values to output file.
            // But first, we need to output the header line
            // "; Sample Rate <sample rate>"
            //
         fileOut.println("; Sample Rate " + sampleRate);
      
            // Since the first column consists of numbers which start
            // at 0 and increase by 1/sampleRate every time slice, we'll
            // just use numSteps to recalculate these numbers.
         int numSteps = 0;
      
            // Finally, we print the values in reverse order (by popping
            // them off the stack). The first column consists of numbers
            // which start at 0 and increase by 1/sampleRate per row, so
            // we'll use numSteps/sampleRate to recalculate the appropriate
            // values. Uniform spacing will be accomplished by printing a tab.
         if(generic) {
            System.err.println("no support for generics yet");
            System.exit(1);
         } else {
            while (!s.isEmpty()) {
               fileOut.println((double) numSteps / sampleRate + "\t" +
               s.peek());
               s.pop();
               numSteps++;
            }
         }
      
            //
            // Close the files
            //
         fileIn.close();
         fileOut.close();
      
      } catch(IOException ioe) {
         System.err.println("Error opening/reading/writing input or output file.");
         System.exit(1);
      } catch(NumberFormatException nfe) {
         System.err.println(nfe.toString());
         System.err.println("Error in file format");
         System.exit(1);
      }
   }
}
