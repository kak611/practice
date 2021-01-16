class SingleLinkedList {

	static private Node first;
	static private int size;

	public SingleLinkedList() {
		first = null;
		size = 0;
	}

	public static void insertFirst(int val) {
		Node node = new Node(val);
		node.next = first;
		first = node;
		size++;
	}

	public int deleteFirst() {
		if (first == null) return -1;
		int num = first.val;
		first = first.next;
		size--;
		return num;
	}

	public static void reverse(int start, int end) {
		if (start == end || start < 0
			|| start > size() || end > size()) return;

		Node dummyNode = new Node(-1, first);
		Node curr = dummyNode;
		int lo = 0;
		while (++lo < start) {
			curr = curr.next;
		}

		Node sublist = curr.next;
		while (start++ < end) {
			Node temp = sublist.next;
			sublist.next = temp.next;
			temp.next = curr.next;
			curr.next = temp;
		}
		first = dummyNode.next;
	}

	public static void oddeven() {
		Node dummyNode = new Node(-1, first);
		Node odd = dummyNode.next;
		Node even = dummyNode.next.next;
		Node evenStart = even;

		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;

			odd = odd.next;
			even = even.next;			
		}
		odd.next = evenStart;
	}

	public static void displayList() {
		Node curr = first;

		while (curr != null) {
			System.out.print(curr);
			curr = curr.next;
		}
		System.out.println();
	}

	public static boolean insertAfter(int key, int val) {
		Node curr = first;
		if (curr == null) {
			System.out.println(key + " not found!");
			return false;
		}

		while (curr != null && curr.val != key) {
			curr = curr.next;
		}
		if (curr == null) {
			System.out.println(key + " not found!");
			return false;		
		} else {
			Node node = new Node(val);
			node.next = curr.next;
			curr.next = node;
		}
		size++;
		return true;
	}

	public static int delete(int key) {
		if (isEmpty()) return -1;
		Node prev = null;
		Node curr = first;
		
		while (curr != null && curr.val != key) {
			prev = curr;
			curr = curr.next;
		}

		int val = -1;
		if (curr == null) {
			return -1;
		} else if (curr == first) {
			first = first.next;
		} else {
			prev.next = curr.next;
			val = curr.val;
			curr.next = null;
		}

		size--;
		return val;
	}

	public static boolean isEmpty() {
		return size == 0; // first == null;
	}

	public static int size() {
		return size;
	}

	static class Node {
		int val;
		Node next;

		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}

		public Node(int val) {
			this(val, null);
		}

		public String toString() {
			return this.val + " ";
		}
	}
}