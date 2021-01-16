import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

class SelectionSort {
	public static void main(String[] args) {
		int N = 10;
		int min = 10;
		int max = 80;

		int[] arr = new int[N];
		Random random = new Random();

		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}

		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	// selection sort
	public static void sort(int[] arr) {		
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			if (i != min) {
				swap(arr, i, min);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}