package kruskal;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Stack;


public class KruskalMST {
    private double weight;  // weight of MST
    private Queue<Edge> mst = new Queue<Edge>();  // edges in MST

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public KruskalMST(EdgeWeightedGraph G) {
        // more efficient to build heap by passing array of edges
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        // run greedy algorithm
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { // v-w does not create a cycle
                uf.union(v, w);  // merge v and w components
                mst.enqueue(e);  // add edge e to mst
                weight += e.weight();
            }
        }

        // check optimality conditions
        assert check(G);
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    public double weight() {
        return weight;
    }
    
    // check optimality conditions (takes time proportional to E V lg* V)
    private boolean check(EdgeWeightedGraph G) {

        // check total weight
        double total = 0.0;
        for (Edge e : edges()) {
            total += e.weight();
        }
        double EPSILON = 1E-12;
        if (Math.abs(total - weight()) > EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
            return false;
        }

        // check that it is acyclic
        UF uf = new UF(G.V());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : G.edges()) {
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest (cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new UF(G.V());
            for (Edge f : mst) {
                int x = f.either(), y = f.other(x);
                if (f != e) uf.union(x, y);
            }
            
            // check that e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.either(), y = f.other(x);
                if (!uf.connected(x, y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }


    /**
     * Unit tests the <tt>KruskalMST</tt> data type.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }

}


class Edge implements Comparable<Edge> { 

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        if (v < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (w < 0) throw new IndexOutOfBoundsException("Vertex name must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    // Returns the weight of the edge.
    public double weight() {
        return weight;
    }

   
   // Returns either endpoint of the edge.
    public int either() {
        return v;
    }

    
    // Returns the endpoint of the edge that is different from the given vertex
      public int other(int vertex) {
        if      (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    /**
     * Compares two edges by weight.
  return a negative integer, zero, or positive integer depending on whether
     *    this edge is less than, equal to, or greater than that edge
     */
    public int compareTo(Edge that) {
        if      (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else                                    return  0;
    }

    //Returns a string representation of the edge.
         public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
   public static void main(String[] args) {
        Edge e = new Edge(12, 23, 3.14);
        StdOut.println(e);
    }
}
class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;
    
    
    // Initializes an empty edge-weighted graph with <tt>V</tt> vertices and 0 edges.
    public EdgeWeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }

    
    // * Initializes a random edge-weighted graph with <tt>V</tt> vertices and <em>E</em> edges.
    public EdgeWeightedGraph(int V, int E) {
        this(V);
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = (int) (Math.random() * V);
            int w = (int) (Math.random() * V);
            double weight = Math.round(100 * Math.random()) / 100.0;
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    /**  
     * Initializes an edge-weighted graph from an input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices and edge weights,
     * with each entry separated by whitespace.
    */
    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

   
     // Initializes a new edge-weighted graph
      public EdgeWeightedGraph(EdgeWeightedGraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : G.adj[v]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adj[v].add(e);
            }
        }
    }

    // Returns the number of vertices in the edge-weighted graph.
       public int V() {
        return V;
    }

// Returns the number of edges in the edge-weighted graph.
    public int E() {
        return E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }
//   Adds the undirected edge <tt>e</tt> to the edge-weighted graph.
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

   // Returns the edges incident on vertex <tt>v</tt>.
        public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    // Returns the degree of vertex <tt>v</tt>.
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    //Returns all edges in the edge-weighted graph.
    
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // only add one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

   // Returns a string representation of the edge-weighted graph.
       public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        StdOut.println(G);
    }

}

