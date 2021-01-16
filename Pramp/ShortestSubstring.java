import java.util.*;

class ShortestSubstring {
	// find length of shortest substring
	// modified to find indices of shortest substring

	public static void main(String[] args) {
		char[] arr = {'x', 'y', 'z'};
		String s = "xyyzyzyx";
		// int result = lengthOfShortestSubstring(s, arr);
		int[] result = indicesOfShortestSubstring(s, arr);
		System.out.println("Result: " + Arrays.toString(result));
		System.out.println("shortest length: " + (result[1] - result[0]));
	}

	public static int[] indicesOfShortestSubstring(String s, char[] arr) {
		// int[] occur = new int[arr.length];
		Map<Character, Integer> map = new HashMap<>();
		for (char c : arr) {
			int cnt = map.getOrDefault(c, 0);
			map.put(c, cnt + 1);
		}

		int[] result = new int[] {-1, -1};
		int remainingToCover = arr.length;
		// x  y  y  z  y  z  y  x
		//       l  r
		// remainingToCover = 0

		for (int left = 0, right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			if (map.containsKey(c)) {
				map.put(c, map.get(c)-1);
				if (map.get(c) == 0) remainingToCover--;
			}

			while (remainingToCover == 0) {
				if ((result[0] == -1 && result[1] == -1)
					|| (right - left) < result[1] - result[0]) {
					result[0] = left;
					result[1] = right;					
				}

				if (map.containsKey(s.charAt(left))) {
					map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
					if(map.get(s.charAt(left)) > 0) remainingToCover++;
				}
				left++;
			}
		}

		return result;
	}
}