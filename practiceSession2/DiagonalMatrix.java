class DiagonalMatrix {
	public static void main(String[] args) {
		int[][] matrix = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		printDiagonal(matrix);
	}

	public static void printDiagonal(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		for (int j = 0; j < cols; j++) {
			helper(matrix, rows, cols, 0, j);
		}

		for (int i = 1; i < rows; i++) {
			helper(matrix, rows, cols, i, cols-1)
;		}

	}

	public static void helper(int[][] matrix, int rows, int cols, int r, int c) {
		int i = r;
		int j = c;
		while (i < rows && j >= 0) {
			System.out.print(matrix[i][j] + " ");
			i++;
			j--;
		}
		System.out.println(" ");
	}
}