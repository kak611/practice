import java.util.*;

class SolveSudoku {
	public static void main(String[] args) {
		int[][] matrix =   {{5,3,0,0,7,0,0,0,0},
							{6,0,0,1,9,5,0,0,0},
							{0,9,8,0,0,0,0,6,0},
							{8,0,0,0,6,0,0,0,3},
							{4,0,0,8,0,3,0,0,1},
							{7,0,0,0,2,0,0,0,6},
							{0,6,0,0,0,0,2,8,0},
							{0,0,0,4,1,9,0,0,5},
							{0,0,0,0,8,0,0,7,9}};

		int rows = matrix.length;
		int cols = matrix[0].length;

		if (solveSudoku(matrix, rows, cols, 0, 0)) {
			System.out.println("Sudoku solved :)");
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Sudoku cannot be solved :(");
		}

	}

	public static boolean solveSudoku(int[][] matrix, int rows, int cols, int i, int j) {
		if (j == cols) {
			j = 0;
			i++;
			if (i == rows) {
				return true;
			}
		}

		// System.out.println("check1: " + Arrays.deepToString(matrix));

		if (matrix[i][j] != 0) {			
			return solveSudoku(matrix, rows, cols, i, j + 1);
		}

		// check every entry if it fits in
		for (int val = 1; val <= 9; val++) {
			if (isValidEntry(matrix, rows, cols, i, j, val)) {
				matrix[i][j] = val;
				if (solveSudoku(matrix, rows, cols, i, j+1)) {
					return true;					
				}
			}
		}

		// backtrack -- no values are valid
		matrix[i][j] = 0;		
		return false;
	}

	public static boolean isValidEntry(int[][] matrix, int rows, int cols, int r, int c, int val) {
		// check specific row
		for (int i = 0; i < rows; i++) {
			if (matrix[i][c] == val) return false;
		}

		// check specific col
		for (int j = 0; j < cols; j++) {
			if (matrix[r][j] == val) return false;
		}

		// check specific grid
		int size = (int)Math.sqrt(rows);
		int I = r/size;
		int J = c/size;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (matrix[size * I + i][size * J + j] == val) return false;
			}
		}
		return true;
	}
}