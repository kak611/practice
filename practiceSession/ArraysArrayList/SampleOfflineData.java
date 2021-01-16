import java.util.*;

class SampleOfflineData {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 5, 7, 11, 20, 9, 15, 17);
		int size = 3;
		randomSampling_r(0, size, list);
		randomSampling_i(size, list);
	}

	// recursive
	public static void randomSampling_r(int i, int k, List<Integer> list) {
		// System.out.println("i = " + i);
		if (i == k) {
			// System.out.println("Random subset of size " + k + ": " + list.subList(0, k));
			System.out.println("Subset (Recursively): " + list.subList(0, k));
			return;
		}
		Random random = new Random();
		int randomIndex = random.nextInt(list.size() - i) + i; // dont add 1 to exclude size from set of possible indexes 0...size()-1
		// System.out.println("Before swap: " + list);
		Collections.swap(list, i, randomIndex);
		// System.out.println("After swap with index=" + randomIndex + ": " + list);
		randomSampling_r(i+1, k, list);
	}


	// iterative
	public static void randomSampling_i(int k, List<Integer> list) {
		Random random = new Random();
		for (int i=0; i < k; i++) {
			// [1,2,3,4]			
			Collections.swap(list, i, i + random.nextInt(list.size() - i));
		}
		System.out.println("Subset (Iteratively): " + list.subList(0, k));
	}
}