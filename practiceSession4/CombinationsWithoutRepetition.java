import java.util.*;

class CombinationsWithoutRepetition {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		int r = 2;

		combination(arr, tempList, result, 0, r);
		System.out.println("Combinations Without Repetition: " + result);
	}

	public static void combination(int[] arr, List<Integer> tempList, List<List<Integer>> result, int index, int r) {
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		if (index >= arr.length) return; // without optimization.. takes longer
		// int numRemaining = r - tempList.size();
		// if (numRemaining + index >= arr.length) return; // with optimization
		tempList.add(arr[index]);
		// combination(arr, tempList, result, index, r);  // with repetition
		combination(arr, tempList, result, index + 1, r);  // without repetition
		tempList.remove(tempList.size() - 1);
		combination(arr, tempList, result, index + 1, r);
	}
}