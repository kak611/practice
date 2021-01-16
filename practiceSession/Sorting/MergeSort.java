import java.util.Random;
import java.util.Arrays;

/*
	Merge sort is a stable algorithm but not in-place
	time complexity: best/average/worst case O(nlogn)
	space complexity: o(n)
	Method: merging
*/
class MergeSort {
	public static void main(String[] args) {
		final int N = 10;
		final int MIN = 5;
		final int MAX = 30;
		Random random = new Random();
		int[] arr = new int[N];
		for (int i=0; i<arr.length; i++) {
			arr[i] = random.nextInt((MAX - MIN) + 1) + MIN; // range START..END
		}
		System.out.println(Arrays.toString(arr));
		sort(arr, 0, arr.length-1);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}

	/*
		Steps:
		1. error check
		2. get mid point
		3. recursively call sort for subarrays
		4. merge array with left, mid, right pointers
	*/
	public static void sort(int[] arr, int left, int right) {
		// step 1
		if (left >= right) return;

		// step 2
		int mid = left + (right - left)/2;

		// step 3
		sort(arr, left, mid);
		sort(arr, mid+1, right);

		// step 4
		// merge1(arr, left, mid, right);	// method 1 create temp array
		merge2(arr, left, mid, right);		// method 2 create two temp subarrays
	}

	/*
		Steps:
		1. Create temp array w.r.t relative size (right-left+1) because it can be some part (subarray) of array
		2. Initialize start of both subarrays & start of temp array i, j, k
		3. Compare, sort and fill temp array
		4. Copy temp array to array at relative positions
	*/
	private static void merge1(int[] arr, int left, int mid, int right) {
		// step 1
		int[] temp = new int[right-left+1];

		// step 2
		int i = left, j = mid+1, k = 0;

		// step 3
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
				//i++;
			} else {
				temp[k++] = arr[j++];
				//j++;
			}			
			//k++;
		}

		while (i <= mid) temp[k++] = arr[i++];
		while (j <= right) temp[k++] = arr[j++];

		// step 4
		for (int m = left; m <= right; m++) {
			arr[m] = temp[m-left];
		}
	}

	/*
		Steps:
		1. get subarray lengths
		2. create temp subarrays
		3. copy respective subarray content to temp subarrays
		4. initialize traversal variables i,j,k
		5. compare and copy sorted elements to array from temp arrays
	*/
	private static void merge2(int[] arr, int left, int mid, int right) {
		// step 1
		int len1 = (mid - left) + 1;
		int len2 = right - mid;

		// step 2
		int[] temp1 = new int[len1];
		int[] temp2 = new int[len2];

		// step 3
		for (int i=left; i <= mid; i++) {
			temp1[i-left] = arr[i];
		}
		for (int j = mid+1; j <= right; j++) {
			temp2[j-(mid+1)] = arr[j];
		}

		// // OR another way of writing
		// for (int i = 0; i < len1; i++) {
		// 	temp1[i] = arr[left + i];
		// }
		// for (int j = 0; j < len2; j++) {
		// 	temp2[j] = arr[mid+1+j];
		// }

		// step 4
		int i=0, j=0;
		int k = left;	// note k is initialized to left

		// step 5
		while (i < len1 && j < len2) {
			if (temp1[i] <= temp2[j]) {
				arr[k++] = temp1[i++];
			} else {
				arr[k++] = temp2[j++];
			}
		}

		while (i < len1) arr[k++] = temp1[i++];
		while (j < len2) arr[k++] = temp2[j++];
	}
}