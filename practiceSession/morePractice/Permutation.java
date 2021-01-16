import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;

class Permutation {
	public static void main(String[] args) {
		String str = "AABC";
		List<String> list = permute(str);
		System.out.println("Permutations: " + list);
	}

	public static List<String> permute(String str) {
		TreeMap<Character, Integer> treeMap = new TreeMap<>();
		for (Character c : str.toCharArray()) {
			if (!treeMap.containsKey(c)) {
				treeMap.put(c, 1);
			} else {
				treeMap.put(c, treeMap.get(c) + 1);
			}
		}

		char[] char_arr = new char[treeMap.size()];
		int[] cnt_arr = new int[treeMap.size()];

		int i = 0;
		for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
			char_arr[i] = entry.getKey();
			cnt_arr[i] = entry.getValue();
			i++;
		}

		char[] temp_arr = new char[str.length()];
		List<String> result = new ArrayList<>();
		permute(char_arr, cnt_arr, temp_arr, 0, result);
		return result;
	}

	public static void permute(char[] char_arr, int[] cnt_arr, char[] temp_arr, int level, List<String> result) {
		if (level == temp_arr.length) {
			//result.add(Arrays.asList(temp_arr));			
			result.add(String.valueOf(temp_arr));
			return;
		}

		for (int i=0; i < char_arr.length; i++) {
			if (cnt_arr[i] > 0) {
				temp_arr[level] = char_arr[i];
				cnt_arr[i]--;
				permute(char_arr, cnt_arr, temp_arr, level+1, result);
				cnt_arr[i]++;
			}
		}
	}
}