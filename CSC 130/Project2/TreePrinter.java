/*Sam Lee
  6/10/2018
  CSC 130
  Project #2
*/
/**
 * BST and AVL tree printer for Integer nodes.
 *
 * CS 146 Data Structures and Algorithms
 * Summer 2015
 * Department of Computer Science
 * San Jose State University
 * 
 * @author Ron Mak
 *
 */
public class TreePrinter {
    private static final int MAX_LEVELS = 6;
    
    private BinarySearchTree<Integer> tree;  // the tree
    private int height;                      // its height
    
    // Powers of 2
    private static int POWERS_OF_2[] = new int[MAX_LEVELS+2];
    static {
        int power = 1;
        for (int i = 0; i < MAX_LEVELS + 2; i++) {
            POWERS_OF_2[i] = power;
            power *= 2;            
        }
    }
    
    /**
     * Constructor
     * @param tree the tree to print.
     */
    public TreePrinter(BinarySearchTree<Integer> tree) {
        this.tree = tree;
        this.height = tree.height();
    }
    
    /**
     * Print the tree using a level-order traversal.
     * @param label the label to print before the tree.
     */
    public void print(String label) {       
        System.out.println(label);

        // Queue of nodes at this level.
        BinaryNode<Integer> thisLevelNodes[] = 
                (BinaryNode<Integer>[]) new BinaryNode[1];
        
        int offset = POWERS_OF_2[(height+1)]-1;
        
        thisLevelNodes[0] = tree.getRoot();
        
        // Loop to print each level of nodes.
        for (int level = 0; level <= height; level++) {
            if (level > MAX_LEVELS) {
                System.out.println("*** Too many levels to print. ***");
                break;
            }
            
            // Print node data.
            printData(level, offset, thisLevelNodes);
            
            if (level != height) {
                
                // Print outgoing pointers /\ from each parent node.
                printOutgoingPointers(level, offset, thisLevelNodes);
                
                offset = POWERS_OF_2[height - level] - 1;
    
                // Print connecting dashes ----
                if (level < height-1) {
                    printConnectingDashes(level, offset, thisLevelNodes);
                }
                
                // Print incoming pointers / and \ to each child node.
                printIncomingPointers(level, offset, thisLevelNodes);
                
                // Prepare the next level of nodes.
                thisLevelNodes = nextLevel(level, thisLevelNodes);
            }
        }
    }
    
    /**
     * Print node data.
     * @param level the current level
     * @param offset the current offset
     * @param levelNodes the current level of nodes
     */
    private void printData(int level, int offset, 
                           BinaryNode<Integer> levelNodes[])
    {
        printSpaces(offset);
        
        int k = POWERS_OF_2[level];
        for (int i = 0; i < k; i++) {
            BinaryNode<Integer> node = levelNodes[i];
            
            if (node != null) {
                System.out.printf("%3d ", node.getData());
            }
            else {
                System.out.print("    ");
            }
            
            // Space over to the next node in this level.
            if (i < k-1) printSpaces(2*offset - 2);
        }
        
        System.out.println();
    }
    
    /**
     * Print outgoing pointers /\ from each non-null parent node.
     * @param level the current level
     * @param offset the current offset
     * @param levelNodes the current level of nodes
     */
    private void printOutgoingPointers(int level, int offset, 
                                       BinaryNode<Integer> levelNodes[])
    {
        printSpaces(offset);
        
        int k = POWERS_OF_2[level];
        for (int i = 0; i < k; i++) {
            BinaryNode<Integer> node = levelNodes[i];
            
            // Has left child: print /
            if ((node != null) && (node.getLeft() != null)) {
                System.out.print(" /");
            }
            
            // No left child: print space
            else {
                System.out.print("  ");
            }
            
            // Has right child: print \
            if ((node != null) && (node.getRight() != null)) {
                System.out.print("\\ ");
            }
            
            // No right child: print space
            else {
                System.out.print("  ");
            }
            
            // Space over to the next node in this level.
            if (i < k-1) printSpaces(2*offset-2);
        }
        
        System.out.println();
    }
    
    /**
     * Print the connecting dashes between 
     * an outgoing pointer and an incoming pointer.
     * @param level the current level
     * @param offset the current offset
     * @param levelNodes the current level of nodes
     */
    private void printConnectingDashes(int level, int offset, 
                                       BinaryNode<Integer> levelNodes[])
    {
        if (offset > 1) printSpaces(offset);
        
        int k = POWERS_OF_2[level];
        for (int i = 0; i < k; i++) {
            BinaryNode<Integer> node = levelNodes[i];
            
            // Has left child: print dashes
            if ((node != null) && (node.getLeft() != null)) {
                printSpaces(3);
                printDashes(offset-1);
            }
            
            // No left child: print spaces
            else {
                printSpaces(offset+2);
            }
            
            // Has right child: print dashes
            if ((node != null) && (node.getRight() != null)) {
                printSpaces(2);
                printDashes(offset-1);
            }
            
            // No right child: print spaces
            else {
                printSpaces(offset+1);
            }
            
            // Space over to the next node in this level.
            if (i < k-1) printSpaces(2*offset+1);
        }
        
        System.out.println();
    }
    
    /**
     * Print incoming pointers / or \ to each non-null child node.
     * @param level the current level
     * @param offset the current offset
     * @param levelNodes the current level of nodes
     */
    private void printIncomingPointers(int level, int offset,
                                       BinaryNode<Integer> levelNodes[])
    {
        printSpaces(offset);
        
        int k = POWERS_OF_2[level];
        for (int i = 0; i < k; i++) {
            BinaryNode<Integer> node = levelNodes[i];
            
            // Left child: print /
            if ((node != null) && (node.getLeft() != null)) {
                System.out.print("  /");
            }
            
            // No left child: print spaces
            else {
                printSpaces(3);
            }
            
            // Right child: print \
            if ((node != null) && (node.getRight() != null)) {
                printSpaces(2*offset);
                System.out.print("\\");
            }
            
            // No right child: print spaces
            else {
                printSpaces(2*offset+1);
            }
            
            // Space over to the next node in this level.
            if (i < k-1) printSpaces(2*offset);
        }
        
        System.out.println();
    }
    
    /**
     * Prepare the next level of nodes.
     * @param level the current level
     * @param levelNodes the current level of nodes
     * @return the next level of nodes.
     */
    private BinaryNode<Integer>[] nextLevel(int level, 
                                            BinaryNode<Integer> levelNodes[])
    {
        BinaryNode<Integer> nextLevel[] = 
                (BinaryNode<Integer>[]) new BinaryNode[POWERS_OF_2[level+1]];
        
        for (int i = 0; i < POWERS_OF_2[level]; i++) {
            BinaryNode<Integer> node = levelNodes[i];
            
            // Queue the left child nodes of each non-null parent node.
            nextLevel[2*i] = (node != null) && (node.getLeft() != null)
                           ? node.getLeft() : null;
                                        
            // Queue the right child nodes of each non-null parent node.
            nextLevel[2*i+1] = (node != null) && (node.getRight() != null)
                             ? node.getRight() : null;
        }
        
        return nextLevel;
    }
    
    /**
     * Print spaces.
     * @param count the number of spaces.
     */
    private void printSpaces(int count)
    {
        for (int i = 0; i < count; i++) 
            System.out.print(" ");
    }
    
    /**
     * Print dashes.
     * @param count the number of dashes.
     */
    private void printDashes(int count)
    {
        for (int i = 0; i < count; i++) System.out.print("-");
    }
}
