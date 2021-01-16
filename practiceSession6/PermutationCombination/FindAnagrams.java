import java.util.*;

class FindAnagrams {
	static int n;
	public static void main(String[] args) {
		String s = "AABC"; // 4!/2!
		n = s.length();
		// Anagrams -> aab, aba, baa
		// Anagrams of abc -> abc, acb, bac, bca, cab, cba

		List<String> result = new ArrayList<>();
		StringBuilder strb = new StringBuilder();

		TreeMap<Character, Integer> map = new TreeMap<>();
		for (char c : s.toCharArray()) {
			map.putIfAbsent(c, 0);
			map.put(c, map.get(c) + 1);
		}

		char[] uniq_arr = new char[map.size()];

		int i = 0;		
		for (char key : map.keySet()) {
			uniq_arr[i++] = key;
		}

		permutations(uniq_arr, strb, result, map);
		System.out.println("Result: " + result);

	}

	public static void permutations(char[] uniq_arr, StringBuilder strb, List<String> result, TreeMap<Character, Integer> map) {
			if (strb.length() == n) {
				result.add(strb.toString());
				return;
			}

			// System.out.println(Arrays.toString(uniq_arr));
			// System.out.println(Arrays.toString(map));						

			for (int i = 0; i < uniq_arr.length; i++) {
				if (map.get(uniq_arr[i]) == 0) continue;

				strb.append(uniq_arr[i]);
				map.put(uniq_arr[i], map.get(uniq_arr[i]) - 1);
				permutations(uniq_arr, strb, result, map);
				strb.deleteCharAt(strb.length() - 1);
				map.put(uniq_arr[i], map.get(uniq_arr[i]) + 1);
			}
		} 
}