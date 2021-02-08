import java.util.*;

// pre-requisite: the range of numbers should be known in advance
// in this case the range of array elements is between 1 to 9
class CountingSort {
	public static void main(String[] args) {
		MyArray myarray = new MyArray(10, 1, 9);
		int[] arr = myarray.getUnsortedArray();
		System.out.println("Unsorted: " + Arrays.toString(arr));

		sort(arr);
		System.out.println("Count sort: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		int[] cnt = new int[10]; // 1 - 9

		// o(n)
		for (int num : arr) cnt[num]++;

		int j = 0;
		// o(n)
		for (int i = 0; i < cnt.length; i++) {
			while (cnt[i] > 0) {
				arr[j++] = i;
				cnt[i]--;
			}
		}
	}
}