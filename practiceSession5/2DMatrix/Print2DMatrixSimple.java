class Print2DMatrixSimple {
	public static void main(String[] args) {
		int[][] matrix = {{11,12,13,14}, {15,16,17,18}, {19,20,21,22}, {23,24,25,26}, {27, 28, 29, 30}, {31, 32, 33, 34}};
		// int[][] matrix = { {1, -1, 1, 0, 2}, {1,1,1,0,0}, {2,3,-1,1,-1}, {2, -1, 1, 0, 0}, {2,3,2,3,2}};
		
		int rows = matrix.length;
		int cols = matrix[0].length;

		// print horizontal
		printHorizontal(matrix, rows ,cols);

		// print vertical
		// printVertical(matrix, rows, cols);

		// print diagonal top-right to bottom-left
		// printDiagonal(matrix, rows, cols);

		// print diagonal bottom-left to top-right
		printDiagonal2(matrix, rows, cols);
	}

	public static void printDiagonal2(int[][] matrix, int rows, int cols) {
		// col is fixed to 0 & increment col & decrement row
		for (int i = 0; i < rows; i++) {
			// because cols increment in this case, we have to pass in cols max limit
			print2(matrix, cols, i, 0);
		}

		for (int j = 1; j < cols; j++) {
			print2(matrix, cols, rows - 1, j);
		}
	}

	private static void print2(int[][] matrix, int cols, int i, int j) {
		while (i >= 0 && j < cols) {
			System.out.print(matrix[i--][j++] + " ");
		}
		System.out.println();
	}

	public static void printDiagonal(int[][] matrix, int rows, int cols) {
		System.out.println("\nDiagonal: ");

		// row is fixed & go diagonal increasing row and decreasing col
		for (int j = 0; j < cols; j++) {
			print(matrix, rows, 0, j);
		}

		// col is fixed and go diagonal by increasing row and decreasing col
		for (int i = 1; i < rows; i++) {
			print(matrix, rows, i, cols - 1);
		}
	}

	private static void print(int[][] matrix, int rows, int i, int j) {
		int r = i;
		int c = j;
		while (r < rows && c >= 0) {
			System.out.print(matrix[r++][c--] + " ");
		}
		System.out.println();
	}





	public static void printVertical(int[][] matrix, int rows, int cols) {
		System.out.println("\nVertical: ");
		for (int j = 0; j < cols; j++) {	// j is fixed for inner loop
			for (int i = 0; i < rows; i++) {
				System.out.print(matrix[i][j] + " ");	// j represents cols which is fixed
			}
			System.out.println();
		}

	}

	public static void printHorizontal(int[][] matrix, int rows, int cols) {
		System.out.println("\nHorizontal: ");
		for (int i = 0; i < rows; i++) {  // i is fixed for inner loop
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");  // since i represents row, row is fixed
			}
			System.out.println();
		}
	}
}