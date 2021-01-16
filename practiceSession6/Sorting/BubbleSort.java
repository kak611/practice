import java.util.*;

class BubbleSort {
	public static void main(String[] args) {
		MyArray myarray = new MyArray(5, 10, 99);
		int[] arr = myarray.getUnsortedArray();
		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	





	// public static void sort(int[] arr) {
	// 	int n = arr.length;
	// 	for (int i = 0; i < n - 1; i++) {
	// 		int[] a = Arrays.copyOfRange(arr, i, n - 1);
	// 		System.out.println("Outer: " + Arrays.toString(a));
	// 		for (int j = 0; j < n - i - 1; j++) {
	// 			int[] b = Arrays.copyOfRange(arr, j, n - i - 1);
	// 			// System.out.println("Inner: " + Arrays.toString(b));
	// 			if (arr[j] > arr[j+1]) {
	// 				int temp = arr[j+1];
	// 				arr[j+1] = arr[j];
	// 				arr[j] = temp;
	// 			}
	// 			// System.out.println("== Inner: " + Arrays.toString(b));
	// 		}
	// 		System.out.println("Inner: " + Arrays.toString(a));
	// 	}
	// }
}