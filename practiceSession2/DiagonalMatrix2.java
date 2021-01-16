import java.util.*;

class DiagonalMatrix2 {
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) {
		int[][] matrix = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		printDiagonal(matrix);
		System.out.println(result);
	}

	public static void printDiagonal(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int d = 1;

		for (int j = 0; j < cols; j++) {
			d += 1;
			helper(matrix, rows, cols, 0, j, d);
		}

		for (int i = 1; i < rows; i++) {
			d += 1;
			helper(matrix, rows, cols, i, cols-1, d);
		}

	}

	public static void helper(int[][] matrix, int rows, int cols, int r, int c, int d) {
		int i = r;
		int j = c;
		List<Integer> temp = new ArrayList<>();

		while (i < rows && j >= 0) {
			temp.add(matrix[i][j]);			
			i++;
			j--;
		}
		
		if (d%2 == 0) Collections.reverse(temp);
		result.addAll(temp);
	}
}