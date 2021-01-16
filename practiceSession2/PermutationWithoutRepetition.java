import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

class PermutationWithoutRepetition {
	// write a function to create n-ary tree for given string with depth 2 (with repetiton of characters)
	// then traverse and print leaf words
	// For e.g, s="abc", length (depth) =2, branches = length of string

	public static void main(String[] args) {
		String str = "abc";
		int length = 3;

		Node root = new Node(' ');
		HashSet<Character> hashset = new HashSet<>();
		constructTree(str.toCharArray(), length, 0, root, new HashSet<Character>());
		StringBuilder strb = new StringBuilder();
		dfs(root, length, 0, strb);
	}

	public static void constructTree(char[] arr, int depth, int currDepth, Node node, HashSet<Character> hashset) {
		if (currDepth == depth) return;

		// arr.length = number of branches
		for (int i = 0; i < arr.length; i++) {
			if (!hashset.contains(arr[i])) {
				node.children.add(new Node(arr[i]));
				hashset.add(arr[i]);
			}
			System.out.println(hashset);
			constructTree(arr, depth, currDepth + 1, node.children.get(i), hashset);
			if (hashset.contains(arr[i])) hashset.remove(arr[i]);
		}
	}

	public static void dfs(Node root, int depth, int currDepth, StringBuilder strb) {
		if (currDepth == depth)  {
			System.out.print(strb.toString() + " ");
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