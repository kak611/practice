class Iterator<T> implements InterfaceIter<T> {
	DoublyLinkedList list;
	DoublyLinkedList.Link current;
	DoublyLinkedList.Link last;

	public Iterator(DoublyLinkedList list) {
		this.list = list;
		this.current = list.getPreLink();		
		//this.last = list.getPostLink();
	}

	public void reset() {
		current = list.getPreLink();
		//last = list.getPostLink();
	}

	public DoublyLinkedList.Link getCurrent() {
		return current;
	}

	public boolean hasNext() { 
		return current.getNext() != null;
	}

	public boolean hasPrevious() { 
		return current.getPrev() != null;
	}

	public DoublyLinkedList.Link next() {
		current = current.getNext();
		return current;
	}

	public DoublyLinkedList.Link previous() {
		current = current.getPrev();
		return current;
	}
	
	public void insertBefore(T data) {}
	public void insertAfter(T data) {}

// 	// either Link class should be outside or Iterator class should be inside with Link class to implement this
	public DoublyLinkedList.Link deleteCurrent() { return null; }
// 	public DoublyLinkedList.Link deleteCurrent() {
// 		if (list.isEmpty()) {
// 			System.out.println("Iter: List is empty!!");
// 			return null;
// 		}

// 		DoublyLinkedList.Link tmp = current;
// 		if (current == list.getPreLink().getNext()) {
// 			list.deleteFirst();
// 		} else if (current == list.getPostLink().getPrev()) {
// 			list.deleteLast();
// 		} else {
// 			//current.getPrev().getNext() = current.getNext();
// 			//current.getNext().getPrev() = current.getPrev();
// 		}

// 		return tmp;
// 	}


}
