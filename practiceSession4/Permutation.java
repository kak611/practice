import java.util.*;

class Permutation {
	// the only difference in permutation and combination algorithm is,
	// 		in permutation we loop from index 0 because we want to consider all possible arrangements/order of elements
	// 		in combination, we pass in the index because we dont need to repeat same elements with different order (AB = BA)

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};

		List<ArrayList<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		int r = 4; // r distinct elements taken from n elements in permutation

		permutation(arr, tempList, result, new boolean[arr.length], r);
		System.out.println("Permutation of arr: " + result);
	}

	public static void permutation(int[] arr, List<Integer> tempList, List<ArrayList<Integer>> result, boolean[] visited, int r) {
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				tempList.add(arr[i]);
				visited[i] = true;
				permutation(arr, tempList, result, visited, r);				
				tempList.remove(tempList.size() - 1);
				visited[i] = false;
			}
		}

	}
}