import java.util.*;

class FreshPromotion {
	/*
		similar to https://leetcode.com/problems/wildcard-matching/submissions/
		Algorithm:
			1. convert shoppingCart to string of numbers and codeList to pattern
				Note that for this example, the pattern will always have '*' at beginning and end
					and 'anything' is equivalent to '?'
			2. Now apply wildcard-matching logic on new strings
	*/
	public static void main(String[] args) {
		// String[][] codeList = {{"apple", "apple"}, {"banana", "anything", "banana"}};
		// String[] shoppingCart = {"orange", "apple", "apple", "banana", "orange", "banana"};

		// String[][] codeList = {{"apple", "apple"}, {"banana", "anything", "banana"}};
		// String[] shoppingCart = {"banana", "orange", "banana", "apple", "apple"};

		// String[][] codeList = {{"apple", "apple"}, {"banana", "anything", "banana"}};
		// String[] shoppingCart = {"apple", "banana", "apple", "banana", "orange", "banana"};

		String[][] codeList = {{"apple", "apple"}, {"apple", "apple", "banana"}};
		String[] shoppingCart = {"apple", "apple", "apple", "banana"};

		boolean result = isCustomerWinner(codeList, shoppingCart);
		System.out.println("Output: " + result);
	}

	public static int value = 1;
	public static boolean isCustomerWinner(String[][] codeList, String[] shoppingCart) {
		Map<String, Integer> map = new HashMap<>();
		String pattern = getString(codeList, map, true);
		String input = getString(new String[][] {shoppingCart}, map, false);

		System.out.println("pattern: " + pattern);
		System.out.println("input: " + input);

		return isMatch(input, pattern);
	}

	public static boolean isMatch(String input, String pattern) {
		int i = 0, j = 0, starIndex = -1, sIndex = -1;
		while (i < input.length()) {
			if (j < pattern.length() && (pattern.charAt(j) == '?' || input.charAt(i) == pattern.charAt(j))) {
				i++;
				j++;
			} else if (j < pattern.length() && pattern.charAt(j) == '*') {
				starIndex = j;
				sIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				sIndex++;
				i = sIndex;
			} else {
				return false;
			}
		}

		while (j < pattern.length() && pattern.charAt(j) == '*') j++;

		return (j == pattern.length());
	}

	public static String getString(String[][] codeList, Map<String, Integer> map, boolean isPattern) {		
		StringBuilder strb = new StringBuilder();
		for (String[] list : codeList) {
			for (String s : list) {
				if (!s.equals("anything") && !map.containsKey(s)) {
					map.put(s, value);
					strb.append(value);
					value++;
				} else {
					if (s.equals("anything")) {
						strb.append("?");
					} else {
						strb.append(map.get(s));
					}
				}
			}
		}

		if (isPattern) {
			strb.insert(0, "*");
			strb.append("*");
		}

		return strb.toString();
	}
}