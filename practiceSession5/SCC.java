import java.util.*;

class SCC {
	public static final int NODES = 9;
	public static int label;
	public static int[] order;
	public static boolean[] explored;
	public static void main(String[] args) {
		int[][] pairs = {{7,1}, {4,7}, {1,4}, {9, 7}, {9,3}, {6,9}, {3,6}, {8,6}, {2,8}, {8,5}, {5,2}};

		Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
		// create reverse graph
		for (int i = 1; i <= NODES; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		for (int[] pair : pairs) {			
			graph.get(pair[1]).add(pair[0]);
		}

		System.out.println(graph);

		order = new int[NODES + 1];
		explored = new boolean[NODES + 1];
		label = 1; // start from 1
		for (int i = NODES; i > 0; --i) {
			if (!explored[i]) {
				dfs(graph, i);
			}
		}

		// System.out.println(Arrays.toString(order));

		// create graph using new order
		graph.clear();
		for (int[] pair : pairs) {
			graph.putIfAbsent(order[pair[0]], new ArrayList<Integer>());
			graph.get(order[pair[0]]).add(order[pair[1]]);
		}

		System.out.println("New graph: " + graph);

		// find leaders
		List<Integer> leaders = new ArrayList<>();
		Arrays.fill(explored, false);
		for (int i = NODES; i > 0; --i) {
			if (!explored[i]) {
				leaders.add(i);
				dfs(graph, i);
			}
		}

		System.out.println("Leaders of SCC: " + leaders);
	}

	public static void dfs(Map<Integer, ArrayList<Integer>> graph, int vertex) {
		explored[vertex] = true;
		for (int edge : graph.get(vertex)) {
			if (!explored[edge]) {
				dfs(graph, edge);
			}
		}
		order[vertex] = label++;
	}
}