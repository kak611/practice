import java.util.Random;
import java.util.Arrays;

/*
	Insertion sort is a stable algorithm as well as in-place
	time complexity: best: o(n), average/worst case O(n^2)
	space complexity: o(1)
	Method: insertion
*/
class InsertionSort {
	public static void main(String[] args) {
		final int N = 10;
		final int MIN = 5;
		final int MAX = 30;
		Random random = new Random();
		int[] arr = new int[N];
		for (int i=0; i<arr.length; i++) {
			arr[i] = random.nextInt((MAX - MIN) + 1) + MIN; // range START..END
		}
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length-1);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}

	/*
		Steps:
		1. In a loop starting at index 1, start with arr[1] as key and go on comparing with previous elements to find correct sorted position
		2. set a pointer to previous element i.e. arr[0]
		3. keep moving pointer to previous elements till the position to insert key is found
		4. insert key
	*/
	public static void sort(int[] arr, int start, int end) {		
		for (int i = start + 1; i <= end; i++) {
			// step 1
			int key = arr[i];

			// step 2
			int j = i-1;
			
			// step 3
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}

			// step 4
			arr[j+1] = key;
		}		
	}
}
