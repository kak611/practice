import java.util.*;

class RoverControl {
	public static void main(String[] args) {
		// int n = 4;
		// String[] commands = {"RIGHT", "UP", "DOWN", "LEFT", "DOWN", "DOWN"};
		/* Expected output: 12 */
		

		int n = 4;
		String[] commands = {"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"};
		/* Expected output: 8 */


		int pos = findPosition(n, commands);
		System.out.println("Output: " + pos);
	}

	public static int findPosition(int n, String[] commands) {
		int[][] matrix = new int[n][n];
		Map<String, int[]> map = new HashMap<>();
		map.put("RIGHT", new int[] {0, 1});
		map.put("LEFT", new int[] {0, -1});
		map.put("UP", new int[] {-1, 0});
		map.put("DOWN", new int[] {1, 0});

		Deque<int[]> queue = new LinkedList<>();
		for (String s : commands) {
			queue.add(map.get(s));
		}

		int[] pos = findPosition(matrix, 0, 0, queue);
		return (pos[0] * n + pos[1]);
	}

	public static int[] findPosition(int[][] matrix, int i, int j, Deque<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = i + p[0];
			int y = j + p[1];

			if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) continue;

			i = x;
			j = y;
		}

		return new int[] {i, j};
	}
}