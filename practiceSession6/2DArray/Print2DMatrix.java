class Print2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{11,12,13,14}, {15,16,17,18}, {19,20,21,22}, {23,24,25,26}};
		// int[][] matrix = { {1, -1, 1, 0, 2}, {1,1,1,0,0}, {2,3,-1,1,-1}, {2, -1, 1, 0, 0}, {2,3,2,3,2}};
		
		int rows = matrix.length;
		int cols = matrix[0].length;

		// print horizontal
		printHorizontal(matrix, rows ,cols);

		// print vertical
		printVertical(matrix, rows, cols);
		printVertical2(matrix, rows, cols);
		rotateLeft(matrix, rows, cols);
		rotateRight(matrix, rows, cols);
		mirror(matrix, rows, cols);

		// print diagonal top-right to bottom-left
		printDiagonal(matrix, rows, cols);

		// print diagonal bottom-left to top-right
		printDiagonal2(matrix, rows, cols);
	}

	// top-right to bottom-left starting from top-left
	public static void printDiagonal(int[][] matrix, int rows, int cols) {
		System.out.println("Print counter diagonal starting from top-left: ");
		// row = 0 is fixed
		for (int j = 0; j < cols; j++) {
			printTopRightToBottomLeft(matrix, rows, cols, 0, j);
		}

		// col = col-1 is fixed
		for (int i = 1; i < rows; i++) {
			printTopRightToBottomLeft(matrix, rows, cols, i, cols - 1);
		}
	}

	private static void printTopRightToBottomLeft(int[][] matrix, int rows, int cols, int i, int j) {
		int r = i;
		int c = j;

		// looking at horizontal matrix, diagonally row increases and col decreases
		while (r < rows && c >= 0) {
			System.out.print(matrix[r++][c--] + " ");
		}
		System.out.println();
	}

	// top-left to bottom-right starting from top-right
	public static void printDiagonal2(int[][] matrix, int rows, int cols) {
		System.out.println("Print diagonal starting from top-right: ");
		// row=0 is fixed
		for (int j = cols - 1; j >= 0; j--) {
			printTopLeftToBottomRight(matrix, rows, cols, 0, j);
		}

		// col=0 is fixed
		for (int i = 1; i < rows; i++) {
			printTopLeftToBottomRight(matrix, rows, cols, i, 0);
		}
	}

	private static void printTopLeftToBottomRight(int[][] matrix, int rows, int cols, int i, int j) {
		int r = i;
		int c = j;

		// row as well as col increases
		while (r < rows && c < cols) {
			System.out.print(matrix[r++][c++] + " ");
		}
		System.out.println();
	}


	public static void printHorizontal(int[][] matrix, int rows, int cols) {
		System.out.println("Print horizontal: ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}


	public static void printVertical(int[][] matrix, int rows, int cols) {
		System.out.println("Print vertical: ");
		for (int j = 0; j < cols; j++) {
			for (int i = 0; i < rows; i++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}


	public static void printVertical2(int[][] matrix, int rows, int cols) {
		System.out.println("Print vertical2: ");
		for (int j = 0; j < cols; j++) {
			for (int i = rows - 1 ; i >= 0; i--) {
				System.out.print(matrix[rows - i - 1][j] + " ");
				// System.out.print(matrix[rows - 1 - j][i] + " ");
			}
			System.out.println();
		}
	}

	// print vertical (rotate right)
	/* how to think?
		Look at normal matrix i.e. horizontal print
		We want to print first col as row in reverse.. i.e. 23 19 15 11..			
		So, look at the position of element 23, j is fixed to 0 and row index changes
			1. Note that we want to bring element (23) located at (i = rows - 1 & j = 0) to (i = 0, j = 0)
			   Since element 23 (i = rows - 1 & j = 0), so, loop j from from 0 & i from rows - 1
			2. Note that col becomes row & row becomes col. So, swap the for loops
			   
	*/

	public static void rotateRight(int[][] matrix, int rows, int cols) {
		System.out.println("Rotate right: ");
		for (int j = 0; j < cols; j++) {
			for (int i = rows - 1 ; i >= 0; i--) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}


	/*
	   we want to bring element 14 at 0,0
	   so j starts from col - 1 & i starts from 0
	   because 14 is at j = col - 1 & i = 0
	   And, since we are rotating we need to swap loops

	*/
	// print vertical (rotate left)
	public static void rotateLeft(int[][] matrix, int rows, int cols) {
		System.out.println("Rotate left: ");
		for (int j = cols - 1; j >= 0; j--) {
			for (int i = 0; i < rows; i++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}


	// print mirror
	/* how to think?
		Look at normal matrix i.e. horizontal print
		Look at element 14.. we want to bring element 14 (i = 0 & j = cols-1) to (i = 0 & j = 0)
		we want to print each row in reverse.. 14 13 12 11..					
			1. Since element 14 (i = 0 & j = cols-1), so, i starts from 0 & col starts from cols - 1
			2. Note that row remains row and col remains col. So no need to swap loops
			   So, loop j from 0 to col - 1 & i from rows - 1 to 0		
	*/
	public static void mirror(int[][] matrix, int rows, int cols) {
		System.out.println("Mirror: ");
		for (int i = 0; i < rows; i++) {
			for (int j = cols - 1; j >= 0; j--) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}