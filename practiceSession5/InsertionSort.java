import java.util.Random;
import java.util.Arrays;

class InsertionSort {
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
		System.out.println("Insertion Sort: " + Arrays.toString(arr));
	}

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