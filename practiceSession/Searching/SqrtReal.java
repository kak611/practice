class SqrtReal {
	public static void main(String[] args) {
		double num = 7.1;
		double res = sqrt(num);
		System.out.println("Square root of " + num + " is " + res);
	}

	// binary search logic
	public static double sqrt(double num) {
		double left, right;
		if (num >= 1.0) {
			left = 1.0;
			right = num;
		} else {
			left = num;
			right = 1.0;
		}

		while (compare(left, right) == Ordering.SMALLER) {
			double mid = left + 0.5 * (right - left);
			double midsq = mid * mid;
			if (compare(midsq, num) == Ordering.LARGER) {
				right = mid;
			} else if (compare(midsq, num) == Ordering.SMALLER) {
				left = mid;
			} else {
				return mid;
			}
		}
		return left;
	}

	public static enum Ordering { SMALLER, EQUAL, LARGER }

	public static Ordering compare(double n1, double n2) {
		final double EPSILON = 0.00001;
		double diff = (n1 - n2)/n2;		
		if (diff > EPSILON) {			
			return Ordering.LARGER;
		} else if (diff == EPSILON) {
			return Ordering.EQUAL;			
		} else {		
			// goes in infinite loop if not < -EPSILON	
			if (diff < -EPSILON) {
				System.out.println("here>> " + diff);
			}
			return Ordering.SMALLER;			
		}		
	}
}