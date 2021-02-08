import java.util.*;

// Find number of ways to climb stairs with 1 to 2 steps at a time
class ClimbingStairs {
	public static void main(String[] args) {
		int steps = 5;
		// int ways = findWays(steps);
		int ways = findWaysRecursively(steps);
		System.out.println("Number of ways: " + ways);
	}

	/*
		0 1 2 3 4 5

		1. f(x) objective function
		2. f(0) = 1, f(1) = 1, f(2) = 2
		3. recurrence function: f(i) = f(i-1) + f(i-2);
		4. return f(n);

	*/
	public static int findWays(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[n];
	}

	public static int findWaysRecursively(int n) {
		if (n < 2) return 1;

		return findWaysRecursively(n - 1) + findWaysRecursively(n - 2);
	}
}
