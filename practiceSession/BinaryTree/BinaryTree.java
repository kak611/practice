import java.util.Deque;
import java.util.LinkedList;

// complete binary tree is a tree in which at each level except probably the last level
// all nodes are completely filled and the nodes are as left as possible
class BinaryTree {
	public static final int COUNT = 10;

	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public BinaryTree(int val) {
		this.root = new Node(val);
	}

	public BinaryTree(int[] arr) {
		this.root = buildTree(arr, 0);
	}

	public Node getRootNode() {
		return root;
	}

	// construct BT in level order (similar to preorder)
	public Node buildTree(int[] arr, int index) {
		if (index >= arr.length) return null;
		Node node = new Node(arr[index]);
		node.left = buildTree(arr, 2*index + 1);
		node.right = buildTree(arr, 2*index + 2);
		return node;
	}

	//DFS traversal (using implicit stack)
	public void inOrder(Node root) {				
		if (root == null) return;
		inOrder(root.left);
		System.out.print(root);
		inOrder(root.right);
	}

	//DFS traversal (using implicit stack)
	public void preOrder(Node root) {		
		if (root == null) return;
		System.out.print(root);
		preOrder(root.left);
		preOrder(root.right);
	}

	//DFS traversal (using implicit stack)
	public void postOrder(Node root) {		
		if (root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root);
	}

	// BFS traversal using explicit queue
	public void levelOrder(Node root) {		
		if (root == null) return;

		Deque<Node> queue = new LinkedList<>();
		queue.addLast(root);
		Node node;
		while(!queue.isEmpty()) {
			node = queue.removeFirst();
			// sort of pre-order way but no recursion here
			System.out.print(node);
			if(node.left != null) queue.addLast(node.left);
			if(node.right != null) queue.addLast(node.right);
		}
	}

	// reverse inorder traversal (right --> root --> left)
	public void printBinaryTree2D(Node root, int space) {
		if (root == null) return;

		space += COUNT;

		printBinaryTree2D(root.right, space);
		//System.out.println("\n");
		for (int i = COUNT; i < space; i++) {
			System.out.print(" ");
		}		
		System.out.print(root + "\n");
		printBinaryTree2D(root.left, space);
	}

	public void inOrderIterative(Node root) {
		if (root == null) return;
		Deque<Node> stack = new LinkedList<>();
		Node curr = root;
		while (!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.addFirst(curr);
				curr = curr.left;
			} else {
				curr = stack.removeFirst();
				System.out.print(curr.val + " ");
				curr = curr.right;
			}
		}
	}

	public static void printBorder(Node root) {
		Node curr = root;
		//	1. print left border
		while (curr != null) {
			// dont print leaf nodes as they are covered in next step
			if (curr.left != null || curr.right != null) {
				System.out.print(curr.val + " ");
			}
			curr = curr.left;
		}

		//	2. print leaf nodes
		printLeafNodes(root);

		//	3. print right border
		curr = root;
		Deque<Node> stack = new LinkedList<>();	
		while (curr != null) {
			stack.addFirst(curr);
			curr = curr.right;
		}
		while(!stack.isEmpty()) {
			curr = stack.removeFirst();
			// dont print root node and leaf nodes as they are already covered
			if (curr == root || (curr.left == null && curr.right == null)) continue;
			System.out.print(curr.val + " ");
		}
	}

	public static void printLeafNodes(Node root) {
		if (root == null) return;
		printLeafNodes(root.left);
		if (root.left == null && root.right == null) {
			System.out.print(root.val + " ");
		}
		printLeafNodes(root.right);
	}


	class Node {
		private int val;
		private Node left;
		private Node right;

		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		public String toString() {
			return this.val + " ";
		}
	}

}