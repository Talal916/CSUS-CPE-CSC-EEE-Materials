package edu.csus.csc130.fall2019.assignment2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MaxDHeapTest {
	@SuppressWarnings("rawtypes")
	@Test
	void test_1() {
		int[] keys = {92, 55, 82, 59, 23, 6, 95, 31, 76, 75, 54, 16, 88, 69, 28};
		MaxDHeap<Integer> maxPQ = new MaxDHeap<Integer>(100, 2);
		for (int i=0; i<keys.length; i++) {
			maxPQ.insert(keys[i]);
			Assert.assertEquals((i+1), maxPQ.size()); 
		}
		
		int[] pIndexes = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
		for (int i=0; i<keys.length; i++) {
			int pIndex = maxPQ.getParentIndex(i);
			Assert.assertEquals(pIndexes[i], pIndex); 
		}
		
		
		int[] lIndexes = {1,3, 5, 7, 9, 11, 13};
		int[] rIndexes = {2, 4, 6, 8, 10, 12, 14};
		for (int i=0; i<=6; i++) {
			int lIndex = maxPQ.getLeftMostChildIndex(i);
			int rIndex = maxPQ.getRightMostChildIndex(i);
			Assert.assertEquals(lIndexes[i], lIndex); 
			Assert.assertEquals(rIndexes[i], rIndex); 
		}
		
		Integer[] expectedPQ = {95, 76, 92, 59, 75, 88, 82, 31, 55, 23, 54, 6, 16, 69, 28};
		Comparable[] actualPQ = maxPQ.getPQ();
		int size = expectedPQ.length;
		for (int i=0; i<size; i++) {
			Assert.assertEquals(expectedPQ[i], (Integer) actualPQ[i]); 
		}
		
		Integer max = maxPQ.delMax();
		Assert.assertEquals(95, (int) max); 
		Assert.assertEquals(--size, maxPQ.size()); 
		
		Integer[] expectedPQ2 = {92, 76, 88, 59, 75, 28, 82, 31, 55, 23, 54, 6, 16, 69};
		actualPQ = maxPQ.getPQ();
		size = expectedPQ2.length;
		for (int i=0; i<size; i++) {
			Assert.assertEquals(expectedPQ2[i], (Integer) actualPQ[i]); 
		}
	}

	@SuppressWarnings("rawtypes")
	@Test
	void test_2() {
		int[] keys = {92, 55, 82, 59, 23, 6, 95, 31, 76, 75, 54, 16, 88, 69, 28};
		MaxDHeap<Integer> maxPQ = new MaxDHeap<Integer>(100, 3);
		for (int i=0; i<keys.length; i++) {
			maxPQ.insert(keys[i]);
			Assert.assertEquals((i+1), maxPQ.size()); 
		}
		
		int[] pIndexes = {-1, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4};
		for (int i=0; i<keys.length; i++) {
			int pIndex = maxPQ.getParentIndex(i);
			Assert.assertEquals(pIndexes[i], pIndex); 
		}
		
		
		int[] lIndexes = {1, 4, 7, 10, 13};
		int[] rIndexes = {3, 6, 9, 12, 15};
		for (int i=0; i<=4; i++) {
			int lIndex = maxPQ.getLeftMostChildIndex(i);
			int rIndex = maxPQ.getRightMostChildIndex(i);
			Assert.assertEquals(lIndexes[i], lIndex); 
			Assert.assertEquals(rIndexes[i], rIndex); 
		}
		
		Integer[] expectedPQ = {95, 92, 82, 88, 69, 6, 55, 31, 76, 75, 54, 16, 59, 23, 28};
		Comparable[] actualPQ = maxPQ.getPQ();
		int size = expectedPQ.length;
		for (int i=0; i<size; i++) {
			Assert.assertEquals(expectedPQ[i], (Integer) actualPQ[i]); 
		}
		
		Integer max = maxPQ.delMax();
		Assert.assertEquals(95, (int) max); 
		Assert.assertEquals(--size, maxPQ.size()); 
		
		Integer[] expectedPQ2 = {92, 69, 82, 88, 28, 6, 55, 31, 76, 75, 54, 16, 59, 23};
		actualPQ = maxPQ.getPQ();
		size = expectedPQ2.length;
		for (int i=0; i<size; i++) {
			Assert.assertEquals(expectedPQ2[i], (Integer) actualPQ[i]); 
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	void test_3() {
		int[] keys = {92, 55, 82, 59, 23, 6, 95, 31, 76, 75, 54, 16, 88, 69, 28};
		MaxDHeap<Integer> maxPQ = new MaxDHeap<Integer>(100, 4);
		for (int i=0; i<keys.length; i++) {
			maxPQ.insert(keys[i]);
			Assert.assertEquals((i+1), maxPQ.size()); 
		}
		
		int[] pIndexes = {-1, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3};
		for (int i=0; i<keys.length; i++) {
			int pIndex = maxPQ.getParentIndex(i);
			Assert.assertEquals(pIndexes[i], pIndex); 
		}
		
		
		int[] lIndexes = {1, 5, 9, 13};
		int[] rIndexes = {4, 8, 12, 16};
		for (int i=0; i<=3; i++) {
			int lIndex = maxPQ.getLeftMostChildIndex(i);
			int rIndex = maxPQ.getRightMostChildIndex(i);
			Assert.assertEquals(lIndexes[i], lIndex); 
			Assert.assertEquals(rIndexes[i], rIndex); 
		}
		
		Integer[] expectedPQ = {95, 92, 88, 69, 23, 6, 55, 31, 76, 75, 54, 16, 82, 59, 28};
		Comparable[] actualPQ = maxPQ.getPQ();
		int size = expectedPQ.length;
		for (int i = 0; i < size; i++) {
			Assert.assertEquals(expectedPQ[i], (Integer) actualPQ[i]);
		}

		Integer max = maxPQ.delMax();
		Assert.assertEquals(95, (int) max);
		Assert.assertEquals(--size, maxPQ.size());

		Integer[] expectedPQ2 = { 92, 76, 88, 69, 23, 6, 55, 31, 28, 75, 54, 16, 82, 59 };
		actualPQ = maxPQ.getPQ();
		size = expectedPQ2.length;
		for (int i = 0; i < size; i++) {
			Assert.assertEquals(expectedPQ2[i], (Integer) actualPQ[i]);
		}
	}
	
	@Test
	void test_4() {
		int[] keys = {68, 2, 36, 74, 73, 71, 80, 61, 50, 52, 69, 66, 44, 32, 29, 73, 78, 38, 53, 
				72, 78, 54, 74, 4, 24, 74, 97, 88, 45, 25, 33};
		MaxDHeap<Integer> maxPQ = new MaxDHeap<Integer>(100, 5);
		for (int i=0; i<keys.length; i++) {
			maxPQ.insert(keys[i]);
			Assert.assertEquals((i+1), maxPQ.size()); 
		}
		
		int[] pIndexes = {-1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5};
		for (int i=0; i<keys.length; i++) {
			int pIndex = maxPQ.getParentIndex(i);
			Assert.assertEquals(pIndexes[i], pIndex); 
		}
		
		int[] lIndexes = {1, 6, 11, 16, 21, 26, 31};
		int[] rIndexes = {5, 10, 15, 20, 25, 30, 35};
		for (int i=0; i<=6; i++) {
			int lIndex = maxPQ.getLeftMostChildIndex(i);
			int rIndex = maxPQ.getRightMostChildIndex(i);
			Assert.assertEquals(lIndexes[i], lIndex); 
			Assert.assertEquals(rIndexes[i], rIndex); 
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	void test_5() {
		int[] keys = {68, 2, 36, 74, 73, 71, 80, 61, 50, 52, 69, 66, 44, 32, 29, 73, 78, 38, 53, 
				72, 78, 54, 74, 4, 24, 74, 97, 88, 45, 25, 33};
		MaxDHeap<Integer> maxPQ = new MaxDHeap<Integer>(100, 5);
		for (int i=0; i<keys.length; i++) {
			maxPQ.insert(keys[i]);
		}
		
		Integer[] expectedPQ = {97, 74, 73, 78, 74, 88, 2, 61, 50, 52, 69, 36, 44, 32, 29, 66, 68, 38, 53, 72, 78, 
				54, 73, 4, 24, 74, 71, 80, 45, 25, 33};
		Comparable[] actualPQ = maxPQ.getPQ();
		int size = expectedPQ.length;
		for (int i = 0; i < size; i++) {
			Assert.assertEquals(expectedPQ[i], (Integer) actualPQ[i]);
		}

		Integer max = maxPQ.delMax();
		Assert.assertEquals(97, (int) max);
		Assert.assertEquals(--size, maxPQ.size());

		Integer[] expectedPQ2 = { 88, 74, 73, 78, 74, 80, 2, 61, 50, 52, 69, 36, 44, 32, 29, 66, 68, 38, 53, 72, 78, 
				54, 73, 4, 24, 74, 71, 33, 45, 25};
		actualPQ = maxPQ.getPQ();
		size = expectedPQ2.length;
		for (int i = 0; i < size; i++) {
			Assert.assertEquals(expectedPQ2[i], (Integer) actualPQ[i]);
		}

	}

}
