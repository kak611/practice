import java.util.Arrays;
import java.util.Random;

class TestBinaryTree {

	public static int size = 31;
	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[size];
		for (int i=0; i<arr.length; i++) {
			arr[i] = random.nextInt(99) + 1;
		}
		System.out.print("Input array: \n" + Arrays.toString(arr));

		BinaryTree bt = new BinaryTree(arr);
		BinaryTree.Node root = bt.getRootNode();

		System.out.println("\n\n");
		System.out.println("In a given binary tree T, the total number of nodes 'n' are (2^(h+1) - 1) of which 2^h are leaf nodes where, h is height of the tree.");
		System.out.println("In other words, out of total 'n' nodes, the total leaf nodes are n/2 i.e. (2^h . 2^1)/2 i.e. 2^h");
		System.out.println("The root is at depth 0. Therefore, nodes at root are 2^0");
		System.out.println("The leaves are at depth h. Therefore, total nodes are depth h are 2^depth i.e. 2^h");
		System.out.println("The time complexity of traversal is O(n) for total 'n' nodes");
		System.out.println("The space complexity of DFS traversal is O(h) where the value of h is logn for complete binary tree & h=n for right/left skewed tree");
		System.out.println("The space complexity of BFS traversal (using queue) is max. number of nodes stored i.e. at leaf-level which is n/2 i.e. O(n)\n");
		System.out.println("\nPrinting Binary Tree with nodes n = (2^(h+1) - 1) = " + size + "... \n");
		bt.printBinaryTree2D(root, 0);
		System.out.println("\nPrint border:");
		bt.printBorder(root);
		System.out.println("\nIn-order traversal: ");
		bt.inOrder(root);
		System.out.println("\nPre-order traversal: ");
		bt.preOrder(root);
		System.out.println("\nPost-order traversal: ");
		bt.postOrder(root);
		System.out.println("\nLevel order traversal:");
		bt.levelOrder(root);		
		System.out.println("\nInOrder iterative:");
		bt.inOrderIterative(root);
		System.out.println("");


	}
}