import java.util.*;

class Subset {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4 };
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();

		subset(arr, tempList, list, 0);
		System.out.println(list);
		System.out.println(list.size());
	}

	public static void subset(int[] arr, List<Integer> tempList, List<List<Integer>> list, int index) {
		if (index == arr.length) {
			list.add(new ArrayList<>(tempList));
			return;
		}		
		
		tempList.add(arr[index]);  // with index value
		subset(arr, tempList, list, index+1);
		tempList.remove(tempList.size() - 1);  // without index value
		subset(arr, tempList, list, index+1);
	}


}