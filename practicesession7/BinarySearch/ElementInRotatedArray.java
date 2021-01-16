import java.util.*;
class ElementInRotatedArray {
	public static void main(String[] args) {
		// MyArray myarray = new MyArray(15,100,999);
		MyArray myarray = new MyArray(10,10,99);
		int[] arr = myarray.getSortedArray();
		Random random = new Random();
		rightRotate(arr, 2);
		System.out.println(Arrays.toString(arr));


		int target = arr[random.nextInt(arr.length)];		
		int result = findElement(arr, target);		
		System.out.println("Index of element " + target + " in rotated array: " + result);

		// int target2 = random.nextInt(arr.length);		
		// int result2 = findElement(arr, target2);		
		// System.out.println("Index of element " + target2 + " in rotated array: " + result2);
	}

	public static int findSmallestEle(int[] arr) {
		return -1;
	}

	public static int findElement(int[] arr, int target) {
		int lo = 0, hi = arr.length - 1;
		int result = -1;
		while (lo <= hi) {
			int mid = (hi - lo)/2 + lo;
			if (target == arr[mid]) {
				result = mid;
				break;
			}
			if (arr[mid] <= arr[hi]) {
				if (target > arr[mid] && target <= arr[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			} else {
				if (target < arr[mid] && target >= arr[lo]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
		}		

		return result;
	}

	public static void rightRotate(int[] arr, int cnt) {				
		reverse(arr, 0, arr.length - 1);		
		reverse(arr, 0, cnt-1);		
		reverse(arr, cnt, arr.length - 1);		
	}

	public static void reverse(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}