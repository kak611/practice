// no repetition in output  (https://www.superprof.co.uk/resources/academic/maths/probability/combinatorics/permutations-with-repetition.html)
// note: repetition in input still meaning 1122 will still use the same logic for non-repetition permutation
// this also covers:
//   1. r = total length without repetition in input
//   2. r = total length with repetition in input
//   3. r < total length without repetition in input
//   4. r < total length with repetition in input

// Todo: check complexity using recurrence relation

/*
 permutation of 123

different arrangment of each element in the input
r = 2, 3, total length

                    cnt  0 0 1
                             i        
					indx 0 1 2	  - - -
                         1 2 3    2 1 3

*/

import java.util.*;

class Permutation {
	public static void main(String[] args) {
		// String s = "112223"; // for input-repeated elements, time complexity : (6! / (2! . 3!))
		// int r = s.length(); // total slots

		// String s = "123456"; // for distinct elements, time complexity : (n!/ (n - r)!)
		// int r = s.length(); // total slots

		String s = "112223"; // for r < s.length(), ??
		int r = 2; // total slots

		TreeMap<Character, Integer> map = new TreeMap<>();
		for (char c : s.toCharArray()) {
			map.putIfAbsent(c, 0);
			map.put(c, map.get(c) + 1);
		}
		List<String> result = new ArrayList<>();
		// int r = s.length(); // total length
		

		permutation(map, new StringBuilder(), result, r);
		System.out.println("Result: " + result);		
		System.out.println("Result size: " + result.size());


		// permutation2 -- using char array instead of StringBuilder
		List<String> result2 = new ArrayList<>();
		permutation2(map, new char[r], 0, result2, r);
		System.out.println("Result: " + result2);		
		System.out.println("Result size: " + result2.size());
	}

	public static void permutation(TreeMap<Character, Integer> map, StringBuilder strb, List<String> result, int r) {
		if (strb.length() == r) {
			result.add(strb.toString());
			return;
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 0) continue;
			map.put(entry.getKey(), entry.getValue() - 1);
			strb.append(entry.getKey());
			permutation(map, strb, result, r);
			map.put(entry.getKey(), entry.getValue() + 1);
			strb.deleteCharAt(strb.length() - 1);
		}
	}


	// using char array
	public static void permutation2(TreeMap<Character, Integer> map, char[] tempArr, int index, List<String> result, int r) {
		if (index == r) {
			result.add(new String(tempArr));
			return;
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 0) continue;
			map.put(entry.getKey(), entry.getValue() - 1);
			tempArr[index] = entry.getKey();			
			permutation2(map, tempArr, index + 1, result, r);
			map.put(entry.getKey(), entry.getValue() + 1);			
		}
	}
}
