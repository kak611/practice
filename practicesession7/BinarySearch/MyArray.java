import java.util.Random;
import java.util.Arrays;

class MyArray {
	public static final int SIZE = 10;
	public static final int MIN = 20;
	public static final int MAX = 999;

	private Random random;
	private int[] nums;
	private int size;
 	private int min;
	private int max;
		
	public MyArray(int size, int startRange, int endRange) {
		this.size = size;
		this.min = startRange;
		this.max = endRange;
		random = new Random();
		nums = new int[this.size];
	}

	public MyArray(int size) {
		this(size, MIN, MAX);
	}

	public MyArray() {
		this(SIZE, MIN, MAX);
	}

	public int[] getUnsortedArray() {
		createArray();
		return nums;		
	}

	public int[] getSortedArray() {
		createArray();
		insertionSort(nums);
		return nums;
	}	

	private void createArray() {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(max - min + 1) + min;
		}
	}	

	private void insertionSort(int[] arr) {
		if (arr.length <= 1) return;
		for (int i = 1; i < arr.length; i++) {
			int j = i-1;
			int key = arr[i];
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;			
			}
			// insert
			arr[j+1] = key;
		}
	}
}