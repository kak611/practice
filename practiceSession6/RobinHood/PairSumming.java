import java.util.*;

// https://leetcode.com/discuss/interview-question/808272/Robinhood-OA
// https://www.geeksforgeeks.org/number-of-pairs-whose-sum-is-a-power-of-2/
// Question: count all the pairs with indices i<=j whose sum is a power of 2.

class PairSumming {
	public static void main(String[] args) {
		int arr[] = {1, -1, 2, 3};
		List<int[]> result = findPairs(arr);
		for (int[] a : result) {
			System.out.print("[" + a[0] + ", " + a[1] + "] ");
		}
	}

	public static List<int[]> findPairs(int[] arr) {
		List<int[]> result = new ArrayList<>();

		/* 
			1. sort the array using treemap with value as occurrences
			2. for each element, find the next higher element (target) which is power of two
			3. Using two-sum technique, find the pair
			4. use the occurrences < 1 to mark element visited
		*/

		TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
			public int compare(Integer n1, Integer n2) {				
				return (n1 == n2) ? 0 : (n1 > n2) ? -1 : 1;  // sort in desc order so that maximum pairs are found
			}
		});
		for (int n : arr) {
			map.putIfAbsent(n, 0);
			map.put(n, map.get(n) + 1);
		}

		System.out.println(map);

		int target = 1;
		for (int val : map.keySet()) {
			if (map.get(val) < 1) continue; // i visited

			target = 1;
			while (target <= val) {
				target <<= 1;  // power of two contains only one bit
			}

			System.out.println("val: " + val + ", target: " + target);

			// two sum logic
			if (map.containsKey(target -  val)) {
				if(map.get(target - val) < 1) continue; // j visited
				if (target - val == val && map.get(val) == 1) continue; // same number and distinct
				result.add(new int[] {target - val, val}); // i <= j

				map.put(target - val, map.get(target - val) - 1); // decrement count of i in pair (i, j)
				map.put(val, map.get(val) - 1); // decrement occurrence count of j in pair (i, j)
			}
		}

		return result;
	}
}