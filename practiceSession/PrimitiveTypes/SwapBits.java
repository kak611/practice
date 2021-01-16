class SwapBits {
	public static void main(String[] args) {
		long num = 17;
		binaryRepresentation(num);
		int i = 1;
		int j = 2;
		long result = swap(num, i,j);
		System.out.print("After swapping " + i + "th & " + j + "th bits: ");
		binaryRepresentation(result);
		countBits(num);
		countBitsFaster(num);
		parity(num);
		parityFaster(num);
	}

	public static void binaryRepresentation(long num) {
		if (num < 0) return;
		getBitsRecursive(num);
		System.out.println("");
	}

	public static void getBitsRecursive(long num) {
		if (num == 0) return;
		getBitsRecursive(num/2);
		System.out.print(num%2 + " ");
	}

	public static long swap(long num, long i, long j) {
		long result = num;
		if (((num >>> i) & 1) != ((num >>> j) & 1)) {
			long bitmask = (1L << i) | (1L << j);
			result ^= bitmask;
		}
		return result;
	}

	public static void countBits(long num) {
		short cnt = 0;
		while (num != 0) {
			cnt += (num & 1);
			num >>>=  1;			
		}
		System.out.println("Numner of Bits in O(n): " + cnt);
	}

	public static void countBitsFaster(long num) {
		if (num == 0) return;

		short cnt = 0;
		while (num != 0) {			
			num &= (num - 1);
			cnt++;
		}
		System.out.println("Numner of Bits in O(s) where s is number of bits set to 1: " + cnt);
	}

	public static void parity(long num) {
		int result = 0;
		while (num != 0) {
			result ^= (num & 1);
			num >>>= 1;
		}
		System.out.println("Parity (0 for even bits, 1 for odd bits) in O(n) is " + result);
	}

	public static void parityFaster(long num) {
		if (num == 0) return;
		int result = 0;
		while(num != 0) {
			result ^= 1;
			num &= (num -1);
		}
		System.out.println("Parity (0 for even bits, 1 for odd bits) in O(s) is " + result);
	}
}