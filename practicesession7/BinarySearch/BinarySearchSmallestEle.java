import java.util.*;

class BinarySearchSmallestEle {
	public static void main(String[] args) {
		MyArray myarr = new MyArray(11, 10, 999);
		int[] arr = myarr.getSortedArray();

		Random random = new Random();
		int i = random.nextInt(arr.length);
		rightRotate(arr, i);
		System.out.println("Rotated by " + i + ": " + Arrays.toString(arr));
		int index = binarySearchSmallest(arr);
		System.out.println("Index of smallest element: " + index);
	} 

	public static int binarySearchSmallest(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {
			int mid = (hi - lo)/2 + lo;
			if (arr[mid] < arr[hi]) { // unrotated
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	public static void rightRotate(int[] arr, int i) {
		System.out.println(Arrays.toString(arr));
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, i - 1);
		reverse(arr, i, arr.length - 1);		
	}

	public static void reverse(int[] arr, int lo, int hi) {
		while (lo < hi) {
			int temp = arr[lo];
			arr[lo] = arr[hi];
			arr[hi] = temp;
			lo++;
			hi--;
		}
	}

}