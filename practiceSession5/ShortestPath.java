import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class ShortestPath {
	// Dijktra's shortest path distance
	// Given nodes A - F
	// Edges: A -> B 10, A -> C 15, B -> D 12, B -> F 15, C -> E 10, D -> E 2, D -> F 1, F -> E 5
	public static void main(String[] args) {
		Graph graph = new Graph();
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");

		A.addEdge("B", 10);
		A.addEdge("C", 15);
		B.addEdge("D", 12);
		B.addEdge("F", 15);
		C.addEdge("E", 10);
		D.addEdge("E", 2);
		D.addEdge("F", 1);
		F.addEdge("E", 5);

		graph.addNode(A);
		graph.addNode(B);
		graph.addNode(C);
		graph.addNode(D);
		graph.addNode(E);
		graph.addNode(F);

		// graph.display();
		// calculate shortest distance from A to other nodes
		calculateShortestDistance(graph, A);		
		graph.display();

		graph.displayDistance();
	}

	public static void calculateShortestDistance(Graph graph, Node source) {
		Set<Node> settled = new HashSet<>();
		Set<Node> unsettled = new HashSet<>();

		source.setDistance(0);
		source.getPath().add(source.name);
		unsettled.add(source);		

		while (!unsettled.isEmpty()) {
			Node u = getSmallestDistanceNode(unsettled);
			unsettled.remove(u);

			for (Map.Entry<String, Integer> entry : u.getEdges().entrySet()) {
				Node v = graph.getNode((String)entry.getKey());
				if(!settled.contains(v)) {					
					int length = (int)entry.getValue();
					if ((u.getDistance() + length) < v.getDistance()) {
						v.setDistance((u.getDistance() + length));
						List<String> path = new ArrayList<>(u.getPath());
						path.add(v.name);						
						v.setPath(path);

						unsettled.add(v);
					}
				}
			}
			settled.add(u);
		}
	}

	public static Node getSmallestDistanceNode(Set<Node> unsettled) {
		int minDistance = Integer.MAX_VALUE;
		Node minNode = null;
		for (Node node : unsettled) {
			if (node.distance < minDistance) {
				minDistance = node.distance;
				minNode = node;
			}
		}

		return minNode;
	}

	static class Graph {
		Map<String, Node> nodes;

		public Graph() {
			nodes = new HashMap<>();
		}

		public void addNode(Node node) {
			nodes.put(node.name, node);
		}

		public void display() {
			System.out.println(nodes);
		}

		public void displayDistance() {
			Iterator<String> iter = nodes.keySet().iterator();
			while(iter.hasNext()) {				
				String nodeName = iter.next();				
				System.out.println("Distance of Node " + nodeName + " from A: " + this.getNode(nodeName).getDistance());
				System.out.println("Shortest path: " + this.getNode(nodeName).shortestPath);
			}
		}

		public Node getNode(String name) {
			return nodes.get(name);
		}
	}

	static class Node {
		String name;
		Map<String, Integer> edges;
		int distance;
		List<String> shortestPath;

		public Node(String name) {
			this.name = name;
			edges = new HashMap<String, Integer>();
			distance = Integer.MAX_VALUE;
			shortestPath = new ArrayList<>();
		}

		public void addEdge(String name, int length) {
			this.edges.put(name, length);
		}

		public String toString() {
			return this.name + " " + edges;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		public int getDistance() {
			return this.distance;
		}

		public Map<String, Integer> getEdges() {
			return this.edges;
		}

		public void setPath(List<String> path) {
			this.shortestPath = path;
		}

		public List<String> getPath() {
			return this.shortestPath;
		}



		public void printPath() {
			System.out.println(shortestPath);
		}
	}
}