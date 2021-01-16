/*
	BinaryHeap is a complete binary tree. In complete binary tree with level ordering,
		parent = (i-1)/2;
		left child = 2*i + 1;
		right child = 2*i + 2;
*/

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Deque;

// Note: This code is not implemented properly. Use Integer class to handle null objects properly.
//       All algorithms are correct.
//		 From java's priorityQueue code, it seems we dont need to use binary tree node logic. Just work on arrays.
class BinaryHeap {
	private static final int COUNT = 10;
	private Node root;
	private int[] arr;
	private int capacity;
	private int numOfElements;

	// constructor 1
	public BinaryHeap(int capacity) {
		this.capacity = capacity;		
		this.arr = new int[this.capacity];
		this.numOfElements = 0;
		this.root = null;
	}

	// constructor 2
	public BinaryHeap(int[] arr) {
		this.arr = arr;
		this.capacity = arr.length;
		this.numOfElements = arr.length;
		this.root = buildHeap(arr, capacity);
	}


	// ** public methods **

	public Node getRootNode() {
		return this.root;
	}

	// display using root node
	public void displayHeapArr() {
		System.out.println("Min heap array representation: ");
		for (int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}


	// display level ordering traversal
	public void displayBinaryHeap() {
		Node node = this.root;
		System.out.println("Level order traversal of min-heap: ");
		Deque<Node> queue = new LinkedList<>();
		if (node != null) queue.add(node);
		Node curr;
		while (!queue.isEmpty()) {
			curr = queue.pollFirst();			
			System.out.print(curr);

			if (curr.left != null) queue.add(curr.left);
			if (curr.right != null) queue.add(curr.right);
		}
		System.out.println("");
	}

	// display 2D using reverse in-order traversal
	public void displayHeapIn2D(Node node, int space) {		
		if (node == null) return;
		space += COUNT;

		displayHeapIn2D(node.right, space);
		for (int i=COUNT; i < space; i++) {
			System.out.print(" ");
		}		
		System.out.println(node);
		displayHeapIn2D(node.left, space);
	}

	public int getMin() {
		return root.val;
	}

	// insert new element in min-heap & update it
	public void insert(int val) {
		if (numOfElements == capacity) {
			// amortize arr size
			this.capacity = 2 * capacity;
			int[] temp_arr = Arrays.copyOfRange(this.arr, 0, this.capacity);			
			this.arr = temp_arr;
			// fill empty slots with -1
			Arrays.fill(arr, numOfElements, capacity, -1);
			//System.out.println("Amortized array size: " + capacity + ", num of elements copied from old array: " + numOfElements);
		}		
		arr[numOfElements] = val;	
		
		// this wont work because the recursion call on 'child node' as parent (if smallest). so filterup/siftup
		//heapify(arr, capacity, (numOfElements-1)/2);
		// filterup index of new element if needed
		filterUp(arr, numOfElements);		

		numOfElements++;
		System.out.println("Inserted element: " + val);		
		displayHeapArr();
	}

	// delete smallest element in min-heap & update it
	public int extractMin() {
		int min = arr[0];
		arr[0] = arr[numOfElements-1];
		arr[numOfElements-1] = -1;
		numOfElements--;
		heapify(arr, capacity, 0);
		System.out.println(Arrays.toString(arr));
		this.root = buildBinaryTree(arr, capacity, 0);
		return min;
	}

	// remove at a given index (PriorityQueue implements this method
	// public int removeAt(int index) {}

	// check if given array is a min-heap
	public boolean isMinHeap(int[] arr) { return true; }

	// check if binary tree is a min-heap
	public boolean isMinHeap(Node node) { return true; }




	// ** private methods **

	// build min-heap
	private Node buildHeap(int[] arr, int n) {
		if (n == 0) return null;

		// start heapifyng from last non-leaf node in reverse order (because we need not heapify leaf nodes)
		// last non-leaf node = parent of last element i.e. parent of (n-1)
		// last non-leaf node = (i-1)/2 = ((n-1)-1)/2 = (n-2)/2 = n/2-1
		int index = n/2-1;
		for (int i=index; i >= 0; --i) {
			heapify(arr, n, i);	
		}

		// build binary tree from heapified array (apply level ordering) & return root node
		return buildBinaryTree(arr, n, 0);
	}


	// min-heap
	private void heapify(int[] arr, int n, int index) {
		// if (index >= n || index < 0) return;

		// index is parent node index
		int smallestInd = index;
		int leftChildInd = 2* index + 1;
		int rightChildInd = 2* index + 2;

		if (leftChildInd < n && arr[leftChildInd] < arr[index]) {
			smallestInd = leftChildInd;
		}

		if (rightChildInd < n && arr[rightChildInd] < arr[smallestInd]) {
			smallestInd = rightChildInd;
		}

		// if smallest element is not parent then swap
		if (smallestInd != index) {
			int temp = arr[index];
			arr[index] = arr[smallestInd];
			arr[smallestInd] = temp;

			// heapify parent of smallest i.e. (index-1)/2 where index=smallest
			// int parent = (smallestInd-1)/2;
			heapify(arr, n, smallestInd);
		}
	}

	private Node buildBinaryTree(int[] arr, int n, int parentInd) {
		if (n == 0 || parentInd >= n) return null;
		int leftInd = 2 * parentInd + 1;
		int rightInd = 2 * parentInd + 2;

		Node root = new Node(arr[parentInd]);
		root.left = buildBinaryTree(arr, n, leftInd);
		root.right = buildBinaryTree(arr, n, rightInd);
		return root;
	}

	private void filterUp(int[] arr, int index) {
		int parentInd = (index-1)/2;
		if (parentInd >= 0 && arr[parentInd] > arr[index]) {
			// swap
			int temp = arr[index];
			arr[index] = arr[parentInd];
			arr[parentInd] = temp;
			filterUp(arr, parentInd);

			// this is o(n) so not good idea
			this.root = buildBinaryTree(arr, capacity, 0);
		}
	}



	// Node class
	private static class Node {
		int val;
		Node left;
		Node right;

		public Node(int val) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return this.val + " ";
		}
	}
}