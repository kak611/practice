import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class PhoneNumber {
	static List<String> arrList = new ArrayList<>();
	static Map<Character, String> map = new HashMap<>();

	public static void main(String[] args) {
		final String str = "23";
		// final String str = "2276696";
		getMnemonics(str);
		System.out.println(arrList.toString());
		System.out.println(arrList.size());
	}

	public static void getMnemonics(String str) {
		// Phone keypad: 2 => abc, 3 => def, 4 => ghi, 5 =>jkl, 6 => mno, 7 => pqrs, 8 => tuv, 9 => wxyz
		if (str.length() == 0) return;
		char[] arr = new char[str.length()];		

		// phone keypad
		map.put('2', "ABC");
		map.put('3', "DEF");
		map.put('4', "GHI");
		map.put('5', "JKL");
		map.put('6', "MNO");
		map.put('7', "PQRS");
		map.put('8', "TUV");
		map.put('9', "WXYZ");

		generateListOfWords(str, arr, 0);
	}

	public static void generateListOfWords(String str, char[] arr, int level) {
		if (level == str.length()) {
			arrList.add(String.valueOf(arr));
			return;
		}
		// get each Character[] position recursively
		char c = str.charAt(level); // 2 from input 23
		for (int i=0; i < map.get(c).length(); i++) {
			arr[level] = map.get(c).charAt(i);
			generateListOfWords(str, arr, level+1);
		}
	}
}