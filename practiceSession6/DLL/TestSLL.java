class TestSLL {
	public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();		
		System.out.println(sll.isEmpty());
		sll.insertFirst(4);
		sll.insertFirst(5);
		sll.insertFirst(6);		
		sll.displayList();
		sll.delete(5);		
		sll.displayList();
		sll.insertAfter(5, 7);
		System.out.println(sll.isEmpty());
		while (!sll.isEmpty()) {
			sll.deleteFirst();
		}
		System.out.println(sll.isEmpty());
		sll.insertAfter(6, 7);
		sll.insertAfter(7, 8);
		sll.displayList();
		sll.deleteFirst();
		sll.displayList();

		for (int i = 0; i < 10; i++) {
			sll.insertFirst(i);
		}
		sll.displayList();
		sll.reverse(1,sll.size());
		sll.displayList();
		sll.reverse(1,sll.size());
		sll.displayList();
		sll.reverse(4,6);
		sll.displayList();
		sll.oddeven();
		sll.displayList();
	}
}