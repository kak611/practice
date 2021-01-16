import java.util.*;
class SpiralOrdering {
	public static void main(String[] args) {
		// int[][] matrix = { {11, 12, 13, 14, 15}, {16,17,18,19,20}, {21,22,23,24,25}, {26,27,28,29,30}, {31,32,33,34,35}};
		// int[][] matrix = { {11, 12, 13, 14, 15}, {16,17,18,19,20}, {21,22,23,24,25}, {26,27,28,29,30};
		int[][] matrix = { {11, 12, 13, 14}, {16, 17, 18, 19}, {21, 22, 23, 24}, {26, 27, 28, 29}, {31, 32, 33, 34}};
		printHorizontal(matrix);
		printSpiral(matrix);
	}	

	public static void printSpiral(int[][] matrix) {
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int x = 0;
		int y = 0;
		int dir = 0;
		for (int i = 0; i < matrix.length * matrix[0].length; i++) {
			System.out.print(matrix[x][y] + " ");
			matrix[x][y] = -1;
			int newX = x + dirs[dir][0];
			int newY = y + dirs[dir][1];

			if (newX < 0 || newY < 0 || newX >= matrix.length || newY >= matrix[0].length
				|| matrix[newX][newY] == -1) {
				dir = (dir + 1) % 4;
				newX = x + dirs[dir][0];
				newY = y + dirs[dir][1];
			}

			x = newX;
			y = newY;
		}
	}

	
	public static void printHorizontal(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}