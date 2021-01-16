/*
Smallest Substring of All Characters
Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"
*/

import java.util.*;

class SmallestSubstring {
	public static void main(String[] args) {
		String str = "xyyzyzyx";
		char[] arr = {'x', 'y', 'z'};

		String smallestSubstring = getShortestUniqueSubstring(str, arr);
		System.out.println("Output: " + smallestSubstring);		
	}

	/*
		x y y z y z y x
		      l       r
	*/
	public static String getShortestUniqueSubstring(String str, char[] arr) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : arr) {
			map.put(c, 1); // unique chars
		}

		int remainingChars = arr.length;
		int startIndex = -1;
		int endIndex = -1;

		for (int left = 0, right = 0; right < str.length(); right++) {
			char c = str.charAt(right);
			if (map.containsKey(c)) {				
				map.put(c, map.get(c) - 1);
				if (map.get(c) >= 0) remainingChars--;
			}

			// System.out.println(map);
			// System.out.println(remainingChars + ", " + left + ", " + right);
			while (remainingChars == 0) {

				if ((startIndex == -1 && endIndex == -1)
					|| (right - left) < (endIndex - startIndex)) {
					startIndex = left;
					endIndex = right;
				}

				if (map.containsKey(str.charAt(left))) {
					map.put(str.charAt(left), map.get(str.charAt(left)) + 1);
					if (map.get(str.charAt(left)) > 0) remainingChars++;
				}

				left++;
			}
		}

		// System.out.println(startIndex + ", " + endIndex);
		return (startIndex > -1 && endIndex > -1) ? str.substring(startIndex, endIndex + 1) : "";
	}
}