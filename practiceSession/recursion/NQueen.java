import java.util.*;

class NQueen {

	static List<List<Point>> result;
	public static void main(String[] args) {
		final int N = 4;
		result = new ArrayList<>();
		getNQueenPositions(N);
	}

	public static void getNQueenPositions(int boardSize) {
		List<Point> points = new ArrayList<>();
		getPositions(0, boardSize, points);
	}

	public static void getPositions(int newRow, int boardSize, List<Point> points) {	

		if (newRow == boardSize) {
			result.add(points);
			System.out.println(points);
			return;
		}

		// search for position in newRow		
		for (int newCol = 0; newCol < boardSize; newCol++) {
			if (isValidPosition(newRow, newCol, points)) {
				points.add(new Point(newRow, newCol));
				getPositions(newRow + 1, boardSize, points);
				points.remove(points.size()-1);
			}
		}
	}

	public static boolean isValidPosition(int row, int col, List<Point> points) {
		// this is important
		if (row == 0) return true; //first position

		for (Point point : points) {
			if (row == point.row || col == point.col ||
				Math.abs(row - point.row) == Math.abs(col - point.col)) {
				return false;
			}
		}
		return true;		
	}

	static class Point {
		int row;
		int col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public String toString() {
			return "[" + this.row + ", " + this.col + "]";
		}
	}
}