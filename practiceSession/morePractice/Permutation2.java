import java.util.List;
import java.util.ArrayList;

class Permutation2 {
	public static void main(String[] args) {
		String str = "ABCD";
		List<String> result = permute(str);
		System.out.println(result);
	}

	public static List<String> permute(String str) {
		List<String> result = new ArrayList<>();
		permute(str, "", result);
		return result;
	}

	public static void permute(String str, String prefix, List<String> result) {
		if (str.length() == 0) {
			result.add(prefix);
			return;
		}

		for (int i=0; i < str.length(); i++) {
			String remainder = str.substring(0, i) + str.substring(i+1);
			permute(remainder, prefix + str.charAt(i), result);
		}
	}
}