import java.util.*;

class RotateMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{10,20,30,40,22}, {50,60,70,80,23}, {90,10,11,12,24}, {13,14,15,16,25}, {17,18,19,20,21,26}};
		printMatrix(matrix);
		rotate(matrix);
		printMatrix(matrix);
	}

	public static void rotate(int[][] matrix) {
		int offset = matrix.length - 1;
		for (int i = 0; i < matrix.length/2; i++) {
			for (int j = i; j < matrix.length - 1 - i; j++) {
				int temp1 = matrix[offset - j][i];
				int temp2 = matrix[offset - i][offset - j];
				int temp3 = matrix[j][offset - i];
				int temp4 = matrix[i][j];

				matrix[i][j] = temp1;
				matrix[offset - j][i] = temp2;
				matrix[offset - i][offset - j] = temp3;
				matrix[j][offset - i] = temp4;
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}