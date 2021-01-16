import java.util.*;

// Sorting algorithm using BST
class BSTInsertDelete {
	public static Node root;
	public static final int SPACE = 10;
	public static void main(String[] args) {
		MyArray myArray = new MyArray(15,100,999);		
		int[] arr = myArray.getUnsortedArray();		
		System.out.println("Before creating BST: " + Arrays.toString(arr));
		for (int a : arr) {
			insert(a);
		}

		inOrder(root);
		System.out.println("\n\n");
		displayTree(root, 0);

		System.out.println("\nDelete root node\n\n");
		delete(root.val);
		displayTree(root, 0);
		System.out.println("\n\n");
		inOrder(root);
		System.out.println("\nMin: " + getMin(root));
		System.out.println("Max: " + getMax(root));

		
		Random random = new Random();
		int num = arr[random.nextInt(arr.length)];
		// find predecessor
		System.out.println("\npredecessor of " + num + " : " + findPredecessorWithoutParentPointer(num));
		System.out.println("predecessor (using parent pointer) of " + num + " : " + findPredecessor(num));
		Node res1 = findPredecessorRecursively(root, num);
		System.out.println("predecessor (recursively) of " + num + " : " + ((res1 == null) ? -1 : res1.val));

		// find successor
		System.out.println("\nSuccessor of " + num + " : " + findSuccessorWithoutParentPointer(num));
		System.out.println("Successor (using parent pointer) of " + num + " : " + findSuccessor(num));
		Node res2 = findSuccessorRecursively(root, num);

		System.out.println("Successor (recursively) of " + num + " : " + ((res2 == null) ? -1 : res2.val));

		// select
		updateSize(root);
		int indx = random.nextInt(arr.length);
		Node n = findNthNode(root, indx);
		System.out.println(indx + "th node: " + ((n != null) ? n.val : -1));

		// // rank
		// int indx2 = random.nextInt(arr.length);
		// int rank = findRank(root, arr[indx2]);
		// System.out.println("Rank of " + arr[indx2] + ": " + rank);
	}

