import java.util.*;

/*
	* Q * *		00 01 02 03		* * Q *
	* * * Q     10 11 12 13     Q * * * 
	Q * * *		20 21 22 23     * * * Q
	* * Q *		30 31 32 33     * Q * * 

	1. iterate each row
	2. for each row, check each col position if valid and place the queen
	3. else backtrack and move to next column

*/
class NQueen {
	public static void main(String[] args) {
		int n = 5;
		// all possible outcomes
		List<List<int[]>> result = new ArrayList<>();
		findQueenPosition(0, n, new ArrayList<int[]>(), result);
		System.out.println("All possible Queen positions are : ");
		for (List<int[]> position : result) {
			for (int[] p : position) System.out.print(Arrays.toString(p) + " ");
			System.out.println();
		}
	}

	// time complexity: n^n  --> branches^depth where branches = number of cols per level & depth = number of rows
	public static boolean findQueenPosition(int row, int cols, List<int[]> positions, List<List<int[]>> result) {
		if (row == cols) {			
			result.add(new ArrayList<>(positions));
			return true;
		}

		for (int i = 0; i < cols; i++) {
			if (isValidPosition(row, i, positions)) {				
				positions.add(new int[] {row, i});
				findQueenPosition(row + 1, cols, positions, result);
				positions.remove(positions.size() - 1);
			}			
		}

		return false;  // no valid position found
	}

	public static boolean isValidPosition(int row, int col, List<int[]> positions) {
		// allow first row any position
		if (row == 0) {
			return true;
		}
		
		for (int[] position : positions) {			
			// System.out.println("isValid?: " + row + "," + col);
			if (row == position[0] || col == position[1] 
				|| Math.abs(row - position[0]) == Math.abs(col - position[1])
				|| (row + col) == (position[0] + position[1])) return false;
		}

		return true;
	}
}