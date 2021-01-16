import java.util.*;

class NumOfIslands {
    public static void main(String[] args) {                
        Random random = new Random();
        char[] chars= {'0', '1'};
        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                char[][] grid = new char[row][col];
                for (char[] c : grid) {
                    Arrays.fill(c, '1');
                    // for (int m = 0; m < col; m++) {
                    //     c[m] = chars[random.nextInt(2)];
                    // }
                }
                System.out.println((row * col) + ", " + numIslands(grid));
            }
        }
    }
    
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Deque<Position> queue = new LinkedList<>();
        int cnt_op = 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cnt_op++;
                if (grid[i][j] == '1') {
                    result++;
                    queue.addLast(new Position(i, j));
                    cnt_op++;
                    // mark visited
                    grid[i][j] = '0';                    
                    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                    Position pos;
                    while (!queue.isEmpty()) {
                        // System.out.println("grid: " + Arrays.deepToString(grid));
                        pos = queue.removeFirst();                        
                        cnt_op++;
                        for (int[] dir : dirs) {
                            int x = pos.i + dir[0];
                            int y = pos.j + dir[1];
                            
                            if (x >= 0 && y >= 0 && x < grid.length 
                                && y < grid[0].length && grid[x][y] == '1') {                                
                                queue.addLast(new Position(x, y));
                                cnt_op++;
                                //mark visited
                                grid[x][y] = '0';
                            }
                        }                        
                    }
                }
            }
        }
        // System.out.println("cnt_op: " + cnt_op);
        return cnt_op;
        // return result;
    }
    
    static class Position {
        int i;
        int j;
        
        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}