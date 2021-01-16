import java.util.*;
// Tip: remember to set k = lo in both methods
class MergeSort {
	public static void main(String[] args) {
		MyArray myArr = new MyArray(10, 1, 99);
		int[] arr = myArr.getUnsortedArray();
		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	// time complexity: o(nlogn)
	// space complexity: o(n)
	public static void sort(int[] arr, int lo, int hi) {
		if (lo >= hi) return;

		int mid = (hi - lo)/2 + lo;
		sort(arr, lo, mid);
		sort(arr, mid+1, hi);
		// merge1(arr, lo, mid, hi); // Using new array
		merge2(arr, lo, mid, hi); // using two sub-arrays
	}

	public static void merge2(int[] arr, int lo, int mid, int hi) {
		int left_size = mid - lo + 1;
		int right_size = hi - mid;
		int[] left_arr = new int[left_size];
		int[] right_arr = new int[right_size];

		// create sub-arrays
		for (int i = lo; i <= mid; i++) {
			left_arr[i - lo] = arr[i];
		}

		for (int j = mid+1; j <= hi; j++) {
			right_arr[j - (mid + 1)] = arr[j];
		}

		int i = 0, j = 0, k = lo;

		// merge
		while (i < left_size && j < right_size) {
			if (left_arr[i] < right_arr[j]) {
				arr[k++] = left_arr[i++];
			} else {
				arr[k++] = right_arr[j++];
			}
		}

		while (i < left_size) {
			arr[k++] = left_arr[i++];
		}

		while (j < right_size) {
			arr[k++] = right_arr[j++];
		}
	}

	public static void merge1(int[] arr, int lo, int mid, int hi) {
		int[] result = new int[hi - lo + 1];

		int i = lo;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= hi) {
			if (arr[i] < arr[j]) {
				result[k++] = arr[i++];
			} else {
				result[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			result[k++] = arr[i++];
		}

		while (j <= hi) {
			result[k++] = arr[j++];
		}
		// System.out.println(Arrays.toString(result));

		k = lo;
		while (k <= hi) {
			arr[k] = result[k - lo];
			k++;
		}
	}
}