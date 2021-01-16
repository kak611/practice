import java.util.Random;
import java.util.Arrays;

class MergeSort {
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
		sort(arr, 0, arr.length - 1);
		System.out.println("Merge sort: " + Arrays.toString(arr));		
	}

	public static void sort(int[] arr, int left, int right) {
		if (left >= right) return;

		int mid = left + (right - left)/2;
		sort(arr, left, mid);
		sort(arr, mid + 1, right);
		// merge1(arr, left, mid, right);
		merge2(arr, left, mid, right);
	}

	// method 2 : creating temp array and then copying to original
	public static void merge2(int[] arr, int left, int mid, int right) {
		int[] temp_arr = new int[right - left + 1];

		int i = left, j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
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
		for (int l = 0; l < temp_arr.length; l++) {
			arr[k++] = temp_arr[l];
		}
	}













	// method 1 : creating two subarrays
	public static void merge1(int[] arr, int left, int mid, int right) {
		int size_left = mid - left + 1;
		int size_right = right - mid;

		int[] left_arr = new int[size_left];
		int[] right_arr = new int[size_right];

		for (int i = 0; i < left_arr.length; i++) {
			left_arr[i] = arr[i + left];
		}

		for (int j = 0; j < right_arr.length; j++) {
			right_arr[j] = arr[mid + 1 + j];
		}

		int i = left, j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (left_arr[i - left] < right_arr[j - (mid + 1)]) {
				arr[k] = left_arr[i - left];
				i++;
			} else {
				arr[k] = right_arr[j - (mid + 1)];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			arr[k++] = left_arr[i - left];
			i++;
		}

		while (j <= right) {
			arr[k++] = right_arr[j - (mid + 1)];
			j++;
		}
	}
}