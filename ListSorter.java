package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorter {

	public static int insertionSortThreshold = 5;

	public static <T> void insertionSort(List<T> arr, Comparator<? super T> cmp) {
		for (int unsortedLine = 1; unsortedLine < arr.size(); unsortedLine++) {
			T unsortedVal = arr.get(unsortedLine);
			int sortedLine;
			for (sortedLine = unsortedLine - 1; sortedLine >= 0
					&& cmp.compare(arr.get(sortedLine), unsortedVal) > 0; sortedLine--) {
				T temp = arr.get(sortedLine);
				arr.set(sortedLine, unsortedVal);
				arr.set(unsortedLine, temp);
				unsortedLine--;
			}

		}
	}

	public static <T extends Comparable<? super T>> void mergesort(List<T> arr) {
		if (arr.size() < 2) {
			return;
		}
		ArrayList<T> tempList = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++)
			tempList.add(null);
		mergesortHelper(arr, tempList);
	}

	private static <T extends Comparable<? super T>> void mergesortHelper(List<T> arr, List<T> tempList) {
		// base case
		Comparator<T> cmp = (s1, s2) -> (s1).compareTo((s2));
		if (arr.size() <= insertionSortThreshold) {
			insertionSort(arr, cmp);
		} else {
			int mid = arr.size() / 2;
			List<T> left = arr.subList(0, mid);
			List<T> right = arr.subList(mid, arr.size());

			mergesortHelper(left, tempList);
			mergesortHelper(right, tempList);
			merge(arr, tempList, left, right);
		}

	}

	private static <T extends Comparable<? super T>> void merge(List<T> arr, List<T> tempList, List<T> left,
			List<T> right) {

		int leftSize = arr.size() / 2;
		int rightSize = arr.size() - leftSize;
		int i = 0;
		int l = 0;
		int r = 0;

		while (l < leftSize && r < rightSize) {
			if (left.get(l).compareTo(right.get(r)) < 0) {
				tempList.set(i, left.get(l));
				i++;
				l++;
			} else {
				tempList.set(i, right.get(r));
				i++;
				r++;
			}
		}
		while (l < leftSize) {
			tempList.set(i, left.get(l));
			i++;
			l++;
		}
		while (r < rightSize) {
			tempList.set(i, right.get(r));
			i++;
			r++;
		}
		for (int n = 0; n < arr.size(); n++) {
			arr.set(n, tempList.get(n));
		}

	}

	public static <T extends Comparable<? super T>> void quicksort(List<T> arr) {
		int start = 0;
		int end = arr.size() - 1;
		if (end <= start)
			return;
		quicksortHelper(arr, start, end);
	}

	public static <T extends Comparable<? super T>> void quicksortHelper(List<T> arr, int start, int end) {
		if (end <= start)
			return;
		int pivot = partition(arr, start, end);
		quicksortHelper(arr, start, pivot - 1);
		quicksortHelper(arr, pivot + 1, end);

	}

	public static <T extends Comparable<? super T>> int partition(List<T> arr, int start, int end) {
//		T pivot = arr.get(end);
		T pivot = choosePivot(arr, "median", start, end);
		int index = start - 1;

		for (int j = start; j <= end - 1; j++) {
			if (arr.get(j).compareTo(pivot) < 0) {
				index++;
				T temp = arr.get(index);
				arr.set(index, arr.get(j));
				arr.set(j, temp);
			}
		}
		index++;
		T temp = arr.get(index);
		arr.set(index, arr.get(end));
		arr.set(end, temp);

		return index;
	}

	public static List<Integer> generateAscending(int size) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			arr.add(i + 1);
		}
		return arr;
	}

	public static List<Integer> generatePermuted(int size) {
		ArrayList<Integer> arr = (ArrayList<Integer>) generateAscending(size);
		Collections.shuffle(arr);
		return arr;
	}

	public static List<Integer> generateDescending(int size) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = size - 1; i >= 1; i--) {
			arr.add(i);
		}
		return arr;
	}

	private static <T extends Comparable<? super T>> T choosePivot(List<T> arr, String pivotSelect, int start, int end) {
		T pivot;
		Comparator<T> cmp = (s1, s2) -> (s1).compareTo((s2));
		switch (pivotSelect) {
		case "last":
			pivot = arr.get(end);
			return pivot;
		case "first":
			pivot = arr.get(start);
			arr.set(start, arr.get(end));
			arr.set(end, pivot);
			return pivot;
		case "median":
			T firstElement = arr.get(start);
			T middleElement = arr.get(end/2);
			T lastElement = arr.get(end);
			ArrayList<T> selection = new ArrayList<T>();
			selection.add(firstElement);
			selection.add(middleElement);
			selection.add(lastElement);
			insertionSort(selection, cmp);
			pivot = selection.get(1);
			if (selection.get(1).equals(firstElement)) {
				arr.set(start, arr.get(end));
				arr.set(end, pivot);
				return pivot;
			}
			if (selection.get(1).equals(middleElement)) {
				arr.set(end/2, arr.get(end));
				arr.set(end, pivot);
				return pivot;
			}
			if (selection.get(1).equals(lastElement)) {
				return pivot;
			}
			return pivot;
		default:
			pivot = arr.get(end);
			return pivot;
			
		}

	}

}
