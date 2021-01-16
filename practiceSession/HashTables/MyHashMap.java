class MyHashMap<K,V> {

	private Entry<K,V>[] buckets;
	private static final int INITIAL_CAPACTIY = 16;
	private int size;
	private int capacity;
	// private Entry<K,V> first, last;		// required to implement LinkedHashMap

	public MyHashMap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		buckets = new Entry[capacity];
	}

	public MyHashMap() {
		this(INITIAL_CAPACTIY);
	}

	/*
		Steps:
		1. get hash
		2. find bucket
		3. get linkedlist
		4. insert in linkedlist
	*/
	public void put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V>(key, value);
		// step 1
		int hashValue = hash(key);
		System.out.println("put(): hashvalue of " + key + ": " + hashValue);

		// step 2		
		int bucket = hashValue % getCapacity();	// In Java 8, its hash & (n-1) where, n is capacity

		// step 3
		Entry existingEntry = buckets[bucket];

		// step 4
		if (existingEntry == null) {
			buckets[bucket] = newEntry;
			size++;
		} else {
			while(existingEntry.next != null) {
				if (existingEntry.key.equals(key)) {
					existingEntry.value = value;
					return;
				}
				existingEntry = existingEntry.next;
			}

			if (existingEntry.key.equals(key)) {
				existingEntry.value = value;
			} else {
				existingEntry.next = newEntry;
				size++;
			}
		}
	}


	/*
		Steps:
		1. get hash value
		2. find bucket
		3. find linkedList head
		4. find key and return value
	*/
	public V get(K key) {
		// step 1
		int hashValue = hash(key);
		System.out.println("get(): hashvalue of " + key + ": " + hashValue);

		// step 2
		int bucket = hashValue % getCapacity();

		// step 3
		Entry<K,V> entry = buckets[bucket];

		// step 4
		while (entry != null) {
			if (entry.key.equals(key)) {				
				return entry.value;
			}
			entry = entry.next;
		}

		return null;
	}

	private int getCapacity() {
		return this.capacity;
	}

	private int getSize() {
		return this.size;
	}

	// taken from Java 8 HashMap implementation
	private int hash(Object key) {
		int h;
		if ((Character) key == 'c') return 98;	// hardcoding for testing collision
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	class Entry<K,V> {		
		K key;
		V value;
		Entry<K,V> next;
		// Entry<K,V> before, after;	// required to implement LinkedHashMap

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
}