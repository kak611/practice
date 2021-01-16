import java.util.*;

class QuickSort {
	public static void main(String[] args) {
		Random random = new Random();
		int n = 10;
		int min = 10;
		int max = 100;
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;			
		}

		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println("QuickSort: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr, int left, int right) {
		if (arr.length <= 1) return;
		if (left >= right) return;

		choosePivot(arr, left, right);
		int pivotInd = partition(arr, left, right);
		sort(arr, left, pivotInd - 1);
		sort(arr, pivotInd + 1, right);
	}

	public static void choosePivot(int[] arr, int left, int right) {
		int mid = (right - left)/2 + left;
		// swap the selected pivot with first element
		swap(arr, left, mid);
	}

	public static int partition(int[] arr, int left, int right) {
		int p = arr[left];
		int i = left + 1;

		for (int j = left + 1; j <= right; j++) {
			if (arr[j] < p) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, left, i-1);
		return (i-1);
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}