import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

class ShortestPath {
	public static final int NODES = 9;
	static int[] shortestPaths;
	public static void main(String[] args) {
		// Assume every edge has length = 1
		int[][] pairs = {{1, 5}, {2, 3}, {3, 4}, {4, 5}, {4, 2}, {5, 6}, {6, 9}, {7, 8}, {8, 9}, {9, 7}, {6, 1}};

		List<ArrayList<Integer>> graph = new ArrayList<>();		

		graph.add(0, new ArrayList<>());
		for (int i = 1; i <= NODES; i++) {
			graph.add(i, new ArrayList<Integer>());
		}

		for (int[] pair : pairs) {
			graph.get(pair[0]).add(pair[1]);
		}

		System.out.println("Graph: " + graph);		

		shortestPaths = new int[NODES + 1];
		bfs(graph, 1);
		System.out.println("Shortest paths for each node from vertex 1 are " + Arrays.toString(shortestPaths));
	}

	public static void bfs(List<ArrayList<Integer>> graph, int vertex) {
		boolean[] explored = new boolean[NODES + 1];
		for (int i = 0; i <= NODES; i++) {
			shortestPaths[i] = Integer.MAX_VALUE;			
		}
		Deque<Integer> queue = new LinkedList<>();
		shortestPaths[vertex] = 0;
		explored[vertex] = true;
		queue.addLast(vertex);

		while (!queue.isEmpty()) {
			int v = queue.removeFirst();
			for (int edge : graph.get(v)) {
				if (!explored[edge]) {
					shortestPaths[edge] = Math.min(shortestPaths[edge], shortestPaths[v] + 1);
					explored[edge] = true;
					queue.addLast(edge);
				}
			}
		}
	}
}
