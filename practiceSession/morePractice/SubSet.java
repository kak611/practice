import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class SubSet {
	public static void main(String[] args) {
		Integer[] arr = {0, 1, 2, 1};
		List<Integer> list = Arrays.asList(arr);
		subSet(list);
	}

	public static void subSet(List<Integer> list) {
		List<Integer> result = new ArrayList<>();
		getSubset(list, 0, result);
	}

	public static void getSubset(List<Integer> list, int nextTarget, List<Integer> result) {
		if (nextTarget == list.size()) {
			System.out.println(result);
			return;
		}
		
		result.add(list.get(nextTarget));		
		getSubset(list, nextTarget + 1, result);
		result.remove(result.size() - 1);
		getSubset(list, nextTarget + 1, result);
	}
}