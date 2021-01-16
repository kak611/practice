class BaseConversion {
	public static void main(String[] args) {		
		String str = "11111111";
		int base1 = 2;
		int base2 = 16;
		String result = convertToBase(str, base1, base2);

		System.out.println("base" + base2 + " of base" + base1 + " " + str + " is " + result);
	}

	// convert num from base1 to base2
	public static String convertToBase(String str, int base1, int base2) {
		// First, convert num from base1 to base 10
		int result = 0;
		boolean isNegative = str.startsWith("-");
		for (int i= (isNegative ? 1 : 0); i < str.length(); i++) {
			result = result * base1 + str.charAt(i) - '0';			
		}
		
		System.out.println("base10 of base" + base1 + " " + str + " is " + result);
		return (isNegative ? "-" : "") + convertToBase(result, base2);
		
	}

	public static String convertToBase(int num, int base2) {
		//return (num == 0) ? "" : convertToBase(num/base2, base2) + 
		//	(char)((num % base2 >= 10) ? 'A' + (num % base2) - 10 : '0' + (num % base2));

		String str = "";
		if (num == 0) return str;

		str = convertToBase(num/base2, base2);
		return str + (char)((num % base2 >= 10) ? 'A' + num % base2 - 10 : '0' + num % base2);
	}
}