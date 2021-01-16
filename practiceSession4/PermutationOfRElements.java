import java.util.*;

class PermutationOfRElements {
	public static void main(String[] args) {
		// r out of n i.e. nPr = n!/(n-r)!
		int[] arr = {1,2,3,4};
		List<ArrayList<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		int r = 4; // nPr = 3 * 4 = 12

		permutations(arr, tempList, result, new boolean[arr.length], r);
		System.out.println("Permutations of r out of n: " + result);			
	}

	public static void permutations(int[] arr, List<Integer> tempList, List<ArrayList<Integer>> result, boolean[] visited, int r) {
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) continue;			
			tempList.add(arr[i]);
			visited[i] = true;
			permutations(arr, tempList, result, visited, r);
			tempList.remove(tempList.size() - 1);
			visited[i] = false;
		}
	}
}