//union -find data structure 
 class UF {
    private int[] id;     // id[i] = parent of i
    private byte[] rank;  // rank[i] = rank of subtree rooted at i (cannot be more than 31)
    private int count;    // number of components

       public UF(int N) {
        if (N < 0) throw new IllegalArgumentException();
        count = N;
        id = new int[N];
        rank = new byte[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            rank[i] = 0;
        }
    }

   // Returns the component identifier for the component containing site 
     
    public int find(int p) {
        if (p < 0 || p >= id.length) throw new IndexOutOfBoundsException();
        while (p != id[p]) {
            id[p] = id[id[p]];    // path compression by halving
            p = id[p];
        }
        return p;
    }

   // Returns the number of components.
    public int count() {
        return count;
    }
  
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make root of smaller rank point to root of larger rank
        if      (rank[i] < rank[j]) id[i] = j;
        else if (rank[i] > rank[j]) id[j] = i;
        else {
            id[j] = i;
            rank[i]++;
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
//The <tt>Queue</tt> class represents a first-in-first-out (FIFO)  queue of generic items.
 
 class Queue<Item> implements Iterable<Item> {
 private int N;               // number of elements on queue
 private Node<Item> first;    // beginning of queue
 private Node<Item> last;     // end of queue

 // helper linked list class
 private static class Node<Item> {
     private Item item;
     private Node<Item> next;
 }
//Initializes an empty queue.
 public Queue() {
     first = null;
     last  = null;
     N = 0;
 }

 public boolean isEmpty() {
     return first == null;
 }

// Returns the number of items in this queue.
 public int size() {
     return N;     
 }
//Returns the item least recently added to this queue.
  public Item peek() {
     if (isEmpty()) throw new NoSuchElementException("Queue underflow");
     return first.item;
 }

// Adds the item to this queue.
   public void enqueue(Item item) {
     Node<Item> oldlast = last;
     last = new Node<Item>();
     last.item = item;
     last.next = null;
     if (isEmpty()) first = last;
     else           oldlast.next = last;
     N++;
 }

 // Removes and returns the item on this queue that was least recently added.
    public Item dequeue() {
     if (isEmpty()) throw new NoSuchElementException("Queue underflow");
     Item item = first.item;
     first = first.next;
     N--;
     if (isEmpty()) last = null;   // to avoid loitering
     return item;
 }
//Returns a string representation of this queue.
 public String toString() {
     StringBuilder s = new StringBuilder();
     for (Item item : this)
         s.append(item + " ");
     return s.toString();
 } 

// Returns an iterator that iterates over the items in this queue in FIFO order.
   public Iterator<Item> iterator()  {
     return new ListIterator<Item>(first);  
 }

 // an iterator, doesn't implement remove() since it's optional
 private class ListIterator<Item> implements Iterator<Item> {
     private Node<Item> current;

     public ListIterator(Node<Item> first) {
         current = first;
     }

     public boolean hasNext()  { return current != null;                     }
     public void remove()      { throw new UnsupportedOperationException();  }

     public Item next() {
         if (!hasNext()) throw new NoSuchElementException();
         Item item = current.item;
         current = current.next; 
         return item;
     }
 }
 public static void main(String[] args) {
     Queue<String> q = new Queue<String>();
     while (!StdIn.isEmpty()) {
         String item = StdIn.readString();
         if (!item.equals("-")) q.enqueue(item);
         else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
     }
     StdOut.println("(" + q.size() + " left on queue)");
 }
}
 /**
  *  The <tt>MinPQ</tt> class represents a priority queue of generic keys.
  *  This implementation uses a binary heap.
  */
  class MinPQ<Key> implements Iterable<Key> {
     private Key[] pq;                    // store items at indices 1 to N
     private int N;                       // number of items on priority queue
     private Comparator<Key> comparator;  // optional comparator


 // Initializes an empty priority queue with the given initial capacity.
     public MinPQ(int initCapacity) {
         pq = (Key[]) new Object[initCapacity + 1];
         N = 0;
     }

   // Initializes an empty priority queue.
     public MinPQ() {
         this(1);
     }
 //Initializes an empty priority queue with the given initial capacity,using the given comparator.
      public MinPQ(int initCapacity, Comparator<Key> comparator) {
         this.comparator = comparator;
         pq = (Key[]) new Object[initCapacity + 1];
         N = 0;
     }

   
 // Initializes an empty priority queue using the given comparator.
     public MinPQ(Comparator<Key> comparator) { this(1, comparator); }

     /**
      * Initializes a priority queue from the array of keys.
      * Takes time proportional to the number of keys, using sink-based heap construction.
     */
     public MinPQ(Key[] keys) {
         N = keys.length;
         pq = (Key[]) new Object[keys.length + 1];
         for (int i = 0; i < N; i++)
             pq[i+1] = keys[i];
         for (int k = N/2; k >= 1; k--)
             sink(k);
         assert isMinHeap();
     }

     
   // Is the priority queue empty?
      public boolean isEmpty() {
         return N == 0;
     }
     // Returns the number of keys on the priority queue.
     public int size() {
         return N;
     }
 // Returns a smallest key on the priority queue.
       public Key min() {
         if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
         return pq[1];
     }

     // helper function to double the size of the heap array
     private void resize(int capacity) {
         assert capacity > N;
         Key[] temp = (Key[]) new Object[capacity];
         for (int i = 1; i <= N; i++) temp[i] = pq[i];
         pq = temp;
     }

     // Adds a new key to the priority queue.
         public void insert(Key x) {
         // double size of array if necessary
         if (N == pq.length - 1) resize(2 * pq.length);

         // add x, and percolate it up to maintain heap invariant
         pq[++N] = x;
         swim(N);
         assert isMinHeap();
     }

       // Removes and returns a smallest key on the priority queue.
     public Key delMin() {
         if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
         exch(1, N);
         Key min = pq[N--];
         sink(1);
         pq[N+1] = null;         // avoid loitering and help with garbage collection
         if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length  / 2);
         assert isMinHeap();
         return min;
     }

 // functions to restore the heap invariant.
       private void swim(int k) {
         while (k > 1 && greater(k/2, k)) {
             exch(k, k/2);
             k = k/2;
         }
     }

     private void sink(int k) {
         while (2*k <= N) {
             int j = 2*k;
             if (j < N && greater(j, j+1)) j++;
             if (!greater(k, j)) break;
             exch(k, j);
             k = j;
         }
     }

  // functions for compares and swaps.
        private boolean greater(int i, int j) {
         if (comparator == null) {
             return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
         }
         else {
             return comparator.compare(pq[i], pq[j]) > 0;
         }
     }

     private void exch(int i, int j) {
         Key swap = pq[i];
         pq[i] = pq[j];
         pq[j] = swap;
     }

     // is pq[1..N] a min heap?
     private boolean isMinHeap() {
         return isMinHeap(1);
     }

     // is subtree of pq[1..N] rooted at k a min heap?
     private boolean isMinHeap(int k) {
         if (k > N) return true;
         int left = 2*k, right = 2*k + 1;
         if (left  <= N && greater(k, left))  return false;
         if (right <= N && greater(k, right)) return false;
         return isMinHeap(left) && isMinHeap(right);
     }

     
      //Returns an iterator that iterates over the keys on the priority queue in ascending order.
     public Iterator<Key> iterator() { return new HeapIterator(); }

     private class HeapIterator implements Iterator<Key> {
         // create a new pq
         private MinPQ<Key> copy;

         // add all items to copy of heap
         // takes linear time since already in heap order so no keys move
         public HeapIterator() {
             if (comparator == null) copy = new MinPQ<Key>(size());
             else                    copy = new MinPQ<Key>(size(), comparator);
             for (int i = 1; i <= N; i++)
                 copy.insert(pq[i]);
         }

         public boolean hasNext()  { return !copy.isEmpty();                     }
         public void remove()      { throw new UnsupportedOperationException();  }

         public Key next() {
             if (!hasNext()) throw new NoSuchElementException();
             return copy.delMin();
         }
     }

       public static void main(String[] args) {
         MinPQ<String> pq = new MinPQ<String>();
         while (!StdIn.isEmpty()) {
             String item = StdIn.readString();
             if (!item.equals("-")) pq.insert(item);
             else if (!pq.isEmpty()) StdOut.print(pq.delMin() + " ");
         }
         StdOut.println("(" + pq.size() + " left on pq)");
     }

 }
// class for print output 
final class StdOut {

    // force Unicode UTF-8 encoding; otherwise it's system dependent
    private static final String CHARSET_NAME = "UTF-8";

    // assume language = English, country = US for consistency with StdIn
    private static final Locale LOCALE = Locale.US;

    // send output here
    private static PrintWriter out;

    // this is called before invoking any methods
    static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
        }
        catch (UnsupportedEncodingException e) { System.out.println(e); }
    }

    // don't instantiate
    private StdOut() { }

    // close the output stream (not required)
   /**
     * Close standard output.
     */
    public static void close() {
        out.close();
    }

   /**
     * Terminate the current line by printing the line separator string.
     */
    public static void println() {
        out.println();
    }

   /**
     * Print an object to standard output and then terminate the line.
     */
    public static void println(Object x) {
        out.println(x);
    }

   /**
     * Print a boolean to standard output and then terminate the line.
     */
    public static void println(boolean x) {
        out.println(x);
    }

   /**
     * Print a char to standard output and then terminate the line.
     */
    public static void println(char x) {
        out.println(x);
    }

   /**
     * Print a double to standard output and then terminate the line.
     */
    public static void println(double x) {
        out.println(x);
    }

   /**
     * Print a float to standard output and then terminate the line.
     */
    public static void println(float x) {
        out.println(x);
    }

   /**
     * Print an int to standard output and then terminate the line.
     */
    public static void println(int x) {
        out.println(x);
    }

   /**
     * Print a long to standard output and then terminate the line.
     */
    public static void println(long x) {
        out.println(x);
    }

   /**
     * Print a short to standard output and then terminate the line.
     */
    public static void println(short x) {
        out.println(x);
    }

   /**
     * Print a byte to standard output and then terminate the line.
     */
    public static void println(byte x) {
        out.println(x);
    }

   /**
     * Flush standard output.
     */
    public static void print() {
        out.flush();
    }

   /**
     * Print an Object to standard output and flush standard output.
     */
    public static void print(Object x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a boolean to standard output and flush standard output.
     */
    public static void print(boolean x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a char to standard output and flush standard output.
     */
    public static void print(char x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a double to standard output and flush standard output.
     */
    public static void print(double x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a float to standard output and flush standard output.
     */
    public static void print(float x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print an int to standard output and flush standard output.
     */
    public static void print(int x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a long to standard output and flush standard output.
     */
    public static void print(long x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a short to standard output and flush standard output.
     */
    public static void print(short x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a byte to standard output and flush standard output.
     */
    public static void print(byte x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a formatted string to standard output using the specified
     * format string and arguments, and flush standard output.
     */
    public static void printf(String format, Object... args) {
        out.printf(LOCALE, format, args);
        out.flush();
    }

   /**
     * Print a formatted string to standard output using the specified
     * locale, format string, and arguments, and flush standard output.
     */
    public static void printf(Locale locale, String format, Object... args) {
        out.printf(locale, format, args);
        out.flush();
    }

    // This method is just here to test the class
    public static void main(String[] args) {

        // write to stdout
        StdOut.println("Test");
        StdOut.println(17);
        StdOut.println(true);
        StdOut.printf("%.6f\n", 1.0/7.0);
    }

}
