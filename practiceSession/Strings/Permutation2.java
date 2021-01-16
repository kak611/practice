class Permutation2 {
	public static void main(String[] args) {
		String str = "abcd";
		permutation(str, "");
	}

	public static void permutation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.print(prefix + " ");
		}

		for (int i=0; i < str.length(); i++) {
			String remainder = str.substring(0, i) + str.substring(i+1);
			//System.out.println(remainder);
			permutation(remainder, prefix + str.charAt(i));
		}
	}
}