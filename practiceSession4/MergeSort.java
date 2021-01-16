import java.util.Arrays;
import java.util.Random;

class MergeSort {
	public static void main(String[] args) {
		int N = 10;
		int min = 5;
		int max = 100;

		int[] arr = new int[N];
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}

		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		mergesort(arr, 0, arr.length - 1);
	}

	public static void mergesort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left)/2;
			mergesort(arr, left, mid);
			mergesort(arr, mid + 1, right);
			merge2(arr, left, mid, right);
		}
	}

	public static void merge2(int[] arr, int left, int mid, int right) {
		int size = (right - left) + 1;
		int[] temp_arr = new int[size];

		int i = left, j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp_arr[k - left] = arr[i++];
			} else {
				temp_arr[k - left] = arr[j++];
			}
			k++;
		}

		while (i <= mid) {
			temp_arr[k - left] = arr[i++];
			k++;
		}

		while (j <= right) {
			temp_arr[k - left] = arr[j++];
			k++;
		}

		k = left;
		while (k <= right) {
			arr[k] = temp_arr[k - left];
			k++;
		}
	}














	public static void merge1(int[] arr, int left, int mid, int right) {
		int size_left = (mid + 1) - left;
		int size_right = right - mid;

		int[] left_arr = new int[size_left];
		int[] right_arr =  new int[size_right];

		for (int i = left; i <= mid; i++) {
			left_arr[i - left] = arr[i];
		}

		for (int j = mid + 1; j <= right; j++) {
			right_arr[j - (mid + 1)] = arr[j];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < size_left && j < size_right) {
			if (left_arr[i] <= right_arr[j]) {
				arr[k] = left_arr[i++];
			} else {
				arr[k] = right_arr[j++];
			}
			k++;
		}

		while (i < size_left) {
			arr[k++] = left_arr[i++];
		}

		while (j < size_right) {
			arr[k++] = right_arr[j++];
		}
	}

}


