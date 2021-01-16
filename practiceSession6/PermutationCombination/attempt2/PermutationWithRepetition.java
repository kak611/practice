import java.util.*;

class PermutationWithRepetition {
	public static void main(String[] args) {
		// String s = "123"; // for distinct elements, time complexity: n ^ r i.e. 3^3 = 27
		// int r = s.length();

		// String s = "123"; // for distinct elements, time complexity: n ^ r i.e. 3^2 = 9
		// int r = 2;

		// This looks like invalid case where input and output both has repetition
		// because the duplicates in input will get used more than once in output any ways
		String s = "112"; // for duplicates elements, time complexity: ??
		int r = s.length();
		
		

		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) set.add(c);

		List<String> result = new ArrayList<>();
		// assuming input is distinct
		permutation(s.toCharArray(), new char[r], 0, result, r);
		System.out.println("Result: " + result);
		System.out.println("Result size: " + result.size());

		List<String> result2 = new ArrayList<>();
		// assuming input contains duplicates
		permutation2(new ArrayList<Character>(set), new char[r], 0, result2, r);
		System.out.println("Result2: " + result2);
		System.out.println("Result2 size: " + result2.size());
		
	}



	/*
        indx:     0 1 2                          0 1 2
                  i                              
        elem:     1 2 3             permutation: 1 1 1  

	*/

	public static void permutation(char[] arr, char[] tempArr, int index, List<String> result, int r) {
		if (index == r) {
			result.add(new String(tempArr));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			tempArr[index] = arr[i];
			permutation(arr, tempArr, index + 1, result, r);
		}
	}

	public static void permutation2(List<Character> list, char[] tempArr, int index, List<String> result, int r) {
		if (index == r) {
			result.add(new String(tempArr));
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			tempArr[index] = list.get(i);
			permutation2(list, tempArr, index + 1, result, r);
		}
	}
}