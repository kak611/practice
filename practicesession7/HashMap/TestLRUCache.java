import java.util.*;

class TestLRUCache {
	public static void main(String[] args) {
		LRUCache<Integer, String> cache = new LRUCache(5);
		cache.put(1, "abc");
		cache.put(2, "def");				
		cache.put(3, "ghi");
		cache.display();
		System.out.println(cache.get(2));
		cache.display();
		cache.put(4, "jkl");		
		cache.put(5, "jkl");		
		cache.display();
		cache.put(3, "lmn");
		cache.display();
		System.out.println(cache.get(1));
		cache.display();
		cache.put(6, "pqr");
		cache.display();
		cache.put(5, "pqr");
		cache.display();
		cache.put(7, "pqr");
		cache.put(8, "pqr");
		cache.display();
	}	
}