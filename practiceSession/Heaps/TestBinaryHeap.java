import java.util.Random;
import java.util.Arrays;

class TestBinaryHeap {
	public static void main(String[] args) {
		final int N = 10;		
		int[] arr = new int[N];
		Random random = new Random();
		// range of random numbers => min to max
		int min = 5;
		int max = 20;
		for (int i=0; i<arr.length; i++) {
			// for min = 5 & max = 11, (max - min) + 1 = 7 
			// i.e. random number range is 0..6 & add min to it
			arr[i] = random.nextInt((max - min) + 1) + min;
		}

		int[] arr2 = {12, 11, 15, 17, 10, 16, 7, 9, 15, 10};
		arr = arr2;

		System.out.println("Input Array: " + Arrays.toString(arr));
		BinaryHeap heap = new BinaryHeap(arr);
		//System.out.println("Updated array (Min-Heap): " + Arrays.toString(arr));

		// display updated array		
		heap.displayHeapArr();

		// display using root node
		heap.displayBinaryHeap();
		
		System.out.println("2D representation of min-heap: ");
		heap.displayHeapIn2D(heap.getRootNode(), 0);

		System.out.println("Min value: " + heap.getMin());		
		heap.insert(8);		
		heap.displayHeapIn2D(heap.getRootNode(), 0);
		int val = heap.extractMin();
		System.out.println("ExtractMin: " + val);
		heap.displayHeapIn2D(heap.getRootNode(), 0);
	}
}