import java.util.*;

class SimpleBinarySearch {
	public static void main(String[] args) {
		int size = 10;
		int minLimit = 100;
		int maxLimit = 999;
		MyArray myArray = new MyArray(size, minLimit, maxLimit);		
		int[] arr = myArray.getSortedArray();	

		// pick random number from arr and binarySearch it
		Random random = new Random();
		int indx = random.nextInt(arr.length);
		int target = arr[indx];
		int target2 = random.nextInt(maxLimit);
		System.out.println(Arrays.toString(arr));
		
		int result1 = binarySearch(arr, target);
		System.out.println("\nbinarySearch index for " + target + ": " + result1);		
		System.out.println("binarySearch index for " + target2 + ": " + binarySearch(arr, target2));

		int result2 = binarySearch2(arr, target);
		System.out.println("\nbinarySearch2 index for " + target + ": " + result2);		
		System.out.println("binarySearch2 index toBeInserted for " + target2 + ": " + binarySearch2(arr, target2));

		int result3 = Arrays.binarySearch(arr, target);
		System.out.println("\nbinarySearch index for " + target + " (using lib): " + result3);
		System.out.println("binarySearch index for " + target2 + " (using lib): " + Arrays.binarySearch(arr, target2));

		if (result1 != result2 && result2 != result3) {
			System.out.println("results mismatch!");
		}
	}


	// observation to avoid confusion:
	// Assuming always using lo = 0 and hi = length - 1,
	//   if using while (left < right), use '<' instead of '<=' inner if condition
	//   if using while (left <= right), use right = mid - 1 instead of right = mid.. otherwise it might stuck in infinite loop
	public static int binarySearch2(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int mid = (right - left)/2 + left;
			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return (left < arr.length && (arr[left] != target)) ? -(left + 1) : left;
		// return left;
	} 

	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (right - left)/2 + left;
			if (arr[mid] == target) {
				return mid;
			} else if(arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -(left+1);
	}
}