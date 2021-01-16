import java.util.*;

class HeapSort {
	public static void main(String[] args) {	
		MyArray myarr = new MyArray(5, 10 ,99);
		int[] arr = myarr.getUnsortedArray();
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = n/2-1; i >= 0; --i) {
			heapify(arr, n, i);
		}

		// why is this for loop required ?
		// this is extract-min loop. After heapify, the max element is at 0th index
		// extract it and swap the 0th element with last element and heapify to restore
		// this is exactly how heap works.. extraction is o(1) however, heapifying is logn
		for (int i = n-1; i >= 0; --i) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}
	}

	public static void heapify(int[] arr, int size, int parentIndx) {
		int maxIndex = parentIndx;
		int leftChild = 2 * parentIndx + 1;
		int rightChild = 2 * parentIndx + 2;

		if (leftChild < size && arr[leftChild] > arr[maxIndex]) {
			maxIndex = leftChild;
		}

		if (rightChild < size && arr[rightChild] > arr[maxIndex]) {
			maxIndex = rightChild;		
		}

		if (maxIndex != parentIndx) {
			int temp = arr[parentIndx];
			arr[parentIndx] = arr[maxIndex];
			arr[maxIndex] = temp;

			heapify(arr, size, maxIndex);
		}
	}
}