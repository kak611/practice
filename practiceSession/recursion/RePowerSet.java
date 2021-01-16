import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class RePowerSet {
	public static void main(String[] args) {		
		List<Integer> list = Arrays.asList(1,2,3);
		//List<String> list = Arrays.asList("A", "A", "B", "C");	// this code doesnt work for duplicates
		getPowerSet(list);
	}

	public static void getPowerSet(List<Integer> list) {
		List<List<Integer>> result = new ArrayList<>();
		getPowerSet(0, list, new ArrayList<Integer>(), result);
		System.out.println(result);
	}

	public static void getPowerSet(int index, List<Integer> inputList, List<Integer> selectedList, List<List<Integer>> result) {
		if (index == inputList.size()) {
			// System.out.print(selectedList + " ");			
			// result.add(selectedList);	// this gives empty result
			result.add(new ArrayList<>(selectedList));	// why create new ArrayList? 			
			return;
		}

		selectedList.add(inputList.get(index)); // for e.g. for index = 2, add 3 to selectedList => {1, 2, 3}		
		getPowerSet(index+1, inputList, selectedList, result);
		selectedList.remove(selectedList.size() - 1); // for e.g. for index = 2, remove 3 from selectedList => {1, 2}
		getPowerSet(index+1, inputList, selectedList, result);
		
		// // Test
		// List<List<String>> strList = new ArrayList<>();
		// List<String> strings = Arrays.asList("ab", "cd");
		// strList.add(strings);
		// System.out.println(strList);
	}
}