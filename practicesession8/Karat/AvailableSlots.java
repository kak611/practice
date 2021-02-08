import java.util.*;

class AvailableSlots {
	public static void main(String[] args) {
		int[][] p1 = {{815, 900}, {1230, 1350}, {1500, 1600}, {2300, 2400}};
		int[][] p2 = {{1015, 1130}, {0000, 745}, {1615, 1630}, {2250, 2320}};
		int[][] p3 = {{830, 915}, {150, 415}, {430, 520}, {1400, 1500}};

		List<int[][]> schedule1 = new ArrayList(Arrays.asList(p1, p2, p3));
		List<int[][]> schedule2 = new ArrayList(Arrays.asList(p1, p3));
		List<int[][]> schedule3 = new ArrayList(Arrays.asList(p3, p2));

		List<int[][]> result1 = findAvailableTimes(schedule1);
		System.out.println("\nResult1: ");
		for (int[][] r : result1) System.out.println(Arrays.deepToString(r));

		List<int[][]> result2 = findAvailableTimes(schedule2);
		System.out.println("\nResult2: ");
		for (int[][] r : result2) System.out.println(Arrays.deepToString(r));


		List<int[][]> result3 = findAvailableTimes(schedule3);
		System.out.println("\nResult3: ");
		for (int[][] r : result3) System.out.println(Arrays.deepToString(r));
	}

	public static List<int[][]> findAvailableTimes(List<int[][]> schedule) {
		PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) {
					return Integer.compare(a[1], b[1]);
				}
				return Integer.compare(a[0], b[0]);
			}
		});

		for (int[][] meetings : schedule) {
			for (int[] meeting : meetings) {
				pq.add(meeting);
			}
		}

		if (pq.isEmpty()) return new ArrayList<>();
		List<int[]> res = new ArrayList<>();
		
		int[] curr = {0000,0000};
		while (!pq.isEmpty()) {
			// System.out.println(Arrays.toString(pq.peek()));
			if (pq.peek()[0] > curr[1]) {
				res.add(new int[] {curr[1], pq.peek()[0]});
				curr = pq.poll();
			} else {
				curr[1] = Math.max(curr[1], pq.poll()[1]);
			}
		}

		List<int[][]> result = new ArrayList<>();
		result.add(res.toArray(new int[res.size()][]));

		return result;
	}
}