/****************************************
Lawrence Naidu & Sam Lee
CSC 130
Programming Project 3
****************************************/

public class AVLTree<E extends Comparable<? super E>> implements DataCounter<E>{
	protected BinaryNode root; 
	protected int size;
	
	public AVLTree() {
		root = null;
		size = 0;
	}
	
	public class BinaryNode {
		E data;
		BinaryNode left;
		BinaryNode right;
		int count;
		int height;

		public E getData() {
			return this.data;
		}
		
		BinaryNode getLeft() {
			return this.left;
		}
		
		BinaryNode getRight() {
			return this.right;
		}
		
		public BinaryNode(E data) {
			this.data = data;
			count = 1;
			left = right = null;
			size++;
			height = 0;
		}
	}
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public DataCount[] getCounts() {
		@SuppressWarnings("unchecked")
		DataCount<E>[] counts = new DataCount[size];
        if (root != null)
            traverse(root, counts, 0);
        	//System.out.println("Size: " + size);
        return counts;
	}


	@Override
	public void incCount(E data) { //Change implementation to address Height and Rebalance
		
		BinaryNode leaf = root;
		root = insert(leaf, data);
	}
	
	BinaryNode insert(BinaryNode leaf,E data) {
		if (leaf == null) {
			leaf = new BinaryNode(data);
			//System.out.println("Inserting: " + leaf.getData());
			return leaf;
		} 
		
		//System.out.println("Comparing " + data + " : " + leaf.data);
	    int cmp = data.compareTo(leaf.data);
	    if (cmp == 0) {
     		leaf.count += 1;
     	}
	    else if (cmp < 0) {
	    	//System.out.println(data + " < " + leaf.data);
       		leaf.left = insert(leaf.left, data);	        	} 
	    else {
	    	//System.out.println(data + " > " + leaf.data);
	    	leaf.right = insert(leaf.right, data);
	    }
		leaf.height = getMax(getHeight(leaf.left), getHeight(leaf.right)) + 1;
		leaf = rebalanceTree(leaf);
		
		return leaf;
	}
	
	BinaryNode rebalanceTree(BinaryNode leaf) {
		//System.out.println("In Rebalance");
		if (getBalance(leaf) < -1) { 																				//Right Heavy
			//System.out.println("RightHeavy\n" + leaf.data + "(" + leaf.height + "," + getBalance(leaf) + ")");
			if (getBalance(leaf.right) > 0) {																		//Right-Left Rotation
				//System.out.print("Double Right-");
				leaf.right = rightRotate(leaf.right);
				setHeight(leaf);
			}
			//System.out.println("Left Rotation: " + leaf.right.data);
			leaf = leftRotate(leaf);
		}
		else if (getBalance(leaf) > 1) {																			//Left Heavy
			//System.out.println("LeftHeavy\n" + leaf.data + "(" + leaf.height + "," + getBalance(leaf) + ")");
			if (getBalance(leaf.left) < 0) {																		//Left-Right Rotation
				//System.out.print("Double Left-");
				leaf.left = leftRotate(leaf.left);
				setHeight(leaf);
			}
			//System.out.println("Right Rotation: " + leaf.left.data);
			leaf = rightRotate(leaf);
		}
		return leaf;
	}
	
	int getBalance(BinaryNode leaf) {
		//System.out.println("Checking Balance of " + leaf.data);
		return ((leaf == null) ? 0 : getHeight(leaf.left) - getHeight(leaf.right));
	}
	
	BinaryNode rightRotate(BinaryNode leaf) {
		//System.out.println("In rightRotate");
		BinaryNode temp = leaf.left;
		leaf.left = temp.right;
		temp.right = leaf;
		
		leaf.height = getHeight(leaf.left) > getHeight(leaf.right) ? getHeight(leaf.left) + 1 : getHeight(leaf.right) + 1;
		temp.height = getHeight(temp.left) > leaf.height ? getHeight(temp.left) + 1 : leaf.height + 1;
		return temp;
	}
	
	BinaryNode leftRotate(BinaryNode leaf) {
		//System.out.println("In leftRotate");
		BinaryNode temp = leaf.right;
		leaf.right = temp.left;
		temp.left = leaf;
		
		leaf.height = getHeight(leaf.left) > getHeight(leaf.right) ? getHeight(leaf.left) + 1 : getHeight(leaf.right) + 1;
		temp.height = getHeight(temp.right) > leaf.height ? getHeight(temp.right) + 1 : leaf.height + 1;
		return temp;
	}
	
	public int getHeight(BinaryNode leaf) {
		if(leaf == null) {
			return -1;
		}
		return leaf.height;
	}
	
	public int getMax(int left, int right) {
		return (left > right ? left : right);
	}
	
	public int setHeight(BinaryNode leaf) {
		return ((leaf == null) ? -1 : leaf.height);
	}
	
	protected int traverse(BinaryNode leaf, DataCount<E>[] counts, int idx) {
        if(leaf != null) {
            idx = traverse(leaf.left, counts, idx);
            counts[idx] = new DataCount<E>(leaf.data, leaf.count);
            //System.out.println("Count: " + counts[idx].data + ", Index: " + idx);
            idx = traverse(leaf.right, counts, idx + 1);
        }
        return idx;
    }
}
