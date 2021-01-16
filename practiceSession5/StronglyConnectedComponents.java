import java.util.*;

class StronglyConnectedComponents {
	public static final int NODES = 9;
	static int finishing_time;
	static int[] order_arr;
	static List<Integer> leaders;
	static boolean[] visited;
	static boolean isStep1;
	public static void main(String[] args) {
		int[][] pairs = {{7,1}, {4,7}, {1,4}, {9, 7}, {9,3}, {6,9}, {3,6}, {8,6}, {2,8}, {8,5}, {5,2}};
		
		// step1: traverse reverse graph and identify finishing time
		// step2: traverse graph with updated nodes w.r.t finishing time and find leaders (SCC)

		// create reverse graph
		Map<Integer, ArrayList<Integer>> rgraph = new HashMap<>();
		for (int[] pair : pairs) {
			if (!rgraph.containsKey(pair[1])) {
				rgraph.put(pair[1], new ArrayList<Integer>());
			}
			rgraph.get(pair[1]).add(pair[0]);
		}

		System.out.println(rgraph);

		// traverse graph and find finishing time
		isStep1 = true;		
		dfs_loop(rgraph);
		// print finishing time
		System.out.println("Finishing time order: " + Arrays.toString(order_arr));

		// create graph (w.r.t finishing time)
		rgraph.clear();
		for (int[] pair : pairs) {
			if (!rgraph.containsKey(order_arr[pair[0]])) {
				rgraph.put(order_arr[pair[0]], new ArrayList<Integer>());
			}
			rgraph.get(order_arr[pair[0]]).add(order_arr[pair[1]]);
		}
		System.out.println("New graph: " + rgraph);

		// traverse graph and find leaders i.e SCC
		leaders = new ArrayList<>();
		isStep1 = false;
		dfs_loop(rgraph);
		System.out.println("SCC leaders: " + leaders);

	}

	public static void dfs_loop(Map<Integer, ArrayList<Integer>> rgraph) {
		visited = new boolean[NODES + 1];
		finishing_time = 0;
		order_arr = new int[NODES + 1]; // labels from 1 to 9

		for (int i = NODES; i > 0; --i) {
			if (!visited[i]) {
				if (!isStep1) leaders.add(i);
				dfs(rgraph, i);
			}
		}
	}

	public static void dfs(Map<Integer, ArrayList<Integer>> graph, int vertex) {
		visited[vertex] = true;
		for (int edge : graph.get(vertex)) {
			if (!visited[edge]) {
				dfs(graph, edge);
			}
		}
		if (isStep1) {
			finishing_time++;
			order_arr[vertex] = finishing_time;
		}
	}
}