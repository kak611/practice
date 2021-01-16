import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Set;
import java.util.HashSet;

class AmazonTest {
	// Write an algorithm that will convert a grid consisting of 0s, 1s to 1s in minimum pass
    // every 1's will convert adjacent values to 1 if not 1.
	// for e.g,
	//   01101	 	 11111      11111
    //   01010  =>   11111  =>  11111
    //   00001       01011      11111 
    //   01000       11101      11111
    //   Total : 2 passes

    public static void main(String[] args) {
    	List<List<Integer>> grid = new ArrayList<>();
    	grid.add(Arrays.asList(0,1,1,0,1));
    	grid.add(Arrays.asList(0,1,0,1,0));
    	grid.add(Arrays.asList(0,0,0,0,1));
    	grid.add(Arrays.asList(0,1,0,0,0));


        // Sample 2 => expected result = 3
        // List<List<Integer>> grid = new ArrayList<>();
        // grid.add(Arrays.asList(0,0,1,0,1));
        // grid.add(Arrays.asList(0,0,0,1,0));
        // grid.add(Arrays.asList(0,0,0,0,1));
        // grid.add(Arrays.asList(0,1,0,0,0));

        // create clone of grid
        newGrid = new ArrayList<>();
        for (List<Integer> list : grid) newGrid.add(new ArrayList<>(list));                

        System.out.println("grid before: ");
    	print(newGrid);
    	int result = getMinimumPasses(grid);    	
        System.out.println("grid after: ");
        print(newGrid);
    	System.out.println("Total passes: " + result);
    }



    static List<List<Integer>> newGrid;
    public static int getMinimumPasses(List<List<Integer>> grid) {
        int rows = grid.size();
        int cols = grid.get(0).size();

        boolean allOnes = false;
        int count = 0;

        while (!allOnes) {                        
            // System.out.println("After pass " + count + ": ");
            // print(grid);            
            allOnes = true;
            count++;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid.get(i).get(j) == 0) {
                        allOnes = false;
                    } else {
                        bfs(grid, rows, cols, i, j);
                    }
                }
            }
            // System.out.println("newGrid after:");
            // print(newGrid);

            grid = newGrid;
        }

        return count;
    }

    public static void bfs(List<List<Integer>> grid, int rows, int cols, int i, int j) {
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        Set<String> visited = new HashSet<>();        

        while (!queue.isEmpty()) {
            // for (int[] arr : queue) System.out.print("[" + arr[0] + "," + arr[1] + "]");
            // System.out.println(visited);
            int[] pair = queue.poll();
            for (int[] dir : new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}) {
                int x = pair[0] + dir[0];
                int y = pair[1] + dir[1];

                if (x < 0 || y < 0 || x >= rows || y >= cols
                    || visited.contains(x + "_" + y)) continue;
                
                visited.add(x + "_" + y);

                // if adjacent cells are 1 then add to queue to update their adjacent 0 cells to 1                
                
                if (grid.get(x).get(y) == 0) {
                    newGrid.get(x).set(y, 1); // set one                    
                } else {                    
                    queue.add(new int[] {x,y});                    
                }
            }
        }
    }

    public static void print(List<List<Integer>> grid) {
        for (List<Integer> list : grid) {
            System.out.println(list);
        }
    }
}