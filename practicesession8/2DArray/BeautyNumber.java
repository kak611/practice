import java.util.*;

class BeautyNumber {
	public static final int SUBMATRIX_SIZE = 2;
	public static void main(String[] args) {
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

		int rows = matrix.length;
		int cols = matrix[0].length;
		printMatrix(matrix, rows, cols);

		List<Data> missingNumbers = findMissingNumbers(matrix, rows, cols);		
		System.out.println(missingNumbers);

		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
			public int compare(Data d1, Data d2) {
				return Integer.compare(d1.val, d2.val);
			}
		});

		for (Data d : missingNumbers) pq.add(d);

		int[][] temp_matrix = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			temp_matrix[i] = matrix[i].clone();
		}

		reOrderMatrix(matrix, temp_matrix, pq);
		printMatrix(matrix, rows, cols);
	}

	public static void reOrderMatrix(int[][] matrix, int[][] temp_matrix, PriorityQueue<Data> pq) {
		for (int start_pos_i = 0; start_pos_i < matrix.length; start_pos_i += SUBMATRIX_SIZE) {
			for (int start_pos_j = 0; start_pos_j < matrix[0].length; start_pos_j += SUBMATRIX_SIZE) {
				Data d = pq.poll();
				for (int i = start_pos_i, x = d.i; x < d.i + SUBMATRIX_SIZE; i++, x++) {
					for (int j = start_pos_j, y = d.j; y < d.j + SUBMATRIX_SIZE; j++, y++) {
						matrix[i][j] = temp_matrix[x][y];
					}
				}
			}
		}
	}

	public static List<Data> findMissingNumbers(int[][] matrix, int rows, int cols) {
		List<Data> result = new ArrayList<>();
		for (int start_pos_i = 0; start_pos_i < rows; start_pos_i += SUBMATRIX_SIZE) {
			for (int start_pos_j = 0; start_pos_j < cols; start_pos_j += SUBMATRIX_SIZE) {

				// missing number is amongst the numbers 1 to n where n is size of the submatrix
				boolean[] visited = new boolean[SUBMATRIX_SIZE * SUBMATRIX_SIZE + 1];				

				for (int i = start_pos_i; i < start_pos_i + SUBMATRIX_SIZE; i++) {
					for (int j = start_pos_j; j < start_pos_j + SUBMATRIX_SIZE; j++) {
						if (matrix[i][j] > 0 && matrix[i][j] <= (SUBMATRIX_SIZE * SUBMATRIX_SIZE)) visited[matrix[i][j]] = true;
					}
				}

				for (int i = 1; i < visited.length; i++) {
					if (!visited[i]) {
						result.add(new Data(i, start_pos_i, start_pos_j));
						break;
					}
				}
			}
		}

		return result;
	}

	public static void printMatrix(int[][] matrix, int rows, int cols) {
		
		System.out.println();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}

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
			return this.val + "--[" + this.i + ", " + this.j + "]\t";
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