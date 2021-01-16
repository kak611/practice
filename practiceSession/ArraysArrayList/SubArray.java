import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class SubArray {
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4};		
		List<List<Integer>> list = getArraysIteratively(Arrays.asList(arr));
		System.out.println(list);
		List<List<Integer>> list2 = getSubArrays(Arrays.asList(arr));
		System.out.println(list2);
	}

	// iterative o(n^2)
	public static List<List<Integer>> getArraysIteratively(List<Integer> arr) {
		List<List<Integer>> result = new ArrayList<>();		
		// subarray starting with i
		for (int i=0; i< arr.size(); i++) {
			// subarray ending with j
			for (int j = i; j < arr.size(); j++) {
				result.add(arr.subList(i, j+1));
			}
		}
		return result;
	}

	// recursive method
	public static List<List<Integer>> getSubArrays(List<Integer> arrList) {
		int start = 0;
		int end = 0;
		//int end = arrList.size() - 1;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		genArrays(arrList, start, end, result);
		return result;
	}

	public static void genArrays(List<Integer> arrList, int start, int end, List<List<Integer>> result) {
		if (end == arrList.size()) return;

		if (start > end) {
			genArrays(arrList, 0, end+1, result);
		} else {
			List<Integer> tmpList = new ArrayList<Integer>();
			for (int i=start; i <= end; i++) {
				tmpList.add(arrList.get(i));
			}
			result.add(tmpList);
			genArrays(arrList, start+1, end, result);		
		}
	}
}