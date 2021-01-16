import java.util.*;

/*
	Heap sort is not a stable algorithm but in-place
	time complexity: best/average/worst case O(nlogn)
	space complexity: o(1)
	Method: selection
*/
class HeapSort {

	public static void main(String[] args) {
		final int N = 10;
		int max = 29;
		int min = 8;
		Random random = new Random();
		int[] arr = new int[N];

		for (int i=0; i< arr.length; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}

		System.out.println(Arrays.toString(arr));
		sort(arr, arr.length);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}


	/*
		Steps:
		1. heapify n/2-1 to 0 elements (Note that heapify should be max-heap because we extract max and add it to the end of the array)
		2. start loop from last to first element
		3. extract min and add it to the end of list 
		4. heapify n-1 elements (i.e. length = (i = n-1) and child as root node)
					1

				/		\

			2				3 (swap parents with min & recursively call on right child aka siftdown or heapify)
	*/
	public static void sort(int[] arr, int n) {
		// step 1
		for (int i = n/2-1; i >= 0; --i) {
			heapify(arr, n, i);	
		}

		// step 2
		for (int i=n-1; i >=0; --i) {
			// step 3 -- extract min and swap with last element in the array
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// step 4
			heapify(arr, i, 0);
		}
	}

	// implement max heap
	private static void heapify(int[] arr, int size, int parentIndex) {
		int largest = parentIndex;
		int leftChild = (2 * parentIndex) + 1;
		int rightChild = (2 * parentIndex) + 2;

		if (leftChild < size && arr[leftChild] > arr[parentIndex]) {
			largest = leftChild;
		}

		if (rightChild < size && arr[rightChild] > arr[largest]) {
			largest = rightChild;
		}

		if (largest != parentIndex) {
			int temp = arr[parentIndex];
			arr[parentIndex] = arr[largest];
			arr[largest] = temp;

			heapify(arr, size, largest);
		}
	}

}