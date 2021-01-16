import java.util.Random;

class Rotate2DArray {
	public static void main(String[] args) {
		final int N = 4;
		//final int M = 5;	// below algorithm wont work for rectangle
		int min = 10;
		int max = 50;		
		Random random = new Random();
		int[][] arr = new int[N][N];
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[0].length; j++) {
				arr[i][j] = random.nextInt(max-min+1) + min;
				//System.out.print(arr[i][j] + " ");
			}
			//System.out.println("");
		}

		printMatrix(arr);
		rotate(arr);
		printMatrix(arr);
	}

	/*
		Steps
		1. Start from outer layer and go inside
		2. Swap four elements simultaneously
	*/
	public static void rotate(int[][] arr) {
		int size = arr.length;
		int matrixSize = arr.length-1;

		for (int i=0; i<size/2; i++) {
			for (int j=i; j<matrixSize-i; j++) {
				int temp1 = arr[matrixSize-j][i]; // 3,0
				int temp2 = arr[matrixSize-i][matrixSize-j]; // 3,3  	note [i]=>[j] (right-bottom)
				int temp3 = arr[j][matrixSize-i]; // 0,3
				int temp4 = arr[i][j]; // 0,0 							note [i]=>[j] (left-top)
				//System.out.println(temp1 + ", " + temp2 + ", " + temp3 + ", " + temp4);

				arr[i][j] = temp1;
				arr[matrixSize-j][i] = temp2;
				arr[matrixSize-i][matrixSize-j] = temp3;
				arr[j][matrixSize-i] = temp4;
			}
		}

	}

	public static void printMatrix(int[][] arr) {
		for (int i=0; i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}