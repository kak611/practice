import java.util.*;

class PermutationWithRepetition {
	public static void main(String[] args) {
		int[] arr = {1,1,2,3};
		List<Integer> tempList = new ArrayList<>();
		Set<ArrayList<Integer>> result = new HashSet<>();
		int r = arr.length;

		Map<Integer, Integer> map = new HashMap<>();
		for (int n : arr) {
			int cnt = map.getOrDefault(n, 0);
			map.put(n, cnt + 1);
		}

		System.out.println(map);

		permutations(arr, tempList, result, map, r);
		System.out.println("Permutations with repetition: " + result);
	}

	public static void permutations(int[] arr, List<Integer> tempList, Set<ArrayList<Integer>> result, Map<Integer, Integer> map, int r) {
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == 0) continue;
			tempList.add(arr[i]);
			map.put(arr[i], map.get(arr[i]) - 1);

			permutations(arr, tempList, result, map, r);

			tempList.remove(tempList.size() - 1);
			map.put(arr[i], map.get(arr[i]) + 1);
		}
	}
}