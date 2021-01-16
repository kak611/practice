import java.util.*;

class PrintDiagonal {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		printDiagonal(arr);
	}

	public static void printDiagonal(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;

		for (int j = 0; j < cols; j++) {
			int l = 0;
			int k = j;

			while (l < rows && k >= 0) {
				System.out.print(arr[l++][k--] + " ");
			}
		}

		for (int i = 1; i < rows; i++) {
			int l = i;
			int k = cols - 1;

			while (l < rows && k >= 0) {
				System.out.print(arr[l++][k--] + " ");
			}
		}
	}
}