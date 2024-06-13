package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListSorterTester {

	ArrayList<Integer> emptyArr, smallAscArr, largeAscArr, smallDesArr, largeDesArr, smallShuffledArr, largeShuffledArr,
			intArr3, intArr4;

	@BeforeEach
	void setUp() throws Exception {

		emptyArr = new ArrayList<Integer>();
		smallAscArr = (ArrayList<Integer>) ListSorter.generateAscending(10);
		largeAscArr = (ArrayList<Integer>) ListSorter.generateAscending(30);
		smallDesArr = (ArrayList<Integer>) ListSorter.generateDescending(10);
		largeDesArr = (ArrayList<Integer>) ListSorter.generateDescending(30);
		smallAscArr = (ArrayList<Integer>) ListSorter.generateAscending(10);
		smallShuffledArr = (ArrayList<Integer>) ListSorter.generatePermuted(10);
		largeShuffledArr = (ArrayList<Integer>) ListSorter.generatePermuted(30);

		intArr3 = new ArrayList<Integer>();
		intArr3.add(1);
		intArr3.add(2);
		intArr3.add(3);
		intArr3.add(4);
		intArr3.add(5);

		intArr4 = new ArrayList<Integer>();
		intArr4.add(5);
		intArr4.add(4);
		intArr4.add(3);
		intArr4.add(2);
		intArr4.add(1);

	}

	@Test
	void testquickSortEmptyArray() {
		ArrayList<Integer> testCopyArr = new ArrayList<Integer>();
		ListSorter.quicksort(emptyArr);
		assertEquals(testCopyArr, emptyArr);

	}

	@Test
	void testquickSortSmallAscArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(10);
		ListSorter.quicksort(smallAscArr);
		for (int i = 0; i < smallAscArr.size(); i++) {
			assertEquals(testCopyArr.get(i), smallAscArr.get(i));
		}
	}

	@Test
	void testquickSortLargeAscArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(30);
		ListSorter.quicksort(largeAscArr);
		for (int i = 0; i < largeAscArr.size(); i++) {
			assertEquals(testCopyArr.get(i), largeAscArr.get(i));
		}
	}

	@Test
	void testquickSortSmallDesArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(10);
		ListSorter.quicksort(smallDesArr);
		for (int i = 0; i < smallDesArr.size(); i++) {
			assertEquals(testCopyArr.get(i), smallDesArr.get(i));
		}
	}

	@Test
	void testquickSortLargeDesArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(30);
		ListSorter.quicksort(largeDesArr);
		for (int i = 0; i < largeDesArr.size(); i++) {
			assertEquals(testCopyArr.get(i), largeDesArr.get(i));
		}
	}

	@Test
	void testquickSortSmallShuffledArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(30);
		ListSorter.quicksort(smallShuffledArr);
		for (int i = 0; i < smallShuffledArr.size(); i++) {
			assertEquals(testCopyArr.get(i), smallShuffledArr.get(i));
		}
	}

	@Test
	void testquickSortLargeShuffledArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(30);
		ListSorter.quicksort(largeShuffledArr);
		for (int i = 0; i < largeShuffledArr.size(); i++) {
			assertEquals(testCopyArr.get(i), largeShuffledArr.get(i));
		}
	}

	@Test
	void testQuickSortEmptyArray() {
		ArrayList<Integer> testCopyArr = new ArrayList<Integer>();
		ListSorter.quicksort(emptyArr);
		assertEquals(testCopyArr, emptyArr);

	}

	@Test
	void testQuickSortSmallAscArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(10);
		ListSorter.quicksort(smallAscArr);
		for (int i = 0; i < smallAscArr.size(); i++) {
			assertEquals(testCopyArr.get(i), smallAscArr.get(i));
		}
	}

	@Test
	void testQuickSortLargeAscArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(30);
		ListSorter.quicksort(largeAscArr);
		for (int i = 0; i < largeAscArr.size(); i++) {
			assertEquals(testCopyArr.get(i), largeAscArr.get(i));
		}
	}

	@Test
	void testQuickSortSmallDesArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(10);
		ListSorter.quicksort(smallDesArr);
		for (int i = 0; i < smallDesArr.size(); i++) {
			assertEquals(testCopyArr.get(i), smallDesArr.get(i));
		}
	}

	@Test
	void testQuickSortLargeDesArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(30);
		ListSorter.quicksort(largeDesArr);
		for (int i = 0; i < largeDesArr.size(); i++) {
			assertEquals(testCopyArr.get(i), largeDesArr.get(i));
		}
	}

	@Test
	void testQuickSortSmallShuffledArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(30);
		ListSorter.quicksort(smallShuffledArr);
		for (int i = 0; i < smallShuffledArr.size(); i++) {
			assertEquals(testCopyArr.get(i), smallShuffledArr.get(i));
		}
	}

	@Test
	void testQuickSortLargeShuffledArray() {
		ArrayList<Integer> testCopyArr = (ArrayList<Integer>) ListSorter.generateAscending(30);
		ListSorter.quicksort(largeShuffledArr);
		for (int i = 0; i < largeShuffledArr.size(); i++) {
			assertEquals(testCopyArr.get(i), largeShuffledArr.get(i));
		}
	}

	@Test
	void testGenerateAscending() {
		ArrayList<Integer> array = (ArrayList<Integer>) ListSorter.generateAscending(5);
		for (int i = 0; i < 5; i++) {
			assertEquals(intArr3.get(i), array.get(i));
		}
	}

	@Test
	void testGenerateDescending() {
		ArrayList<Integer> array = (ArrayList<Integer>) ListSorter.generateAscending(5);
		for (int i = 0; i < 5; i++) {
			assertEquals(intArr3.get(i), array.get(i));
		}
	}

}
