import java.util.*;

class RobotGrid {
	// Elements of Programming -- 17.3, pg. 312
	public static void main(String[] args) {
		// int[][] grid = {{0, 0, 1, 0}, {0, 1, 0 , 0}, {0, 0, 0, 0}, {1, 1, 0, 0}};	// 2 ways
		int[][] grid = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};	// 70 ways
		int ways = findWays(grid);		
		System.out.println("Number of ways to reach bottom-right: " + ways);
	}

	public static int findWays(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		int[][] ways = new int[rows][cols];
		
		for (int[] arr : ways) Arrays.fill(arr, -1);

		ways[0][0] = 1; //  number of ways at first positions is 1 way which is no way
		System.out.println(Arrays.deepToString(ways));
		int result = ways(grid, rows - 1, cols -1, ways);
		System.out.println(Arrays.deepToString(ways));
		return result;
	}

	// time complexity: O(n*m)
	// top-down approach
	public static int ways(int[][] grid, int x, int y, int[][] ways) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
			|| grid[x][y] == 1) {
			return 0;
		}

		if (ways[x][y] == -1) {
			int numOfWaysTop = ways(grid, x, y - 1, ways);
			int numOfWayLeft = ways(grid, x - 1, y, ways);
			ways[x][y] = numOfWaysTop + numOfWayLeft;
		}
		
		return ways[x][y];
	}

}