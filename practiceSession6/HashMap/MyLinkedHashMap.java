import java.util.Map;
import java.util.HashMap;

class MyLinkedHashMap {

	private Node first;
	private Node last;
	private int size;
	private int capacity;
	private Map<Integer, Node> map;
	public static final int CAPACITY = 16;

	public MyLinkedHashMap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.map = new HashMap<>();

		first = new Node(-1, -1);
		first.prev = null;

		last = new Node(-1, -1);
		last.next = null;

		first.next = last;
		last.prev = first;
	}

	public MyLinkedHashMap() {
		this(CAPACITY);
	}

	public void put(int key, int val) {
		Node node = map.get(key);
		if (node != null) {
			node.val = val;	
			moveToFirst(node);
		} else {
			node = new Node(key, val);
			map.put(key, node);
			addFirstNode(node);
			size++;
		}

		if (size() > capacity()) {
			Node lastNode = removeLast();
			map.remove(lastNode.key);
			size--;
		}
	}

	public int get(int key) {
		Node node = map.get(key);
		int result = -1;
		if (node != null) {
			moveToFirst(node);
			result = node.val;
		}
		return result;
	}


	public void addFirstNode(Node node) {		
		if (node == null) return;

		node.prev = first;
		node.next = first.next;

		first.next.prev = node;
		first.next = node;
	}

	public void removeNode(Node node) {
		if (node == null) return;

		Node pre = node.prev;
		Node post = node.next;

		pre.next = post;
		post.prev = pre;

		node.prev = null;
		node.next = null;
	}

	public void moveToFirst(Node node) {
		removeNode(node);
		addFirstNode(node);
	}

	public Node removeLast() {
		Node lastNode = last.prev;
		removeNode(lastNode);
		// last.prev = lastNode.prev;
		// lastNode.prev.next = last;

		// lastNode.prev = null;
		// lastNode.next = null;

		return lastNode;
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
		while (curr != null) {
			strb.append(curr + "->");
			curr = curr.next;
		}

		strb.deleteCharAt(strb.length() - 1);
		strb.deleteCharAt(strb.length() - 1);
		return "map: " + map + "\nlinkedList: " + strb.toString();
	}

	static class Node {
		int key;
		int val;		
		Node prev;
		Node next;

		public Node(int key, int val, Node prev, Node next) {
			this.key = key;
			this.val = val;
			this.prev = prev;
			this.next = next;
		}

		public Node(int key, int val) {
			this(key, val, null, null);
		}

		public String toString() {
			return "[" + this.key + "," + this.val + "]";
		}
	}

}