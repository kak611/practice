import java.util.Arrays;

class Replace {
	public static void main(String[] args) {
		System.out.println("hi");
		char[] arr = new char[] {'a','b','d','d','e','b','a','c','b'};
		System.out.println(Arrays.toString(arr));
		char[] res = replaceChar(arr);
		System.out.println("Result: " + Arrays.toString(res));
	}

	public static char[] replaceChar(char[] arr) {
		if (arr.length == 0) return new char[]{};

		//get count for each b delete it and for each a replace with two d
		int cnt = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == 'a') {
				cnt += 2;
			} else if (arr[i] == 'b') {
				continue;
			} else {
				cnt++;
			}
		}

		char[] result = new char[cnt];
		int j = 0;

		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 'a') {
				result[j] = 'd';
				result[j+1] = 'd';
				j += 2;
			} else if (arr[i] == 'b') {
				continue;
			} else {
				result[j] = arr[i];
				j++; 
			}
		}

		return result;
	}
}