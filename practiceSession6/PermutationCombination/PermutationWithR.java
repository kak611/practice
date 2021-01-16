import java.util.*;

class PermutationWithR {
	// same as basic permutation. Just pass r value	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[arr.length];
		int r = 2; // nPr = 2P6 = 5 * 6 = 30

		permutation(arr, list, result, visited, r);		
		System.out.println(result);		
		System.out.println(result.size());
	}

	public static void permutation(int[] arr, List<Integer> tempList, List<List<Integer>> result, boolean[] visited, int r) {
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) continue; // with repetition comment this line. # of permutations = 6^2 = 36
			tempList.add(arr[i]);
			visited[i] = true;
			permutation(arr, tempList, result, visited, r);
			tempList.remove(tempList.size() - 1);
			visited[i] = false;
		}
	}
}