class TestDoublyLinkedList {
	public static void main(String[] args) {
		// why cant dll type InterfaceDLL call getIterator() ?? 
		//InterfaceDLL<Integer> dll = new DoublyLinkedList<>();
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		InterfaceDLL<Character> dll2 = new DoublyLinkedList<>();		

		// insert first
		dll.insertFirst(2);
		dll.insertFirst(1);

		// insert first character
		dll2.insertFirst('a');
		dll2.insertAfter('a', 'b');
		dll2.displayForward();
		dll2.displayBackward();
		dll2.delete('a');
		dll2.displayForward();

		// insert last
		dll.insertLast(9);
		dll.insertLast(10);

		// display
		dll.displayForward();
		dll.displayBackward();

		//delete first
		int tmp = dll.deleteFirst();
		dll.displayForward();
		//delete last
		dll.deleteLast();
		//dll.deleteLast();
		//dll.deleteFirst();

		// display
		dll.displayForward();
		//dll.displayBackward();

		dll.insertAfter(2, 11);
		dll.displayForward();

		dll.delete(2);
		dll.displayForward();

		// Using iterator
		DoublyLinkedList.Link node;
		Iterator<Integer> iter = dll.getIterator();
		while (iter.hasNext()) {
			node = iter.next();
			System.out.println("Node: " + node);
		}

		while (iter.hasPrevious()) {
			DoublyLinkedList.Link curr = iter.getCurrent();
			System.out.println("Current Node: " + curr);
			node = iter.previous();
			System.out.println("Node: " + node);
		}

		//reset
		iter.reset();
		node = iter.next();
		System.out.println("Node: " + node);
	}
}