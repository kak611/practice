class BSTInsertDelete {
	private static TreeNode root = null;

	public static void main(String[] args) {
		String str = "10 5 25 15 30 31 20 11 13 12 17 16 19 18 22 21 24";
		String[] list = str.split(" ");

		constructBST(list);
		// print2D(root, 0);
		inOrder(root);


		remove(20);
		remove(11);
		remove(15);
		remove(12);
		remove(13);
		remove(22);	
		System.out.println("");		
		inOrder(root);

		insert(20);
		insert(11);
		insert(15);
		insert(12);
		insert(13);
		insert(22);
		System.out.println("");		
		inOrder(root);		

		// print2D(root, 0);
	}

	public static void remove(int key) {
		TreeNode curr = root;
		TreeNode parent = null;

		while (curr != null && curr.val != key) {
			parent = curr;
			if (key < curr.val) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}			
		}
		
		if (curr == null) return; // key not found!

		TreeNode keyNode = curr;
		if (keyNode.right != null) {
			TreeNode rNode = keyNode.right;
			TreeNode rParent = keyNode;
			while (rNode.left != null) {
				rParent = rNode;
				rNode = rNode.left;
			}			
			keyNode.val = rNode.val;			
			if (rParent.left == rNode) {
				rParent.left = rNode.right;
			} else {
				rParent.right = rNode.right;
			}
			rNode.right = null;
		} else {			
			if (keyNode == root) {
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
	}

	public static void constructBST(String[] list) {
		for (int i=0; i < list.length; i++) {
			insert(getInteger(list[i]));
		}
	}

	public static void insert(int key) {
		if (root == null) {
			root = new TreeNode(key);
		} else {
			TreeNode curr = root;
			TreeNode parent = null;
			while (curr != null) {
				parent = curr;
				if (key == curr.val) {
					return; // duplicate key
				} else if (key <= curr.val) {
					curr = curr.left;
				} else {
					curr = curr.right;
				}
			}

			if (key <= parent.val) {
				parent.left = new TreeNode(key);
			} else {
				parent.right = new TreeNode(key);
			}
		}
	}


	public static int getInteger(String str) {
		int num = 0;
		for (int i=0; i < str.length(); i++) {
			num = num * 10 + str.charAt(i) - '0';
		}
		return num;
	}


	public static final int COUNT = 10;
	public static void print2D(TreeNode root, int space) {
		if (root == null) return;

		space += COUNT;

		print2D(root.right, space);
		//System.out.println("\n");
		for (int i = COUNT; i < space; i++) {
			System.out.print(" ");
		}		
		System.out.print(root + "\n");
		print2D(root.left, space);
	}


	public static void inOrder(TreeNode node) {
		if (node == null) return;
		inOrder(node.left);
		System.out.print(node);
		inOrder(node.right);
	}






	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		public String toString() {
			return this.val + " ";
		}
	}
}