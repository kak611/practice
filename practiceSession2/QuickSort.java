import java.util.Arrays;
import java.util.Random;

class QuickSort {
	public static final int SIZE = 10;
	public static void main(String[] args) {
		int min = 5;
		int max = 41;
		Random random = new Random();
		int[] arr = new int[SIZE];
		for (int i=0; i < arr.length; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		System.out.println(Arrays.toString(arr));

		quicksortH(arr, 0, arr.length-1);
		System.out.println("Sorted Array using Hoare method: " + Arrays.toString(arr));

		System.out.println(Arrays.toString(arr2));
		quicksortL(arr2, 0, arr.length-1);
		System.out.println("Sorted Array using Lumato method: " + Arrays.toString(arr));
	}

	// Hoare method
	public static void quicksortH(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partitionH(arr, start, end);
			quicksortH(arr, start, pivot);
			quicksortH(arr, pivot+1, end);
		}
	}

	public static int partitionH(int[] arr, int l, int r) {
		int mid = l + (r - l)/2;
		int pivot = arr[mid];
		int i = l-1;
		int j = r+1;

		while (true) {
			do {
				i++;
			} while (arr[i] < pivot);

			do {
				j--;
			} while (arr[j] > pivot);

			if (i >= j) return j;
			swap(arr, i, j);
		}
	}

	public static void quicksortL(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partitionL(arr, start, end);
			quicksortL(arr, start, pivot-1);
			quicksortL(arr, pivot + 1, end);
		}
	}


	// Lomuto method
	public static int partitionL(int[] arr, int l, int r) {		
		int pivot = arr[r];		

		int i = l;
		for (int j = l; j < r; j++) {			
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}		
		swap (arr, i, r);
		return i;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}