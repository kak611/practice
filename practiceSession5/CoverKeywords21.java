import java.util.*;

class CoverKeywords21 {
	public static void main(String[] args) {
		String[] arr = {"apple", "banana", "apple", "dog", "cat", "apple", "dog", "apple", "banana", "dog", "cat"};
		List<String> list = Arrays.asList(arr);
		Set<String> set = new HashSet<>();
		set.add("banana");
		set.add("cat");

		// find smallest subarray that covers all the keywords (in any order)
		int[] result = findSmallestSubArrayCoveringSet(list, set);
		System.out.println(Arrays.toString(result));
	}

	public static int[] findSmallestSubArrayCoveringSet(List<String> list, Set<String> set) {
		Map<String, Integer> map = new HashMap<>();
		int[] lastOccurrence = new int[set.size()];
		int[] shortestDistance = new int[set.size()];

		int i = 0;
		for (String s : set) {
			map.put(s, i);
			lastOccurrence[i] = -1;
			shortestDistance[i] = Integer.MAX_VALUE;
			i++;
		}

		int minDistance = Integer.MAX_VALUE;
		int[] result = new int[] {-1, -1};
		for (int j = 0; j < list.size(); j++) {
			if (!map.containsKey(list.get(j))) continue;
			int index = map.get(list.get(j));
			if (index == 0) {
				shortestDistance[index] = 1;
			} else {
				shortestDistance[index] = j - lastOccurrence[index - 1]
				+ shortestDistance[index - 1]; 
			}
			lastOccurrence[index] = j;

			if (index == set.size() - 1) {
				if (shortestDistance[index] < minDistance) {
					minDistance = shortestDistance[index];
					result[0] = j - shortestDistance[index] + 1;
					result[1] = j;
				}
			}
		}
		return result;
	}
}