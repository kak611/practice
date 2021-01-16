import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class PowerOfSet {
	public static void main(String[] args) {
		Integer[] arr = {0,1,2,3,4};
		List<Integer> arrList = Arrays.asList(arr);
		System.out.println(arrList);

		List<List<Integer>> powerset = getPowerSet(arrList);
		System.out.println(powerset);
	}

	public static List<List<Integer>> getPowerSet(List<Integer> arrList) {
		List<List<Integer>> powerset = new ArrayList<>();
		List<Integer> selectedList = new ArrayList<>();
		getPowerSet(arrList, 0, selectedList, powerset);
		return powerset;
	}

	public static void getPowerSet(List<Integer> inputList, int toBeSelected, List<Integer> selectedList, List<List<Integer>> powerset) {
		if (toBeSelected == inputList.size()) {
			powerset.add(new ArrayList<Integer>(selectedList));
			return;
		}

		selectedList.add(inputList.get(toBeSelected));
		System.out.println(">> " + selectedList);
		getPowerSet(inputList, toBeSelected + 1, selectedList, powerset);
		selectedList.remove(selectedList.size() - 1);
		getPowerSet(inputList, toBeSelected + 1, selectedList, powerset);
	}
}