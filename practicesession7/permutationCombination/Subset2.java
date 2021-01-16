import java.util.*;

class Subset2 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4};
		List<List<Integer>> result = subset(arr);
		System.out.println("Result: " + result);
		System.out.println("Size: " + result.size());
	}

	public static List<List<Integer>> subset(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();

		subset(arr, new ArrayList<>(), result, 0, new HashSet<>());
		return result;
	}

	/*
		time complexity: 2^n = 2^4 = 16
	*/
	public static void subset(int[] arr, List<Integer> tempList, List<List<Integer>> result, int index, HashSet<Integer> visited) {
		if (index == arr.length) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		// if (!visited.contains(arr[index])) {
				
			tempList.add(arr[index]);
			// visited.add(arr[index]);
			subset(arr, tempList, result, index + 1, visited);

			tempList.remove(tempList.size() - 1);
			// visited.remove(arr[index]);
			subset(arr, tempList, result, index + 1, visited);
		// }
	}
}