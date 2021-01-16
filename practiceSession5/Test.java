import java.util.*;

class Test {
	public static void main(String[] args) {
		Set<List<Integer>> set = new HashSet<>();
		set.add(Arrays.asList(0,1));
		set.add(Arrays.asList(1,0));
		System.out.println(set);
		// List<Integer> list = new ArrayList<>();
		// list.add(1);
		// list.add(2);
		// list.add(3);
		// list.add(4);
		// list.add(5);

		// System.out.println(list);
		// List<Integer> list2 = new ArrayList<>(list);
		// System.out.println(list2);


	}
}