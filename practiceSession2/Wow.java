import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Wow { 
  
    // Function to count the number of inversions 
    // during the merge process 
    private static long mergeAndCount(int[] arr, int l, int m, int r) 
    { 
  
        // Left subarray 
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
  
        // Right subarray
         int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
  
        int i = 0, j = 0, k = l;
        long swaps = 0; 
  
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
  
        // Fill from the rest of the left subarray 
        while (i < left.length) 
            arr[k++] = left[i++]; 
  
        // Fill from the rest of the right subarray 
        while (j < right.length) 
            arr[k++] = right[j++]; 
  
        return swaps; 
    } 
  
    // Merge sort function 
    private static long mergeSortAndCount(int[] arr, int l, int r) 
    { 
  
        // Keeps track of the inversion count at a 
        // particular node of the recursion tree 
        long count = 0; 
  
        if (l < r) { 
            int m = (l + r) / 2; 
  
            // Total inversion count = left subarray count 
            // + right subarray count + merge count 
  
            // Left subarray count 
            count += mergeSortAndCount(arr, l, m); 
  
            // Right subarray count 
            count += mergeSortAndCount(arr, m + 1, r); 
  
            // Merge count 
            count += mergeAndCount(arr, l, m, r); 
        } 
  
        return count; 
    } 
  
    // Driver code 
    public static void main(String[] args) throws FileNotFoundException { 
        // int[] arr = { 1, 20, 6, 4, 5 }; 
        ArrayList<Integer> list = new ArrayList();
        // File file = new File("C:/Users/Kaustubh/Desktop/test3.txt");
        File file = new File("C:/Users/Kaustubh/Desktop/test2.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());            
        }       
        // System.out.println("List: " + list);

        int[] arr = new int[list.size()];

        int i = 0;
        for (int num : list) {
            arr[i++] = num;
        }

        // System.out.println("Array: " + Arrays.toString(arr));
  
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1)); 
    } 
} 