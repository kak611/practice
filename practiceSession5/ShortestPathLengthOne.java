import java.util.*;

class ShortestPathLengthOne {
	static Map<Character,Integer> distances;
	public static void main(String[] args) {
		// s -> a, s-> b, a->c, b->c, b->d, c->d, c->e, d->e
		// distance from s: s -> 0, a -> 1, b -> 1, c -> 2, d -> 2, e -> 3

		/*

		*/
		char[] vertices = {'s', 'a', 'b', 'c', 'd', 'e'};
		char[][] edges = {{'s', 'a'}, {'s', 'b'}, {'a', 'c'}, {'b', 'c'}, {'b', 'd'}, {'c', 'd'}, {'c', 'e'}, {'d', 'e'}};

		// create graph
		Map<Character, ArrayList<Character>> graph = new HashMap<>();
		for (char v : vertices) {
			graph.put(v, new ArrayList<Character>());
		}
		for (char[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		distances = new HashMap<>();
		findDistanceFromS(graph, 's', vertices);

		System.out.println("Distance from S to each vertex: " + distances);
	}

	public static void findDistanceFromS(Map<Character, ArrayList<Character>> graph, char c, char[] vertices) {
		Deque<Char> queue = new LinkedList<>();
		queue.add(new Char(c, 0));
		boolean[] visited = new boolean[26];

		while (!queue.isEmpty()) {
			// int size = queue.size();
			// for (int i = 0; i < size; i++) {
				Char u = queue.poll();
				if (visited[u.c - 'a']) continue;
				distances.put(u.c, u.dist);
				for (char v : graph.get(u.c)) {
					queue.add(new Char(v, u.dist + 1));
				}				
				visited[u.c - 'a'] = true;
			// }			
		}

		System.out.println(distances);
	}

	static class Char {
		char c;
		int dist;  // level

		public Char(char c, int dist) {
			this.c = c;
			this.dist = dist;
		}
	}
}