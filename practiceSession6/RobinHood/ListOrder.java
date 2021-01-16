import java.util.*;

// https://leetcode.com/discuss/interview-question/838957/Robinhood-OA
class ListOrder {
	public static void main(String[] args) {
		int[][] pairs = {{3,5}, {1,4}, {2,4}, {1,5}};
		Integer[] arr = restoreOrder(pairs);
		System.out.println("Resorted order: " + Arrays.toString(arr));
	}

	public static Integer[] restoreOrder(int[][] pairs) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		// undirected graph
		for (int[] pair : pairs) {
			map.putIfAbsent(pair[0], new ArrayList<>());
			map.putIfAbsent(pair[1], new ArrayList<>());
			map.get(pair[0]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);
		}

		int num = -1;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 1) {
				num = entry.getKey();
				break;
			}
		}

		List<Integer> res = new ArrayList<>();
		dfs(map, num, res, new HashSet<Integer>());			

		return res.toArray(new Integer[res.size()]);
	}

	public static void dfs(Map<Integer, List<Integer>> graph, int num, List<Integer> res, HashSet<Integer> visited) {
		if (visited.contains(num)) return;
		visited.add(num);

		for (int n : graph.get(num)) {
			dfs(graph, n, res, visited);
		}

		res.add(num);
	}
}