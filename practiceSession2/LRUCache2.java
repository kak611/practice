import java.util.Map;
import java.util.HashMap;

class LRUCache2 {
	public static final int CAPACITY = 16;
	private Map<Integer, Node> map;
	private int capacity;
	private int size;
	private Node head;
	private Node tail;


	public LRUCache2(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
		this.size = 0;

		head = new Node();
		head.pre = null;

		tail = new Node();
		tail.post = null;

		head.post = tail;
		tail.pre = head;
	}

	public LRUCache2() {
		this(CAPACITY);
	}

	public void put(int key, int value) {		

		if (map.containsKey(key)) {
			Node n = map.get(key);
			n.value = value;
			moveToHead(n);
		} else {
			Node node = new Node();
			node.key = key;
			node.value = value;

			map.put(key, node);
			addFirst(node);
			size++;

			if (size() > capacity()) {
				Node r = removeLast();
				map.remove(r.key);
				size--;
			}
		}
	}

	public String toString() {
		return "\nmap: " + map + "\nlinkedlist: " + displayList();
	}

	public String displayList() {		
		StringBuilder strb = new StringBuilder();
		Node curr = head;
		while (curr != null) {
			strb.append(curr + "-");
			curr = curr.post;
		}
		strb.deleteCharAt(strb.length() - 1);
		return strb.toString();
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node != null) {
			moveToHead(node);
			return node.value;
		}
		return -1;
	}

	public int size() {
		return this.size;
	}

	public int capacity() {
		return this.capacity;
	}

	public void addFirst(Node node) {
		if (node == null) return;

		node.pre = head;
		node.post = head.post;

		head.post.pre = node;
		head.post = node;
	}

	public void removeNode(Node node) {
		if (node == null) return;
		Node prev = node.pre;
		Node next = node.post;

		prev.post = next;
		next.pre = prev;
	}

	public void moveToHead(Node node) {
		this.removeNode(node);
		this.addFirst(node);
	}

	public Node removeLast() {
		Node res = tail.pre;
		this.removeNode(res);
		return res;
	}

	class Node {
		int key;
		int value;
		Node pre;
		Node post;

		public String toString() {
			return "[" + key + ", " + value + "]";
		}
	}
}