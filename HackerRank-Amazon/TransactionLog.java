// https://leetcode.com/discuss/interview-question/989768/Amazon-or-OA-2020-or-Transaction-logs

import java.util.*;

class TransactionLog {
	public static void main(String[] args) {
		String[] logs = {"345366 89921 45", "029323 38239 23", "38239 345366 15", "029323 38239 77", "345366 38239 23", "029323 345366 13", "38239 38239 23"};
		int threshold = 3;

		Integer[] result = findUsersCrossingThreshold(logs, threshold);
		System.out.println(Arrays.toString(result));
	}

	public static Integer[] findUsersCrossingThreshold(String[] logs, int threshold) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (String log : logs) {
			String[] arr = log.split(" ");
			int val = Integer.parseInt(arr[0]);
			// int val = getInt(arr[0]);
			int cnt = map.getOrDefault(val, 0);
			map.put(val, cnt + 1);

			if (!arr[1].equals(arr[0])) {
				val = Integer.parseInt(arr[1]);
				// val = getInt(arr[0]);
				cnt = map.getOrDefault(val, 0);
				map.put(val, cnt + 1);
			}
		}

		List<Integer> result = new ArrayList<>();
		for (Integer key : map.keySet()) {
			if (map.get(key) >= threshold) result.add(key);
		}

		return result.toArray(new Integer[result.size()]);
	}

	public static int getInt(String s) {
		int num = 0;
		for (char c : s.toCharArray()) {
			num *= 10;
			num += (c - '0');
		}

		return num;
	}
}