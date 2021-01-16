import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class SubArray {
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4};
		List<List<Integer>> list = getSubArray(arr);
		for (List<Integer> subList : list) {
			System.out.println(subList);	
		}		
	}

	public static List<List<Integer>> getSubArray(Integer[] arr) {
		List<List<Integer>> result = new ArrayList<>();

		// starting index of subarray
		for (int i=0; i < arr.length; i++) {
			// ending index of subarray
			for (int j=i; j < arr.length; j++) {
				Integer[] subarr = Arrays.copyOfRange(arr, i, j+1);
				result.add(Arrays.asList(subarr));				
			}
		}
		return result;
	}
}