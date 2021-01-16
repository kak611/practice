import java.util.Arrays;
class FirstLastIndex {
	public static void main(String[] args) {		
		MyArray myarr = new MyArray(10, 1, 9);
		// int[] arr = myarr.getSortedArray();
		// System.out.println(Arrays.toString(arr));
		int[] nums = {1,3,3,3,3,3,3};
		int num = 3;
		int[] result = findFirstLastIndx(nums, num);
		System.out.println(Arrays.toString(nums));
		System.out.println("First and Last Index of " + num + ": " + Arrays.toString(result));
	}

	public static int[] findFirstLastIndx(int[] nums, int num) {
		int firstIndex = binarySearch(nums, num);
		if (firstIndex < 0 || firstIndex >= nums.length
			|| nums[firstIndex] != num) return new int[] {};
		int lastIndex = binarySearch(nums, num+1);		
		return new int[] {firstIndex, lastIndex - 1};
	}

	public static int binarySearch(int[] nums, int num) {
		int lo = 0, hi = nums.length;
		while (lo < hi) {
			int mid = (hi - lo)/2 + lo;
			if (num > nums[mid]) {
				lo = mid+1;
			} else {
				hi = mid;
			}
		}

		return lo;
	}
}