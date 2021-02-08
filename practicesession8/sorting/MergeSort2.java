import java.util.*;

class MergeSort2 {
	public static void main(String[] args) {
		MyArray myArr = new MyArray(10, 1, 99);
		int[] arr = myArr.getUnsortedArray();
		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr, int lo, int hi) {
		if (hi <= lo) return;
		int mid = (hi - lo)/2 + lo;
		sort(arr, lo, mid);
		sort(arr, mid+1, hi);
		merge(arr, lo, mid, hi);
	}

	public static void merge(int[] arr, int lo, int mid, int hi) {

	}
}