class RotateString {
	public static void main(String[] args) {
		String str = "abcdefg";
		int k = 2;
		char[] arr = str.toCharArray();
		System.out.println(String.valueOf(arr));
		rotate(arr, 0, arr.length - 1);
		System.out.println(String.valueOf(arr));
		rotate(arr, 0, arr.length - 1 - k);
		System.out.println(String.valueOf(arr));
		rotate(arr, arr.length - k, arr.length - 1);
		System.out.println(String.valueOf(arr));
	}

	public static void rotate(char[] arr, int start, int end) {
		int l = start;
		int r = end;
		while (l < r) {
			char temp = arr[r];
			arr[r] = arr[l];
			arr[l] = temp;
			l++;
			r--;
		}
	}
}