import java.util.Random;
import java.util.Arrays;

class SelectionSort {
	public static int N = 10;
	public static void main(String[] args) {
		int[] arr = new int[N];
		Random random = new Random();
		int min = 10;
		int max = 100;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}

		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Selection Sort: " + Arrays.toString(arr));
	}

	// selection sort
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minInd = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minInd]) {
					minInd = j;
				}
			}

			swap(arr, i, minInd);			
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}