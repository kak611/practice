import java.util.*;

// https://leetcode.com/discuss/interview-question/802922/Robinhood-coding-assessment-New-Grad-role-USA
class SquareMatrix {
	public static void main(String[] args) {
		String[][] matrices = 
			{ {"14", "3", "10", "4", "16", "10", "?", "2", "?", "9", "15", "11"},
			  {"16", "7", "8", "2", "1", "4", "8", "3", "3", "16", "7", "13"},
			  {"?", "9", "6", "5", "14", "12", "7", "6", "2", "10", "4", "14"},
			  {"15", "1", "13", "12", "9", "15", "5", "13", "1", "8", "12", "6"}
			};

		System.out.println(Arrays.deepToString(matrices));

		sortByMissingNumber(matrices);

		System.out.println("After finding missing numbers: " + Arrays.deepToString(matrices));
	}

	public static void sortByMissingNumber(String[][] matrices) {
		int row = matrices.length;
		int col = matrices[0].length;
		System.out.println("row: " + row + ", col: " + col);
		List<int[]> missingPos = new ArrayList<>();
		List<Integer> missingNums = new ArrayList<>();

		int total = (16 * 17)/2;		
		for (int i = 0; i < col; i += 4) {			
			int sum = 0;
			System.out.println(" ");
			for (int j = 0; j < row; j++) {
				for (int k = i; k < (i + 4); k++) {
					System.out.print(matrices[j][k] + " ");
					if (!matrices[j][k].equals("?"))
						sum += Integer.parseInt(matrices[j][k]);
					else
						missingPos.add(new int[] {j, k});					
				}
				System.out.println();
			}
			System.out.println("sum: " + sum);
			missingNums.add(total - sum);
		}

		System.out.println("missingNums: " + missingNums);		
		Integer[] sortedMissing = missingNums.toArray(new Integer[missingNums.size()]);
		// Integer[] sortedMissing = {3,5,7,2,9,4,1,5,6};
		System.out.println("unsorted: " + Arrays.toString(sortedMissing));
		insertionSort(sortedMissing);
		System.out.println("sorted: " + Arrays.toString(sortedMissing));

		int m = 0;
		for (int[] n : missingPos) {
			System.out.println(n[0] + "-" + n[1]);
			matrices[n[0]][n[1]] = String.valueOf(sortedMissing[m++]);
		}
	}

	public static void insertionSort(Integer[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			for (j = i - 1; j >= 0; --j) {
				if (arr[j] > key) {
					arr[j + 1] = arr[j];
				} else break;
			}

			arr[j + 1] = key;
		}
	}
}