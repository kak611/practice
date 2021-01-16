import java.util.*;
class ElementInRotatedArray {
	public static void main(String[] args) {
		MyArray myarray = new MyArray(15,100,999);
		int[] arr = myarray.getSortedArray();
		Random random = new Random();
		rightRotate(arr, random.nextInt(arr.length));
		System.out.println(Arrays.toString(arr));


		int target = arr[random.nextInt(arr.length)];		
		int result = findElement(arr, target);		
		System.out.println("Index of element " + target + " in rotated array: " + result);

		int target2 = random.nextInt(arr.length);		
		int result2 = findElement(arr, target2);		
		System.out.println("Index of element " + target2 + " in rotated array: " + result2);
	}

	public static int findSmallestEle(int[] arr) {
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

	public static int findElement(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (right - left)/2 + left;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[left] <= arr[mid]) { // unrotated
				if (target >= arr[left] && target < arr[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target > arr[mid] && target <= arr[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void rightRotate(int[] arr, int cnt) {
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, cnt - 1);
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