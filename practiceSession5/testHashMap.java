class testHashMap {
	public static void main(String[] args) {
		MyHashMap<Character, Integer> map = new MyHashMap<>();		

		map.put('a', 1);
		map.put('b', 5);
		// System.out.println(map);
		map.put('a', 6);		

		System.out.println(map);		

		System.out.println("b: " + map.get('b'));
		
		map.put('c', 11);
		map.put('d', 51);

		// test collision
		map.put('q', 55);
		map.put('r', 94);

		// update value
		map.put('c', 16535335);

		System.out.println(map);
		System.out.println("map size: " + map.size());

		// remove key
		System.out.println("Removing d: " + map.get('d'));
		map.remove('d');
		System.out.println(map);
		System.out.println("map size: " + map.size());

		// get value
		System.out.println("d: " + map.get('d'));
		System.out.println("c: " + map.get('c'));

		// remove from collision
		System.out.println("Removing b: " + map.get('b'));
		map.remove('b');
		System.out.println(map);
		System.out.println("map size: " + map.size());
		System.out.println("Removing q: " + map.get('q'));
		map.remove('q');
		System.out.println(map);
		System.out.println("map size: " + map.size());

		// print values
		System.out.println("a: " + map.get('a'));
		System.out.println("b: " + map.get('b'));
		System.out.println("c: " + map.get('c'));
		System.out.println("d: " + map.get('d'));
		System.out.println("q: " + map.get('q'));
		System.out.println("r: " + map.get('r'));
	}
}