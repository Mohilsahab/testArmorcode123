package src.leetcode.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        new SudokuSolver().solveSudoku(board);

        System.out.println();
        System.out.println();
        char[][] board2 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        new SudokuSolver().solveSudoku(board2);
    }

    public void solveSudoku(int[][] board) {
        solveSudoku(board, 0, 0);
        printBoard(board);
    }

    public void solveSudoku(char[][] grid) {
        int[][] board = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '.') {
                    board[row][col] = 0;
                } else {
                    board[row][col] = grid[row][col] - '0';
                }
            }
        }
        solveSudoku(board, 0, 0);
//        printBoard(board);

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = (char)('0' + board[row][col]);
            }
        }
    }

    private void printBoard(int[][] board) {
        System.out.print("[");
        for (int row = 0; row < board.length; row++) {
            System.out.print("[");
            for (int column = 0; column < board[0].length-1; column++) {
                System.out.print("\"" + board[row][column] + "\",");
            }
            System.out.print("\"" + board[row][board[0].length-1] + "\"");

            if (row < board.length-1) {
                System.out.println("],");
            } else {
                System.out.println("]]");
            }
        }
    }

    private boolean solveSudoku(int[][] board, int row, int column) {
        if (column == board[0].length) {
            row++;
            column = 0;
        }
        if (row == board.length) {
            return true;
        }

        if (board[row][column] != 0) {
            return solveSudoku(board, row, column + 1);
        }

        for (int value=1;  value<=9; value++) {
            if (isValidPlacement(board, row, column, value)) {
                board[row][column] = value;
                if (solveSudoku(board, row, column + 1)) {
                    return true;
                }
                board[row][column] = 0;
            }
        }
        return false;
    }

    private boolean isValidPlacement(int[][] board, int row, int col, int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
