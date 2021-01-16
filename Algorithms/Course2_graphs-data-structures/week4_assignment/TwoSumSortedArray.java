import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class TwoSumSortedArray {
	static int minRange;
	static int maxRange;
	static List<List<Long>> result;
	static int cnt;
	public static void main(String[] args) throws FileNotFoundException {
		// range -10000 to 10000
		File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/week4_assignment/2sum.txt");
		minRange = -10000;
		maxRange = 10000;

		// range 5-10
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/week4_assignment/sample1.txt");
		// minRange = 5;
		// maxRange = 10;

		// range 3-8
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/week4_assignment/sample2.txt");
		// minRange = 3;
		// maxRange = 8;


		Scanner scanner = new Scanner(file);

		List<Long> list = new ArrayList<>();		
		while (scanner.hasNextLong()) {			
			list.add(scanner.nextLong());
		}

		result = new ArrayList<>();
		cnt = 0;

		
		Collections.sort(list);
		// System.out.println("Sorted! " + list.size());
		// System.out.println(list);

		long start = System.nanoTime();
		findTargets(list);
		long end = System.nanoTime();
		System.out.println("time: " + (end - start));

		// System.out.println("Result: " + result);
		System.out.println("Result: " + cnt);
	}

	public static void findTargets(List<Long> list) {
		int left = 0;
		int right = list.size() - 1;
		Set<Long> sumCovered = new HashSet<>();

		while (left < right) {

			// ignore duplicates
			while (left < list.size() - 1 && list.get(left) == list.get(left + 1)) left++;
			while (right > 0 && list.get(right) == list.get(right - 1)) right--;			

			// ignore out of range						
			while (right >= 0 && (list.get(left) + list.get(right)) > maxRange) right--;
			while (left < list.size() && (list.get(left) + list.get(right)) < minRange) left++;
			
			// System.out.println("left: " + left + ", right: " + right);
			if (left >= list.size() || right < 0) return;


			// iterate j and check with each i
			int i = left;
			int j = right--;

			while (i < j) {
				long num1 = list.get(i);
				long num2 = list.get(j);
				long sum = num1 + num2;
				if (sum < minRange || sum > maxRange) break;
				if (!sumCovered.contains(sum)) {
					sumCovered.add(sum);
					// result.add(Arrays.asList(num1, num2));
					cnt++;
				}
				i++;		
			}
		}
	}
}