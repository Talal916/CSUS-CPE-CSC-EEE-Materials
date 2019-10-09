/****************************************
Lawrence Naidu & Sam Lee
CSC 130
Programming Project 3
****************************************/

/**
 * TODO Replace this comment with your own.
 * 
 * Stub code for an implementation of a DataCounter that uses a hash table as
 * its backing data structure. We included this stub so that it's very clear
 * that HashTable works only with Strings, whereas the DataCounter interface is
 * generic.  You need the String contents to write your hashcode code.
 */
public class HashTable<E extends Comparable<? super E>> implements
	DataCounter<E> {
	
	protected int table_Size = 52;
	protected int size;
	protected HashNode<E>[] hashTable;
	
	HashTable() {
		hashTable = new HashNode[table_Size];
	}
	public class HashNode<E> {
		E data;
		int count;
		HashNode next;
		
		public HashNode(E Data) {
			data = Data;
			count = 1;
			size++;
			next = null;
		}
	}
	
    /** {@inheritDoc} */
    public int getSize() {
        return size;
    }

    /** {@inheritDoc} */
    public void incCount(E data) {
       int index = 0;
       for (int i = 0; i < ((String)data).length(); i++) {
           index += Integer.valueOf(((String)data).charAt(i));
           //System.out.println(((String)data).charAt(i));
       }
       
       index %= table_Size;
       //System.out.println("String: " + (String)data + "\nIndex: " + index);
       
       if (hashTable[index] == null) {
    	   hashTable[index] = new HashNode(data);
       } 
       else {
    	   HashNode<E> temp = hashTable[index];
    	   while ((temp.next != null) && !(temp.data.equals(data))) {
    		   //System.out.println(temp.data + " != " + data + ": Jumping!");
    		   temp = temp.next;
    	   }
    	   
    	   if (temp.data.equals(data)) {
    		   temp.count++;
    		   //System.out.println("1up: count for " + temp.data + " is: " + temp.count);
    	   }
    	   else {
    		   temp.next = new HashNode(data);
    	   }
       }
    }
    
    /** {@inheritDoc} */
    public DataCount<E>[] getCounts() {
    	@SuppressWarnings("unchecked")
		DataCount<E>[] counts = new DataCount[size];
    	HashNode<E> hash = null;
    	int j = 0;
        for (int i = 0; i < table_Size; i++) {
        	hash = hashTable[i];
        	while (hash != null) {
        		counts[j] = new DataCount<E>(hash.data, hash.count);
            	//System.out.println("Count: " + counts[j].data + ", Index: " + j);
            	hash = hash.next;
            	j++;
        	}
        	
        }
        //System.out.println("Size: " + size);
        return counts;
    }   
}
