import java.util.Arrays;
import java.util.Random;

class BubbleSort {
	public static void main(String[] args) {
		int N = 20;
		int min = 5;
		int max = 151;
		Random random = new Random();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}

		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	// Bubble Sort
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}