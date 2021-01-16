import java.util.*;
class RandomPermutation {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 5, 7, 11, 20);
		int size = list.size();
		List<Integer> result = randomPermutation(size, list);
		System.out.println("Random permutation: " + result);
	}

	// iterative
	public static List<Integer> randomPermutation(int k, List<Integer> list) {		
		Random random = new Random();
		for (int i=0; i < k; i++) {
			Collections.swap(list, i, i + random.nextInt(list.size() - i));
		}
		return list;
	}
}