// https://leetcode.com/discuss/interview-question/983856/Amazon-or-OA-or-Five-Star-Sellers

import java.util.*;

class FiveStarSeller {
	public static void main(String[] args) {
		int totalProducts = 3;
		int[][] productRatings = {{4,4}, {1,2}, {3,6}};
		int percentageThreshold = 77;

		int result = findMinAdditionalFiveStar(productRatings, percentageThreshold, totalProducts);
		System.out.println("Result: " + result);
	}

	public static int findMinAdditionalFiveStar(int[][] productRatings, int threshold, int totalProducts) {
		PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
			public int compare(Data d1, Data d2) {
				return Double.compare(d1.diff, d2.diff);
			}
		});

		double total = 0.0;
		double percentage = 0.0;
		double incrementalPercentage = 0.0;

		for (int i = 0; i < productRatings.length; i++) {
			percentage = getPercentage(productRatings[i]);
			incrementalPercentage = getIncrementalPercentage(productRatings[i]);
			total += percentage;

			// adding negative difference because in case of 4/4 => diff is 0 and it will always be on top of heap.
			// to avoid that, get negative difference so lowest diff appears first
			pq.add(new Data((percentage - incrementalPercentage), i));
		}

		
		double grandPercentage = (total/totalProducts) * 100;
		// System.out.println(pq + ", grandPercentage: " + grandPercentage);

		int result = 0;
		while (grandPercentage < threshold) {
			Data d = pq.poll();
			// System.out.println("d.index: " + d.index);
			int[] arr = productRatings[d.index];
			arr[0] += 1;
			arr[1] += 1;
						
			total -= d.diff; // equivalent to (total = total - percentage + incrementalPercentage)
			grandPercentage = (total/totalProducts) * 100;
			// System.out.println(pq + ", grandPercentage: " + grandPercentage);

			pq.add(new Data((getPercentage(arr) - getIncrementalPercentage(arr)), d.index));
			result++;
		}

		return result;
	}

	private static double getPercentage(int[] arr) {
		// note: typecasting is done for numerator and not to whole division
		return ((double)arr[0]/(double)arr[1]);
	}

	private static double getIncrementalPercentage(int[] arr) {
		// note: typecasting is done for numerator and not to whole division
		// System.out.println("[" + arr[0] + ", " + arr[1] + "] : " + ((double)arr[0] + 1)/(double)(arr[1] + 1));
		return ((double)arr[0] + 1)/(double)(arr[1] + 1);
	}

	static class Data {
		double diff;
		int index;

		public Data(double diff, int index) {
			this.diff = diff;
			this.index = index;
		}

		public String toString() {
			return "diff: " + this.diff + ", index: " + index;
		}
	}
}