import java.util.Map;
import java.util.HashMap;

class LRUCache {
	public static final int CAPACITY = 16;
	private Map<Integer, DLNode> cache;
	private int capacity;
	private int size;
	// head <--> firstNode <--> secondNode <--> ... <--> lastNode <--> tail
	private DLNode head, tail;

	public LRUCache(int capacity) {
		cache = new HashMap<>();
		this.capacity = capacity;
		this.size = 0;

		head = new DLNode();
		head.pre = null;

		tail = new DLNode();
		tail.post = null;

		head.post = tail;
		tail.pre = head;
	}

	public LRUCache() {
		this(CAPACITY);
	}

	public void put(int key, int value) {
		DLNode node = cache.get(key);

		if (node == null) {
			DLNode newNode = new DLNode();
			newNode.key = key;
			newNode.value = value;
		
			cache.put(key, newNode);
			this.addNode(newNode);
			size++;

			if (size > capacity) {
				DLNode lastNode = removeLastNode();
				cache.remove(lastNode.key);
				size--;
			}
		} else {			
			node.value = value;
			this.moveToHead(node);
		}
	}

	public int get(int key) {
		DLNode node = cache.get(key);
		if (node == null) {
			return -1;
		}
		
		moveToHead(node);
		return node.value;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return capacity;
	}

	public String toString() {
		return "\ncache: " + cache + "\nlinkedList: " + displayList();
	}

	private String displayList() {
		DLNode curr = head;
		StringBuilder strb = new StringBuilder();
		while (curr != null) {
			strb.append(curr + "-");
			curr = curr.post;
		}
		strb.deleteCharAt(strb.length() - 1);
		return strb.toString();
	}


	// doubly linkedlist node	
	class DLNode {
		int key;
		int value;
		DLNode pre;
		DLNode post;

		public String toString() {
			return "[" + key + ", " + value + "]";
		}
	}

	private void addNode(DLNode node) {
		if (node == null) return;

		node.pre = head;
		node.post = head.post;

		head.post.pre = node;
		head.post = node;
	}

	private void removeNode(DLNode node) {
		if (node == null) return;

		DLNode pre = node.pre;
		DLNode post = node.post;

		pre.post = post;
		post.pre = pre;
	}

	private void moveToHead(DLNode node) {
		this.removeNode(node);
		this.addNode(node);
	}

	private DLNode removeLastNode() {
		DLNode result = tail.pre;
		this.removeNode(result);
		return result;
	}
}