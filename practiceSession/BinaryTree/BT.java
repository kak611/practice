import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

class BT implements BTInterface {

	public static final int COUNT = 10;

	// construct binary tree
	public Node construct(int[] arr) {
		if (arr == null || arr.length == 0) return new Node(-1);
		return buildTree(arr, 0);
	}

	private Node buildTree(int[] arr, int index) {
		if (index > arr.length - 1) return null;

		Node root = new Node(arr[index]);		
		root.left = buildTree(arr, 2*index + 1);
		root.right = buildTree(arr, 2*index + 2);
		return root;
	}

	public Node constructWithParent(int[] arr) {
		if (arr == null || arr.length == 0) return new Node(-1);
		return buildTree(arr, 0, null);
	}

	private Node buildTree(int[] arr, int index, Node parent) {
		if (index > arr.length - 1) return null;

		Node root = new Node(arr[index]);		
		root.parent = (parent != null) ? parent : null;
		root.left = buildTree(arr, 2*index + 1, root);
		root.right = buildTree(arr, 2*index + 2, root);
		return root;
	}

	 public Node buildTreeUsingCounter2(int[] arr) {
	 	int treeSize = 0;
	 	int msbVal = 0;
	 	// root node
	 	Node root = new Node(arr[0]);	 	
	 	treeSize++;
	 	msbVal = treeSize; // 2^0 = 1

	 	for (int i=1; i<arr.length; i++) {
	 		// check if next level in tree i.e. if treeSize is power of 2 (2^depth)
	 		treeSize++;
	 		if ((treeSize & (treeSize - 1)) == 0) {
	 			// msbVal is Most Significant bit i.e. left most set bit.
	 			// its value is 2^depth => 1, 10, 100, 1000...
	 			msbVal = treeSize; // OR msbVal << 1
	 		}
	 		//System.out.println("treeSize: " + treeSize + ", msbVal: " + msbVal);
	 		// need new var because it gets modified by right shift operator
	 		int tmpVal = msbVal;
	 		Node curr = root;
	 		while (true) {
	 			tmpVal >>>= 1;
	 			if ((treeSize & tmpVal) == 0) {
	 				if (curr.left != null) {
	 					curr = curr.left;
	 				} else {
	 					curr.left = new Node(arr[i]);
	 					break;
	 				}
	 			} else {
	 				if (curr.right != null) {	 					
	 					curr = curr.right;
	 				} else {
	 					curr.right = new Node(arr[i]);
	 					break;
	 				}
	 			}
	 		}
	 	}
	 	return root;
	 }

	// build using counter
	public Node buildTreeUsingCounter(int[] arr) {		
		if (arr.length == 0) return null;		
		int counter = 1;
		Node root = new Node(arr[0]);
		Node prev = null;
		Node iter = root;

		for (int i=1; i < arr.length; i++) {			
			counter = i+1;			
			// if counter = 5 (101) then msb position = 3.. so left shift 2 times (1 << 2) to reach MSB
			// if counter = 9 (1001) then msb position = 4.. so left shift 3 times (1 << 3) to reach MSB
			int msb = getMSB(counter);
			msb -= 2;
			// 101 & 100 (in above example) OR 
			// 1001 & 1000 for counter = 9 & (1 << 3)
			iter = root; // start traversing from root
			while (iter != null) {
				prev = iter;
				if ((counter & (1 << msb--)) > 0) {					
					iter = iter.right;					
				} else {
					iter = iter.left;					
				}
			}

			if (counter % 2 == 0) {
				prev.left = new Node(arr[i]);
			} else {
				prev.right = new Node(arr[i]);
			}
		}
		return root;
	}

	public int getMSB(int num) {
		int msb = 0;
		while (num != 0) {
			num >>>= 1; // (n/2)
			msb++;
		}
		return msb;
	}


	// reverse inorder
	public void print2D(Node root, int space) {
		if (root == null) return;
		space += COUNT;

		print2D(root.right, space);		
		for (int i = COUNT; i < space; i++) {
			System.out.print("  ");
		}
		System.out.print(root.val + "\n");

		print2D(root.left, space);
	}


// ***** MISC. *****
	public boolean isSymmetric(Node root) {
		if (root == null) return true;
		return checkSymmetry(root.left, root.right);
	}

