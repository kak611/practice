import java.util.Arrays;

class MyHashMap<K,V> {	
	private Entry<K,V>[] buckets;
	public static final int CAPACITY = 16;
	private int capacity;
	private int size;

	public MyHashMap(int capacity) {
		this.capacity = capacity;
		buckets = new Entry[this.capacity];
		this.size = 0;
	}


	public MyHashMap() {
		this(CAPACITY);
	}

	public int capacity() {
		return this.capacity;
	}

	public int size() {
		return this.size;
	}

	public V remove(K key) {
		// get hash value
		int hashValue =  hash(key);

		// get bucket index
		int bucketIndex = hashValue % capacity();

		// get bucket
		Entry<K, V> entry = buckets[bucketIndex];		
		
		// remove entry
		V value = null;
		if (entry == null) {
			return value;
		} else if (entry.key.equals(key)) {
			buckets[bucketIndex] = entry.next;
			value = entry.value;			
		} else {
			Entry<K, V> prev = entry;
			Entry<K, V> curr = entry.next;			
			while (curr != null) {
				if (curr.key.equals(key)) {
					value = curr.value;
					prev.next = curr.next;
					curr.next = null;
				}
				prev = curr;
				curr = curr.next;				
			}			
		}
		size--;
		return value;
	}

	public V put(K key, V value) {
		// create new Entry
		Entry<K,V> entry = new Entry(key, value);

		// get hash value (if key is null entry is stored at index 0)
		int hashValue = hash(key);

		// get bucket index
		int bucketIndex = hashValue % capacity();		

		// find bucket using hashValue
		Entry<K, V> existingEntry = buckets[bucketIndex];

		// add if new Entry
		if (existingEntry == null) {
			buckets[bucketIndex] = entry;
			size++;
			return value;
		}

		while (existingEntry.next != null) {
			if (existingEntry.key.equals(key)) {
				existingEntry.value = value;
				return value;			
			}
			existingEntry = existingEntry.next;
		}

		if (existingEntry.key.equals(key)) {
			existingEntry.value = value;
		} else {
			existingEntry.next = entry;
			size++;
		}
		return value;
	}

	public V get(K key) {
		// get hash value
		int hashValue = hash(key);

		// get bucket index
		int bucketIndex = hashValue % capacity();		

		// get bucket
		Entry<K,V> existingEntry = buckets[bucketIndex];

		// find key
		while (existingEntry != null) {
			if (existingEntry.key.equals(key)) {
				return existingEntry.value;
			}
			existingEntry = existingEntry.next;
		}

		return null;
	}

	public int hash(Object key) {
		int h = 0;
		return (key == null) ? h : (h = key.hashCode()) ^ (h >>> 16);
	}

	public String toString() {
		return Arrays.toString(buckets);
	}


	class Entry<K,V> {
		K key;
		V value;
		Entry<K,V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		public String toString() {
			Entry curr = this;
			StringBuilder strb = new StringBuilder();

			while (curr != null) {
				strb.append("[" + curr.key + ", " + curr.value + "]-");
				curr = curr.next;
			}
			strb.deleteCharAt(strb.length() - 1);
			return strb.toString();
		}
	}
}