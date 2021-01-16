import java.util.*;

class SelectionSort {
	public static void main(String[] args) {
		MyArray myarray = new MyArray(5, 10, 50);
		int[] arr = myarray.getUnsortedArray();
		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void sort2(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int minInd = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minInd]) {
					minInd = j;
				}
			}

			if (i == minInd) continue;
			int temp = arr[minInd];
			arr[minInd] = arr[i];
			arr[i] = temp;
		}
	}

	public static void sort(int[] arr) {		
		for (int i = 0; i < arr.length; i++) {
			int index = findMin(arr, i, arr.length);
			if (arr[index] != arr[i]) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
	}

	public static int findMin(int[] arr, int start, int end) {
		int minIndx = -1;
		int min = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIndx = i;
			}
		}
		return minIndx;
	}

}