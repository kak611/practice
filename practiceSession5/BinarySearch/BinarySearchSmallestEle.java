import java.util.*;

class BinarySearchSmallestEle {
	public static void main(String[] args) {
		MyArray myarr = new MyArray(11, 1, 10);
		int[] arr = myarr.getSortedArray();

		Random random = new Random();
		int i = random.nextInt(arr.length);
		rightRotate(arr, i);
		System.out.println(Arrays.toString(arr));
		int index = binarySearchSmallest(arr);
		System.out.println("Index of smallest element: " + index);
	} 

	public static int binarySearchSmallest(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int mid = (right - left)/2 + left;
			if (arr[mid] > arr[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	public static void rightRotate(int[] arr, int cnt) {
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, cnt - 1);
		reverse(arr, cnt, arr.length -1);

	}

	private static void reverse(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}