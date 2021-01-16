import java.util.Arrays;

class ValidSudoku {
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

		System.out.println("isValudSudoku: " + isValidSudoku(matrix));
	}

	public static boolean isValidSudoku(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		// validate 3*3 grids
		int size = (int)Math.sqrt(rows);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!isValid(matrix, (size * i), size * (i+1), (size * j), size * (j+1))) {
					return false;
				}
			}
		}

		// validate rows
		for (int i = 0; i < rows; i++) {
			if (!isValid(matrix, i, i+1, 0, cols)) {
				// System.out.println("row index: " + i);
				return false;
			}
		}

		// validate cols
		for (int j = 0; j < cols; j++) {
			if (!isValid(matrix, 0, rows, j, j+1)) {
				// System.out.println("col index: " + j);
				return false;
			}
		}
		return true;


	}

	public static boolean isValid(int[][] matrix, int startRow, int endRow, int startCol, int endCol) {
		// System.out.println(startRow + ", " + endRow + "," + startCol + ", " + endCol);
		// 1 - 9, 0 is empty cell
		boolean[] present = new boolean[10];
		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				if (matrix[i][j] == 0) continue;
				if (present[matrix[i][j]]) {
					// System.out.println(i + "," + j +", " + matrix[i][j]);
					return false; // found duplicate
				}
				present[matrix[i][j]] = true;
			}
		}		
		return true;
	}
}