	public static Node findNthNode(Node root, int index) {
		while (root != null) {
			int leftSize = (root.left != null) ? root.left.size : 0;
			if (index == leftSize + 1) {
				return root;
			} else if (index > leftSize + 1) {
				index -= (leftSize + 1);
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return null;
	}

	// public static int findRank(Node root, int val) {
	// 	Node curr = root;
	// 	// find val node
	// 	while (curr != null && curr.val != val) {
	// 		curr = (val < curr.val) ? curr.left : curr.right;
	// 	}

	// 	if (curr == null) return -1;
	// 	System.out.println("root size: " + root.size);
	// 	System.out.println(val + " node size: " + curr.size);
	// 	return root.size - curr.size;
	// }

	public static void updateSize(Node root) {
		if (root == null) return;

		updateSize(root.left);
		updateSize(root.right);
		root.size = 1 + ((root.left != null) ? root.left.size : 0)
				 	+ ((root.right != null) ? root.right.size : 0);
	}

	// recursive
	public static Node findPredecessorRecursively(Node root, int val) {
		if (root == null) return null;

		if (val > root.val) {
			Node result = findPredecessorRecursively(root.right, val);
			return (result != null) ? result : root;
		} else {
			return findPredecessorRecursively(root.left, val);
		}
	}
	
	// iterative
	public static int findPredecessorWithoutParentPointer(int val) {		
		Node curr = root;
		Node result = null;
		while (curr != null) {
			// if val is greater than current val, then current val can be predecessor
			// mark this and go right			
			if (val > curr.val) {
				result = curr;
				curr = curr.right;
			} else {
				curr = curr.left;
			}			
		}
		return (result != null) ? result.val : -1;
	}

	// using parent
	public static int findPredecessor(int val) {
		Node curr = root;		

		// find val since the input is not the exact node whose predecessor is to be searched
		while (curr != null && curr.val != val) {			
			curr = (val < curr.val) ? curr.left : curr.right;
		}

		if (curr == null) return -1;

		if (curr.left != null) {
			curr = curr.left;
			while (curr.right != null) {
				curr = curr.right;
			}
			return curr.val;
		}

		while (curr.parent != null && curr.parent.left == curr) {
			curr = curr.parent;
		}
		return (curr.parent != null) ? curr.parent.val : -1;		
	}


	// recursive
	public static Node findSuccessorRecursively(Node root, int val) {
		if (root == null) return null;

		if (val < root.val) {
			Node result = findSuccessorRecursively(root.left, val);			
			return (result != null) ? result : root;
		} else {
			return findSuccessorRecursively(root.right, val);
		}
	}

	// iterative
	public static int findSuccessorWithoutParentPointer(int val) {		
		Node curr = root;
		Node result = null;

		while (curr != null) {
			// if val is smaller, curr.val can be successor
			// so mark this and go left			
			if (val < curr.val) {
				result = curr;
				curr = curr.left;
			} else {
				curr = curr.right;				
			}
		}
		return (result != null) ? result.val : -1;
	}

	
	// using parent
	public static int findSuccessor(int val) {
		Node curr = root;

		// find val since the input is not the exact node whose successor is to be searched
		while (curr != null && curr.val != val) {
			curr = (val < curr.val) ? curr.left : curr.right;
		}
		if (curr == null) return -1;

		if (curr.right != null) {
			curr = curr.right;
			while (curr.left != null) {
				curr = curr.left;
			}
			return curr.val;
		}

		while (curr.parent != null && curr.parent.right == curr) {
			curr = curr.parent;
		}

		return (curr.parent != null) ? curr.parent.val : -1;
	}

	public static int getMin(Node root) {
		if (root == null) return -1;
		Node curr = root;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr.val;
	}

	public static int getMax(Node root) {
		if (root == null) return -1;
		Node curr = root;
		while (curr.right != null) {
			curr = curr.right;
		}
		return curr.val;
	}

	public static boolean delete(int val) {
		Node parent = null;
		Node curr = root;

		// find val
		while (curr != null && curr.val != val) {
			parent = curr;
			curr = (val < curr.val) ? curr.left : curr.right;
		}

		// if not found, return false
		if (curr == null) return false;

		Node keyNode = curr;		
		if (keyNode.right != null) {
			Node rNode = keyNode.right;
			Node parentNode = keyNode;
			while (rNode.left != null) {
				parentNode = rNode;
				rNode = rNode.left;
			}

			keyNode.val = rNode.val;
			if (parentNode.left == rNode) {
				parentNode.left = rNode.right;
			} else {
				parentNode.right = rNode.right;
			}
			rNode.right = null;
		} else {
			if (root == keyNode) {
				root = keyNode.left;
				keyNode.left = null;
			} else {
				if (parent.left == keyNode) {
					parent.left = keyNode.left;
				} else {
					parent.right = keyNode.left;
				}
				keyNode.left = null;
			}
		}
		return true;
	}

	public static void displayTree(Node root, int cnt) {
		if (root == null) return;
		cnt += SPACE;
		displayTree(root.right, cnt);
		for (int i = SPACE; i < cnt; i++) {
			System.out.print(" ");
		}
		System.out.print(root.val + "\n");
		displayTree(root.left, cnt);
	}

	public static void inOrder(Node root) {
		if (root == null) return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	public static void insert(int val) {
		Node node = new Node(val);
		if (root == null) {
			node.parent = root;
			root = node;			
		} else {
			Node curr = root;
			Node parent = null;
			while (curr != null) {
				parent = curr;
				if (val <= curr.val) {
					curr = curr.left;
				} else {
					curr = curr.right;
				}
			}

			if (val < parent.val) {
				parent.left = node;				
			} else {
				parent.right = node;
			}
			node.parent = parent;
		}
		return;
	}



	static class Node {
		int val;
		int size;
		Node left;
		Node right;
		Node parent;

		public Node(int val) {
			this.val = val;
		}
	}
}