import java.util.Arrays;
class FirstLastIndex {
	public static void main(String[] args) {		
		int[] nums = {31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31};
		int[] result = findFirstLastIndx(nums, 31);
		System.out.println("First and Last Index of 31: " + Arrays.toString(result));
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

	public static int binarySearch(int[] nums, int num) {}
}