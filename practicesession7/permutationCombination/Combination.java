import java.util.*;

class Combination {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		int r = 2;
		
		List<List<Integer>> result = new ArrayList<>();
		combination(arr, new ArrayList<Integer>(), result, 0, r);
		System.out.println("Combination: " + result);

		List<List<Integer>> result2 = new ArrayList<>();
		combinationWithRepetition(arr, new ArrayList<Integer>(), result2, 0, r);
		System.out.println("Combination with repetition: " + result2);


	}

	public static void combinationWithRepetition(int[] arr, List<Integer> tempList, List<List<Integer>> result, int index, int r) {
		/*
			combination with repetition: nCr = (r + n - 1)!/r!(n - 1)! = (5!/2!.3!) = 4 * 5 / 2 = 10
										 nCr = 6!/2!.4! = 5 * 6 / 2 = 15
		*/
		if (r == tempList.size()) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = index; i < arr.length; i++) {
			tempList.add(arr[i]);
			combinationWithRepetition(arr, tempList, result, i, r);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void combination(int[] arr, List<Integer> tempList, List<List<Integer>> result, int index, int r) {
		/*
			combination without repetition: nCr = (n)! / r!(n-r)! = 4!/2!.2! = 12/2 = 6
		*/
		if (r == tempList.size()) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = index; i < arr.length; i++) {
			tempList.add(arr[i]);
			combination(arr, tempList, result, i + 1, r);
			tempList.remove(tempList.size() - 1);
		}
	}
}