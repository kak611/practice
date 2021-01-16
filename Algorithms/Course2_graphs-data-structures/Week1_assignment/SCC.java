import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.PriorityQueue;
import java.util.Collections;

import java.io.File;
import java.io.FileNotFoundException;

class SCC {

	// public static int NODES = 9;
	public static int NODES = 875714;
		
	static Map<Integer, ArrayList<Integer>> graph; 
	static boolean[] visited;
	static int t;
	static int[] finish_order;
	static boolean isFindLeader;
	static List<Integer> leaders;
	static PriorityQueue<Integer> pq;
	static int size;

	public static void main(String[] args) throws FileNotFoundException {		
		graph = new HashMap<>();
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week1_assignment/sample.txt"); // 9 NODES		
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week1_assignment/sample2.txt"); // 12 NODES
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week1_assignment/sample3.txt"); // 8 NODES
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week1_assignment/sample4.txt"); // 8 NODES
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week1_assignment/sample5.txt"); // 8 NODES
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week1_assignment/sample6.txt"); // 9 NODES
		File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week1_assignment/SCC.txt");
		Scanner scanner = new Scanner(file);

		int col1 = 0;
		int col2 = 0;

		/* step 1 : find finishing order by traversing reverse graph */
		// create reverse graph		
		while (scanner.hasNextInt()) {
			if (scanner.hasNextInt()) col1 = scanner.nextInt();
			if (scanner.hasNextInt()) col2 = scanner.nextInt();
			if (!graph.containsKey(col2)) {
				graph.put(col2, new ArrayList<>());
			}
			graph.get(col2).add(col1);
		}		
		
		t = 0;
		finish_order = new int[NODES + 1]; // label starting from 1 to NODES
		isFindLeader = false;
		dfs_loop(graph);
		// System.out.println("Finishing time: " + Arrays.toString(finish_order));



		/* step 2: find SCC leaders and size of each SCC using new graph constructed using finish_order */
		// create graph using finishing order
		graph.clear();
		scanner = new Scanner(file);
		while (scanner.hasNextInt()) {
			if (scanner.hasNextInt()) col1 = scanner.nextInt();
			if (scanner.hasNextInt()) col2 = scanner.nextInt();			

			if (!graph.containsKey(finish_order[col1])) {
				graph.put(finish_order[col1], new ArrayList<Integer>());				
			}
			graph.get(finish_order[col1]).add(finish_order[col2]);
		}
		// System.out.println("Graph: " + graph);
		isFindLeader = true;
		leaders = new ArrayList<Integer>();
		pq = new PriorityQueue<Integer>(5);
		size = 0;
		dfs_loop(graph);

		// System.out.println("Leaders: " + leaders);		
		System.out.println("sizeOfSCC: " + pq);

	}

	public static void dfs_loop(Map<Integer, ArrayList<Integer>> graph) {
		visited = new boolean[NODES + 1];
		for (int i = NODES; i > 0; --i) {
			if (!visited[i]) {
				if (isFindLeader) {
					leaders.add(i);
					size = 1;
				}
				dfs(graph, i);
				if (isFindLeader) {
					pq.add(size);
					if (pq.size() > 5) pq.poll();
				}
			} 
		}
	}

	public static void dfs(Map<Integer, ArrayList<Integer>> graph, int vertex) {
		visited[vertex] = true;
		if (graph.containsKey(vertex)) {
			for (int edge : graph.get(vertex)) {				
				if (!visited[edge]) {
					if (isFindLeader) size++;
					dfs(graph, edge);
				}
			}
		}		
		if (!isFindLeader) finish_order[vertex] = ++t;		
	}
}