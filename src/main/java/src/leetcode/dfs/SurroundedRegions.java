package src.leetcode.dfs;

public class SurroundedRegions {
    public static void main(String[] args) {
        char [][]board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new SurroundedRegions().solve(board);

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board==null || board.length==0) {
            return ;
        }
        for(int j=0; j<board[0].length; j++) {
            if(board[0][j] == 'O') {
                solve(board, 0, j);
            }
        }
        for(int j=0; j<board[0].length; j++) {
            if(board[board.length-1][j] == 'O') {
                solve(board, board.length-1, j);
            }
        }
        for(int i=1; i<board.length-1; i++) {
            if(board[i][0] == 'O') {
                solve(board, i, 0);
            }
        }
        for(int i=1; i<board.length-1; i++) {
            if(board[i][board[0].length-1] == 'O') {
                solve(board, i, board[0].length-1);
            }
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void solve(char[][] board, int row, int column) {
        if (row<0 || row > board.length-1
                || column < 0 || column > board[0].length - 1) {
            return;
        }
        if (board[row][column] == 'O') {
            board[row][column] = '1';
            solve(board, row + 1, column);
            solve(board, row -1, column);
            solve(board, row, column + 1);
            solve(board, row, column - 1);
        }
    }
}
