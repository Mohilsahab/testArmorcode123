package src.leetcode.dfs;

public class NumberOfIslands {
    public static void main(String[] args) {
        /*char [][]grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };*/
        char [][]grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void numIslands(char[][] grid, int row, int column) {
        if (row<0 || row > grid.length-1
                || column < 0 || column > grid[0].length - 1) {
            return;
        }
        if (grid[row][column] == '1') {
            grid[row][column] = '2';
            numIslands(grid, row + 1, column);
            numIslands(grid, row -1, column);
            numIslands(grid, row, column + 1);
            numIslands(grid, row, column - 1);
        }
    }
}
