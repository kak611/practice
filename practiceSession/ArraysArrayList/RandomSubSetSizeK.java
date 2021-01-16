import java.util.*;

class RandomSubSetSizeK {
	public static void main(String[] args) {
		final int n = 100;
		final int k = 4;
		List<Integer> result = randomSubset(n, k);
		System.out.println("Random Subset of size " + k + ": " + result);						
	}

	public static List<Integer> randomSubset(int n, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Random random = new Random();

		for (int i=0; i < k; i++) {
			Integer randomIndex = random.nextInt(n - i) + i;
			Integer ptr1 = map.get(randomIndex);
			Integer ptr2 = map.get(i);

			if (ptr1 == null && ptr2 == null) {
				map.put(i, randomIndex);
				map.put(randomIndex, i);
			} else if (ptr1 == null && ptr2 != null) {
				map.put(randomIndex, ptr2);
				map.put(i, randomIndex);
			} else if (ptr1 != null && ptr2 == null) {
				map.put(randomIndex, i);
				map.put(i, ptr1);
			} else {
				map.put(i, ptr1);
				map.put(randomIndex, ptr2);
			}
		}

		System.out.println(map);
		List<Integer> result = new ArrayList<>(k);
		for (int i=0; i < k; i++) {
			result.add(map.get(i));
		}

		return result;
	}
}