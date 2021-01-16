import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

class Traverse2D {
	public static void main(String[] args) {
		List<List<Integer>> grid = new ArrayList<>();
		grid.add(Arrays.asList(1,2,3));
		grid.add(Arrays.asList(4,5,6));
		grid.add(Arrays.asList(7,8,9));

		// List<Integer> pattern = Arrays.asList(2,1,4,7);		
		// List<Integer> pattern = Arrays.asList(1,2,3,6,5);
		// List<Integer> pattern = Arrays.asList(1,2,5,8,9);
		// List<Integer> pattern = Arrays.asList(1,2,3,6,5,4,7,8,9);
		// List<Integer> pattern = Arrays.asList(1,2,5,4,5,8,7,8,7,8,9);
		// List<Integer> pattern = Arrays.asList(1,2,4,8,9);
		System.out.println("isPattern: " + String.valueOf(isPatternExists(grid, pattern)));
	}

	public static boolean isPatternExists(List<List<Integer>> grid, List<Integer> pattern) {
		HashSet<Point> points = new HashSet<>();
		for (int i=0; i < grid.size(); i++) {
			for (int j=0; j < grid.get(0).size(); j++) {
				if (isPatternExists(i, j, grid, pattern, points, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isPatternExists(int x, int y, List<List<Integer>> grid, List<Integer> pattern, HashSet<Point> points, int offset) {
		if (offset == pattern.size()) {
			return true;
		}

		if (x < 0 || x >= grid.size() || y < 0 || y >= grid.get(0).size() 
			|| points.contains(new Point(x, y, offset))) return false;

		if (grid.get(x).get(y) == pattern.get(offset)) {
			return isPatternExists(x+1, y, grid, pattern, points, offset + 1) ||
				isPatternExists(x, y+1, grid, pattern, points, offset + 1) ||
				isPatternExists(x-1, y, grid, pattern, points, offset + 1) ||
				isPatternExists(x, y-1, grid, pattern, points, offset + 1);
		}

		points.add(new Point(x, y, offset));
		return false;
	}

	static class Point {
		int x;
		int y;
		int offset;

		Point(int x, int y, int offset) {
			this.x = x;
			this.y = y;
			this.offset = offset;
		}

		public String toString() {
			return this.x + ", " + this.y + ", " + this.offset;
		}
	}
}