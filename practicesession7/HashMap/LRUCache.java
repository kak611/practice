import java.util.*;

class LRUCache<K, V> {
	private Node head;
	private Node tail;
	private Map<K, Node<K,V>> map;	
	private int size;
	private int capacity;
	public static final int CAPACITY = 16;

	public LRUCache(int capacity) {
		map = new HashMap<>();
		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.prev = head;		

		size = 0;
		this.capacity = capacity;
	}

	public LRUCache() {
		this(CAPACITY);
	}

	public int size() {
		return this.size;
	}

	public int capacity() {
		return this.capacity;
	}

	public void display() {
		Node curr = head;
		while (curr.next != tail) {
			curr = curr.next;
			System.out.print(curr);			
		}
		System.out.println();
	}

	public void put(K key, V value) {
		Node n = map.get(key);

		if (n == null) {
			n = new Node(key, value);			
			addFirst(n);			
			map.put(key, n);			
			size++;			
			if (size > capacity) {
				Node temp = removeLast();
				map.remove(temp.key);
				size--;
			}
		} else {
			moveToFirst(n);
			n.value = value;
		}
	}

	public V get(K key) {
		Node n = map.get(key);
		if (n == null) {
			return null;
		}

		V result = (V) n.value;
		moveToFirst(n);

		return result;
	}


	public void addFirst(Node node) {
		Node curr = head;
		node.prev = curr;
		node.next = curr.next;

		curr.next.prev = node;
		curr.next = node;
	}

	public void remove(Node node) {
		Node pre = node.prev;
		Node post = node.next;

		pre.next = post;
		post.prev = pre;

		node.prev = null;
		node.next = null;
	}

	public void moveToFirst(Node node) {
		remove(node);
		addFirst(node);
	}

	public Node removeLast() {
		Node res = tail.prev;
		remove(res);
		return res;
	}


	static class Node<K, V> {
		K key;
		V value;
		Node next;
		Node prev;

		public Node() {
			next = null;
			prev = null;
		}

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
			prev = null;
		}

		public String toString() {
			return "[" + this.key + ", " + this.value + "]-";
		}
	}
}