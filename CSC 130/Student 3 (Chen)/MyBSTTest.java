package edu.csus.csc130.fall2019.assignment3;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MyBSTTest {
	@Test
	void testConcat_1() {
		MyBST<Integer, Integer> bst1 = new MyBST<Integer, Integer>();
		int size1 = bst1.size();
		
		int[] a2 = {157, 109, 104, 111, 179, 173, 190, 118, 107, 142};
		MyBST<Integer, Integer> bst2 = buildBST(a2);
		int size2 = bst2.size();
		
		bst1.concat(bst2);
		
		Assert.assertEquals(size1 + size2, bst1.size());
		Assert.assertTrue(bst1.isBST());
		for (int n: a2) {
			Assert.assertTrue(bst1.contains(n));
		}
	}
	
	@Test
	void testConcat_2() {
		int[] a1 = {11, 88, 36, 49, 60, 5, 84, 9, 83, 47};
		MyBST<Integer, Integer> bst1 = buildBST(a1);
		int size1 = bst1.size();
		
		MyBST<Integer, Integer> bst2 = new MyBST<Integer, Integer>();;
		int size2 = bst2.size();
		
		bst1.concat(bst2);
		
		Assert.assertEquals(size1 + size2, bst1.size());
		Assert.assertTrue(bst1.isBST());
		for (int n: a1) {
			Assert.assertTrue(bst1.contains(n));
		}
	}

	@Test
	void testConcat_3() {
		int[] a1 = {11, 88, 36, 49, 60, 5, 84, 9, 83, 47};
		MyBST<Integer, Integer> bst1 = buildBST(a1);
		int size1 = bst1.size();
		
		int[] a2 = {157, 109, 104, 111, 179, 173, 190, 118, 107, 142};
		MyBST<Integer, Integer> bst2 = buildBST(a2);
		int size2 = bst2.size();
		
		bst1.concat(bst2);
		
		Assert.assertEquals(size1 + size2, bst1.size());
		Assert.assertTrue(bst1.isBST());
		for (int n: a1) {
			Assert.assertTrue(bst1.contains(n));
		}
		for (int n: a2) {
			Assert.assertTrue(bst1.contains(n));
		}
	}
	
	@Test
	void testConcat_4() {
		int[] a1 = {90, 88, 86, 84, 83, 82, 65, 54, 46, 45};
		MyBST<Integer, Integer> bst1 = buildBST(a1);
		int size1 = bst1.size();
		
		int[] a2 = {100, 102, 111, 116, 117, 121};
		MyBST<Integer, Integer> bst2 = buildBST(a2);
		int size2 = bst2.size();
		
		bst1.concat(bst2);
		
		Assert.assertEquals(size1 + size2, bst1.size());
		Assert.assertTrue(bst1.isBST());
		for (int n: a1) {
			Assert.assertTrue(bst1.contains(n));
		}
		for (int n: a2) {
			Assert.assertTrue(bst1.contains(n));
		}
	}
	
	@Test
	void testConcat_5() {
		int[] a1 = {2, 5, 7, 11, 20, 21, 22, 25, 26, 35, 39, 46};
		MyBST<Integer, Integer> bst1 = buildBST(a1);
		int size1 = bst1.size();
		
		int[] a2 = {105, 107, 109, 115, 117, 125, 126, 127, 133, 135, 136, 138, 139, 149, 153, 154, 157, 169, 182, 189};
		MyBST<Integer, Integer> bst2 = buildBST(a2);
		int size2 = bst2.size();
		
		bst1.concat(bst2);
		
		Assert.assertEquals(size1 + size2, bst1.size());
		Assert.assertTrue(bst1.isBST());
		for (int n: a1) {
			Assert.assertTrue(bst1.contains(n));
		}
		for (int n: a2) {
			Assert.assertTrue(bst1.contains(n));
		}
	}
	
	private MyBST<Integer, Integer> buildBST(int[] a) {
		MyBST<Integer, Integer> bst = new MyBST<Integer, Integer>();
		for (int i=0; i<a.length; i++) {
			bst.put(a[i], i);
		}
		return bst;
	}

}
