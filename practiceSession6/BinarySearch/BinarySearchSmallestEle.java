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
	}

}