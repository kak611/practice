import java.util.*;

class StringSplit {
	public static void main(String[] args) {
		// String s = "aabeefegeeccrr";
		String s = "aabesdafdafgdfrlgmsfddsgfgfhfgehrjgouiregjnkgmnregporneogiegegrdfsefegeeccrr";
		int k = 3;

		int result = minimalSplit(s, k);
		System.out.println("minimal split: " + result);
	}

	public static int minimalSplit(String s, int k) {
		int[] arr = new int[26];
		int result = 0;		
		int symb = 0;
		StringBuilder strb = new StringBuilder();
		List<String> list = new ArrayList<>();
		for (char c : s.toCharArray()) {
			if (arr[c - 'a'] == 0) symb++;
			arr[c - 'a']++;
			strb.append(c);
			if (symb >= k) {
				list.add(strb.toString());
				strb = new StringBuilder();
				result++;				
				symb = 0;
				arr = new int[26]; // Assume: repetition is allowed as its not mentioned
			}
		}
		System.out.println(list);
		return result;
	}
}