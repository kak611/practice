class DiagonalMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		printDiagonals(matrix);		
	}

	static int n;
	static int m;
	public static void printDiagonals(int[][] matrix) {
		m = matrix.length;
		n = matrix[0].length;

		int i = 0;
		for (int j = 0; j < n; j++) {
			print(matrix, i , j);
			System.out.println();
		}

		int j = n - 1;
		for (i = 1; i < m; i++) {
			print(matrix, i, j);
			System.out.println();
		}
	}

	public static void print(int[][] matrix, int i, int j) {
		while (i < m && j >= 0) {
			System.out.print(matrix[i++][j--] + " ");			
		}
	}
}