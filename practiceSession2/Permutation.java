import java.util.*;

class Permutation {
	public static void main(String[] args) {
		String str = "AABC";
		TreeMap<Character, Integer> treeMap = new TreeMap<>();
		ArrayList<String> result = new ArrayList<>();

		for (char c : str.toCharArray()) {
			if (!treeMap.containsKey(c)) {
				treeMap.put(c, 1);
			} else {
				treeMap.put(c, treeMap.get(c) + 1);
			}
		}

		// System.out.println("treemap: " + treeMap);

		int[] cnt_arr = new int[treeMap.size()];
		char[] char_arr = new char[treeMap.size()];
		char[] result_arr = new char[str.length()];

		int i = 0;
		for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
			char_arr[i] = entry.getKey();
			cnt_arr[i] = entry.getValue();
			i++;
		}

		// System.out.println(Arrays.toString(char_arr));
		// System.out.println(Arrays.toString(cnt_arr));

		getPermutations(char_arr, cnt_arr, result_arr, result, 0);
		for (String s : result) {
			System.out.print(s + " ");
		}
		// System.out.println("Permutations: " + result);
	}

	public static void getPermutations(char[] char_arr, int[] cnt_arr, char[] result_arr, ArrayList<String> result, int level) {

		if (level == result_arr.length) {
			result.add(String.valueOf(result_arr));
			return;
		}

		for (int i=0; i < char_arr.length; i++) {
			if (cnt_arr[i] > 0) {
				result_arr[level] = char_arr[i];
				cnt_arr[i]--;
				getPermutations(char_arr, cnt_arr, result_arr, result, level+1);
				cnt_arr[i]++;
			}
		}
	}
}