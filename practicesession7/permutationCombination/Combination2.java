import java.util.*;

class Combination2 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		int r = 3;
		
		List<List<Integer>> result = new ArrayList<>();
		combinations(arr, new ArrayList<>(), result, 0, r);
		System.out.println("Combination: " + result);
		System.out.println("size: " + result.size());

		List<List<Integer>> result2 = new ArrayList<>();
		combinationsWithRepetitionAllowed(arr, new ArrayList<>(), result2, 0, r);
		System.out.println("Combination with repetition: " + result2);
		System.out.println("size: " + result2.size());
	}

	/*
		time complexity: (n!)/r! * (n - r)!
	*/
	public static void combinations(int[] arr, List<Integer> tempList, List<List<Integer>> result, int index, int r) {
		if (tempList.size() == r) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		int remaining = r - tempList.size();
		for (int i = index; i < arr.length; i++) {
			if (remaining + i - 1 > arr.length) break;
			tempList.add(arr[i]);
			combinations(arr, tempList, result, i + 1, r);
			tempList.remove(tempList.size() - 1);																													
		}
	}


	/*
		time complexity: (r + n - 1)!/r! * (n-1)! = 6!/2! * 4! = 15
	*/
	public static void combinationsWithRepetitionAllowed(int[] arr, List<Integer> tempList, List<List<Integer>> result, int index, int r) {
		if (r == tempList.size()) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		int remaining = r - tempList.size();
		for (int i = index; i < arr.length; i++) {
			if (remaining + i - 1 > arr.length) break;
			tempList.add(arr[i]);
			combinationsWithRepetitionAllowed(arr, tempList, result, i, r);
			tempList.remove(tempList.size() - 1);
		}
	}

}