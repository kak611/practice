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

	 	int rows = matrix.length;
	 	int cols = matrix[0].length;
		// printMatrix(matrix, 0, 0, rows, cols, 0);

		List<MissingInt> missingIntegers = getMissingIntegers(matrix, rows, cols);
		// System.out.println("Missing integers: " + missingIntegers);

		Collections.sort(missingIntegers, new Comparator<MissingInt>() {
			public int compare(MissingInt a, MissingInt b) {
				return a.num - b.num;
			}
		});
		System.out.println("Missing integers: " + missingIntegers);
		reOrderMatrix(matrix, missingIntegers);
		System.out.println("Reordered Matrix: ");
		printMatrix(matrix, 0, 0, rows, cols, 0);

	}

	public static void reOrderMatrix(int[][] matrix, List<MissingInt> list) {
		// create clone of matrix
		int[][] cloneMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			cloneMatrix[i] = matrix[i].clone();
		}

		int k = 0;
		for (int i = 0; i < matrix.length; i += SUBMATRIX_SIZE) {
			for (int j = 0; j < matrix[0].length; j += SUBMATRIX_SIZE) {
				MissingInt m = list.get(k++);
				for (int x = i, a = m.sIndex; x < i + SUBMATRIX_SIZE; x++, a++) {
					for (int y = j, b = m.eIndex; y < j + SUBMATRIX_SIZE; y++, b++) {
						matrix[x][y] = cloneMatrix[a][b];
					}
				}
			}
		}
	}

	public static List<MissingInt> getMissingIntegers(int[][] matrix, int rows, int cols) {
		// TreeSet<MissingInt> result = new TreeSet<>();
		List<MissingInt> result = new ArrayList<>();
		TreeSet<Integer> set = new TreeSet<>(Arrays.asList());		

		for (int i = 0; i < rows; i += SUBMATRIX_SIZE) {
			for (int j = 0; j < cols; j += SUBMATRIX_SIZE) {
				// initialize set
				for (int k = 1; k <= SUBMATRIX_SIZE * SUBMATRIX_SIZE; k++) set.add(k);

				// printMatrix(matrix, i, j, i + SUBMATRIX_SIZE, j + SUBMATRIX_SIZE, j);
				for (int x = i; x < i + SUBMATRIX_SIZE; x++) {
					for (int y = j; y < j + SUBMATRIX_SIZE; y++) {						
						if (set.contains(matrix[x][y])) set.remove(matrix[x][y]);
					}
				}				

				result.add(new MissingInt(set.first(), i, j));
			}
		}

		return result;
	}

	public static void printMatrix(int[][] matrix, int i, int j, int rows, int cols, int startIndex) {
		if (j == cols) {		
			System.out.println();
			if (i+1 == rows) {
				System.out.println();
				return;
			}
			i += 1;
			j = startIndex;
		}

		System.out.print(matrix[i][j] + " ");
		printMatrix(matrix, i, j+1, rows, cols, startIndex);
	}

	static class MissingInt { //implements Comparable<MissingInt> {
		int num;
		int sIndex;
		int eIndex;

		public MissingInt(int num, int sIndex, int eIndex) {
			this.num = num;
			this.sIndex = sIndex;
			this.eIndex = eIndex;
		}

		public int compareTo(MissingInt o) {
			return Integer.compare(this.num, o.num);
		}

		public String toString() {			
			// return "" + num + ", sIndex: " + sIndex + ", eIndex: " + eIndex;
			return "" + num;
		}

		// // to add in TreeSet
		// public boolean equals(Object o) {
		// 	if (this == o) return true;

		// 	if (!(o instanceof MissingInt)) return false;

		// 	MissingInt m = (MissingInt) o;

		// 	if (m.sIndex == this.sIndex 
		// 		&& m.eIndex == this.eIndex
		// 		&& m.num == this.num) return true;			

		// 	return false;
		// }

		// public int hashCode() {			
		// 	return (num + "-" + String.valueOf(sIndex) + "-" + String.valueOf(eIndex)).hashCode();
		// }
	}

}