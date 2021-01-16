import java.util.*;

class CombinationsWithRepetition1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		int r = 2;

		combination(arr, tempList, result, 0, r);
		System.out.println("CombinationWithRepetition: " + result);
		System.out.println(result.size());
	}

	public static void combination(int[] arr, List<Integer> tempList, List<List<Integer>> result, int index, int r) {
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		int numRemaining = r - tempList.size();
		for (int i = index; i < arr.length ; i++) {
			if (numRemaining + i - 1 > arr.length) break;
			tempList.add(arr[i]);
			// combination(arr, tempList, result, i, r);  // with repetition
			combination(arr, tempList, result, i + 1, r);  // without repetition
			tempList.remove(tempList.size() - 1);
		}
	}
}