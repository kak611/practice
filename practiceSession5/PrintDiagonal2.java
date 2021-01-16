class PrintDiagonal2 {
	static int[][] arr;
	public static void main(String[] args) {
		int size = 5;
		arr = new int[][] {{11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}, {26,27,28,29,30}};

		printMatrix();		
		printVerticalMatrix();
	}

	public static void printMatrix() {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printVerticalMatrix() {
		System.out.println();
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}