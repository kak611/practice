import java.util.*;

class MergeSort {
	public static void main(String[] args) {
		MyArray myarr = new MyArray(5,10,99);
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
			int mid = (hi - lo)/2 + lo;
			sort(arr, lo, mid);
			sort(arr, mid+1, hi);
			merge1(arr, lo, mid, hi);
			// merge2(arr, lo, mid, hi);
		}
	}

	public static void merge2(int[] arr, int lo, int mid, int hi) {		
		int[] tempArr = new int[hi - lo + 1];

		int i = lo, j = mid + 1;
		int k = 0;

		while (i <= mid && j <= hi) {
			if (arr[i] < arr[j]) {
				tempArr[k++] = arr[i++];
			} else {
				tempArr[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			tempArr[k++] = arr[i++];
		}

		while (j <= hi) {
			tempArr[k++] = arr[j++];
		}

		k = lo;
		while (k <= hi) {
			arr[k] = tempArr[k - lo];
			k++;
		}
	}





	// method 1: creating sub-arrays
	public static void merge1(int[] arr, int lo, int mid, int hi) {
		int leftSize = mid - lo + 1;
		int rightSize = hi - mid;

		int[] leftArr = new int[leftSize];
		int[] rightArr = new int[rightSize];

		for (int i = 0; i < leftSize; i++) {
			leftArr[i] = arr[lo + i];
		}

		for (int j = 0; j < rightSize; j++) {
			rightArr[j] = arr[mid + j + 1];
		}
		// System.out.println(Arrays.toString(leftArr));
		// System.out.println(Arrays.toString(rightArr));

		int i = 0, j = 0;
		int k = lo;

		while (i < leftSize && j < rightSize) {
			if (leftArr[i] < rightArr[j]) {
				arr[k] = leftArr[i++];
			} else {
				arr[k] = rightArr[j++];
			}
			k++;			
		}

		while (i < leftSize) {
			arr[k++] = leftArr[i++];
		}

		while (j < rightSize) {
			arr[k++] = rightArr[j++];
		}
	}
}