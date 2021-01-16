class PrintSquare {
	public static void main(String[] args) {
		int n = 20;
		printSquare(n, n);
	}

	// use character '*'
	public static void printSquare(int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1
					|| i == j || i + j == rows - 1) {
					System.out.print("*" + " ");
				} else {
					System.out.print("  "); // 2 spaces
				}
			}			
			System.out.println();
		}
	}
}