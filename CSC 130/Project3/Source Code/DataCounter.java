/**
 * Simple class to hold a piece of data and its count. The class has package
 * access so that the various implementations of DataCounter can access its
 * contents, but not client code.
 * 
 * @param <E> type of data whose count we are recording.
 */
class DataCount<E> {
    /**
     * The data element whose count we are recording.
     */
    E data;

    /**
     * The count for the data element.
     */
    int count;

    /**
     * Create a new data count.
     * 
     * @param data the data element whose count we are recording.
     * @param count the count for the data element.
     */
    DataCount(E data, int count) {
        this.data = data;
        this.count = count;
    }
}

/**
 * Interface for a data structure that allows you to count the number of times
 * you see each piece of data.
 * 
 * Although you will be using this interface only with Strings, we have tried to
 * "genericize" the code as much as possible. DataCounter counts elements of an
 * unconstrained generic type E, and BinarySearchTree restricts E to Comparable
 * types. HashTable is String-only, because you'll be implementing your own
 * hashcode and will need access to the actual String contents.
 * 
 * @param <E> The type of data to be counted.
 */
public interface DataCounter<E> {

    /**
     * Increment the count for a particular data element.
     * 
     * @param data data element whose count to increment.
     */
    public void incCount(E data);

    /**
     * The number of unique data elements in the structure.
     * 
     * @return the number of unique data elements in the structure.
     */
    public int getSize();

    /**
     * Get an array of all of the data counts in the DataCounter structure. The
     * array should contain exactly one DataCount instance for each unique
     * element inserted into the structure. The elements do not need to be in
     * any particular order.
     * 
     * @return an array of the data counts.
     */
    public DataCount<E>[] getCounts();

}
