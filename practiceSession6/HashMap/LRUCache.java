ximport java.util.*;

class LRUCache {
	public static final int CAPACITY = 16;
	private int capacity;
	private int size;
	private Map<Integer, Node> map;
	private Node first;
	private Node last;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		map = new HashMap<>();

		first = new Node();
		last = new Node();

		first.next = last;
		last.prev = first;
	}

	public LRUCache() {
		this(CAPACITY);
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node == null) {
			node = new Node();
			node.key = key;
			node.value = value;
			addFirst(node);
			map.put(key, node);
			size++;

			// evict least used Node
			if (size() > capacity()) {
				Node temp = pollLast();
				System.out.println("Evicted: " + temp.key + ", " + temp.value);
				map.remove(temp.key);
				size--;
			}
		} else {
			node.value = value;
			removeNode(node);
			addFirst(node);
		}		
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}

		removeNode(node);
		addFirst(node);
		return node.value;		
	}

	private void addFirst(Node node) {
		node.prev = first;
		node.next = first.next;

		first.next.prev = node;
		first.next = node;
	}

	private void removeNode(Node node) {
		Node pre = node.prev;
		Node post = node.next;

		pre.next = post;
		post.prev = pre;
	}

	private Node pollLast() {
		Node temp = last.prev;
		removeNode(temp);
		return temp;
	}

	public int size() {
		return this.size;
	}

	public int capacity() {
		return this.capacity;
	}

	public String toString() {
		StringBuilder strb = new StringBuilder();
		Node curr = first;

		while (curr.next != last) {
			curr = curr.next;
			strb.append(curr + ",");
			
		}

		if (strb.length() > 0 ) strb.deleteCharAt(strb.length() - 1);
		return strb.toString();
	}


	static class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public String toString() {
			return key + "-" + value;
		}
	}
}