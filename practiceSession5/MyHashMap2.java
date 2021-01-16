import java.util.Arrays;

class MyHashMap2<K,V> {
	public static final int CAPACITY = 16;
	private Entry<K,V>[] buckets;
	private int capacity;
	private int size;

	public MyHashMap2(int capacity) {		
		this.capacity = capacity;
		int size = 0;
		buckets = new Entry[this.capacity];
	}

	public MyHashMap2() {
		this(CAPACITY);
	}

	public void put(K key, V value) {
		// step 1: get hashvalue
		int hashvalue = hash(key);

		// step 2: find bucketId
		int bucketId = hashvalue % capacity();

		// step 3: get entry
		Entry<K,V> currEntry = buckets[bucketId];

		// step 4: insert key,value
		if (currEntry == null) {
			buckets[bucketId] = new Entry(key, value);
			size++;
			return;
		}

		Entry prev = currEntry;
		while (currEntry != null) {			
			if (currEntry.key.equals(key)) {
				currEntry.value = value;
				return;
			}
			prev = currEntry;
			currEntry = currEntry.next;
		}

		prev.next = new Entry<K,V>(key, value);
		size++;
	}

	public V get(K key) {
		// step 1: get hashvalue
		int hashvalue = hash(key);

		// step 2: get bucketId
		int bucketId = hashvalue % capacity;

		// step 3: get bucket
		Entry<K,V> currEntry = buckets[bucketId];

		//  step 4: find key
		while (currEntry != null) {
			if (currEntry.key.equals(key)) {
				return currEntry.value;
			}
		}

		return null;
	}

	public V remove(K key) {
		int hashvalue = hash(key);
		int bucketId = hashvalue % capacity;
		Entry<K,V> e = buckets[bucketId];	
		V result = null;	
		if (e == null) {
			return result;
		} else if (e.key.equals(key)) {
			result = e.value;
			buckets[bucketId] = e.next;			
		} else {
			Entry prev = e;
			while (e.next != null) {
				prev = e;
				e = e.next;
				if (e.key.equals(key)) {
					result = e.value;
					prev.next = e.next;
					e.next = null;
					break;					
				}
			}
		}
		return result;
	}

	public String toString() {
		return Arrays.toString(buckets);
	}

	public int hash(K key) {
		// int result = (key == null) ? 0 : Object.hashcode(key);
		int h = 0;
		int result = (key == null) ? h : (h = key.hashCode()) ^ (h >>> 16);
		return result;
	}

	public int size() {
		return this.size;
	}

	public int capacity() {
		return this.capacity;
	}



	class Entry<K,V> {
		K key;
		V value;
		Entry next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			Entry curr = this;
			StringBuilder strb = new StringBuilder();
			while (curr != null) {
				strb.append("[" + curr.key + "-" + curr.value + "]" + "-");
				curr = curr.next;
			}
			strb.deleteCharAt(strb.length() - 1);
			return strb.toString();
		}
	}
}