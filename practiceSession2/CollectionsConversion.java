import java.util.*;

class CollectionsConversion {
	public static void main(String[] args) {
		Character[] arr = {'a', 'e', 'i', 'o', 'u'};
		System.out.println("Array: " + Arrays.toString(arr));

		List<Character> list = Arrays.asList(arr);		
		System.out.println("List: " + list);

		HashSet<Character> set = new HashSet<>(list);
		System.out.println("HashSet: " + set);
		

		List<Character> list2 = Arrays.asList('a','b');
		System.out.println("ArrayList2: " + list2);

		HashSet<Character> set2 = new HashSet<>(list2);
		System.out.println("HashSet2: " + set2);

		Character[] arr2 = list2.toArray(new Character[list2.size()]);
		System.out.println("Array2: " + Arrays.toString(arr2));
	}
}