import java.util.Random;
import java.util.Arrays;

class BubbleSort {
	public static int N = 10;
	public static void main(String[] args) {
		int min = 10;
		int max = 1000;
		Random random = new Random();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}

		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Bubble Sort: " + Arrays.toString(arr));		
	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					swap(arr, i, j);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}