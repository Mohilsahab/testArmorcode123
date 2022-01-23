package src.leetcode.dfs;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(new RottenOranges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int maxCount = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 2) {
                    count = dfs(grid, i, j);
                    if (count > maxCount) {
                        maxCount = count;
                    }
                }
            }
        }
        return maxCount;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j] == 3 || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 3;
        int count = dfs(grid, i-1, j);
        count = Math.max(dfs(grid, i+1, j), count);
        count = Math.max(dfs(grid, i, j-1), count);
        count = Math.max(dfs(grid, i, j+1), count);
        return 1 + count;
    }
}
