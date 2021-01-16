import java.util.*;

class SquareRoot {
	public static void main(String[] args) {
		Random random = new Random();
		int num = random.nextInt(999) + 1;		
		System.out.println("Nearest squareRoot of " + num + ": " + sqrt(num));
	}

	public static int sqrt(int num) {
		int left = 0, right = num;

		while (left <= right) {
			int mid = (right - left)/2 + left;
			int midsq = mid * mid;

			if (midsq <= num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left - 1;
	}
}