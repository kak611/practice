import java.util.*;

class ShortestSubstring2 {
	// find length of shortest substring
	// modified to find indices of shortest substring
	// using integer array instead of map

	public static void main(String[] args) {
		char[] arr = {'x', 'y', 'z'};
		String s = "xyyzyzyx";
		// int result = lengthOfShortestSubstring(s, arr);
		int[] result = indicesOfShortestSubstring(s, arr);
		System.out.println("Result: " + Arrays.toString(result));
		System.out.println("shortest length: " + (result[1] - result[0]));
	}

	public static int[] indicesOfShortestSubstring(String s, char[] arr) {
		int[] occur = new int[26];
		Set<Character> set = new HashSet<>();
		for (char c : arr) {
			occur[c - 'a']++;
			set.add(c);
		}

		int[] result = new int[] {-1, -1};
		int remainingToCover = arr.length;
		// x  y  y  z  y  z  y  x
		//       l  r
		// remainingToCover = 0

		for (int left = 0, right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			if (set.contains(c)) {
				occur[c - 'a']--;
				if (occur[c - 'a'] >= 0) remainingToCover--;
			}

			while (remainingToCover == 0) {
				if ((result[0] == -1 && result[1] == -1)
					|| (right - left) < result[1] - result[0]) {
					result[0] = left;
					result[1] = right;					
				}
				
				if (set.contains(s.charAt(left))) {
					occur[s.charAt(left) - 'a']++;
					if(occur[s.charAt(left) - 'a'] > 0) remainingToCover++;
				}

				left++;
			}
		}

		return result;
	}
}