import java.util.*;

class Permutation2 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4};
		int r = arr.length;

		List<List<Integer>> result = new ArrayList<>();
		permutations(arr, new ArrayList<>(), new HashSet<>(), result, 4);
		System.out.println("Permutation without Repetition: " + result);
		System.out.println("Permutation without Repetition size: " + result.size());

		List<List<Integer>> result2 = new ArrayList<>();
		permutationsWithRepetitionAllowed(arr, new ArrayList<>(), new HashSet<>(), result2, 2);
		System.out.println("Permutation with Repetition: " + result2);
		System.out.println("Permutation with Repetition size: " + result2.size());
	}

	/*
		time complexity = n!
	*/
	public static void permutations(int[] arr, List<Integer> tempList, Set<Integer> visited, List<List<Integer>> result, int r) {
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited.contains(arr[i])) {
				tempList.add(arr[i]);
				visited.add(arr[i]);
				permutations(arr, tempList, visited, result, r);
				tempList.remove(tempList.size() - 1);
				visited.remove(arr[i]);
			}
		}
	}

	/*
		time complexity = n^r
	*/
	public static void permutationsWithRepetitionAllowed(int[] arr, List<Integer> tempList, Set<Integer> visited, List<List<Integer>> result, int r) {
		if (r == tempList.size()) {
			result.add(new ArrayList<>(tempList));
			return;			
		}

		for (int i = 0; i < arr.length; i++) {
			tempList.add(arr[i]);
			permutationsWithRepetitionAllowed(arr, tempList, visited, result, r);
			tempList.remove(tempList.size() - 1);
		}
	}
}