import java.util.Random;
import java.util.Arrays;

class HeapSort {	
	public static void main(String[] args) {
		int[] arr = {10, 22, 83, 51, 35, 8, 19, 77};
		System.out.println("Array: " + Arrays.toString(arr));
		heapify(arr);
		System.out.println("Heapify (Bubble-down): " + Arrays.toString(arr));
		// System.out.println(extractMin(arr));
		// System.out.println("Heapify (Bubble-down): " + Arrays.toString(arr));
		heapSort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void heapSort(int[] arr) {
		heapify(arr);
		for (int i = arr.length - 1; i >= 0; --i) {			
			int min = extractMin(arr, i);
			// System.out.println("min : " + min + ", " + ", i: " + i + ", " + Arrays.toString(arr));
			arr[i] = min;
		}

		reverse(arr);
	}

	public static void reverse(int[] arr) {
		for (int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}

	public static void heapify(int[] arr) {
		int lastParentNode = arr.length/2 - 1;
		for (int i = lastParentNode; i >= 0; --i) {			
			heapify(arr, i);
		}
	}

	public static void heapify(int[] arr, int i) {
		int leftChild = (2 * i) + 1;
		int rightChild = (2 * i) + 2;

		int minIndex = i;

		if (leftChild < arr.length && arr[leftChild] < arr[minIndex]) {
			minIndex = leftChild;
		}

		if (rightChild < arr.length && arr[rightChild] < arr[minIndex]) {
			minIndex = rightChild;
		}

		if (minIndex != i) {
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			heapify(arr, minIndex);			
		}
	}

	public static int extractMin(int[] arr, int len) {
		int min = arr[0];
		arr[0] = arr[len];
		arr[len] = Integer.MAX_VALUE;

		siftDown(arr, len, 0);
		return min;
	}

	// heapify
	public static void siftDown(int[] arr, int len, int i) {		
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;

		int minIndex = i;
		if (leftChild <= len && arr[leftChild] < arr[minIndex]) {
			minIndex = leftChild;
		}

		if (rightChild <= len && arr[rightChild] < arr[minIndex]) {
			minIndex = rightChild;
		}

		if (minIndex != i) {
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
			siftDown(arr, len, i);
		}
	}
}