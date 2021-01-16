class DoublyLinkedList<T> implements InterfaceDLL<T> {

	private Link first;
	private Link last;

	// == Iterator logic start ==

	public Iterator<T> getIterator() {
		return new Iterator(this);
	}

	public Link getPreLink() {		
		Link pre = new Link(null);
		pre.next = first;
		return pre;
	}

	public Link getPostLink() {
		Link post = new Link(null);
		post.prev = last;
		return post;
	}

	// public setFirst(Link link) {
	// 	this.first = link;
	// }

	// == Iterator logic ends == 

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(T num) {
		Link newLink = new Link(num);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.prev = newLink;
		}
		newLink.next = first;		
		first = newLink;
	}

	public void insertLast(T num) {
		Link newLink = new Link(num);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		newLink.prev = last;
		last = newLink;
	}

	public T deleteFirst() { 
		if (isEmpty()) return null;

		System.out.println("Deleted First element");
		T tmp = first.val;
		if (first.next == null) {
			last = null;
		} else {
			first.next.prev = null;			
		}
		//Link tmp = first;
		first = first.next;
		return tmp;

		
	}

	public T deleteLast() { 
		if (isEmpty()) return null;

		System.out.println("Deleted last element");		
		T tmp = last.val;
		if (last.prev == null || first.next == null) {
			first = null;
		} else {
			last.prev.next = null;
		}
		//Link tmp = last;
		last = last.prev;
		return tmp;		
	}

	public void insertAfter(T key, T val) {
		if (isEmpty()) {
			displayForward();
			return;
		}

		Link curr = first;
		Link newLink = new Link(val);
		while (curr != null && curr.val != key) {
			curr = curr.next;

			if (curr == null) {
				System.out.println("Key not found!");
				return;
			}
		}

		if (curr == last) {
			newLink.next = null;
			last = newLink;
		} else {
			curr.next.prev = newLink;
			newLink.next = curr.next;
		}

		curr.next = newLink;
		newLink.prev = curr;
	}

	public T delete(T key) {
		if(isEmpty()) {
			displayForward();
			return null;
		}

		Link curr = first;
		while(curr != null && curr.val != key) {
			curr = curr.next;
			if (curr == null) {
				System.out.println("key to be deleted NOT found!!");
				return null;
			}
		}

		T tmp = curr.val;
		System.out.println("Deleteing key " + tmp + " ...");

		if (curr == first) {
			//deleteFirst();
			if(curr.next != null) {
				curr.next.prev = null;
			}
			first = first.next;
		} else if (curr == last) {
			//deleteLast();
			if (curr.prev != null) {
				curr.prev.next = null;
			}
			last = last.prev;
		} else {
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
			// required ??
			curr.next = null;
			curr.prev = null;
		}

		return tmp;
	}

	public void displayForward() {
		Link curr = first;

		System.out.print("Displaying Forward: ");
		if (isEmpty()) {
			System.out.println("Linkedlist is empty!!");
			return;
		}
		while(curr != null) {
			System.out.print(curr);
			curr = curr.next;
		}
		System.out.println("");
	}

	public void displayBackward() {
		Link curr = last;

		System.out.print("Displaying Backward: ");
		if (isEmpty()) {
			System.out.println("Linkedlist is empty!!");
			return;
		}

		while (curr != null) {
			System.out.print(curr);
			curr = curr.prev;
		}
		System.out.println("");
	}

	class Link {
		private T val;
		private Link next;
		private Link prev;

		public void setNext(Link link) {
			this.next = link;
		}

		public Link getNext() {
			return this.next;
		}

		public void setPrev(Link link) {
			this.prev = link;
		}

		public Link getPrev() {
			return this.prev;
		}
	

		public Link(T val, Link next, Link prev) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}

		public Link(T val) {
			this(val, null, null);		
		}

		public String toString() {
			return this.val + " ";
		}
	}
}