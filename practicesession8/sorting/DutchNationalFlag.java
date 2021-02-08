import java.util.Random;
import java.util.Arrays;

class DutchNationalFlag {
	public static void main(String[] args) {
		int size = 25;
		Random random = new Random();
		int[] arr = new int[size];
		for (int i=0; i<size; i++) {
			arr[i] = random.nextInt(3) + 1;
		}
		arr = new int[] {3, 1, 3, 2, 2, 2, 3, 1, 3, 3, 1, 1, 3, 1, 3, 1, 2, 3, 1, 2, 3, 3, 1, 1, 2};

		int pivot = 2;
		System.out.println(Arrays.toString(arr) + ", pivot: " + pivot);
		// partition_sol1(arr, pivot);
		partition_sol2(arr, pivot);
		System.out.println(Arrays.toString(arr));
	}

	public static void partition_sol1(int[] arr, int pivot) {		
		// first pass
		int i = 0, j = i;  // Note: important that i and j start at same position
		while (j < arr.length) {
			if ( arr[j] < pivot) {
				swap(arr, i++, j);				
			}			
			j++;
		}

		// second pass
		i = arr.length - 1;
		j = i;	// Note: important that i and j start at same position
		while (j >= 0 && arr[j] >= pivot) {
			if (arr[j] > pivot) {
				swap(arr, i--, j);
			}
			--j;
		}
	}

	public static void partition_sol2(int[] arr, int pivot) {
		// one pass
		int smaller = 0;
		int equal = 0;
		int higher = arr.length - 1;

		while (equal <= higher) {  // note : equal <= higher and not < arr.length
			if (arr[equal] < pivot) {
				swap(arr, smaller++, equal++);
			} else if (arr[equal] == pivot) {
				equal++;
			} else {
				// note: dont increment equal pointer as the element coming from right side is unknown where smaller or equal or greater
				swap(arr, higher--, equal);  
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {		
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}