//package practiceSession4;

import java.util.Arrays;
import java.util.Random;

class InsertionSort {
	public static void main(String[] args) {
		int N = 20;
		int min = 5;
		int max = 77;

		int[] arr = new int[N];
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;			
		}

		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	// Insertion Sort
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j - 1;
			}

			arr[j+1] = key;
		}
	}
}