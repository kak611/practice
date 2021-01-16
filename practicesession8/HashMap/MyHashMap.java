import java.util.*;

class MyHashMap<K, V> {
	public static final int CAPACITY = 16;
	Entry<K,V>[] buckets;
	int capacity;
	int size;

	public MyHashMap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		buckets = new Entry[this.capacity];
	}

	/*
		1. get hashvalue
		2. get bucketindex
		3. get entry
		4. put if
			a. entry is null
			b. entry is not null
	*/
	public void put(K key, V value) {

		if (size() == capacity()) {
			System.out.println("Full capacity utilized. Doubling the capacity");
			/* Note: simply doubling array size and copying from old array wont work
				     because now the hashvalues will change because of new mod value i.e. double the capacity
			*/

			amortize();			
		}

		int hashvalue = hash(key);		

		int bucketindex = (hashvalue % capacity());

		System.out.println("hashcode for " + key + " is " + hashvalue + " and bucketindex: " + bucketindex);

		Entry<K, V> entry = buckets[bucketindex];

		if (entry == null) {
			entry = new Entry(key, value);
			buckets[bucketindex] = entry;
			size++;
		} else {
			Entry curr = entry;
			Entry prev = null;

			while (curr != null) {
				if (curr.key.equals(key)) {					
					curr.value = value;
					break;
				}
				prev = curr;
				curr = curr.next;				
			}

			if (curr == null) {
				prev.next = new Entry(key, value);
				size++;
			}
		}

		System.out.println("put: " + display());
	}

	/*
		1. get hashvalue
		2. get bucketindex
		3. get bucket
		4. find entry
	*/
	public V get(K key) {
		int hashvalue = hash(key);

		int bucketindex = (hashvalue % capacity());

		Entry<K,V> entry = buckets[bucketindex];

		V result = null;

		if (entry != null) {
			Entry curr = entry;			
			while (curr != null) {
				if (curr.key.equals(key)) {
					result = (V) curr.value;
					break;
				}
				curr = curr.next;
			}
		}

		return result;		
	}

	/*
		1. get hashvalue
		2. get bucketindex
		3. get bucket
		4. find and remove entry
	*/
	private Entry<K, V> removeEntry(K key) {
		int hashvalue = hash(key);

		int bucketindex = (hashvalue % capacity);

		Entry<K, V> entry = buckets[bucketindex];

		Entry result = null;

		if (entry != null) {
			Entry curr = entry;
			Entry prev = null;						

			while (curr != null) {
				if (curr.key.equals(key)) {
					result = curr;

					// remove first entry
					if (prev == null) {
						buckets[bucketindex] = curr.next;
					// remove mid or last entry
					} else {
						prev.next = curr.next;						
					}
					curr = null;					
					break;
				}

				prev = curr;
				curr = curr.next;
			}

			size--;
		}

		return result;
	}

	public V remove(K key) {
		Entry temp = removeEntry(key);
		System.out.println("remove '" + key + "': " + display());
		return (temp == null) ? null : (V) temp.value;
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

	public int hash(K key) {
		int h = 0;
		return Objects.hash(key);

		// return (key == null) ? h : (h = key.hashCode() ^ (h >>> 16));
	}

	public String display() {
		StringBuilder strb = new StringBuilder();

		for (Entry<K, V> entry : buckets) {
			Entry<K, V> curr = entry;			

			while (curr != null) {
				strb.append(curr + "-");
				curr = curr.next;				
			}

			if (strb.length() > 0) {
				strb.deleteCharAt(strb.length() - 1);
				strb.append("--");
			}
		}

		return strb.toString();
	}

	/*
		1. create new bucket of size double
		2. swap old and new buckets
		3. iterate new bucket (now pointing to old bucket)
			a. this.put each entry to old bucket (now new bucket)
	*/
	public void amortize() {
		capacity = capacity * 2;
		Entry<K,V>[] newBuckets = new Entry[capacity];

		// swap buckets
		Entry<K,V>[] tempBucket = newBuckets;
		newBuckets = buckets;
		buckets = tempBucket;		

		size = 0; // after copying, size will automatically be set to correct value
		for (Entry e : newBuckets) {
			Entry curr = e;
			while (curr != null) {				
				this.put((K) curr.key, (V) curr.value);
				curr = curr.next;
			}
		}

		newBuckets = null;
		tempBucket = null;

		System.out.println("New capacity: " + buckets.length);
		System.out.println("size: " + size);
		System.out.println(Arrays.toString(buckets));
	}

	class Entry<K, V> {
		K key;
		V value;
		Entry next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			return "[" + key + ", " + value + "]";
		}
	}
}