import java.util.*;

class BeautyNumber {
	public static final int SUBMATRIX_SIZE = 2;
	public static void main(String[] args) {
		// 4 X 4 matrix
		// int[][] matrix = {{-1,2,1,4}, {3,5,2,6}, {1,2,1,6}, {3,6,7,4}};

		// 6 X 6
		int[][] matrix = {{-1,1,1,4,12,51}, {3,5,2,6,0,-2}, {1,2,1,6,3,-3}, {3,6,7,4,22,10}, {1,2,3,5,3,7}, {1,2,3,4,1,2}};
		/*
			Missing numbers:							Sorted Matrix:
							2, 3, 1										1,1,1
							4, 2, 1										2,2,3
							3, 1, 4										3,4,4
			Input Matrix:								Expected output:
						-1  1 1 4 12 51									12 51 3 5  3  -3 
			 			3  5 2 6  0 -2									0 -2  3 4 22  10 
			 			1  2 1 6  3 -3 									1  6 -1 1  1  4 
			 			3  6 7 4 22 10 									7  4  3 5  2  6 
			 			1  2 3 5  3  7									1  2  1 2  3  7 
				 		1  2 3 4  1  2 									1  2  3 6  1  2 
		*/

		printMatrix(matrix, 0, 0, matrix.length, matrix[0].length);

		List<Data> beautyNumbers = findMissingNumbers(matrix);

		// min heap
		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
			public int compare(Data a, Data b) {
				return a.val - b.val;	// asc. order
			}
		});
		// System.out.println(beautyNumbers);

		// re-order matrix
		int[][] temp_matrix = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			temp_matrix[i] = matrix[i].clone();
		}

		for (Data data : beautyNumbers) pq.add(data);



		// sort as per missing numbers
		reOrder(matrix, temp_matrix, pq);

		// Output
		System.out.println("\nOutput: ");
		printMatrix(matrix, 0, 0, matrix.length, matrix.length);
	}

	public static List<Data> findMissingNumbers(int[][] matrix) {
		List<Data> result = new ArrayList<>();

		int rows = matrix.length;
		int cols = matrix[0].length;

		// traverse submatrix 2X2 one at a time
		for (int start_pos_i = 0; start_pos_i < rows; start_pos_i += SUBMATRIX_SIZE) {
			for (int start_pos_j = 0; start_pos_j < cols; start_pos_j += SUBMATRIX_SIZE) {
				/*
					Note:
					  lowest missing number will be between 1 to 4 for 4X4 matrix as there will be 2X2 sub-matrices.

					  More examples:
					  lowest missing number will be between 1 to 4 for 6X6 matrix if split into 2X2 as there are 4 lowest numbers that can fit
					  lowest missing number will be between 1 to 9 for 6X6 matrix if split into 3X3 as there are 9 lowest numbers that can fit

				*/
				boolean[] exists = new boolean[(SUBMATRIX_SIZE * SUBMATRIX_SIZE + 1)];
				exists[0] = true; // mark as exists or just ignore as positive number for this question is >= 1

				// printMatrix(matrix, start_pos_i, start_pos_j, start_pos_i+2, start_pos_j+2);
				for (int i = start_pos_i; i < (start_pos_i + SUBMATRIX_SIZE); i++) {
					for (int j = start_pos_j; j < (start_pos_j + SUBMATRIX_SIZE); j++) {
						if (matrix[i][j] > 0 && matrix[i][j] <= (SUBMATRIX_SIZE * SUBMATRIX_SIZE)) exists[matrix[i][j]] = true;
					}
				}


				/* 
					lowest number is the one that is not marked as exists
					0 1 2 3 4
					T _ _ _ _
				*/
				int lowest_num = 1;
				for (int index = 0; index < exists.length; index++) {
					if (!exists[index]) {
						lowest_num = index;
						break;
					}					
				}

				result.add(new Data(lowest_num, start_pos_i, start_pos_j));
			}
		}

		return result;
	}

	public static void reOrder(int[][] matrix, int[][] temp_matrix, PriorityQueue<Data> pq) {
		int rows = matrix.length;
		int cols = rows;

		for (int start_pos_i = 0; start_pos_i < rows; start_pos_i += SUBMATRIX_SIZE) {
			for (int start_pos_j = 0; start_pos_j < cols; start_pos_j += SUBMATRIX_SIZE) {
				Data data = pq.poll();
				for (int x = data.i, i = start_pos_i; x < data.i + SUBMATRIX_SIZE; x++, i++) {
					for (int y = data.j, j = start_pos_j; y < data.j + SUBMATRIX_SIZE; y++, j++) {
						// System.out.println("i: " + i + ", j: " + j + ", data.i: " + x + ", data.j: " + y);
						matrix[i][j] = temp_matrix[x][y];
					}
				}
			}
		}
	}

	private static void printMatrix(int[][] matrix, int r, int c, int rows, int cols) {
		for (int i = r; i < rows; i++) {
			for (int j = c; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// object to hold beauty number and matrix start position
	static class Data {
		int val;
		int i;
		int j;

		public Data(int val, int i, int j) {
			this.val = val;
			this.i = i;
			this.j = j;
		}

		public String toString() {
			return "lowest missing number is " + val + " for matrix starting at: " + i + "," + j + "\n";
		}
	}
}












/*
	DESCRIPTION:
	Beauty Number

You are given MxM matrix where M is an even number (2,4,6,...)
A beauty number is defined for a 2x2 matrix as the lowest missing positive integer in the matrix

Re order the given matrix based on the beauty number for the submatrices. If the beauty number is the same, order them in any way

Ex input

[
-1 2 1 4
 3 5 2 6
 1 2 1 6
 3 6 7 4
]
Ex output:

[
-1 2 1 6
 3 5 7 4
 1 4 1 2
 2 6 3 6
]
Explanation:
The beauty numbers for the input matrix will be

[
 1 3
 4 2
]
So we need to re order the original matrix based on the beauty numbers

*/