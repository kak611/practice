import java.util.*;

class QuickSort {
	public static void main(String[] args) {
		MyArray myarr = new MyArray(15, 100 ,999);
		int[] arr = myarr.getUnsortedArray();
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void sort(int[] arr, int lo, int hi) {
		if (lo < hi) {			
			int pivotInd = partition(arr, lo, hi);
			sort(arr, lo, pivotInd - 1);
			sort(arr, pivotInd + 1, hi);
		}
	}

	public static int partition(int[] arr, int lo, int hi) {
		int mid = (hi - lo)/2 + lo;
		swap(arr, lo, mid);
		int pivot = arr[lo];

		int i = lo + 1;
		for (int j = lo + 1; j <= hi; j++) {
			if (arr[j] < pivot) {
				swap(arr, i++, j);
			}
		}
		swap(arr, lo, i-1);
		return i-1;
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}