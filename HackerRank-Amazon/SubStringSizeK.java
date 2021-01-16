import java.util.*;

class SubStringSizeK {
	public static void main(String[] args) {
		// String s = "awaglknagawunagwkwagl";
		// int k = 4;

		// String s = "abacab";
		// int k = 3;

		String s = "abcabc";
		int k = 3;

		List<String> result = findSubstringsOfSizek(s, k);
		System.out.println("Output: " + result);
	}

	/*
		1. initialize hashmap character : index
		2. initialize i & j to 0 and iterate through each character
			a. if char is not in map, add it and its index
			b. else if its there, update i to max of i, char index + 1
			c. check if substring length == k and add it to set if matches
		3. return the set as list of strings 
	*/
	public static List<String> findSubstringsOfSizek(String s, int k) {
		Set<String> set = new HashSet<>();		
		StringBuilder strb = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();		
		boolean[] visited = new boolean[26];

		for (int i = 0, j = 0; j < s.length(); j++) {
			if (!map.containsKey(s.charAt(j))) {				
				map.put(s.charAt(j), j);				
			} else {				
				i = Math.max(i, map.get(s.charAt(j)) + 1);
				map.put(s.charAt(j), j);
			}

			if ((j - i + 1) == k) {
				set.add(s.substring(i, j+1));				
				i++;
			}
		}

		return new ArrayList<String>(set);
	}
}