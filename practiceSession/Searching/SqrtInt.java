class SqrtInt {
	public static void main(String[] args) {
		int num = 64;
		int res = sqrt(num);
		System.out.println("Square root of Integer " + num + " is >= " + res);
	}

	public static int sqrt(int num) {
		int l = 0, r = num;
		while(l <= r) {
			int mid = l + (r-l)/2;
			System.out.println("mid: " + mid);
			int midsq = mid * mid;
			// add <= in below condition and return l-1 because l is incremented below
			if (midsq < num) {
				l = mid + 1;
				System.out.println("update left: " + l);
			} else if (midsq > num) {
				r = mid - 1;
				System.out.println("update right: " + r);
			}
		}
		return l-1;
	}
}