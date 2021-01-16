class LinkedListOfLeaves {
	public static void main(String[] args) {
		
	}

	public static List<TreeNode<Integer>> createListOfLeaves(TreeNode<Integer> node) {
		List<TreeNode<Integer>> result = new ArrayList<>();
		preOrder(node, result);
		// inOrder(node, result);		
		return result;
	}

	public static void preOrder(TreeNode<Integer> node, List<TreeNode<Integer>> result) {
		if (node == null) return;		
		if (node.left == null && node.right == null) {
			result.add(node);
		} else {
			inOrder(node.left, result);
			inOrder(node.right, result);
		}		
	}

	// public static void inOrder(TreeNode<Integer> node, List<TreeNode<Integer>> result) {
	// 	if (node == null) return;
	// 	inOrder(node.left);
	// 	if (node.left == null && node.right == null) {
	// 		result.add(node);
	// 	}
	// 	inOrder(node.right);
	// }
}