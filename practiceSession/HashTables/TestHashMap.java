class TestHashMap {
	public static void main(String[] args) {
		MyHashMap<Character, Integer> hashmap = new MyHashMap<>();
		hashmap.put('a', 1);
		hashmap.put('b', 2);
		hashmap.put('a', 3);
		hashmap.put('c', 4);  // hashcode of c = b is hardcoded.

		System.out.println("value for key 'a' is " + hashmap.get('a'));
		System.out.println("value for key 'b' is " + hashmap.get('b'));
		System.out.println("value for key 'c' is " + hashmap.get('c'));	// b & c are different obj but same hashcode
		System.out.println("value for key 'b' is " + hashmap.get('b'));
	}
}