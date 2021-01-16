import java.util.*;

class QuickSort {
	public static void main(String[] args) {
		MyArray myArr = new MyArray(10, 1, 99);
		int[] arr = myArr.getUnsortedArray();		
		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void sort(int[] arr, int lo, int hi) {
		if (lo >= hi) return;
		// swapping pivot to leftmost position
		int pivotIndx = partition1(arr, lo, hi); 
		sort(arr, lo, pivotIndx - 1); // note that pivotIndx-1 is passed
		sort(arr, pivotIndx + 1, hi);

		// without swapping and pointers at both ends
		// int pivotIndx = partition2(arr, lo, hi); 
		// sort(arr, lo, pivotIndx); // note this that pivotIndx is passed and not pivotIndx - 1
		// sort(arr, pivotIndx + 1, hi);
	}

	// this method is easy to implement than other
	public static int partition1(int[] arr, int lo, int hi) {
		int mid = (hi - lo)/2 + lo;
		swap(arr, lo, mid);
		int pivot = arr[lo];

		int i = lo + 1;
		int j = i;		// Note: i and j must begin at same position

		while (j <= hi) {
			if (arr[j] < pivot) {
				swap(arr, i++, j);
			}
			j++;
		}

		swap(arr, lo, i-1);
		return i-1;
	}

	// same as quicksort wikipage Hoare partition scheme
	// note that pivotIndx is passed and not pivotIndx-1
	// this is required because there can exists duplicate in input array
	// and two same elements can be at different position rather than next to each other
	public static int partition2(int[] arr, int lo, int hi) {
		int mid = (hi - lo)/2 + lo;
		int pivot = arr[mid];
		int i = lo, j = hi;

		while (true) {
			while (i <= hi && arr[i] < pivot) i++;
			while (j >= lo && arr[j] > pivot) j--;
			if (i >= j) return j;
			swap(arr, i++, j--);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}