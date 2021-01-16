import java.util.List;
import java.util.ArrayList;

class ReverseGraph {
	public static final int NODES = 9;
	public static void main(String[] args) {
		int[][] pairs = {{1, 5}, {2, 3}, {3, 4}, {4, 5}, {4, 2}, {5, 6}, {6, 9}, {7, 8}, {8, 9}, {9, 7}, {6, 1}};

		// Ajdacency Lists
		List<ArrayList<Integer>> graph = new ArrayList<>();
		List<ArrayList<Integer>> reverseGraph = new ArrayList<>();

		graph.add(0, new ArrayList<>());
		reverseGraph.add(0, new ArrayList<>());
		for (int i = 1; i <= NODES; i++) {
			graph.add(i, new ArrayList<Integer>());
			reverseGraph.add(i, new ArrayList<Integer>());
		}

		for (int[] pair : pairs) {
			graph.get(pair[0]).add(pair[1]);
			reverseGraph.get(pair[1]).add(pair[0]);
		}

		System.out.println("Graph: " + graph);		
		System.out.println("reverseGraph: " + reverseGraph);		

		// Adjacency Matrix
		int[][] mgraph = new int[NODES + 1][NODES + 1];   		// NODES + 1 because nodes are labelled 1 to 9
		int[][] mreverseGraph = new int[NODES + 1][NODES + 1];	// NODES + 1 because nodes are labelled 1 to 9

		for (int[] pair : pairs) {
			mgraph[pair[0]][pair[1]] = 1;
			mreverseGraph[pair[1]][pair[0]] = 1;
		}

		System.out.print("\nGraph:\n");

		for (int i = 1; i <= NODES; i++) {
			for (int j = 1; j <= NODES; j++) {
				System.out.print(mgraph[i][j] + " ");
			}
			System.out.print("\n");
		}

		System.out.print("\nReverse Graph:\n");

		for (int i = 1; i <= NODES; i++) {
			for (int j = 1; j <= NODES; j++) {
				System.out.print(mreverseGraph[i][j] + " ");
			}
			System.out.print("\n");
		}

		// Transpose graph i.e. reverse a given matrix graph
		transpose(mgraph);
	}

	public static void transpose(int[][] mgraph) {
		System.out.print("\nTranspose of Graph (i.e reverseGraph):\n");
		for (int i = 1; i <= NODES; i++) {
			for (int j = 1; j <= NODES; j++) {
				System.out.print(mgraph[j][i] + " ");
			}
			System.out.print("\n");
		}
	}
	
}