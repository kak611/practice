import java.util.*;

class RobotGrid2 {
	/* Modified version Elements of Programming -- 17.3, pg. 312

	Given a grid of size mxn,
	count the number of ways you can go from (0, 0) to end of grid.

	You can move down or right only. You don't like taking boring paths, 
	so you move in the same direction continuously at max 2 times. 
	For e.g: grid [3, 4] : (0, 0) -> (0, 1) -> (0, 2) -> (0, 3) is not valid since you moved right 3 times. 
	whereas, (0, 0) -> (0, 1) -> (0, 2) -> (1, 2) -> (1, 3) -> (2, 3) is one of the valid paths.

	*/
	public static void main(String[] args) {
		// int[][] grid = {{0, 0, 1, 0}, {0, 1, 0 , 0}, {0, 0, 0, 0}, {1, 1, 0, 0}};
		int[][] grid = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
		int ways = findWays(grid);
		System.out.println("Number of ways to reach bottom-right: " + ways);
	}

	// NOT SURE ABOUT THIS APPROACH

	// bottom-up approach
	public static int findWays(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		int[][] ways = new int[rows][cols];
		ways[0][0] = 1; //  number of ways at first positions is 1 way which is no way

		// rows - 2 as last two positions cannot be reached
		// no of ways to reach cells in first col
		for (int i = 0; i < rows - 2; i++) ways[i][0] = 1;
		for (int i = rows - 2; i < rows; i++) ways[i][0] = -1;	

		// cols - 2 as last two positions cannot be reached
		// no of ways to reach cells in first row
		for (int j = 0; j < cols - 2; j++) ways[0][j] = 1;
		for (int j = cols - 2; j < cols; j++) ways[0][j] = -1;		

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				// robot can move atmost two steps right or down
				// numOfWaysTop = (numOfWays above i.e. x-1, y) - (numOfWays x-3,y)
				// as curr position cannot be reached from 
				int numOfWaysTop = (i - 1 < 0) ? 0 : ways[i-1][j];
				numOfWaysTop -= (i-3 < 0) ? 0 : ways[i-3][j];

				int numOfWaysLeft = (j - 1 < 0) ? 0 : ways[i][j-1];
				numOfWaysLeft -= (j - 3 < 0) ? 0 : ways[i][j-3];
				System.out.println(numOfWaysTop + ", " + numOfWaysLeft);

				ways[i][j] = numOfWaysTop + numOfWaysLeft;
			}
		}

		System.out.println(Arrays.deepToString(ways));

		return ways[rows-1][cols-1];
	}

}