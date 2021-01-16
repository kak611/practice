import java.util.*;

class CoverKeywords {
	public static void main(String[] args) {
		String[] arr = {"apple", "banana", "apple", "dog", "cat", "apple", "dog", "banana", "apple", "cat", "banana"};
		List<String> list = Arrays.asList(arr);
		Set<String> set = new HashSet<>();
		set.add("banana");
		set.add("cat");

		// find smallest subarray that covers all the keywords (in any order)				
		int[] result1 = findSmallestSubArrayCoveringSet1(list, set);
		System.out.println(Arrays.toString(result1));

		int[] result2 = findSmallestSubArrayCoveringSet2(list, set);
		System.out.println(Arrays.toString(result2));		
	}


	// using LinkedHashMap
	public static int[] findSmallestSubArrayCoveringSet2(List<String> list, Set<String> set) {
		int[] result = new int[] {-1, -1};
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		for (String s : set) {
			map.put(s, null);
		}

		int i = 0;
		int seenSoFar = 0;

		while (i < list.size()) {
			if (map.containsKey(list.get(i))) {
				String s = list.get(i);
				Integer indx = map.get(s);
				if (indx == null) {
					seenSoFar++;
				}
				// remove and add will ensure insertion order is maintained for update value as well.
				map.remove(s);
				map.put(s, i);
			
				if (seenSoFar == set.size()) {
					int j = getFirstInsertionIndex(map);
					if ((result[0] == -1 && result[1] == -1) ||
						i - j < result[1] - result[0]) {
						result[0] = j;
						result[1] = i;
					}
				}
			}
			i++;
		}

		return result;
	}

	private static int getFirstInsertionIndex(LinkedHashMap<String,Integer> map) {
		int index = Integer.MIN_VALUE;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			index = entry.getValue();
			break;
		}
		return index;
	}


	// using two pointers
	public static int[] findSmallestSubArrayCoveringSet1(List<String> list, Set<String> set) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : set) {
			int count = map.getOrDefault(s, 0);
			map.put(s, count + 1);
		}

		int [] result = new int[] {-1, -1};
		int totalKeywords = set.size();

		for (int left = 0, right = 0; right < list.size(); right++) {
			Integer keywordCount = map.get(list.get(right));
			if (keywordCount != null) {
				map.put(list.get(right), --keywordCount);
				if (keywordCount >= 0) {
					totalKeywords--;
				}
			}

			while (totalKeywords == 0) {
				if ((result[0] == -1 && result[1] == -1) ||
					(right - left) < result[1] - result[0]) {
					result[0] = left;
					result[1] = right;
				}

				keywordCount = map.get(list.get(left));
				if (keywordCount != null) {
					map.put(list.get(left), ++keywordCount);
					if (keywordCount > 0) {
						totalKeywords++;
					}
				}
				left++;
			}
		}

		return result;
	}

}