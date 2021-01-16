class StringInteger {
	public static void main(String[] args) {
		final String str = Integer.MAX_VALUE + ""; //"-328";
		final int num = -12345;

		int result = getIntegerValue(str);
		System.out.println("Integer value: " + result);

		// // If result has exceeded Integer.MAX_VALUE after adding two	
		// result +=2;
		// if (result < 0) {
		// 	System.out.println("MIN VALUE: " + result);			
		// }
		
		String output = getStringValue(num);		
		System.out.println("String output: " + output);
	}

	public static int getIntegerValue(String str) {
		int isNegative = (str.charAt(0) == '-') ? -1 : 1;
		int result = 0;
		for (int i = (isNegative == -1) ? 1 : 0; i < str.length(); i++) {
			result = result * 10 + (str.charAt(i) - '0');			
		}

		if (isNegative == -1) {
			result = -result;
		}

		return result;
	}

	public static String getStringValue(int num) {
		StringBuilder strb = new StringBuilder();		
		int n = Math.abs(num);

		// while(n > 0) {
		// 	char c = (char)('0' + (n%10));
		// 	n /= 10;
		// 	strb.append(c);
		// }

		// if (num < 0) {
		//  	strb.append('-');
		// }

		// strb.reverse();

		getRecursively(n, strb);		
		return ((num < 0) ? "-" : "") + strb.toString();
	}

	public static void getRecursively(int num, StringBuilder strb) {
		if (num == 0) return;

		getRecursively(num/10, strb);
		char c = (char) ('0' + num%10);
		strb.append(c);

		//if below line is last then the output string is still in reverse order
		// and also its called tail recursion which means no recursive stack is built

		//getRecursively(num/10, strb);
	}
}