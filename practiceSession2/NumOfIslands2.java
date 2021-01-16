import java.util.*;

class NumOfIslands2 {        
    public static void main(String[] args) {                        
        Random random = new Random();
        char[] chars= {'0', '1'};
        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                char[][] grid = new char[row][col];
                for (char[] c : grid) {
                    // Arrays.fill(c, '0');
                    for (int m = 0; m < col; m++) {
                        c[m] = chars[random.nextInt(2)];
                    }
                }
                System.out.println((row * col) + ", " + numIslands(grid));
            }
        }
    }

    static int cnt_op = 0;
    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        cnt_op = 0;
        UnionFind uf = new UnionFind(grid);
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cnt_op++;
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];

                        if (x >= 0 && y >= 0 && x < grid.length 
                            && y < grid[0].length && grid[x][y] == '1') {
                            // cnt_op++;                        
                            uf.union((i * grid[0].length + j),(x * grid[0].length + y));
                        }
                    }
                }
            }
        }

        // return uf.count;
        return cnt_op++;
    }

    
    static class UnionFind {
        private int[] parents;
        public int count = 0;
        
        public UnionFind(char[][] grid) {
            parents = new int[grid.length * grid[0].length];            
            
            for (int i= 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {                    
                    cnt_op++;
                    if (grid[i][j] == '1') {                        
                        parents[i * grid[0].length + j] = i * grid[0].length + j;
                        count++;
                    }
                }
            }
            // System.out.println(Arrays.toString(parents));
        }
        
        public void union(int num1, int num2) {
            int parent1 = find(num1);
            int parent2 = find(num2);
            
            // System.out.println("Parent of " + num1 + ": " + parent1);
            // System.out.println("Parent of " + num2 + ": " + parent2);
            
            if (parent1 != parent2) {
                cnt_op++;
                parents[parent2] = parent1;
                this.count--;
            }
            // System.out.println("Total count after union: " + count);
            // System.out.println(Arrays.toString(parents));
        }
        
        public int find(int num) {
            int parent = parents[num];
            
            if (parent == num) return parent;
            
            cnt_op++;
            parents[num] = find(parent);
            return parents[num];
        }
    }
}