import java.util.*;

class SquareRoot {
	public static void main(String[] args) {
		Random random = new Random();
		int num = random.nextInt(999) + 1;		
		System.out.println("Nearest squareRoot of " + num + ": " + sqrt(num));
	}

	public static int sqrt(int num) {
		int left = 0;
		int right = num;

		while (left < right) {
			int mid = (right - left)/2 + left;
			int square = mid * mid;

			if (square > num) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left - 1;
	}
}