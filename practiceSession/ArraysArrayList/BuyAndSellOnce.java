import java.util.Arrays;

class BuyAndSellOnce {
	public static void main(String[] args) {
		int[] arr = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		//int[] arr = {12, 11, 13, 9, 12, 8, 14, 13, 15};
		
		int result1 = maxProfit(arr);
		System.out.println("Max profit once: " + result1);

		int result2 = maxProfitTwice(arr);
		System.out.println("Max profit twice: " + result2);

		int result3 = maxProfitNtimes(arr);
		System.out.println("Max profit n times: " + result3);

		
	}

	public static int maxProfitNtimes(int[] arr) {
		int maxProfit = 0; int val;
		for (int i=1 ; i < arr.length; i++) {			
			val = arr[i-1];
			while (i < arr.length && arr[i] >= arr[i-1]) i++;
			maxProfit += arr[i-1] - val;
		}		
		return maxProfit;
	}


	public static int maxProfitTwice(int[] arr) {
		int[] profitPerDay = new int[arr.length];
		int max = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i=0; i < arr.length; i++) {			
			max = Math.max(max, arr[i] - minPrice);		
			profitPerDay[i] = max;
			minPrice = Math.min(minPrice, arr[i]);
		}
		// System.out.println(Arrays.toString(profitPerDay));

		max = 0;
		int maxPrice = Integer.MIN_VALUE;
		for (int i = arr.length-1; i>0; --i) {
			maxPrice = Math.max(maxPrice, arr[i]);			
			max = Math.max(max, (maxPrice - arr[i]) + profitPerDay[i-1]);			
		}
		return max;
	}


	public static int maxProfit(int[] arr) {
		int[] temp = new int[arr.length];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int val = arr[0];

		for (int i=1; i< arr.length; i++) {
			if (arr[i] >= val) {
				max = Math.max(max, arr[i]-val);
				temp[i] = max;
			} else {
				val = arr[i];
			}			
		}
		// System.out.print(Arrays.toString(temp));

		return max;
	}
}