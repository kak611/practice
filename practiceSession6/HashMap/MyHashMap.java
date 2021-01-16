import java.util.Objects;

class MyHashMap<K, V> {
	public static final int CAPACITY = 16;
	private int capacity;
	private Entry<K,V>[] buckets;
	private int size;

	public MyHashMap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		buckets = new Entry[this.capacity];
	}

	public MyHashMap() {
		this(CAPACITY);
	}

	public int size() {
		return this.size;
	}

	public int capacity() {
		return this.capacity;
	}

	public int getHash(K key) {
		return hash(key);
	}

	public String toString() {
		StringBuilder strb = new StringBuilder();
		for (Entry<K, V> entry : buckets) {
			if (entry == null) continue;
			Entry<K, V> curr = entry;
			while (curr != null) {
				strb.append("[" + curr + "]-");
				curr = curr.next;
			}
			strb.deleteCharAt(strb.length() - 1);
			strb.append("|");
		}
		return strb.toString();
	}

	public void put(K key, V value) {
		int hashValue = hash(key);
		int bucketIndex = hashValue % capacity;
		Entry entry = buckets[bucketIndex];

		if (entry == null) {
			buckets[bucketIndex] = new Entry(key, value);
			size++;
		} else {
			while (entry.next != null) {
				if (entry.key.equals(key)) {
					entry.value = value;
					return;
				}
				entry = entry.next;
			}

			if (entry.key.equals(key)) {
				entry.value = value;
			} else {
				entry.next = new Entry(key, value);
			}
		}
	}

	public V get(K key) {
		int hashValue = hash(key);
		int bucketIndex = hashValue % capacity;
		Entry entry = buckets[bucketIndex];

		while (entry != null) {
			if (entry.key == null) {
				return (V)entry.value;
			} else if (entry.key.equals(key)) {
				return (V)entry.value;
			}
			entry = entry.next;
		}
		return null;
	}

	public V remove(K key) {
		int hashValue = hash(key);
		int bucketIndex = hashValue % capacity;
		Entry<K, V> entry = buckets[bucketIndex];
		V val = null;
		if (entry == null) {
			return val;
		} else {
			Entry<K,V> prev = null;
			Entry<K,V> curr = entry;
			while (curr != null) {
				if (curr.key.equals(key)) {
					val = curr.value;
					if (prev == null) {
						buckets[bucketIndex] = curr.next;
					} else {
						prev.next = curr.next;						
					}
					// curr.next = null;
					break;
					
				}	
				prev = curr;
				curr = curr.next;
			}
		}
		return val;
	}

	// todo proper hash function ensures uniform distribution
	public int hash(K key) {
		int h = 0;
		// return Objects.hash(key);
		return (key == null) ? h : (h = key.hashCode() ^ (h >>> 16));
	}


	static class Entry<K, V> {
		K key;
		V value;
		Entry<K,V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		public String toString() {
			return this.key + "-" + this.value;
		}
	}
}