	private boolean checkSymmetry(Node lNode, Node rNode) {
		if (lNode == null && rNode == null) return true;

		if (lNode.val == rNode.val) {
			return checkSymmetry(lNode.left, rNode.right) &&
				checkSymmetry(lNode.right, rNode.left);
		}
		return false;
	}


	public boolean isBalanced(Node root) {
		if (root == null) return true;

		int heightLeftTree = getHeight(root.left);
		int heightRightTree = getHeight(root.right);
		System.out.println("heightLeftTree: " + heightLeftTree + ", heightRightTree: " + heightRightTree);
		return (heightLeftTree - heightRightTree) <= 1;
	}

	private int getHeight(Node root) {
		if (root == null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}


// ******* PRINT ***********

	class NodeWithDepth {
		Integer val;
		Integer depth;

		// Note: override equals and hashmap to use this class objects effectively in treemap

		public NodeWithDepth(Integer val, Integer depth) {
			this.val = val;
			this.depth = depth;
		}

		public NodeWithDepth() {
			this(null, null);
		}
	}

	public void printTopView(Node root) {
		if (root == null) return;
		NodeWithDepth nwd = new NodeWithDepth();

		// key : value => distance : NodeWithDepth
		TreeMap<Integer, NodeWithDepth> treeMap = new TreeMap<>();
		printTopView(root, 0, treeMap, 0);

		for (Map.Entry<Integer, NodeWithDepth> entry : treeMap.entrySet()) {
			System.out.print(entry.getValue().val + " ");
		}
	}

	private void printTopView(Node node, Integer hd, TreeMap<Integer, NodeWithDepth> treeMap, Integer depth) {
		if (node == null) return;
		
		if (!treeMap.containsKey(hd)) {
			treeMap.put(hd, new NodeWithDepth(node.val, depth));
		} else {
			NodeWithDepth temp = treeMap.get(hd);
			// update if new depth is lower than stored depth
			if (depth < temp.depth) {
				treeMap.put(hd, new NodeWithDepth(node.val, depth));
			}
		}

		printTopView(node.left, hd-1, treeMap, depth+1);
		printTopView(node.right, hd+1, treeMap, depth+1);
	}

	class Values {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}

	public void printVerticalNodesUsingTreeMap(Node root) {
		// sorted order as per min to max distance
		TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
		Values val = new Values();
		findMinMax(root, val, 0, treeMap);

		for (Map.Entry<Integer, ArrayList<Integer>> entry: treeMap.entrySet()) {
			for (Integer i : entry.getValue()) {
				System.out.print(i + " ");	
			}			
		}
	}

	public void findMinMax(Node node, Values val, Integer hd, TreeMap<Integer, ArrayList<Integer>> treeMap) {
		if (node == null) return;
		val.min = Math.max(val.min, hd);
		val.max = Math.min(val.max, hd);

		ArrayList<Integer> list;
		if (!treeMap.containsKey(hd)) {
			list = new ArrayList<>();
			list.add(node.val);
			treeMap.put(hd, list);
		} else {
			list = treeMap.get(hd);
			list.add(node.val);
		}

		findMinMax(node.left, val, hd-1, treeMap);
		findMinMax(node.right, val, hd+1, treeMap);
	}



	// O(n^2)
	public void printVerticalNodes(Node root) {
		if (root == null) return;
		Values val = new Values();
		findMinMax(root, val, 0);
		for (int i = val.min; i<= val.max; i++) {
			printVerticalNodes(root, 0, i);	
		}
	}

	public void printVerticalNodes(Node node, int hd, int i) {
		if (node == null) return;

		if (i == hd) {
			System.out.print(node.val + " ");
		}

		//if (i < hd) 
		printVerticalNodes(node.left, hd-1, i);
		//if (i > hd) 
		printVerticalNodes(node.right, hd+1, i);
	}

	private void findMinMax(Node root, Values val, int hd) {
		val.min = Math.min(val.min, hd);
		val.max = Math.max(val.max, hd);
		if (root.left != null) findMinMax(root.left, val, hd-1);
		if (root.right != null) findMinMax(root.right, val, hd+1);
	}

	public void printBorder(Node root) {
		if (root == null) return;
		Node curr = root;

		//print left side top-down
		while (curr.left != null) {			
			System.out.print(curr.val + " ");
			curr = curr.left;
		}

		// use any traversal and print nodes with zero child nodes
		// using preorder iterative traversal
		curr = root;
		Deque<Node> stack = new LinkedList<>();
		stack.addFirst(curr);
		Node node;
		while (!stack.isEmpty()) {
			curr = stack.removeFirst();
			// print only leaf nodes
			if (curr != null) {
				if (curr.left == null && curr.right == null) System.out.print(curr.val + " ");			
				stack.addFirst(curr.right);
				stack.addFirst(curr.left);			
			}
		}

		// print righside bottom-up
		curr = root;
		stack.clear();
		while (curr.right != null) {			
			stack.addFirst(curr);
			curr = curr.right;
		}
		while (!stack.isEmpty()) {
			curr = stack.removeFirst();
			if (curr == root || (curr.left == null && curr.right == null)) continue;
			System.out.print(curr.val + " ");
		}
	}


// **** TRAVERSALS ****

	public void postOrder(Node root) {
		if (root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

	public void preOrder(Node root) {
		if (root == null) return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public List<Integer> preOrderIterative(Node root) {
		if (root == null) return null;
		List<Integer> list = new ArrayList<>();
		Deque<Node> stack = new LinkedList<>();
		stack.addFirst(root);
		Node curr;
		while (!stack.isEmpty()) {
			curr = stack.removeFirst();
			if (curr != null) {
				list.add(curr.val);				
				stack.addFirst(curr.right);
				stack.addFirst(curr.left);
			}
		}
		return list;
	}

	// inOrder iterative in O(1) space i.e. using parent node
	public List<Integer> inOrderUsingParentNode(Node root) {
		//if (root == null) return null;
		List<Integer> list = new ArrayList<>();
		Node curr = root;
		Node prev = null;
		while (curr != null) {
			Node next;
			if (curr.parent == prev) {
				if (curr.left != null) {					
					next = curr.left;				
				} else {
					list.add(curr.val);					
					next = (curr.right != null) ? curr.right : curr.parent;
				}
			} else if (curr.left == prev) {
				list.add(curr.val);
				next = (curr.right != null) ? curr.right : curr.parent;
			} else {
				next = curr.parent;
			}

			prev = curr;
			curr = next;
		}
		return list;
	}

	// inOrder iterative using stack
	public List<Integer> inOrderIterative(Node root) {
		if (root == null) return null;
		List<Integer> list = new ArrayList<>();
		Deque<Node> stack = new LinkedList<>();
		Node curr = root;
		stack.addFirst(curr);
		Node node;
		while (!stack.isEmpty()) {
			while(curr.left != null) {
				curr = curr.left;
				stack.addFirst(curr);
				
			}
			node = stack.removeFirst();
			// print or add
			list.add(node.val);
			if (node.right != null) {				
				node = node.right;
				stack.addFirst(node);
				curr = node;
			}
		}
		return list;
	}

	//inOrder
	public void inOrder(Node root) {		
		if (root == null) return;
		inOrder(root.left);
		if (root.parent != null) {
			System.out.print(root.val + "[" + root.parent.val + "]" + " ");		
		} else {
			System.out.print(root.val + " ");		
		}
		inOrder(root.right);		
	}

	// inorder recursive with list
	public void inOrder(Node root, List<Integer> list) {		
		if (root == null) return;
		inOrder(root.left, list);
		list.add(root.val);
		//System.out.print(root.val + " ");		
		inOrder(root.right, list);		
	}

	// level-order or horizontal traversal
	public List<Integer> levelOrderTraversal(Node root) {
		if (root == null) return null;
		List<Integer> nodeList = new ArrayList<>();

		Deque<Node> queue = new LinkedList<>();
		queue.addLast(root);
		Node node;
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			// add to list or print
			nodeList.add(node.val);
			//System.out.print(node.val + " ");
			
			if (node.left != null) queue.addLast(node.left);
			if (node.right != null) queue.addLast(node.right);
		}
		return nodeList;
	}


	// NODE
	class Node {
		int val;
		Node left;
		Node right;
		Node parent;

		public Node(int val, Node left, Node right, Node parent) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}

		public Node(int val) {
			this(val, null, null, null);
		}
	}
}