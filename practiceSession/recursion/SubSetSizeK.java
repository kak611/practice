import java.util.*;

class SubSetSizeK {
	// also called combinations of size = n!/((n-k!)*k!)
	public static void main(String[] args) {
		int n = 4;
		int k = 3;
		List<List<Integer>> result = combinations(n, k);
		System.out.println("\n\nAll possible combinations of size " + k + " from [1,2,3,4] : ");
		System.out.println(result);
	}

	public static List<List<Integer>> combinations(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		System.out.println("n = " + n + ", k = " + k);
		combinations(n, k, 1, new ArrayList<Integer>(), result);
		return result;
	}

	public static void combinations(int n, int k, int offset, ArrayList<Integer> partialList, List<List<Integer>> result) {
		if (partialList.size() == k) {
			System.out.println(" =========================================================> Final list of size 3: " + partialList);
			result.add(new ArrayList<>(partialList));
			return;
		}

		final int numRemaining = k - partialList.size();
		System.out.println("numRemaining (k - partialList.size()): " + numRemaining);
		System.out.println("=================");
		// this check is not required => numRemaining <= n - i + 1
		for (int i = offset; i <= n && numRemaining <= n - i + 1; ++i) {
			System.out.println("i = " + i + " <= (n=" + n + "), numRemaining: " + numRemaining + " <= (n-i+1)=" + (n-i+1));
			partialList.add(i);
			System.out.println("After adding i: " + partialList);
			System.out.println("calling recursion with (i+1) = " + (i+1));
			combinations(n, k, i + 1, partialList, result);
			partialList.remove(partialList.size() - 1);
			System.out.println("After removing i: " + partialList);
		}
	}
}