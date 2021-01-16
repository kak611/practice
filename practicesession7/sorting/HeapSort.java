import java.util.*;

class HeapSort {
	public static void main(String[] args) {
		MyArray myArr = new MyArray(10, 10, 99);
		int[] arr = myArr.getUnsortedArray();
		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {		
		int parentIndex = (arr.length/2) - 1;

		for (int i = parentIndex; i >= 0; --i) {
			// max-heap
			heapify(arr, i, arr.length);
		}

		// extract max and put it at the end of array
		for (int i = arr.length - 1; i >= 0; --i) {
			arr[i] = extractMax(arr, i);
		}
	}

	public static int extractMax(int[] arr, int i) {
		int max = arr[0];
		arr[0] = arr[i];
		arr[i] = Integer.MIN_VALUE;
		heapify(arr, 0, i); // heapify first element as its swapped with last element
		return max;
	}

	// max-heap : element at 0th index is maximum
	public static void heapify(int[] arr, int parentIndex, int size) {
		int leftIndx = (2 * parentIndex + 1);
		int rightIndx = (2 * parentIndex + 2);

		int maxIndex = parentIndex;
		if (leftIndx < size && arr[leftIndx] > arr[maxIndex]) {
			maxIndex = leftIndx;
		}

		if (rightIndx < size && arr[rightIndx] > arr[maxIndex]) {
			maxIndex = rightIndx;
		}

		if (parentIndex != maxIndex) {
			swap(arr, parentIndex, maxIndex);
			heapify(arr, maxIndex, size);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}