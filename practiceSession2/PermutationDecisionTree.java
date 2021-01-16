import java.util.ArrayList;
import java.util.List;

class PermutationDecisionTree {
	// write a function to create n-ary tree for given string with depth 2 (with repetiton of characters)
	// then traverse and print leaf words
	// For e.g, s="abc", length (depth) =2, branches = length of string

	public static void main(String[] args) {
		String str = "abc";
		int length = 2;

		Node root = new Node(' ');
		constructTree(str.toCharArray(), length, 0, root);
		StringBuilder strb = new StringBuilder();
		dfs(root, length, 0, strb);
	}

	public static void constructTree(char[] arr, int depth, int currDepth, Node node) {
		if (currDepth == depth) return;

		// arr.length = number of branches
		for (int i = 0; i < arr.length; i++) {
			node.children.add(new Node(arr[i]));
			constructTree(arr, depth, currDepth + 1, node.children.get(i));
		}
	}

	public static void dfs(Node root, int depth, int currDepth, StringBuilder strb) {

		if (currDepth == depth)  {  // OR strb.length() == depth. Then we dont need currDepth to increment in recursive functio
n			System.out.print(strb.toString() + " ");
			return;			
		}

		for (int i =0 ; i < root.children.size(); i++) {
			strb.append(root.children.get(i));
			dfs(root.children.get(i), depth, currDepth + 1, strb);
			strb.deleteCharAt(strb.length() - 1);
		}
	}

	static class Node {
		char val;
		List<Node> children;

		public Node(char val) {
			this.val = val;
			children = new ArrayList<Node>();
		}

		public String toString() {
			return "" + this.val;
		}
	}
}