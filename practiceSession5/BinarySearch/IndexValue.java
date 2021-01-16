// binary search
import java.util.*;

class IndexValue {
	public static void main(String[]args) {
		MyArray m = new MyArray(10, 2, 9);
		int[] arr = m.getSortedArray();
		// int[] arr = {2, 3, 3, 4, 6, 6, 6, 7, 7, 7};

		System.out.println(Arrays.toString(arr));

		int result1 = findElementWithSameIndex(arr);
		int result2 = findElementWithSameIndex2(arr);
		System.out.println("Element with same index: " + result1);
		System.out.println("Element with same index: " + result2);
	}

	public static int findElementWithSameIndex2(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int mid = (right - left)/2 + left;
			if (arr[mid] > mid) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public static int findElementWithSameIndex(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;
		while (left <= right) {
			int mid = (right - left)/2 + left;
			if (arr[mid] == mid) {
				result = arr[mid];
				right = mid - 1;
			} else if (arr[mid] > mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return result;
	}

}