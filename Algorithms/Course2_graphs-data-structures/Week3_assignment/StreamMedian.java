import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class StreamMedian {
	public static final int CAPACITY = 16;
	static PriorityQueue<Integer> maxHeap; // for first half
	static PriorityQueue<Integer> minHeap;  // for second half
	
	public static void main(String[] args) throws FileNotFoundException {
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week3_assignment/sample1.txt");
		// File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week3_assignment/sample2.txt");
		File file = new File("C:/Users/Kaustubh/Documents/Algorithms/Course2_graphs-data-structures/Week3_assignment/Median.txt");
		Scanner scanner = new Scanner(file);
		
		maxHeap = new PriorityQueue<>(CAPACITY, Collections.reverseOrder()); // first half
		minHeap = new PriorityQueue<>(CAPACITY); // second half
		int sumOfMedian = 0;

		while (scanner.hasNextInt()) {
			// System.out.println(scanner.nextInt());
			int nextNum = scanner.nextInt();
			if (maxHeap.isEmpty()) {
				maxHeap.add(nextNum);
			} else {
				if (nextNum > maxHeap.peek()) {
					minHeap.add(nextNum);
				} else {
					maxHeap.add(nextNum);
				}
			}

			// balance
			if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.add(maxHeap.poll());
			}

			if (minHeap.size() > maxHeap.size()) {
				maxHeap.add(minHeap.poll());
			}

			// if ith number is even or odd, the median is the max element in maxHeap.
			sumOfMedian += maxHeap.peek();
			// System.out.println("maxHeap: " + maxHeap);
			// System.out.println("minHeap: " + minHeap);
		}

		int totalSize = maxHeap.size() + minHeap.size();
		int median = sumOfMedian % totalSize;
		System.out.println("TotalSize: " + totalSize + ", sumOfMedian: " + sumOfMedian  + ", Median: " + median);
	}
}