import java.util.*;

class CoverKeywords {
	public static void main(String[] args) {
		String[] arr = {"apple", "banana", "apple", "dog", "cat", "apple", "dog", "banana", "cat", "banana"};
		List<String> list = Arrays.asList(arr);
		List<String> dict = new ArrayList<>();
		dict.add("banana");
		dict.add("cat");

		// find smallest subarray that covers all the keywords (in any order)				
		int[] result1 = findSmallestSubArrayCoveringSet1(list, dict);
		System.out.println(Arrays.toString(result1));

		int[] result2 = findSmallestSubArrayCoveringSet2(list, dict);
		System.out.println(Arrays.toString(result2));		
	}


	/*
		[a,b,a,d,c,a,d,b,a,c,b]
                 i     j 
        cnt = 2 -> 1 -> 0
        when cnt == 0,
         while( cnt == 0) move i
           if i == something from [b,c] update cntr
           cnt = 0 -> 1
           i++;
           range = max (i, j or range)
		[b,c]
	*/

	// using two pointers
	public static int[] findSmallestSubArrayCoveringSet1(List<String> list, List<String> dict) {		
		Map<String, Integer> map = new HashMap<>();		
		for (String w : dict) {
			int cnt = map.getOrDefault(w, 0);
			map.put(w, cnt + 1);
		}
		int remainingUniqueWords = map.size();
		int startIndex = -1;
		int endIndex = -1;

		System.out.println(map);
		for (int left = 0, right = 0; right < list.size(); right++) {
			if (map.containsKey(list.get(right))) {
				map.put(list.get(right), map.get(list.get(right)) - 1);
				if (map.get(list.get(right)) == 0) remainingUniqueWords--;
			}

			// move left
			while (remainingUniqueWords == 0) {
				if (map.containsKey(list.get(left))) {
					//update range
					if ((startIndex == -1 && endIndex == -1 ) 
						|| (right - left) < (endIndex - startIndex)) {
						startIndex = left;
						endIndex = right;
					}

					// update map
					map.put(list.get(left), map.get(list.get(left)) + 1);
					if (map.get(list.get(left)) > 0) remainingUniqueWords++;					
				}
				left++;
			}
		}

		return new int[] {startIndex, endIndex};
	}



	/*
		[a,b,a,d,c,a,d,b,a,c,b]
         i
         [b,c,b]

		linkedhashmap:

           add insert in map
           if first time, decrement remaining
            else remove and add to update insertion order because insertion in linkedhashmap does not update exisiting entry

            if (remaining == 0) then update range using curr index and index of first element because linkedhashmap adds from last
            reset the remaining to all elements

	*/

 	public static int[] findSmallestSubArrayCoveringSet2(List<String> list, List<String> dict) {
 		Map<String, Integer> dict_map = new HashMap<>();
 		for (String s : dict) {
 			int cnt = dict_map.getOrDefault(s, 0);
 			dict_map.put(s, cnt + 1);
 		}

 		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
 		int remaining = dict_map.size();
 		int startIndex = -1;
 		int endIndex = -1;

 		for (int i = 0; i < list.size(); i++) {
 			if (dict_map.containsKey(list.get(i))) {
 				if (map.containsKey(list.get(i))) { 					
	 				map.remove(list.get(i));
 				}
	 			map.put(list.get(i), i);

	 			dict_map.put(list.get(i), dict_map.get(list.get(i)) - 1);
	 			if (dict_map.get(list.get(i)) == 0) {
	 				remaining--;
	 			}
 			}

 			if (remaining == 0) {
 				int left = getFirstEntry(map);
 				int right = i;
 				if (startIndex == -1 && endIndex == -1
 					|| (right - left) < (endIndex - startIndex)) {
 					startIndex = left;
 					endIndex = right;
 				}
 			} 			
 		}

 		return new int[] {startIndex, endIndex};
 	}

 	public static int getFirstEntry(LinkedHashMap<String, Integer> map) {
 		int index = 0;
 		for (Map.Entry<String, Integer> entry : map.entrySet()) {
 			index = entry.getValue();
 			break;
 		}
 		return index;
 	}

}