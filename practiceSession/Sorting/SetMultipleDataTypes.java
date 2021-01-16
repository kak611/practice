import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

class SetMultipleDataTypes {
	public static void main(String[] args) {
		Set hashset = new HashSet();
		// Set hashset = new TreeSet();
		hashset.add("abcd");
		hashset.add(new Integer(12));
		hashset.add(new Character('c'));
		hashset.add(new Double(1.1));

		System.out.println(hashset);

	}
}