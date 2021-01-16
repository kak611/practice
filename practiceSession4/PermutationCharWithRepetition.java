import java.util.*;

class PermutationCharWithRepetition {
	public static void main(String[] args) {
		char[] arr = {'A', 'A', 'B', 'C'};
		List<Character> tempList = new ArrayList<>();
		Set<ArrayList<Character>> result = new HashSet<>();
		int r = arr.length;

		Map<Character, Integer> map = new HashMap<>();
		for (char n : arr) {
			int cnt = map.getOrDefault(n, 0);
			map.put(n, cnt + 1);
		}

		System.out.println(map);

		permutations(arr, tempList, result, map, r);
		System.out.println("Permutations with repetition: " + result);
	}

	public static void permutations(char[] arr, List<Character> tempList, Set<ArrayList<Character>> result, Map<Character, Integer> map, int r) {
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