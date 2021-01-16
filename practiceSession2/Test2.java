class Test2 {
	private static int count1 = 0;

	public static void main(String[] args) {
		int count2 = 0;
		inc(count2);
		System.out.println("count1: " + count1);
		System.out.println("count2: " + count2);
	}

	public static void inc(int count2) {
		count1 += 4;
		count2 += 6;	
		System.out.println("Inside.. count1: " + count1);
		System.out.println("Inside.. count2: " + count2);
	}
}