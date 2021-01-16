import java.util.*;
class InsertionSort2 {
	public static void main(String[] args) {
		MyArray myArr = new MyArray(10, 10, 99);
		int[] arr = myArr.getUnsortedArray();
		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
}