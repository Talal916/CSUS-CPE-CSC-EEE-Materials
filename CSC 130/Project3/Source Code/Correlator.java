/****************************************
Lawrence Naidu & Sam Lee
CSC 130
Programming Project 3
****************************************/
import java.io.IOException;

public class Correlator extends WordCount {
	 private static void correlate(String file1, String file2, String type) {
		 DataCount<String>[] count1 = countWords("-frequency", file1, type);
		 DataCount<String>[] count2 = countWords("-frequency", file2, type);
		 double size_1 = count1.length;
		 double size_2 = count2.length;
		 double diff = 0.0;
		 double differenceMetric = 0.0;
	     
		 if (size_1 >= size_2 ) {
	        for (DataCount<String> c1 : count1) {
	           for (DataCount<String> c2 : count2) {
	              if (c1.data.equals(c2.data)) {
	            	 //System.out.println(c1.data + " == " + c2.data);
	            	 diff = (c1.count/size_1 - c2.count/size_2);
	            	 //System.out.println("Diff: " + diff);
	            	 if ((diff > 0.0001) && (diff < 0.01)) {
	            		 differenceMetric += Math.pow(diff, 2);
	            		 //System.out.println("Difference: " + differenceMetric);	            	   
	            	 } 
	              }
	           }
	        }
	     }
	     else {
	        for (DataCount<String> c2 : count2) {
	        	for (DataCount<String> c1 : count1) {
	        		if (c1.data.equals(c2.data)) {
	        			//System.out.println(c1.data + " == " + c2.data);
	        			diff = (c1.count/size_1 - c2.count/size_2);
	        			//System.out.println("Diff: " + diff);
	        			if ((diff > 0.0001) && (diff < 0.01)) {  
	        				differenceMetric += Math.pow(diff, 2);
	        				//System.out.println("Difference: " + differenceMetric);
	        			}
	        		}
	        	}
	        }
	     }
	     System.out.println("\nDifference metric for " + file1 + " and " + file2 + ": " + differenceMetric);
	 }	

public static void main(String[] args) {
		 if (args.length != 3) {
			 System.err.println("Error: Not enough Argument");
			 System.exit(1);
		 }
		 else {
			double timer = System.currentTimeMillis();
			correlate(args[1], args[2], args[0]);
     		timer = System.currentTimeMillis() - timer;
     		System.out.println("It took " + timer + "ms to finish correlating the words!");
		 }
	}    
}
