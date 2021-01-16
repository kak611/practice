import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class AmazonTest2 {
	// Write an algorithm that will convert a grid consisting of 0s, 1s to 1s in minimum pass
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

    	System.out.println(grid);
    	int result = getMinimumPasses(grid.size(),grid.get(0).size(),grid);    	
    	System.out.println("result: " + result);
    }

    public static int getMinimumPasses(int rows, int columns, List<List<Integer>> grid) {        
        int counter = 0;        
        while (true) {
            List<List<Integer>> result = new ArrayList<>();      
            for (int i=0; i < rows; i++) {
                List<Integer> tmpList = new ArrayList<>();            
                List<Integer> curr = grid.get(i);
                
                // traverse each element in row and compare with next element & element from previous row if exists
                // System.out.println("allRowsOne: " + allRowsOne + " input: " + curr);
                for (int j=0; j < curr.size() - 1; j++) {                
                    if (curr.get(j) == 1) {
                        tmpList.add(1);                       
                        continue;
                    }
                    if (curr.get(j+1) == 1 
                        || (i-1 >= 0 && grid.get(i-1).get(j) == 1)
                        || (j-1 >= 0 && curr.get(j-1) == 1)) {
                        tmpList.add(1);                        
                    } else {
                        tmpList.add(0);
                    }
                }

                // add last element
                if (curr.get(curr.size() - 1) == 1 
                    || curr.get(curr.size()-2) == 1 
                    || (i-1 > 0 && grid.get(i-1).get(curr.size()-1) == 1)) {
                    tmpList.add(1);                    
                } else {
                    tmpList.add(0);
                }                            
                result.add(tmpList);
            }
            counter ++;
            int rowCnt = 0;
            System.out.println("result: " + result);
            for (List<Integer> list : result) {
                if (!list.contains(0)) rowCnt++;
            }
            if (rowCnt == rows) break;
            grid = result;            
        }        
    	return counter;
    }
}