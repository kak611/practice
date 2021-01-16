import java.util.List;

interface BTInterface {
	BT.Node construct(int[] arr);	

	
	// prints
	void printBorder(BT.Node root);	// covers printLeafNodes()
	void printVerticalNodes(BT.Node root);
	void printVerticalNodesUsingTreeMap(BT.Node root);
	void printTopView(BT.Node root);
	void print2D(BT.Node root, int space);
		
	// traversals
	List<Integer> levelOrderTraversal(BT.Node root);  // print horizontally
	void inOrder(BT.Node root);	
	void inOrder(BT.Node root, List<Integer> list);
	List<Integer> inOrderIterative(BT.Node root);
	List<Integer> inOrderUsingParentNode(BT.Node root);
	void preOrder(BT.Node root);
	List<Integer> preOrderIterative(BT.Node root);
	void postOrder(BT.Node root);

	// misc.
	boolean isBalanced(BT.Node root);	
	boolean isSymmetric(BT.Node root);
	// void constructUsingTraversalData(int[] inOrderArray, int[] preOrderArray);

}