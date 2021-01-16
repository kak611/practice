import java.util.*;

class SquareRoot {
	public static void main(String[] args) {
		Random random = new Random();
		int num = random.nextInt(999) + 1;		
		System.out.println("Nearest squareRoot of " + num + ": " + sqrt(num));
	}

	public static int sqrt(int num) {
		int lo = 0, hi = num;

		while (lo < hi) {
			int mid = (hi - lo)/2 + lo;			
			if (mid * mid > num) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo - 1;
	}
}