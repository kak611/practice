class PrintSquare {
	public static void main(String[] args) {
		int row = 10;
		print(row);
	}

	public static void print(int row) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				// if ((i + j) == row - 1) System.out.println("i: " + i + ", j: " + j);
				if (i ==0 || i == row - 1 || i == j|| (i + j) == row - 1
					|| j == 0 || j == row - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}				
			}
			System.out.println("");
		}
	}
}