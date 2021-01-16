class TestLRU {
	public static void main(String[] args) {
		int capacity = 5;
		LRUCache lru = new LRUCache(capacity);
		lru.put(1, 10);
		lru.put(5, 50);
		lru.put(3, 30);
		lru.put(7, 70);
		lru.put(8, 20);

		System.out.println(lru);
		System.out.println("Access 3:");
		lru.get(3);
		System.out.println(lru);
		System.out.println("Access 5: " + lru.get(5));		
		System.out.println(lru);

		lru.put(8,80);
		System.out.println(lru);

		lru.put(9, 90);
		System.out.println(lru);
		
		System.out.println("Access LRU evicted element 1: " + lru.get(1));		
		System.out.println(lru);
	}
}