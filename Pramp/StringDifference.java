import java.util.*;

class StringDifference {	
	public static void main(String[] args) {

		String source = "CBBC";
		String target = "CABAABBC";

		// String source = "ABCDEFG";
		// String target = "ABDFFGHQWERTY";

		// String source = "SATURDAY";
		// String target = "SUNDAYS";

		String[] result = differenceBetweenTwoStrings(source, target);
		System.out.println(Arrays.toString(result));
	}

	/*
		1. Find minimum edits
		2. Construct string using it
	*/
	public static String[] differenceBetweenTwoStrings(String source, String target) {
		int[][] dp = new int[source.length() + 1][target.length() + 1];
		for (int[] row : dp) Arrays.fill(row, -1);

		//1. Find minimum edits
		int minEdits = minimiumEdits(source, source.length() - 1, target, target.length() - 1, dp);
		System.out.println("minEdits: " + minEdits);

		//2. construct string using dp
		String result = construct(source, target, dp);
		return result.split(" ");	

		// using recursion
		// StringBuilder strb = new StringBuilder();
		// construct(source, source.length() - 1, target, target.length() - 1, dp, strb);
		// return strb.toString().split(" ");
	
	}


	public static String construct(String source, String target, int[][] dp) {
		for (int[] arr : dp) {
			System.out.println(Arrays.toString(arr));
		}
		int i = 0, j = 0;
		StringBuilder strb = new StringBuilder();
		while (i < source.length() && j < target.length()) {
			if (source.charAt(i) == target.charAt(j)) {
				strb.append(source.charAt(i) + " ");
				i++;
				j++;
			} else {
				if (dp[i+1][j] <= dp[i][j+1]) {
					strb.append("-" + source.charAt(i++) + " ");
				} else {
					strb.append("+" + target.charAt(j++) + " ");
				}
			}
		}

		// while (i < source.length()) {
		// 	strb.append("-" + source.charAt(i++) + " ");
		// }
		
		while (j < target.length()) {
			strb.append("+" + target.charAt(j++) + " ");
		}

		return strb.toString();
	}

	public static int minimiumEdits(String source, int i, String target, int j, int[][] dp) {
		if (i < 0) {
			return j + 1;
		} else if (j < 0) {
			return i + 1;
		} else if (dp[i][j] == -1) {
			if (source.charAt(i) == target.charAt(j)) {
				dp[i][j] = minimiumEdits(source, i - 1, target, j - 1, dp);
			} else {
				int deletion = minimiumEdits(source, i - 1, target, j, dp);
				int insertion = minimiumEdits(source, i, target, j - 1, dp);
				// not using substitution as its not mentioned in the problem description
				// int substitution = minimiumEdits(source, i - 1, target, j - 1, d);
				dp[i][j] = 1 + Math.min(deletion, insertion);
			}
		}

		return dp[i][j];
	}

	// recursive solution (something went wrong !)
	// public static void construct(String source, int i, String target, int j, int[][] dp, StringBuilder strb) {
	// 	if (i < 0 && j < 0) {
	// 		return;
	// 	}

	// 	if (i < 0) {
	// 		strb.insert(0, "+" + target.charAt(j) + " ");
	// 		construct(source, i, target, j - 1, dp, strb);
	// 	} else if (j < 0) {
	// 		strb.insert(0, "-" + source.charAt(i) + " ");
	// 		construct(source, i - 1, target, j, dp, strb);
	// 	} else {
	// 		if (source.charAt(i) != target.charAt(j)) {
	// 			if (i > 0 && j > 0 && dp[i-1][j] <= dp[i][j-1]) {
	// 				strb.insert(0, "-" + source.charAt(i) + " ");				
	// 			} else {
	// 				strb.insert(0, "+" + target.charAt(j) + " ");				
	// 			}
	// 		} else {
	// 			strb.insert(0, target.charAt(j) + " ");
	// 		}
	// 		construct(source, i - 1, target, j - 1, dp, strb);
	// 	}
	// }

}