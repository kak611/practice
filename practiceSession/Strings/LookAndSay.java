class LookAndSay {
	public static void main(String[] args) {
		final int N = 6;
		String result = getNumber(N);
		System.out.println(result);
	}

	public static String getNumber(int num) {
		if (num == 0) return "1";
		if (num == 1) return "11";
		String str = getNumber(num-1);
		StringBuilder strb = new StringBuilder();
		int i=0;
		int j;
		int cnt;

		while(i < str.length()) {
			j = i+1;
			cnt = 1;
			while (j < str.length() && str.charAt(j) == str.charAt(j-1)) {
				cnt++;
				j++;
			}
			strb.append(cnt);
			strb.append(str.charAt(j-1));

			i = j;
		}
		return strb.toString();
	}
}