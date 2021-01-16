import java.util.Random;
import java.util.List;
import java.util.Arrays;

class BTTest {
	public static final int N = 15;

	public static void main(String[] args) {
		int min = 10;
		int max = 90;
		Random random = new Random();		
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(max - min + 1) + min; //range 5..9
		}

		int[] symmetricArr = {0, 1, 1, 2, 3, 3, 2, 4, 5, 6, 7, 7, 6, 5, 4};
		System.out.println("Input array: " + Arrays.toString(arr));

		System.out.println("\n\n");
		System.out.println("In a given perfect binary tree T, the total number of nodes 'n' are (2^(h+1) - 1) of which 2^h are leaf nodes where, h is height of the tree.");
		System.out.println("In other words, out of total 'n' nodes, the total leaf nodes are n/2 i.e. (2^h . 2^1)/2 i.e. 2^h");
		System.out.println("The root is at depth 0. Therefore, nodes at root are 2^0");
		System.out.println("The leaves are at depth h. Therefore, total nodes are depth h are 2^depth i.e. 2^h");
		System.out.println("The time complexity of traversal is O(n) for total 'n' nodes");
		System.out.println("The space complexity of DFS traversal is O(h) where the value of h is logn for complete binary tree & h=n for right/left skewed tree");
		System.out.println("The space complexity of BFS traversal (using queue) is max. number of nodes stored i.e. at leaf-level which is n/2 i.e. O(n)\n");
		System.out.println("\nPrinting Binary Tree with nodes n = (2^(h+1) - 1) = " + N + "... \n");

		// construct
		BT binaryTree = new BT();
		// BT.Node root = binaryTree.construct(arr);
		BT.Node root = binaryTree.constructWithParent(arr);

		// horizontal traversal
		List<Integer> list = binaryTree.levelOrderTraversal(root);
		System.out.println("\nLevel order traversal: " + list);

		binaryTree.print2D(root, 0);

		// inorder
		list.clear();
		System.out.println("\nInorder traversal: ");
		binaryTree.inOrder(root);
		
		
		list.clear();
		list = binaryTree.inOrderIterative(root);
		System.out.println("\nInorder Iterative traversal: " + list);

		list.clear();
		list = binaryTree.inOrderUsingParentNode(root);
		System.out.println("\nInorder Iterative O(1) space: " + list);		
		

		// preorder
		list.clear();
		System.out.println("\nPreOrder traversal: ");
		binaryTree.preOrder(root);

		list.clear();
		list = binaryTree.preOrderIterative(root);
		System.out.println("\nPreOrder Iterative traversal: " + list);

		list.clear();
		System.out.println("\nPostOrder traversal: ");
		binaryTree.postOrder(root);

		System.out.println("\nBorder: ");
		binaryTree.printBorder(root);

		System.out.println("\nVertical traversal: ");
		binaryTree.printVerticalNodes(root);

		System.out.println("\nVertical traversal using treemap: ");
		binaryTree.printVerticalNodesUsingTreeMap(root);

		System.out.println("\nPrint top view: ");
		binaryTree.printTopView(root);
		System.out.println("\n");

		System.out.println("IsBalanced: " + String.valueOf(binaryTree.isBalanced(root)));
		System.out.println("IsSymmetric: " + String.valueOf(binaryTree.isSymmetric(root)));

		BT.Node temp = binaryTree.constructWithParent(symmetricArr);
		binaryTree.print2D(temp, 0);
		System.out.println("IsSymmetric: " + String.valueOf(binaryTree.isSymmetric(temp)));

		BT binaryTree2 = new BT();
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};		
		System.out.println(Arrays.toString(arr2));
		// BT.Node root2 = binaryTree2.buildTreeUsingCounter(arr2);
		BT.Node root2 = binaryTree2.buildTreeUsingCounter2(arr2);
		binaryTree2.print2D(root2, 0);

	}
}