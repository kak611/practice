import java.util.*;

class CombinationWithR {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int r = 2;

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();

		combination(arr, tempList, list, 0, r);
		System.out.println(list);
		System.out.println(list.size());
	}

	public static void combination(int[] arr, List<Integer> tempList, List<List<Integer>> list, int index, int r) {
		if (tempList.size() == r) {
			list.add(new ArrayList<>(tempList));
			return;
		}

		int remaining = r - tempList.size();
		for (int i = index; i < arr.length; i++) {
			if (remaining + i - 1 > arr.length) break;
			tempList.add(arr[i]);
			combination(arr, tempList, list, i+1, r); // without repetition, 6C2 = 5 * 3 = 15
			// combination(arr, tempList, list, i, r); // with repetition, 6C2 = (r+n-1)!/r!.(n-1)! = 7!/2!.5! = 3 * 7 = 21
			tempList.remove(tempList.size() - 1);			
		}
	}
}