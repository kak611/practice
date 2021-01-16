// binary search
import java.util.*;

class IndexValue {
	public static void main(String[]args) {
		MyArray m = new MyArray(5, 1, 5);
		int[] arr = m.getSortedArray();
		// int[] arr = {2, 3, 3, 4, 6, 6, 6, 7, 7, 7};

		System.out.println(Arrays.toString(arr));

		int result1 = findElementWithSameIndex(arr);
		System.out.println("1. Element with same index: " + result1);
		int result2 = findElementWithSameIndex2(arr);		
		System.out.println("2. Element with same index: " + result2);
	}

	public static int findElementWithSameIndex2(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {
			int mid = (hi - lo)/2 + lo;

			if (mid < arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		return (lo == arr[lo]) ? lo : -1;
	}

	public static int findElementWithSameIndex(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;
		int result = -1;
		while (lo <= hi) {
			int mid = (hi - lo) + lo;
			if (arr[mid] == mid) {
				result = mid;
				hi = mid - 1;
			} else if (mid < arr[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return result;
	}

}