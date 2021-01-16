class NextPermutation {
	public static void main(String[] args) {
		// [AABC, AACB, ABAC, ABCA, ACAB, ACBA, BAAC, BACA, BCAA, CAAB, CABA, CBAA]
		String str = "ABCA";	// result should be ACAB
		String result = getNextPermutation(str);
		System.out.println("Next permutation: " + result);
	}

	public static String getNextPermutation(String str) {
		char[] arr = str.toCharArray();
		int index = 0;
		for (int i = arr.length-2; i >=0; --i) {
			if (arr[i] < arr[i+1]) {
				index = i;
				break;
			}
		}

		int j = arr.length-1;
		while (j > index && arr[j] < arr[index]) --j;
		swap(arr, index, j);
		System.out.println("inter: " + String.valueOf(arr));

		// reverse the characters after index
		int start = index + 1;		
		int end = arr.length-1;
		int mid = (end - start)/2 + start;	// too complicated.. make it simple		
		j = end;
		//System.out.println(j + ", " + (j - start + 1) + ", mid: " + mid);
		while (j > mid) {
			swap(arr, j, j - start + 1);
			j--;		
		}

		return String.valueOf(arr);
	}

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}