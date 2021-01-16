import java.util.*;

class FinalScore {
	public static void main(String[] args) {
		Integer score = 12;
		List<Integer> list = Arrays.asList(2,3,7);

		Integer result = numOfScoreCombination(score, list);
		System.out.println("Total combinations for using individual plays (2,3,7) to get given score (12) : " + result);
	}

	// Using 1D array & Bottom-up approach
	public static Integer numOfScoreCombination(Integer score, List<Integer> list) {
		int [] result = new int[score + 1];
		result[0] = 1; //1 way to create score of zero i.e using no individual plays
		
		for (int i=0; i < list.size(); i++) {
			int currScore = 1;
			while (currScore <= score) {
				if (currScore >= list.get(i)) {
					result[currScore] += result[currScore - list.get(i)];
				}	
				currScore++;
			}
		}
		System.out.println(Arrays.toString(result));
		return result[score];
	}


	// Using 2D array & top-down approach (using recursion)
	// public static Integer numOfScoreCombination(Integer score, List<Integer> list) {
	// 	int[][] cache = new int[list.size()][score + 1];

	// 	for (int i=0; i<list.size(); i++) {
	// 		cache[i][0] = 1;  // one way for score zero
	// 		for (int j=1; j <= score; j++) {
	// 			int withoutplay = (i-1 >= 0) ? cache[i-1][j] : 0;
	// 			int withplay = (j - list.get(i) >= 0) ? cache[i][j -l ist.get(i)] : 0;
	// 			cache[i][j] = withoutplay + withplay;
	// 		}
	// 	}
	// 	return cache[list.size()-1][score];
	// }
}