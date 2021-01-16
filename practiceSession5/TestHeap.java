import java.util.*;

class TestHeap {

	static int num = 10;
	public static void main(String[] args) {
		Random random = new Random();
		int min = 100;
		int max = 1000;
		int[] arr = new int[num];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}

		// using heapify O(n)
		Heap heap = new Heap(arr);
		System.out.println("Unsorted: " + Arrays.toString(arr));

		// time complexity of heapsort O(nlogn)
		System.out.print("Heapsort: ");
		while(heap.size > 0) {
			// extractMin O(logn)
			// System.out.println("heap arr:" + Arrays.toString(heap.arr));
			System.out.print(" " + heap.extractMin());			
		}
		System.out.println();
	}
}