import java.util.Arrays;

class Fibonacci {
	static int[] cache;
	static final int N = 46;	// max limit of integer
	// how to calculate for number out of range? using string or linkedlist?
	// linkedlist is a good idea!

	public static void main(String[] args) {
		int num = N;
		// int result1 = fibonacciRecursive(num);
		// System.out.println("Fibonacci (r) of " + num + " is " + result1);	
		// int result2 = fibonacciIterative(num);
		// System.out.println("Fibonacci (i) of " + num + " is " + result2);
		int result3 = fibonacciDP(num);
		System.out.println("Fibonacci (dp) of " + num + " is " + result3);

		int n = 10;
		int result4 = getFibonacci(n);
		System.out.println("Fibonacci from cache: " + n + " is " + result4);
	}

	public static int getFibonacci(int num) {
		if (num > N) return -1;
		return cache[num];
	}

	// O(n), O(n)
	public static int fibonacciDP(int num) {
		cache = new int[num+1];
		Arrays.fill(cache, -1);		
		cache[0] = 0;
		cache[1] = 1;		
		// System.out.println(Arrays.toString(cache));
		return fibonacciDPHelper(num, cache);
	}

	private static int fibonacciDPHelper(int num, int[] cache) {
		// System.out.println("num:" + num);
		// System.out.println(Arrays.toString(cache));
		if (cache[num] == -1) {
			cache[num] = fibonacciDPHelper(num-1, cache) + fibonacciDPHelper(num-2, cache);
		}
		return cache[num];
	}

	// O(2^n), O(n)
	public static int fibonacciRecursive(int num) {		
		if (num <= 1) return num;
		return fibonacciRecursive(num-1) + fibonacciRecursive(num-2);
	}

	// O(n), O(1)
	public static int fibonacciIterative(int num) {
		if (num <= 1) return num;		
		int result = 0;
		int fminus1 = 0;
		int fminus2 = 1;

		for (int i = 2; i <= num; i++) {
			result = fminus1 + fminus2;
			fminus1 = fminus2;
			fminus2 = result;
		}
		return result;
	}
}

