import java.util.*;

class GenerateParenthesis {
	public static void main(String[] args) {
		int n = 3;
		List<String> result = new ArrayList<>();
		generate(n, n, new StringBuilder(), result);
		// generateUsingStringObject(n, n, "", result);
		System.out.println("Parenthesis with " + n + " pairs: " + result);
	}


	/* time complexity: C(n) => 2n!/(n! * (n+1)!), where n = single parenthesis
		output => [((())), (()()), (())(), ()(()), ()()()]
		Each output is 6 characters in length 2 * n
		divide by factorial of duplicates in the input i.e. n! & (n+1)!
	*/
	public static void generate(int open, int close, StringBuilder strb, List<String> result) {
		if (open == 0 && close == 0) {
			result.add(strb.toString());
			return;
		}

		if (open > 0) {
			strb.append("(");
			generate(open - 1, close, strb, result);
			// stringbuilder is mutable so remove the character after adding
			strb.deleteCharAt(strb.length() - 1);
		}

		if (close > open) {
			strb.append(")");
			generate(open, close - 1, strb, result);
			strb.deleteCharAt(strb.length() - 1);
		}
	}

	public static void generateUsingStringObject(int open, int close, String s, List<String> result) {
		if (open == 0 && close == 0) {
			result.add(s);
			return;
		}

		if (open > 0) {
			generateUsingStringObject(open - 1, close, s + "(", result);
		}

		if (close > open) {
			generateUsingStringObject(open, close - 1, s + ")", result);
		}
	}
}