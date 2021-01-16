import java.util.*;

class Combination {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int r = 2;

		List<List<Integer>> result = new ArrayList<>();
		combination(arr, new ArrayList<Integer>(), result, 0, r);
		System.out.println(result);		
	}

	public static void combination(int[] arr, ArrayList<Integer> tempList, List<List<Integer>> result, int index, int r) {
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		int numRemaining = r - tempList.size();
		for (int i = index; (numRemaining + i -1) < arr.length; i++) {
			// if (numRemaining + i - 1 >= arr.length) continue;
			tempList.add(arr[i]);
			combination(arr, tempList, result, i + 1, r);
			tempList.remove(tempList.size() - 1);
		}

	}
}