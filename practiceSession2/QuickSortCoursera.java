import java.util.*;
import java.io.*;

class QuickSortCoursera {

	public static int cmpCnt;
	public static int cmpCnt2;
	public static void main(String[] args) throws FileNotFoundException {		
		List<Integer> list = new ArrayList<>();
		cmpCnt = 0;
		cmpCnt2 = 0;
		// File file = new File("C:/Users/Kaustubh/Documents/practiceSession2/quicksort_samples/quicksort0.txt");
		// File file = new File("C:/Users/Kaustubh/Documents/practiceSession2/quicksort_samples/quicksort1.txt");
		File file = new File("C:/Users/Kaustubh/Documents/practiceSession2/quicksort_samples/quicksort2.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextInt()) {
			list.add(scanner.nextInt());
		}

		int[] arrA = new int[list.size()];
		int i = 0;
		for (int num : list) {
			arrA[i++] = num;
		}

		// System.out.println("Before sort: "  + Arrays.toString(arrA));
		quicksort(arrA, 0, arrA.length);
		System.out.println("After sort: " + Arrays.toString(arrA));
		System.out.println("Total comparisons: " + cmpCnt);
		System.out.println("Total comparisons: " + cmpCnt2);
	}

	public static void quicksort(int[] arr, int start, int end) {
		if (start >= end) return;

		// int pIndex = partition(arr, start, end);
		// int pIndex = partition2(arr, start, end);
		int pIndex = partition3(arr, start, end);

		quicksort(arr, start, pIndex);		
		quicksort(arr, pIndex + 1, end);
	}

	// pivot is first element
	public static int partition(int[] arr, int start, int end) {		
		cmpCnt += (end - start - 1);
		int pivot = arr[start];
		int i = start + 1;
		for (int j = start + 1; j < end; j++) {
			cmpCnt2++;
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, start, i-1);
		// System.out.println("pivot: " + pivot + ", " + Arrays.toString(arr));
		return i-1;
	}

	// pivot is last element
	public static int partition2(int[] arr, int start, int end) {	
		cmpCnt += (end - start - 1);	
		int pivot = arr[end - 1];
		swap(arr, start, end - 1);
		int i = start + 1;
		for (int j = start + 1; j < end; j++) {
			cmpCnt2++;
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, start, i - 1);
		// System.out.println("pivot: " + pivot + ", " + Arrays.toString(arr));
		return i-1;
	}

	// pivot is middle element
	public static int partition3(int[] arr, int start, int end) {			
		cmpCnt += (end - start - 1);

		int mid = 0;
		int len = (end - start);
		if (len%2 == 0) {
			mid = (start + (end - start)/2) - 1;
		} else {
			mid = (start + (end - start)/2);
		}		
		// mid = (start + (end - start)/2);
		int medianIndex = medianOfThree(arr, start, mid, end-1);			
		swap(arr, start, medianIndex);
		int pivot = arr[start];
		int i = start + 1;
		
		for (int j = start + 1; j < end; j++) {
			cmpCnt2++;
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, start, i-1);
		// System.out.println("pivot: " + pivot + ", " + Arrays.toString(arr));
		return i-1;
	}	
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int medianOfThree(int[] arr, int a, int b, int c) {
		if ((arr[a] > arr[b]) != (arr[a] > arr[c]))
			return a;
		else if ((arr[b] > arr[a]) != (arr[b] > arr[c]))
			return b;
		else
			return c;
	} 
}