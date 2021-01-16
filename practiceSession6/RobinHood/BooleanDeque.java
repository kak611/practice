import java.util.*;

// https://leetcode.com/discuss/interview-question/788264/Robinhood-or-OA-New-Grad
class BooleanDeque {
	public static void main(String[] args) {
		// int n = 10;
		// String[] arr = {"L", "L", "C0", "L", "C3"};

		int n = 2;
		String[] arr = {"L", "L", "L", "C1"};

		// String result = booleanDeque(n, arr);
		String result = booleanDeque2(n, arr);
		System.out.println("Result: " + result);
	}

	// using TreeSet
	public static String booleanDeque2(int n, String[] arr) {
		int[] res = new int[n];
		TreeSet<Integer> set = new TreeSet<>();
		int i = 0;
		while (i < n) set.add(i++);

		int index = 0; 
		for (String s : arr) {
			if (s.equals("L")) {
				if (set.isEmpty()) continue;
				index = set.pollFirst();
				res[index] = 1;
			} else {
				index = s.charAt(1) - '0';
				res[index] = 0;
				set.add(index); 
			}
		}

		return Arrays.toString(res);
	}		

	// using min heap
	public static String booleanDeque(int n, String[] arr) {		
		int[] res = new int[n];		

		PriorityQueue<Integer> pq = new PriorityQueue<>(n); // indexes
		int i = 0;
		while (i < n) pq.add(i++);
		// System.out.println("pq: " + pq);

		for (String s : arr) {
			if (s.equals("L")) {
				// System.out.println("pq.peek() : " + pq.peek());
				if (!pq.isEmpty()) res[pq.poll()] = 1;
			} else {
				int indx = s.charAt(1) - '0';
				res[indx] = 0;
				if (pq.isEmpty() || indx < pq.peek()) pq.add(indx);
			}
		}
		
		return Arrays.toString(res);
	}
}