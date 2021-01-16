import java.util.*;

class RandomNumber {
	public static void main(String[] args) {		
		List<Integer> values = Arrays.asList(3,5,7,11);
		List<Double> probabilities = Arrays.asList(0.5, 0.3333, 0.1111, 0.0555);
		int result = nonUniformRandomNumberGeneration(values, probabilities);
		System.out.println("Result: " + result);
	}

	public static int nonUniformRandomNumberGeneration(List<Integer> values, List<Double> probabilities) {
		List<Double> rangeOfProbabilities = new ArrayList<>();
		rangeOfProbabilities.add(0.0);
		for (Double d : probabilities) {
			rangeOfProbabilities.add(rangeOfProbabilities.get(rangeOfProbabilities.size() - 1) + d);
		}
		System.out.println("Probabilities: " + probabilities);
		System.out.println("rangeOfProbabilities: " + rangeOfProbabilities);

		Random random = new Random();
		Double num = random.nextDouble();
		System.out.println("random number: " + num);

		// Collections.binarySearch
		// Returns: the index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1). 
		// The insertion point is defined as the point at which the key would be inserted into the list: the index of 
		// the first element greater than the key, or list.size() if all elements in the list are less than the specified key. 
		// Note that this guarantees that the return value will be >= 0 if and only if the key is found.
		int index = Collections.binarySearch(rangeOfProbabilities, num);		
		System.out.println("index in binarySearch: " + index);

		if (index < 0) {
			index = (Math.abs(index) - 1) - 1;
			System.out.println("Final Index1: " + index);
			return values.get(index);
		} else {
			// probability of finding a value in rangeOfProbability list is very less.
			System.out.println("Final Index2: " + index);
			return values.get(index);
		}
	}
}