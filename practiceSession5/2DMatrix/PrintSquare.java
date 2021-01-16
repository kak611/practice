class PrintSquare {
	public static void main(String[] args) {				
		int rows = 10;		
		printSquare(rows);		
	}

	public static void printSquare(int rows) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (i == 0 || j == 0 || i == rows - 1 || j == rows - 1
					|| i == j || (i + j) == rows - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
