import java.util.*;

class TwoDimensionalSortedArray {
	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		input.add(Arrays.asList(-1, 2, 4, 4, 6));
		input.add(Arrays.asList(1,5,5,9,21));
		input.add(Arrays.asList(3,6,6,9,22));
		input.add(Arrays.asList(3,6,8,10,24));
		input.add(Arrays.asList(6,8,9,12,25));
		input.add(Arrays.asList(8,10,12,13,40));

		boolean result = false;
		int num = 7;

		result = matrixSearch(input, num);
		System.out.println("Element " + num + ": " + result);

		num = 8;
		result = matrixSearch(input, num);
		System.out.println("Element " + num + ": " + result);

		num = -2;
		result = matrixSearch(input, num);
		System.out.println("Element " + num + ": " + result);

		num = 41;
		result = matrixSearch(input, num);
		System.out.println("Element " + num + ": " + result);

		num = -1;
		result = matrixSearch(input, num);
		System.out.println("Element " + num + ": " + result);

		num = 40;
		result = matrixSearch(input, num);
		System.out.println("Element " + num + ": " + result);

		num = 21;
		result = matrixSearch(input, num);
		System.out.println("Element " + num + ": " + result);

		num = 10;
		result = matrixSearch(input, num);
		System.out.println("Element " + num + ": " + result);
	}

	public static boolean matrixSearch(List<List<Integer>> input, int num) {
		int rows = input.size();
		int cols = input.get(0).size();

		if (rows == 0) return false;

		// if (num < input.get(0).get(0) || num > input.get(rows-1).get(cols-1)) return false;
		// if (num == input.get(0).get(0) || num == input.get(rows-1).get(cols-1)) return true;

		int lo = 0, hi = cols - 1;
		while (lo < rows && hi >= 0) {
			// System.out.println(lo + ", " + hi);
			if (num == input.get(lo).get(hi)) {
				return true;
			} else if (num > input.get(lo).get(hi)) {
				lo++;
			} else {
				hi--;
			}
		}

		System.out.println("Searched matrix.");		
		return false;
	}
}