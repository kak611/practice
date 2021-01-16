import java.util.Arrays;

class BubbleSort {

	public static void main(String[] args) {
		MyArray myArr = new MyArray(10, 20, 99);
		int[] arr = myArr.getUnsortedArray();
		System.out.println("Unsorted: " + Arrays.toString(arr));
		sort(arr);
		System.out.println("Bubble sort: " + Arrays.toString(arr));
	} 

	public static void sort(int[] arr) {
		
		while (true) {
			boolean isSwapped = false;
			for (int i = 0; i < arr.length - 1; i++) {
				int j = i+1;
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					isSwapped = true;
				}
			}
			if (!isSwapped) break;
		}
	}
}