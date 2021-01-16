import java.util.*;

class Anagrams {
	public static void main(String[] args) {
		String str = "AABC"; // assume A-Z letters
		// String str = "AA"; // assume A-Z letters
		// String str = "ABA"; // assume A-Z letters
		// String str = "";

		List<String> result = new ArrayList<>();

		if (str.length() == 0) {
			System.out.println(result);
			return;
		}

		TreeMap<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < str.length(); i++) {
			int cnt = map.getOrDefault(str.charAt(i), 0);
			map.put(str.charAt(i), cnt + 1);
		}

		char[] charArr = new char[map.size()];
		int[] countArr = new int[map.size()];

		int i = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			charArr[i] = entry.getKey();
			countArr[i] = entry.getValue();
			i++;
		}

		// System.out.println(map);
		// System.out.println(Arrays.toString(charArr));
		// System.out.println(Arrays.toString(countArr));
		
		permutations(charArr, countArr, new StringBuilder(), result, str.length());

		System.out.println("Anagrams of " + str + ": " + result);
		System.out.println("Size: " + result.size());
	}

	/*
		time complexity: n!/d1! * d2! , where d1, d2... denotes the count of duplicate characters
	*/
	public static void permutations(char[] charArr, int[] countArr, StringBuilder strb, List<String> result, int len) {
		if (strb.length() == len) {
			result.add(strb.toString());
			return;
		}

		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] > 0) {
				strb.append(charArr[i]);
				countArr[i]--;
				permutations(charArr, countArr, strb, result, len);
				strb.deleteCharAt(strb.length() - 1);
				countArr[i]++;
			} 
		}
	}
}