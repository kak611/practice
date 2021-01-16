import java.util.*;


/*
	A represented as A[0 to a-1]
	B represented as B[0 to b-1]
	E[A[0 - a-1]B[0 - b-1]] represents min distance

	if (A[a-1] == B[b-1]) {
		E[A[0 - a-1]B[0 - b-1]] = E[A[0 - a-2]B[0 - b-2]]
	} else {
		E[A[0 - a-1]B[0 - b-1]] = 1 + Math.min (
												E[A[0 - a-2]B[0 - b-2]], // replace
												E[A[0 - a-1]B[0 - b-2]], // add
												E[A[0 - a-2]B[0 - b-1]], // delete
		 					  			    )
			}
*/

class LevenshteinDistance {
	public static void main(String[] args) {
		String A = "ABC";
		String B = "BCD";
		int result = findDistance(A, B);
		System.out.println("Result: " + result);
	}

	public static int findDistance(String A, String B) {
		int[][] matrix = new int[A.length()][B.length()];
		for (int[] arr : matrix) {
			Arrays.fill(arr, -1);
		}
		int result = findDistance(A, B, A.length() - 1, B.length() - 1, matrix);
		for (int[] arr : matrix) {
			System.out.println(Arrays.toString(arr));
		}
		return result;
	}

	public static int findDistance(String A, String B, int index1, int index2, int[][] matrix) {
		if (index1 < 0) {
			return index2 + 1;
		} else if (index2 < 0) {
			return index1 + 1;
		}

		if (matrix[index1][index2] == -1) {
			if (A.charAt(index1) == B.charAt(index2)) {
				matrix[index1][index2] = findDistance(A, B, index1 - 1, index2 - 1, matrix);
			} else {
				// int substitute = findDistance(A, B, index1 - 1, index2 - 1, matrix);
				int add = findDistance(A, B, index1, index2 - 1, matrix); // (index1 - 1) transformed to (index2 - 2) & add char
				int delete = findDistance(A, B, index1 - 1, index2, matrix); // (index1 - 2) transformed to (index2 - 1) & delete char

				matrix[index1][index2] = 1 + Math.min(add, delete);							
			}
		}
		// System.out.println("index1: " + index1 + ", index2: " + index2 
		// 	+ ", A[index1]: " + A.charAt(index1) + ", B[index2]: " + B.charAt(index2) 
		// 	+ ", matrix[index1][index2]: " + matrix[index1][index2]); 
		return matrix[index1][index2];		
	}
}