import java.util.*;

class Permutation {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4};
		int r = arr.length;

		List<List<Integer>> result = new ArrayList<>();
		permutation(arr, new ArrayList<Integer>(), result, r, new boolean[10]); // assume input digits between 0-9
		System.out.println("Permutation without Repetition: " + result);
		System.out.println("Permutation without Repetition size: " + result.size());

		List<List<Integer>> result2 = new ArrayList<>();
		permutationWithRepetition(arr, new ArrayList<Integer>(), result2, r);
		System.out.println("Permutation with Repetition: " + result2);
		System.out.println("Permutation with Repetition size: " + result2.size());
	}

	public static void permutation(int[] arr, List<Integer> tempList, List<List<Integer>> result, int r, boolean[] visited) {
		/*
			permutation without repetition = nPr = n!/(n-r)! = n! for r = n = 4!/0! = 4! = 24
		*/
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			tempList.add(arr[i]);
			permutation(arr, tempList, result, r, visited);
			visited[i] = false;
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void permutationWithRepetition(int[] arr, List<Integer> tempList, List<List<Integer>> result, int r) {
		/*
			permutation with repetition = nPr = n^r = 4 ^ 4 = 256
		*/
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			tempList.add(arr[i]);
			permutationWithRepetition(arr, tempList, result, r);
			tempList.remove(tempList.size() - 1);
		}
	}
}