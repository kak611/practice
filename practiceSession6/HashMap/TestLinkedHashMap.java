class TestLinkedHashMap {
	public static void main(String[] args) {
		MyLinkedHashMap map = new MyLinkedHashMap(5);
		map.put(3,4);
		map.put(33,56);
		map.put(76,1);
		map.put(2,7);
		map.put(67,45);

		System.out.println(map);
		int val = map.get(76);
		System.out.println("val: " + val);
		System.out.println(map);
		map.put(67,67);
		System.out.println(map);
		map.put(10,10);
		System.out.println(map);
		val = map.get(3);
		System.out.println("val: " + val);
		System.out.println(map);
	}
}