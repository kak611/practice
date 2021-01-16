import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;


class ShortestPath2 {
	public static final int CAPACITY = 16;
	public static final int NODES = 6;
	static int[] shortestDistance;
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week2_assignment/sample.txt");
		Scanner scanner = new Scanner(file);

		// graph
		Map<Integer, ArrayList<Node>> graph = new HashMap<>();
		for (int i = 1; i <= NODES; i++) {
			graph.put(i, new ArrayList<Node>());
		}
		while (scanner.hasNextLine()) {
			String[] strings = scanner.nextLine().split("\\s");			
			int v = Integer.parseInt(strings[0]);
			for (int i = 1; i < strings.length; i++) {
				int u = Integer.parseInt(strings[i].split(",")[0]);
				int len = Integer.parseInt(strings[i].split(",")[1]);
				graph.get(v).add(new Node(u, len));
			}
		}
		// System.out.println(graph);
		shortestDistance = new int[NODES + 1];
		Arrays.fill(shortestDistance, Integer.MAX_VALUE);
		findShortestPath(graph, 1);

		System.out.println(Arrays.toString(shortestDistance));
	}

	public static void findShortestPath(Map<Integer, ArrayList<Node>> graph, int vertex) {
		shortestDistance[vertex] = 0;
		boolean[] settled = new boolean[NODES + 1];
		PriorityQueue<Node> pq = new PriorityQueue(CAPACITY, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return Integer.compare(shortestDistance[n1.vertex], shortestDistance[n2.vertex]);
			}
		});

		pq.add(new Node(vertex, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int u = node.vertex;

			for (Node n : graph.get(u)) {
				if (settled[n.vertex]) continue;
				if (shortestDistance[u] + n.length < shortestDistance[n.vertex]) {
					shortestDistance[n.vertex] = shortestDistance[u] + n.length;
					pq.add(n);
				}
			}
			settled[u] = true;
		}
	}

	static class Node {
		int vertex;
		int length;

		public Node(int vertex, int length) {
			this.vertex = vertex;
			this.length = length;
		}

		public String toString() {
			return vertex + "-" + length;
		}
	}
}