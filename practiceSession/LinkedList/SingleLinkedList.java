class SingleLinkedList {

	private static Link first;

	public static void main(String[] args) {
		SingleLinkedList ll = new SingleLinkedList();
		//int emptyval = ll.deleteFirst();
		//System.out.println("DeleteFirst val: " + emptyval);
		//ll.display("List: ");
		ll.insertFirst(1);
		ll.insertFirst(2);
		ll.insertFirst(3);
		ll.insertFirst(4);		
		ll.insertFirst(5);
		ll.insertFirst(6);
		ll.insertFirst(7);
		ll.insertFirst(8);
		ll.insertFirst(9);
		ll.insertFirst(10);
		ll.display("List: ");
		// ll.insertAfter(4, ll.new Link(5));
		// ll.display("List: ");
		// int val = ll.deleteFirst();
		// System.out.println("DeleteFirst val: " + val);
		// Link tmp = ll.delete(ll.new Link(10));
		// System.out.println("Deleted val: " + ((tmp == null) ? null : tmp.val));
		// ll.display("List: ");
		// ll.reverse();
		 ll.reverseIterative();
		 ll.display("ReverseIter: ");
		// Link tmp2 = ll.search(2);
		// System.out.println((tmp2 != null ? "Found: " + tmp2.val : "Value not found"));
		// Link tmp3 = ll.search(11);
		// System.out.println((tmp3 != null ? "Found: " + tmp2.val : "Value not found"));

		first = ll.reverseRecursive(first);
		ll.display("ReversedRecur: ");

		//ll.reverseSublist(2, 5);
		//ll.display("Reversed sublist: ");

		ll.reverseSublistUsingSpace(2, 5);
		ll.display("Reversed sublist: ");
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int val) {
		Link node = new Link(val);
		if (!isEmpty()) {
			node.next = first;
		}
		first = node;
		//this.display("Insert: ");
	}

	public void reverse() {
		Link curr = first;
		Link prev = null;
		Link temp;
		while (curr != null) {
			temp = curr.next;
			//System.out.println("temp => " + temp);			
			curr.next = prev;
			//System.out.println("curr.next => " + curr.next);			
			prev = curr;
			//System.out.println("prev => " + prev);			
			curr = temp;
			//System.out.println("curr => " + curr + "\n");			
		}
		first = prev;		
	}

	public Link reverseRecursive(Link head) {			
		if (head.next == null) return head;

		Link reverseListHead = reverseRecursive(head.next);
		head.next.next = head;
		head.next = null;
		return reverseListHead;
	}

	public void insertAfter(int val, Link node) {
		Link curr = first;
		Link newNode = new Link(val);
		if(!isEmpty()) {
			while (curr != null && curr.val != node.val) {
				curr = curr.next;
			}
			newNode.next = curr.next;
			curr.next = newNode;
		}
		this.display("Insert " + val + " after " + node.val + ": ");
	}

	public Link delete(Link node) {
		Link prev = first;
		Link curr = first;

		while (curr != null && curr.val != node.val) {
			prev = curr;
			curr = curr.next;
		}

		if (curr != null) {
			prev.next = curr.next;
		}

		return curr;	
	}

	public Link search(int val) {
		Link curr = first;
		while (curr != null && curr.val != val) {
			curr = curr.next;
		}
		return curr;
	}

	public int deleteFirst() {				
		if (isEmpty()) return -1;

		Link temp = first;
		first = first.next;
		
		return temp.val;
	}

	public void display(String str) {
		Link curr = first;
		System.out.print(str + " ");
		while(curr != null) {
			System.out.print(curr + " ");
			curr = curr.next;
		}
		System.out.println("");
	}

	class Link {
		int val;
		Link next;

		public Link(int val) {
			this.val = val;
			this.next = null;
		}

		public String toString() {
			return "" + this.val;			
		}
	}

	public void reverseIterative() {
		Link curr = first;
		Link prev = null;
		while (curr != null) {
			Link temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		first = prev;
	}

	public void reverseSublist(int i, int j) {
		// reverse sublist from ith to jth node. Starting node is 1.
		// assume edge nodes are valid and forms sublist

		int k = 1;
		Link dummyNode = new Link(0);
		dummyNode.next = first;
		Link pre = dummyNode;		

		while(k++ < i) {
			pre = pre.next;
		}

		Link start = pre.next;
		while(i++ < j) {
			Link temp = start.next;
			start.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}

		first = dummyNode.next;
	}

	public void reverseSublistUsingSpace(int i, int j) {
		
		Link head = new Link(0);
		head.next = first;
		Link curr = head;

		int k = 1;

		while (k++ < i) {
			curr = curr.next;
		}

		Link dummyNode = new Link(0);
		Link temp = curr.next;

		// point to first node
		dummyNode.next = curr.next;
		while(i++ < j) {
			temp = temp.next;
		}

		//extract list with head as dummyNode
		curr.next = temp.next;
		temp.next = null;
		dummyNode.next = reverseRecursive(dummyNode.next);
		//first = dummyNode.next;
		//display("New: ");

		temp = dummyNode;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = curr.next;
		curr.next = dummyNode.next;
		//display("New: ");
	}
}