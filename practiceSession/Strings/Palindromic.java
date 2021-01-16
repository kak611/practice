class Palindromic {
	public static void main(String[] args) {
		String str1 = "A man, a plan, a canal, Panama.";
		String str2 = "Able was I, ere I saw Elba!";
		String str3 = "Ray a Ray";

		System.out.println("'" + str1 + "'" + " is" + (isPalindromic(str1) ? "" : " NOT") + " palindromic.");
		System.out.println("'" + str2 + "'" + " is" + (isPalindromic(str2) ? "" : " NOT") + " palindromic.");
		System.out.println("'" + str3 + "'" + " is" + (isPalindromic(str3) ? "" : " NOT") + " palindromic.");
	}

	public static boolean isPalindromic(String str) {
		int i = 0;
		int j = str.length() - 1;
		//str = str.toLowerCase();

		while(i < j) {
			while(i<j && !Character.isLetterOrDigit(str.charAt(i))) i++;
			while(i<j && !Character.isLetterOrDigit(str.charAt(j))) j--;
			//while(i<j && !Character.isAlphabetic(str.charAt(i))) i++;
			//while(i<j && !Character.isAlphabetic(str.charAt(j))) j--;
			//System.out.println(i + " " + j);
			if(Character.toLowerCase(str.charAt(i++)) != Character.toLowerCase(str.charAt(j--))) return false;
		}

		return true;
	}

}