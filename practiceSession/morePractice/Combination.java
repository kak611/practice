import java.util.TreeMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Arrays;

class Combination {
	public static void main(String[] args) {
		String str = "AABC";
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
		char[] temp_arr = new char[str.length()];

		int i=0;
		for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
			char_arr[i] = entry.getKey();
			cnt_arr[i] = entry.getValue();
			i++;
		}

		System.out.println(Arrays.toString(char_arr));
		System.out.println(Arrays.toString(cnt_arr));

		combination(char_arr, cnt_arr, 0, temp_arr, 0);
	}

	public static void combination(char[] char_arr, int[] cnt_arr, int pos, char[] temp_arr, int level) {
		print(temp_arr, level);

		for (int i=pos; i < char_arr.length; i++) {
			if (cnt_arr[i] > 0) {
				temp_arr[level] = char_arr[i];
				cnt_arr[i]--;
				combination(char_arr, cnt_arr, i, temp_arr, level+1);
				cnt_arr[i]++;
			}
		}
	}

	public static void print(char[] arr, int pos) {
		for (int i=0; i < pos; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}