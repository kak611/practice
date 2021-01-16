import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class SplitInversion {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Integer> list = new ArrayList();
		// File file = new File("C:/Users/Kaustubh/Desktop/test3.txt");
		File file = new File("C:/Users/Kaustubh/Desktop/test2.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextInt()) {
			list.add(scanner.nextInt());			
		}		
		System.out.println(list);
		// int[] inputArr = list.toArray(new int[list.size()]);
		// System.out.println(Arrays.toString(inputArr));
		int cnt = mergeSortAndCount(list, 0, list.size() - 1);
		// System.out.println("Split Inversions: " + cnt);
	}

  
    // Merge sort function 
    private static int mergeSortAndCount(ArrayList<Integer> list, int l, int r) 
    { 
  
        // Keeps track of the inversion count at a 
        // particular node of the recursion tree 
        int count = 0; 
  
        if (l < r) { 
            int m = l + (r - l)/2; 
  
            // Total inversion count = left subarray count 
            // + right subarray count + merge count 
  
            // Left subarray count 
            count += mergeSortAndCount(list, l, m); 
  
            // Right subarray count 
            count += mergeSortAndCount(list, m + 1, r); 
  
            // Merge count 
            count += mergeAndCount(list, l, m, r); 
        } 
  
        return count; 
    }

	private static int mergeAndCount(ArrayList<Integer> list, int l, int m, int r) { 
  
        // Left subarray 
        // int[] left = Arrays.copyOfRange(arr, l, m + 1); 
        List<Integer> left = list.subList(l, m + 1);        
  
        // Right subarray 
        // int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
        List<Integer> right = list.subList(m + 1, r + 1);
  
        int i = 0, j = 0, k = l, swaps = 0; 
  
        while (i < left.size() && j < right.size()) { 
            if (left.get(i) <= right.get(j)) 
                list.set(k, left.get(i++));
            else { 
                list.set(k, right.get(j++));
                swaps += (m + 1) - (l + i); 
            }
            k++;
        } 
  
        // Fill from the rest of the left subarray 
        while (i < left.size()) {
            list.set(k, left.get(i++));
        	k++;
        }
  
        // Fill from the rest of the right subarray 
        while (j < right.size()) {
            list.set(k, right.get(j++));
            k++;
        }
  
        return swaps; 
    } 

  

	// public static int count(List<Integer> list, int low, int high) {
	// 	if (low < high) {
	// 		int mid = low + (high - low)/2;
	// 		int x = count(list, low, mid);
	// 		int y = count(list, mid + 1, high);
	// 		int z = countSplit(list, low, mid, high);
	// 		return x + y + z;
	// 	}
	// 	return 0;
	// }

	// public static int countSplit(List<Integer> list, int low, int mid, int high) {
	// 	if (list.size() == 1) return 0;
	// 	int len = list.size();
	// 	int[] arrA = new int[mid - low];
	// 	int[] arrB = new int[high - mid - 1];		

	// 	int k = 0;
	// 	for (int i = low; i <= mid; i++) {
	// 		arrA[k++] = list.get(i); 
	// 	}

	// 	k = 0;
	// 	for (int i = mid + 1; i <= high; i++) {
	// 		arrB[k++] = list.get(i); 
	// 	}

	// 	System.out.println(Arrays.toString(arrA));
	// 	System.out.println(Arrays.toString(arrB));
	// 	return 0;
	// }
}