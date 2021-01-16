class MyHashMapTest {
	static MyHashMap<String, Integer> map;

	public static void main(String[] args) {
		map = new MyHashMap(5);

		String key = "";
		
		map.put("abc", 1123);		
		map.put("def", 1212);
		System.out.println("size: " + map.size() + " and capacity: " + map.capacity() + "\n");
		map.put("fed", 324);
		map.put("efd", 543);
		map.put("abc", 1);
		map.put("cool", 2222);
		System.out.println("size: " + map.size() + " and capacity: " + map.capacity() + "\n");

		map.put("now", 223);

		key = "efd";
		key = "cool";
		System.out.println(key + ": " + map.get(key));

		// key = "abc";
		key = "abc";
		System.out.println(key + ": " + map.get(key));

		map.remove("fed");
		map.remove("abc");
		map.remove("cool");

		key = "cool";
		System.out.println(key + ": " + map.get(key));

		map.remove("now");
		map.remove("def");
		map.remove("efd");
		System.out.println("size: " + map.size() + " and capacity: " + map.capacity() + "\n");

		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		map.put("f", 6);
		map.put("g", 7);
		map.put("h", 8);
		map.put("i", 9);
		map.put("j", 10);

		map.put("k", 11);
		map.put("l", 12);
		map.put("m", 13);
		map.put("n", 14);
		map.put("o", 15);
		map.put("p", 16);
		map.put("q", 17);
		map.put("r", 18);
		map.put("s", 19);
		map.put("t", 20);
		map.put("u", 21);
		System.out.println("size: " + map.size() + " and capacity: " + map.capacity() + "\n");

		map.remove("a");
		System.out.println("size: " + map.size() + " and capacity: " + map.capacity() + "\n");

		map.put("a", 1);
		map.put("v", 22);

	}
}