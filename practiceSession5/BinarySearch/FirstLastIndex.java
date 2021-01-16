import java.util.Arrays;
class FirstLastIndex {
	public static void main(String[] args) {		
		int[] nums = {31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 32};
		int[] result = findFirstLastIndx(nums, 32);
		System.out.println("First and Last Index of 32: " + Arrays.toString(result));
	}

	public static int[] findFirstLastIndx(int[] nums, int num) {
		int firstIndex = binarySearch(nums, num);
		firstIndex = (nums[firstIndex] == num) ? firstIndex : -1;
		int lastIndex = (firstIndex == -1) ? -1 : binarySearch(nums, num+1);
		if (lastIndex > -1) {
			lastIndex = (nums[lastIndex] == num) ? lastIndex : lastIndex - 1;
		}

		return new int[] {firstIndex, lastIndex};
	}

	public static int binarySearch(int[] nums, int num) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = (right - left)/2 + left;
			if (num > nums[mid]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}