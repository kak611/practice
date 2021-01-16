import java.util.*;

class Subset {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		List<Integer> tempList = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		subset(arr, tempList, result, 0);
		System.out.println("result: " + result);
		System.out.println("count: " + result.size());
	}

	public static void subset(int[] arr, List<Integer> tempList, List<List<Integer>> result, int index) {
		if (index == arr.length) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		tempList.add(arr[index]);
		subset(arr, tempList, result, index + 1);
		tempList.remove(tempList.size() - 1);
		subset(arr, tempList, result, index + 1);
	}
}