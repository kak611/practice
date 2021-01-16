interface InterfaceIter<T> {
	boolean hasNext();
	boolean hasPrevious();
	DoublyLinkedList.Link next();
	DoublyLinkedList.Link previous();
	DoublyLinkedList.Link getCurrent();
	void reset();

	void insertAfter(T data);
	void insertBefore(T data);
	DoublyLinkedList.Link deleteCurrent();
}