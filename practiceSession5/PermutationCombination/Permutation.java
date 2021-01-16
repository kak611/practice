import java.util.*;
// r = all elements
class Permutation {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		boolean[] visited = new boolean[10];

		permutations(arr, tempList, list, visited);
		System.out.println(list);
		System.out.println(list.size());
	}

	public static void permutations(int[] arr, List<Integer> tempList, List<List<Integer>> list, boolean[] visited) {
		if (tempList.size() == arr.length) {
			list.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) continue;  // comment this line for with repetition so every element can be repeated
			// for repetition, total elements are n^r. So in this case 4^4 = 256
			// without repetition, total elements are n!. So in this case 4! = 24
			tempList.add(arr[i]);			
			visited[i] = true;
			permutations(arr, tempList, list, visited);
			tempList.remove(tempList.size() - 1);
			visited[i] = false;
		}

	}
}