class TestLRUCache {
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(6);
		System.out.println(lru);
		lru.put(1, 2);
		System.out.println(lru);
		lru.put(111, 5);
		lru.put(444, 35462);
		lru.put(3333, 56);
		lru.put(222, 3242342);
		lru.put(1, 4);
		lru.put(666, 3242342);
		System.out.println(lru);

		lru.put(435, 3242342);
		System.out.println(lru);

		System.out.println("get(2): " + lru.get(2));
		System.out.println(lru);
		System.out.println("get(222): " + lru.get(222));
		System.out.println(lru);
		lru.put(1010,765);
		System.out.println(lru);
	}
}