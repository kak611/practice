class InorderConstantTime {
	public static void main(String[] args) {
		
	}

	public static List<Integer> inOrderTraversal(TreeNode<Integer> root) {
		List<Integer> result = new ArrayList<>();
		TreeNode prev = null;
		TreeNode curr = root;

		while (curr != null) {
			TreeNode next = null;
			if (curr.parent == prev) {
				if (curr.left != null) {					
					next = curr.left;
				} else {
					result.add(curr.val);
					next = (curr.right != null) ? curr.right : curr.parent;
				}
			} else if (curr.left == prev) {
				result.add(curr.val);
				next = (curr.right != null) ? curr.right : curr.parent;
			} else {
				next = curr.parent;
			}
			prev = curr;
			curr = next;
		}
		return result;
	}
}