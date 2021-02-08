import java.util.*;

class SelectionSort {
	public static void main(String[] args) {
		MyArray myArr = new MyArray(10, 20, 99);
		int[] arr = myArr.getUnsortedArray();

		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Selection Sort: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (i == minIndex) continue;
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
}