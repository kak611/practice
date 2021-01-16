import java.util.*;
class TwoSumVariation {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();		
		for (int i = -10; i <= 20; i++) {
			list.add(i);
		}

		System.out.println(list);

		// find distinct (x,y) such that x + y = t where t is in range 5 to 10.
		// -5 + 15 = 10, 20 + -12 = 8
		Set<List<Integer>> result = new HashSet<>();
		twoSum(list, result);
		System.out.println(result);
		System.out.println(result.size());
	}

	public static void twoSum(List<Integer> list, Set<List<Integer>> result) {
		Map<Integer, Integer> map = new HashMap<>();
		// target range
		for (int t = 5; t <= 10; t++) {
			for (int i = 0; i < list.size(); i++) {
				int diff = t - list.get(i);
				if (map.containsKey(diff)) {
					Integer[] temp = {list.get(map.get(diff)), list.get(i)};
					Arrays.sort(temp);
					result.add(Arrays.asList(temp));
				} else {
					map.put(list.get(i), i);
				}
			}			
		}
	}
}