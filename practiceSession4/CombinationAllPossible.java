import java.util.*;

class CombinationAllPossible {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};

		List<ArrayList<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();

		// subsets
		combinations(arr, tempList,result, 0);
		System.out.println("Subset/ All possible combinations: " + result);
	}

	public static void combinations(int[] arr, List<Integer> tempList, List<ArrayList<Integer>> result, int index) {
		if (index == arr.length) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}

		tempList.add(arr[index]);
		combinations(arr, tempList, result, index + 1);
		tempList.remove(tempList.size() - 1);
		combinations(arr, tempList, result, index + 1);
	}
}