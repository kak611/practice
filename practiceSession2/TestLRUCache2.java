class TestLRUCache2 {
	public static void main(String[] args) {
		LRUCache2 lru = new LRUCache2(5);
		lru.put(1, 2);
		lru.put(2, 3);
		lru.put(3, 4);
		lru.put(4, 5);
		lru.put(5, 6);

		System.out.println(lru);
		lru.put(4,4);
		System.out.println(lru);
		lru.put(6,6);
		System.out.println(lru);

		System.out.println(lru.get(2));
		System.out.println(lru);
		lru.put(10,10);
		System.out.println(lru);
	}
}