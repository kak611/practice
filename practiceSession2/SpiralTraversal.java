import java.util.List;
import java.util.ArrayList;

class SpiralTraversal {
	public static void main(String[] args) {
		int[][] matrix1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}}; // 4 * 4
		int[][] matrix2 = {{1,2,3}, {5,6,7}, {9,10,11}}; // 3 * 3	
		int[][] matrix3 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}}; // 3 * 4
		int[][] matrix4 = {{1,2,3}, {5,6,7}, {9,10,11}, {13,14,15}}; // 4 * 3	

		List<Integer> result;

		System.out.println("\nUsing layer by layer approach: ");
		// Note this approach works for n * n matrix and not n * m matrix
		result = spiralTraversalLayerByLayer(matrix1);
		System.out.println("4 * 4: " + result);

		result = spiralTraversalLayerByLayer(matrix2);
		System.out.println("3 * 3: " + result);




		System.out.println("\nUsing directions: ");

		result = spiralTraversalIn1DArray(matrix1);
		System.out.println("4 * 4: " + result);

		result = spiralTraversalIn1DArray(matrix2);
		System.out.println("3 * 3: " + result);

		result = spiralTraversalIn1DArray(matrix3);
		System.out.println("3 * 4: " + result);

		result = spiralTraversalIn1DArray(matrix4);
		System.out.println("4 * 3: " + result);
	}

	public static List<Integer> spiralTraversalLayerByLayer(int[][] matrix) {
		List<Integer> result = new ArrayList<>();

		
		/* System.out.println(Math.ceil(matrix.length * 0.5));
		   System.out.println(matrix.length/2);
		   for (int offset = 0; offset < matrix.length/2; offset++) {
		   use Math.ceil to consider the central position of odd size matrix */

		// traverse layer by layer starting from outer layer   
		for (int offset = 0; offset < Math.ceil(matrix.length * 0.5); offset++) {

			if (offset == matrix.length - 1 - offset) {
				result.add(matrix[offset][offset]);
				return result;
			}

			for (int j = offset; j < matrix.length - 1 - offset; j++) {
				result.add(matrix[offset][j]);
			}

			for (int i = offset; i < matrix.length - 1 - offset; i++) {
				result.add(matrix[i][matrix.length - 1 - offset]);
			}

			for (int j = matrix.length - 1 - offset; j > offset; --j) {
				result.add(matrix[matrix.length - 1 - offset][j]);
			}

			for (int i = matrix.length - 1 - offset; i > offset; --i) {
				result.add(matrix[i][offset]);
			}
		}

		return result;
	}

	// consider 1D array and use directions to traverse
	public static List<Integer> spiralTraversalIn1DArray(int[][] matrix) {
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		List<Integer> result = new ArrayList<>();

		int x = 0;
		int y = 0;
		int dir = 0;

		for (int i = 0; i < matrix.length * matrix[0].length; i++) {
			result.add(matrix[x][y]);

			// mark visited
			matrix[x][y] = -1;

			// find next position
			int nextX = x + dirs[dir][0];
			int nextY = y + dirs[dir][1];

			// if new position not valid change direction
			if (nextX < 0 || nextY <  0 || nextX > matrix.length -1
				|| nextY > matrix[0].length - 1 || matrix[nextX][nextY] == -1) {
				dir = (dir + 1) % (dirs.length);
				nextX = x + dirs[dir][0];
				nextY = y + dirs[dir][1];		
			}

			x = nextX;
			y = nextY;
		}
		return result;
	}

	// Not valid function.. some elements are missing.. So need to traverse m * n times for that.
	// public static List<Integer> spiralTraversalIn1DArray(int[][] matrix) {
	// 	List<Integer> result = new ArrayList<>();
	// 	int[][] dirs = {{0, 1}, {1, 0}, {-1,0}, {0, -1}};
	// 	int x = 0;
	// 	int y = -1;

	// 	for (int[] dir : dirs) {
	// 		int nextX = x + dir[0];
	// 		int nextY = y + dir[1];
	// 		while (nextX >= 0 && nextY >= 0 && nextX < matrix.length
	// 			&& nextY < matrix[0].length && matrix[nextX][nextY] != -1) {
	// 			x = nextX;
	// 			y = nextY;
	// 			result.add(matrix[x][y]);
	// 			matrix[x][y] = -1;				

	// 			nextX = x + dir[0];
	// 			nextY = y + dir[1];
	// 		}
	// 	}

	// 	return result;
	// }

}


