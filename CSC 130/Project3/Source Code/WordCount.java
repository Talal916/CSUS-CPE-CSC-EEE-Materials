/****************************************
Lawrence Naidu & Sam Lee
CSC 130
Programming Project 3
****************************************/
import java.io.IOException;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 */
public class WordCount {

    protected static DataCount<String>[] countWords(String impliment, String file, String type) {
    	DataCounter<String> counter = null;
    	switch (type) { 
    	case "-b":
    		System.out.println("Using BST");
    		counter = new BinarySearchTree<String>();
    		break;
    	case "-a":
    		System.out.println("Using AVL");
    		counter = new AVLTree<String>();
    		break;
    	case "-h":
    		System.out.println("Using Hash");
    		counter = new HashTable<String>();
    		break;
    	default:
    		System.err.println("Error: Incorrect data structure specification!");
            System.exit(1);
    	}

        try {
            FileWordReader reader = new FileWordReader(file);
            String word = reader.nextWord();
            while (word != null) {
                counter.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file + e);
            System.exit(1);
        }

        if (impliment.equals("-frequency")) {
        	DataCount<String>[] counts = counter.getCounts();
        	sortByDescendingCount(counts);
        	for (DataCount<String> c : counts) {
        		System.out.println(c.count + " \t" + c.data);
        	}
        	return counts;
        }
        else {
        	System.out.println("Total Number of Unique Words: " + counter.getSize());
        }
       return null; 
    }

    /**
     * TODO Replace this comment with your own.
     * 
     * Sort the count array in descending order of count. If two elements have
     * the same count, they should be in alphabetical order (for Strings, that
     * is. In general, use the compareTo method for the DataCount.data field).
     * 
     * This code uses insertion sort. You should modify it to use a different
     * sorting algorithm. NOTE: the current code assumes the array starts in
     * alphabetical order! You'll need to make your code deal with unsorted
     * arrays.
     * 
     * The generic parameter syntax here is new, but it just defines E as a
     * generic parameter for this method, and constrains E to be Comparable. You
     * shouldn't have to change it.
     * 
     * @param counts array to be sorted.
     */
    private static <E extends Comparable<? super E>> void sortByDescendingCount(
            DataCount<E>[] counts) {
        for (int i = 1; i < counts.length; i++) {
            DataCount<E> x = counts[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (counts[j].count >= x.count) {
                    break;
                }
                counts[j + 1] = counts[j];
            }
            counts[j + 1] = x;
        }
    }

    //Change this so that it takes in the parameters (-a, -b, -h) instead of args.length
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Error: Not enough Argument");
            System.exit(1);
        }
        else {
        	if (args[1].equals("-frequency") || args[1].equals("-num_unique")) {
        		//System.out.println("In frequency");
        		double timer = System.currentTimeMillis();
        		countWords(args[1], args[2], args[0]);
        		timer = System.currentTimeMillis() - timer;
        		System.out.println("It took " + timer + "ms to finish counting the words!");
        	}
        	else
        		System.out.println("Invalid task specification!");
        }    
    }
}
