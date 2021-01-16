import java.util.*;

class CoverKeywords2 {
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

	// using LinkedHashMap
	public static int[] findSmallestSubArrayCoveringSet(List<String> list, Set<String> set) {
		int[] result = new int[] {-1, -1};
		Map<String, Integer> order = new HashMap<>();
		List<Integer> latestOccurrenceIndx = new ArrayList<>();
		List<Integer> shortestDistancefromCurr = new ArrayList<>();
		int shortestDistance = Integer.MAX_VALUE;

		int i = 0;
		for (String s : set) {
			order.put(s, i++);
			latestOccurrenceIndx.add(-1);
			shortestDistancefromCurr.add(Integer.MAX_VALUE);
		}

		for (int j = 0; j < list.size(); j++) {
			Integer keywordIndx = order.get(list.get(j));
			if (keywordIndx != null) {
				if (keywordIndx == 0) {
					shortestDistancefromCurr.set(0, 1);
				} else if (shortestDistancefromCurr.get(keywordIndx - 1) < Integer.MAX_VALUE) {
					int distanceFromPrevKeyword = j - latestOccurrenceIndx.get(keywordIndx - 1);
					shortestDistancefromCurr.set(keywordIndx, distanceFromPrevKeyword + 
						shortestDistancefromCurr.get(keywordIndx - 1));
				}
				latestOccurrenceIndx.set(keywordIndx, j);

				if (keywordIndx == set.size() - 1) {
					int lastKeywordDistance = shortestDistancefromCurr.get(shortestDistancefromCurr.size() - 1);
					if (lastKeywordDistance < shortestDistance) {
						shortestDistance = lastKeywordDistance;
						result[0] = j - shortestDistance + 1;
						result[1] = j;
					}
				}
			}
		}

		return result;
	}
}