import java.util.*;

class CoverKeywordsSequentially {
	public static void main(String[] args) {
		String[] arr = {"apple", "cat", "banana", "apple", "banana", "cat", "apple", "dog", "cat", "banana"};
		List<String> list = Arrays.asList(arr);
		List<String> keywords = new ArrayList<>();
		keywords.add("banana");
		keywords.add("cat");

		// find subarray with order sequentially
		int[] result1 = findSubArray(list, keywords);
		System.out.println(Arrays.toString(result1));
	}

	public static int[] findSubArray(List<String> list, List<String> keywords) {
		Map<String, Integer> map = new HashMap<>();
		List<Integer> shortestDistances = new ArrayList<>();
		List<Integer> latestOccurrences = new ArrayList<>();

		for (int i = 0; i < keywords.size(); i++) {
			map.put(keywords.get(i), i);
			shortestDistances.add(Integer.MAX_VALUE);
			latestOccurrences.add(-1);
		}

		int currShortestDistance = Integer.MAX_VALUE;
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			if (!map.containsKey(list.get(i))) continue;

			Integer keywordInx = map.get(list.get(i));
			if (keywordInx == 0) {
				shortestDistances.set(0, 1);
			} else if (shortestDistances.get(keywordInx - 1) != Integer.MAX_VALUE) {
				int distance = i - latestOccurrences.get(keywordInx - 1);
				shortestDistances.set(keywordInx, distance + shortestDistances.get(keywordInx - 1));
			}
			latestOccurrences.set(keywordInx, i);

			if (keywordInx == shortestDistances.size() - 1) {
				if (shortestDistances.get(shortestDistances.size() - 1) < currShortestDistance) {
					currShortestDistance = shortestDistances.get(shortestDistances.size() - 1);
					startIndex = i - shortestDistances.get(shortestDistances.size() - 1) + 1;
					endIndex = i;
				}
			}
		}
		return new int[] {startIndex, endIndex};
	}
}