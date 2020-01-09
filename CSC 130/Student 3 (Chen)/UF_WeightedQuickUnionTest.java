package edu.csus.csc130.fall2019.assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UF_WeightedQuickUnionTest {

	@Test
	void testUnion_1() {
		UF_WeightedQuickUnion uf = new UF_WeightedQuickUnion(10);
		uf.union(4, 3);
		
		int[] expectedHeight = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
		int[] expectedId = {0, 1, 2, 4, 4, 5, 6, 7, 8, 9};
		int expectedCount = 9;
		
		assertArrayEquals(expectedHeight, uf.getHeight());
		assertArrayEquals(expectedId, uf.getId());
		assertEquals(expectedCount, uf.count());
	}
	
	@Test
	void testUnion_2() {
		UF_WeightedQuickUnion uf = new UF_WeightedQuickUnion(10);
		uf.union(4, 3);
		uf.union(5, 6);
		uf.union(3, 6);
		
		int[] expectedHeight = {0, 0, 0, 0, 2, 1, 0, 0, 0, 0};
		int[] expectedId = {0, 1, 2, 4, 4, 4, 5, 7, 8, 9};
		int expectedCount = 7;
		
		assertArrayEquals(expectedHeight, uf.getHeight());
		assertArrayEquals(expectedId, uf.getId());
		assertEquals(expectedCount, uf.count());
	}

	@Test
	void testUnion_3() {
		UF_WeightedQuickUnion uf = new UF_WeightedQuickUnion(10);
		uf.union(4, 3);
		uf.union(5, 6);
		uf.union(3, 6);
		uf.union(0, 1);
		uf.union(0, 2);
		uf.union(0, 7);
		uf.union(0, 8);
		uf.union(0, 9);
		uf.union(9, 6);
		
		int[] expectedHeight = {1, 0, 0, 0, 2, 1, 0, 0, 0, 0};
		int[] expectedId = {4, 0, 0, 4, 4, 4, 5, 0, 0, 0};
		int expectedCount = 1;
		
		assertArrayEquals(expectedHeight, uf.getHeight());
		assertArrayEquals(expectedId, uf.getId());
		assertEquals(expectedCount, uf.count());
	}
	
	@Test
	void testUnion_4() {
		UF_WeightedQuickUnion uf = new UF_WeightedQuickUnion(10);
		uf.union(1, 2);
		uf.union(6, 1);
		uf.union(0, 8);
		uf.union(6, 2);
		uf.union(8, 7);
		uf.union(7, 0);
		uf.union(5, 7);
		uf.union(1, 4);
		uf.union(6, 7);
		
		int[] expectedHeight = {1, 2, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] expectedId = {1, 1, 1, 3, 1, 0, 1, 0, 0, 9};
		int expectedCount = 3;
		
		assertArrayEquals(expectedHeight, uf.getHeight());
		assertArrayEquals(expectedId, uf.getId());
		assertEquals(expectedCount, uf.count());
	}
	
	@Test
	void testUnion_5() {
		UF_WeightedQuickUnion uf = new UF_WeightedQuickUnion(10);
		uf.union(7, 9);
		uf.union(2, 4);
		uf.union(5, 1);
		uf.union(3, 4);
		uf.union(1, 3);
		uf.union(9, 8);
		uf.union(1, 6);
		uf.union(9, 6);
		uf.union(8, 1);
		uf.union(0, 6);
		
		int[] expectedHeight = {0, 0, 1, 0, 0, 2, 0, 1, 0, 0};
		int[] expectedId = {5, 5, 5, 2, 2, 5, 5, 5, 7, 7};
		int expectedCount = 1;
		
		assertArrayEquals(expectedHeight, uf.getHeight());
		assertArrayEquals(expectedId, uf.getId());
		assertEquals(expectedCount, uf.count());
	}
	
}
