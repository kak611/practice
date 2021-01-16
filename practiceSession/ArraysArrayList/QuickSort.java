import java.util.Arrays;
import java.util.Random;

class QuickSort {
	public static void main(String[] args) {
		int size = 10;
		int[] arr = new int[size];
		Random random = new Random();
		for (int i=0; i<arr.length; i++) {
			arr[i] = random.nextInt(99);
		}
		System.out.println("Input array: " + Arrays.toString(arr));
		sort(arr, 0, arr.length-1);
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}

	public static void sort(int[] arr, int start, int end) {
		if (start >= end) return;

		int mid = start + (end - start)/2;

		int pivot = partition(arr, start, mid, end);
		sort(arr, start, pivot-1);
		sort(arr, pivot+1, end);
	}

	public static int partition(int[] arr, int lo, int mid, int hi) {
		//move mid/pivot to end of arr		
		swap(arr, mid, hi);		
		int pivot = arr[hi];
		//System.out.println(pivot);
		int i = lo;
		int j = lo;

		while(lo++ < hi) {
			if(arr[j] <= pivot) {
				swap(arr, j, i++);								
			}
			j++;
		}
		swap(arr, i, hi);
		//System.out.println(i + ", " + hi + "Partial array: " + Arrays.toString(arr));
		//System.out.println("PivotIndex: " + i);
		return i;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}