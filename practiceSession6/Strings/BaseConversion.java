class BaseConversion {
	public static void main(String[] args) {
		String num = "1111";
		int b1 = 2;
		int b2 = 16;

		String result = convertBase(num, b1, b2);
		System.out.println("Base b1 to Base b2: " + result);
	}

	public static String convertBase(String num, int b1, int b2) {
		 // convert num (b1) to base 10
		int result = 0;
		boolean isNegative = num.startsWith("-");		

		for (int i = (isNegative) ? 1 : 0; i < num.length(); i++) {
			result *= b1;
			result += (Character.isDigit(num.charAt(i))) ? num.charAt(i) - '0' 
					: num.charAt(i) - 'A' + 10;
		}
		System.out.println("Base b2: " + result);
		// convert integer to base b2
		String res = convertToBaseRecursive(result, b2);
		// String res = convertToBase(result, b2);

		return ((isNegative) ? "-" : "") + res;
	}

	public static String convertToBaseRecursive(int num, int b2) {
		if (num == 0) return "";

		return convertToBaseRecursive(num/b2, b2) + 
			((num % b2 < 10) ? (char)((num % b2) + '0')
				: (char)((num % b2) + 'A' - 10));
	}



	public static String convertToBase(int num, int b2) {
		StringBuilder strb = new StringBuilder();		

		int x = Math.abs(num);

		while (x != 0) {
			char c = (x % b2 < 10) ? (char)((x % b2) + '0')
				: (char)((x % b2) + 'A' - 10);
			strb.append(c);
			x /= b2;
		}

		return strb.reverse().toString();
	}
}