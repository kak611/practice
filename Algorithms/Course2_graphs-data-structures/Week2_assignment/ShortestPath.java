import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

import java.io.File;
import java.io.FileNotFoundException;

class ShortestPath {
	public static final int NODES = 6;
	// public static final int NODES = 200;	
	static int[] shortestDistance;	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week2_assignment/sample.txt");
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week2_assignment/dijkstraData.txt");

		Scanner scanner = new Scanner(file);

		// create graph
		List<ArrayList<Node>> graph = new ArrayList<>();
		graph.add(0, null);
		for (int i = 1; i <= NODES; i++) {
			graph.add(new ArrayList<>());
		}
		while(scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split("\\s");			
			int curr = Integer.parseInt(line[0]);
			for (int i = 1; i < line.length; i++) {
				String[] data = line[i].split(",");
				int edge = Integer.parseInt(data[0]);
				int length = Integer.parseInt(data[1]);

				graph.get(curr).add(new Node(edge, length));
			}
		}


		// array of distance from 1 to NODES
		shortestDistance = new int[NODES + 1]; // label from 1
		Arrays.fill(shortestDistance, 1000000);

		// System.out.println(graph);

		calculateShortestPath(graph, 1);
		System.out.println(Arrays.toString(shortestDistance));


		// Assignment requirement -- get shortest distance of 7,37,59,82,99,115,133,165,188,197
		// System.out.println(shortestDistance[7] + "," + shortestDistance[37] + "," +
		// 	shortestDistance[59] + "," + shortestDistance[82] + "," +
		// 	shortestDistance[99] + "," + shortestDistance[115] + "," +
		// 	shortestDistance[133] + "," + shortestDistance[165] + "," +
		// 	shortestDistance[188] + "," + shortestDistance[197]);
	}

	public static void calculateShortestPath(List<ArrayList<Node>> graph, int source) {
		Set<Node> settled = new HashSet<>();
		PriorityQueue<Node> pq = new PriorityQueue<>(NODES+1, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return Integer.compare(shortestDistance[n1.vertex], shortestDistance[n2.vertex]);
			}
		});

		shortestDistance[source] = 0;
		Node node = new Node(source, 0);
		pq.add(node);

		while (!pq.isEmpty()) {
			Node u = pq.poll(); // min heap

			for (Node v : graph.get(u.vertex)) {
				if (!settled.contains(v.vertex)) {
					if (shortestDistance[u.vertex] + v.length < shortestDistance[v.vertex]) {
						shortestDistance[v.vertex] = shortestDistance[u.vertex] + v.length;
						pq.add(v);
					}
				}
			}
			settled.add(u);
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
			return vertex + "_" + length;
		}
	}
}