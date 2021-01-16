import java.util.Scanner;

class Stylesheet {
	public static void main(String[] args) {
		// Seems like Sublime text 3 doesnt have way to read from console
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter xls column name (e.g. AA, B, etc): ");
		// if (scanner.hasNext()) {
		// 	String str = scanner.nextLine();
		// 	System.out.println(str);
		// }

		String str = "BA";
		int columnId = getXLSColumnId(str);
		System.out.println("Column ID for " + str + ": " + columnId);

		int num = 53;
		String result = getXLSColumnName(num);
		System.out.println("Column name for " + num + ": " + result);
	}

	public static int getXLSColumnId(String str) {
		int result = 0;
		for (char c : str.toCharArray()) {
			result = result * 26 + (c - 'A') + 1;
		}

		return result;		
	}

	public static String getXLSColumnName(int num) {
		StringBuilder strb = new StringBuilder();
		getXLSColumnNameRecursively(num, strb);
		return strb.toString();

		// Iterative solution
		// char c = '\0';		
		// while (num != 0) {	
		// 	//System.out.println(num);
		// 	c = (char)('A' + (num % 26 == 0 ? 26 : num % 26) - 1);			
		// 	strb.append(c);
		// 	num = (num % 26 == 0) ? (num / 26 - 1) : num/26;
		// }
		// strb.reverse();
		//return strb.toString();
	}

	public static void getXLSColumnNameRecursively(int num, StringBuilder strb) {
		if (num == 0) return;
		getXLSColumnNameRecursively(num % 26 == 0 ? num / 26 - 1 : num / 26, strb);
		char c = (char)('A' + (num % 26 == 0 ? 26 : num % 26) - 1);
		strb.append(c);
		
	}
}