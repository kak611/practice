interface InterfaceDLL<T> {
	// all fields are public, static and final
	//final int N = 5;

	// public and abstract by default
	void insertFirst(T data);
	void insertLast(T data);
	T deleteFirst();
	T deleteLast();
	T delete(T data);
	void insertAfter(T key, T val);
	void displayForward();
	void displayBackward();	
}