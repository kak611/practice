import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class SubArrayMaxSum {
	public static void main(String[] args) {
		//Integer[] arr = {904, 40, 523, 12, -335, -385, -124, 481, -31};		
		//Integer[] arr = {1,2,3,4};
		Integer[] arr = {6, -1, -5, 2, 8, -4, 9, -3, 2};		
		//Integer[] arr = {-2, 6, 1, -1, 3, -7, 9, -5, 1, -4, 18, -8};		

		// method 1 -- brute-force O(n^2)
		Indices indices = getMaxSumIndices1(Arrays.asList(arr));
		System.out.println("Brute force method  :  " + indices);

		// method 2	-- divide and conquer O(nlogn)
		Indices indices2 = getMaxSumUsingDivideConquer(Arrays.asList(arr));
		System.out.println("Divide and conquer  :  " + indices2);

		// method 3 -- dynamic programming O(n)
		Indices indices3 = getMaxSumUsingDP(Arrays.asList(arr));
		System.out.println("Dynamic programming :  " + indices3);
	}

	public static Indices getMaxSumUsingDP(List<Integer> list) {
		if (list.size() == 0) return new Indices(-1, -1, -1);

		int sum = 0;
		Indices minSum = new Indices(-1, -1, 0);	// dont use (-1, -1, Integer.MAX_VALUE) see below note
		Indices maxSum = new Indices(-1, -1, 0);	// dont use (-1, -1, Integer.MIN_VALUE) see below note

		// if list contains only one value say 904
		//	sum = 904,
		// 	min = compare(904, MAX_VALUE) = 904,
		// 	max = compare(904-904, MIN_VALUE) = compare(0, MIN_VALUE) = 0
		// 	the output of maxSum will be 0 instead of 904

		//	therefore, initialize minSum = maxSum = 0;
		//	min = compare(904, 0) = 0
		//  max = compare (904-0, 0) = 904
		// 	maxSum = 904

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);			
			if (sum < minSum.val) {
				minSum.val = sum;
				minSum.i = 0;  // minSum = sum of s[0..i]
				minSum.j = i;
			}
			System.out.println("minSum: " + minSum);

			// s[i] - s[k] where 0..k sum is min. s[0..i] - s[0..k] = s[k+1, i]
			if (sum - minSum.val > maxSum.val) {
				maxSum.val = sum - minSum.val;
				maxSum.i = minSum.j + 1; // next index after k
				maxSum.j = i;
			}
			System.out.println("maxSum: " + maxSum);
		}
		return maxSum;
	}





















	public static Indices getMaxSumUsingDivideConquer(List<Integer> list) {
		return getMaxSumUsingDivideConquer(list, 0, list.size()-1);
	}

	 public static Indices getMaxSumUsingDivideConquer(List<Integer> list, int start, int end) {
	 	if (start > end) return new Indices(-1, -1, -1);
	 	if (start == end) return new Indices(start, end, list.get(start)); // if only one index is start as well as end then it might go in infinite loop

	 	int mid = start + (end - start)/2;
	 	// max_l & max_r are required for comparing with new sum and updating
	 	Indices max_l = getMaxSumUsingDivideConquer(list, start, mid);	// if index = start = mid, then it might go in infinite loop here
	 	Indices max_r = getMaxSumUsingDivideConquer(list, mid+1, end);

	 	// calculate sum of left subarray
	 	int i = start, j = mid, sum = 0;
	 	while (i <= j) {
	 		sum += list.get(i++);
	 	}

	 	if (sum > max_l.val) {
	 		max_l.val = sum;
	 		max_l.i = start;
	 		max_l.j = mid;
	 	}
	 	//System.out.println("max_l: " + max_l);

	 	// calculate sum of right subarray
	 	i = mid+1; j = end; sum = 0;
	 	while (i <= j) {
	 		sum += list.get(i++);	 		
	 	}
	 	if (sum > max_r.val) {
	 		max_r.val = sum;
	 		max_r.i = mid+1;	// not giving the smallest subarray indices for maxSum (0,6) instead of (3,6) for {6, -1, -5, 2, 8, -4, 9, -3, 2}
	 		max_r.j = end;
	 	}
	 	//System.out.println("max_r: " + max_r);

	 	// calculate cross sum for left subarray
	 	//Indices max_l_cross_sum = getCrossSum(list, start, mid);
	 	Indices max_l_cross_sum = new Indices(-1, -1, Integer.MIN_VALUE);	// doesnt matter here if its Integer.MIN_VALUE or 0
	 	sum = 0;
	 	int l=start, r = mid;
	 	while (r >= l) {
	 		sum += list.get(r);
	 		if (sum > max_l_cross_sum.val) {
	 			max_l_cross_sum.val = sum;
	 			max_l_cross_sum.i = r;
	 			max_l_cross_sum.j = mid; // end of left sub-array	(this step is not required as in next step we will add left & right cross sum) 	
	 		}
	 		r--;
	 	}

	 	// calculate cross sum for right subarray
	 	// Indices max_r_cross_sum = getCrossSum(list, mid+1, end);
	 	Indices max_r_cross_sum = new Indices(-1, -1, Integer.MIN_VALUE);	// doesnt matter here if its Integer.MIN_VALUE or 0
	 	sum = 0; l = mid+1; r = end;
	 	while (l <= end) {
	 		sum += list.get(l);
	 		if (sum > max_r_cross_sum.val) {
	 			max_r_cross_sum.val = sum;
	 			max_r_cross_sum.i = mid+1; // start of right sub-array  (this step is not required as in next step we will add left & right cross sum)
	 			max_r_cross_sum.j = l;
	 		}
	 		l++;
	 	}

	 	Indices cross_sum = new Indices(max_l_cross_sum.i, max_r_cross_sum.j, (max_l_cross_sum.val + max_r_cross_sum.val));

	 	// reusing same variable instead of creating new
	 	max_l = (max_l.val >= max_r.val) ? max_l : max_r;

	 	max_l = (max_l.val >= cross_sum.val) ? max_l : cross_sum;

	 	return max_l;
	 }
	  








	// max sum using iterative method o(n^3)
	public static Indices getMaxSumIndices1(List<Integer> arr) {
		Indices result = new Indices();
		int startInd = -1;
		int endInd = -1;		
		int sum = 0;

		// subarray starting with i
		for (int i=0; i<arr.size(); i++) {
			// subarray ending with j
			for (int j=i; j < arr.size(); j++) {
				List<Integer> temp = arr.subList(i, j+1);
				//System.out.println(temp);
				sum = 0;
				// traverse arraylist
				for (int k=0; k < temp.size(); k++) {
					sum += temp.get(k);
				}
				if (Integer.compare(sum, result.val) >= 0) {
					result.val = sum;	
					result.i = i;
					result.j = j;
				}
			}
		}
		return result;
	}



	// all variables must be private
	static class Indices {
		int i;
		int j;
		int val = Integer.MIN_VALUE;

		Indices() {}

		Indices(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}

		public String toString() {
			return this.i + ", " + this.j + "  max: " + this.val;
		}
	}
}