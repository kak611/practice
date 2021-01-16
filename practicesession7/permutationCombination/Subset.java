import java.util.*;

class Subset {
	public static void main(String[] args) {
		/*
			1 2 3 4

			for each element
			  1. with it
			  2. without it

			- 4  3  3,4  2  2,4  2,3  2,3,4
		*/
		int[] arr = new int[] {1,2,3,4};
		List<List<Integer>> result = subset(arr);
		System.out.println("Result: " + result);
	}

	public static List<List<Integer>> subset(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();

		subset(arr, new ArrayList<Integer>(), result, 0);
		return result;
	}

	public static void subset(int[] arr, List<Integer> tempList, List<List<Integer>> result, int index) {
		if (index == arr.length) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		tempList.add(arr[index]);
		subset(arr, tempList, result, index+1);
		tempList.remove(tempList.size() - 1);
		subset(arr, tempList, result, index+1);
	}
}