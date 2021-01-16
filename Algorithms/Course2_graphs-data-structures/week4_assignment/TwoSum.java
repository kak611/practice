import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class TwoSum {
	static Set<List<Long>> res;
	static Set<Long> used;
	static int cnt;
	static int minRange;
	static int maxRange;
	public static void main(String[] args) throws FileNotFoundException {
		// range -10000 to 10000
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/week4_assignment/2sum.txt");
		// range 5-10
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/week4_assignment/sample1.txt");
		// range 3-8
		File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/week4_assignment/sample2.txt");

		Scanner scanner = new Scanner(file);

		Set<Long> list = new HashSet<>();
		while (scanner.hasNextLong()) {			
			list.add(scanner.nextLong());
		}

		minRange = -10000;
		maxRange = 10000;
		// minRange = 5;
		// maxRange = 10;
		minRange = 3;
		maxRange = 8;

		
		System.out.println("Total numbers: " + list);		
		res = new HashSet<>();
		long start = System.nanoTime();
		used = new HashSet<>();
		cnt = 0;
		findTwoSum(list);		
		long end = System.nanoTime();
		System.out.println("Time in secs: " + (end - start));
		System.out.println("# of sum of numbers between -10000 to 10000: " + res);
	}

	public static void findTwoSum(Set<Long> list) {
		// number : index
		Map<Long, Integer> map = new HashMap<>();		 

		for (int t = minRange; t <= maxRange; t++) {
			Iterator<Long> iter = list.iterator();
			int i = 0;
			while(iter.hasNext()) {
				long num1 = iter.next();
				if (used.contains(num1)) continue;
				long num2 = t - num1;
				if (map.containsKey(num2)) {
					res.add(Arrays.asList(num1, num2));
					cnt++;
					used.add(num1);
					// used.add(num2);
				}
				map.put(num1, i);
				i++;
			}
		}
	}
}