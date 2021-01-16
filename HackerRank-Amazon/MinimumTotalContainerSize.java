/*
	https://aonecode.com/Amazon-Online-Assessment-Minimum-Total-Container-Size

	You want to move N items in k days (N >= k). You have to move atleast one item
	per day.
	The items are listed in array P, where P[i] is size of item i.
	You can move item i only if all items from 0 to [i-1] are already moved.

	Everyday you need a container to pack the item and move it. The container size
	needed for day i is the maximum item size moved on that day.
	Given k days and array P as the item sizes, find out the minimum total container
	size required to move all the items.

	input
	P = [10,2,25,5,15,10,1]
	d = 3
	output
	31
	day 1 - [10,2,20,5,15]. ContainerSize = 20
	day 2 - [10]. ContainerSize = 10
	day 3 - [1]. ContainerSize = 1
	Total = 20 + 10 + 1 = 31

	input
	P = [10,2,25,5,15,10,1]
	d = 5
	output
	43
	day 1 - [10]. ContainerSize = 10
	day 2 - [2]. ContainerSize = 2
	day 3 - [20, 5, 15]. ContainerSize = 20
	day 4 - [10]. ContainerSize = 10
	day 5 - [1]. ContainerSize = 1
	Total = 10 + 2 + 20 + 10 + 1 = 43

	input
	P = [5,4,2,4,3,4,5,4]
	d = 4
	output
	16

	input
	P = [22,12,1,14,17]
	d = 2
	output
	39

*/

import java.util.*;

class MinimumTotalContainerSize {
	public static void main(String[] args) {
		// int[] P = {10,2,20,5,15,10,1};
		// int d = 3;

		// int[] P = {10,2,20,5,15,10,1};
		// int d = 5;

		// int[] P = {5,4,2,4,3,4,5,4};
		// int d = 4;

		int[] P = {22,12,1,14,17};
		int d = 2;

		if (d > P.length) {
			// atleast one item should be moved per day
			System.out.println("number of days should be <= number of items");
			return;
		}

		// find minumum container size
		int result = findMinimumSize(P, d);
		System.out.println("Output: " + result);
	}

	// sliding window
	public static int findMinimumSize(int[] arr, int d) {
		// sliding window (container) size
		int k = arr.length - d + 1;   // number of items - number of days + 1
		Deque<Integer> queue = new LinkedList<>();
		Deque<Integer> currMax = new LinkedList<>();
		int startIndex = 0;
		int endIndex = k-1;		
		int maxContainerSum = 0;
		// int maxInContainer = 0;

		// initialize queue
		int index = 0;
		int total = 0;
		while (index < k) {
			queue.add(index);
			total += arr[index];
			// maxInContainer = Math.max(maxInContainer, arr[index]);

			while (!currMax.isEmpty() && arr[currMax.peekLast()] < arr[index]) currMax.removeLast();
			currMax.add(index);
			// maxInContainer = currMax.peekFirst();

			index++;
		}
		// System.out.println(total);
		maxContainerSum = Math.max(maxContainerSum, total);

		// find maxInContainer for length k
		for (int i = k; i < arr.length; i++) {
			total -= arr[queue.peekFirst()];
			queue.removeFirst();

			queue.add(i);
			total += arr[queue.peekLast()];
			// System.out.println(total);

			if (total >= maxContainerSum) {
				maxContainerSum = total;

				// update start and end index of maxSizeContainer
				startIndex = queue.peekFirst();
				endIndex = queue.peekLast();

				/* 
					is there a better way of finding max element in current window in constant time ??
				*/
				// maxInContainer = Math.max(maxInContainer, findMaxInCurrentContainer(new ArrayList<>(queue), arr));

				/* 
					yes, using another sliding window to find max (https://leetcode.com/problems/sliding-window-maximum/)
				*/
				while (!currMax.isEmpty() && currMax.peek() < (i - k + 1)) currMax.removeFirst();
				while (!currMax.isEmpty() && arr[currMax.peekLast()] < arr[i]) currMax.removeLast();
				currMax.add(i);
				// maxInContainer = arr[currMax.peekFirst()];
				// System.out.println(currMax);
			}

		}

		int sum = arr[currMax.peekFirst()];
		for (int i = 0; i < startIndex; i++) sum += arr[i];
		for (int i = endIndex + 1; i < arr.length; i++) sum += arr[i];
		
		return sum;
	}

	public static int findMaxInCurrentContainer(ArrayList<Integer> list, int[] arr) {
		int max = 0;
		for (int num : list) max = Math.max(max, arr[num]);
			// System.out.println("max: " + max);
		return max;
	}
}