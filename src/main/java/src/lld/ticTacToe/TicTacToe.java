package src.lld.ticTacToe;

import java.util.Scanner;

public class TicTacToe {
    private int gameNo; // to store game no

    private Board board;
    private Player player1;
    private Player player2;
    private boolean player1Turn;
    private Player winner;

    public TicTacToe(int boardDimensions) {
        this.board = new Board(boardDimensions);
        this.player1Turn = true;
    }

    public Player getCurrentPlayer() {
        return player1Turn ? player1 : player2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int boardDimensions = sc.nextInt();
        int boardDimensions = 3;
        TicTacToe ticTacToe = new TicTacToe(boardDimensions);

        ticTacToe.player1 = new Player(TicTacToePieceEnum.CROSS, "Player1");
        ticTacToe.player2 = new Player(TicTacToePieceEnum.CIRCLE, "Player2");

        Player currentPlayer;
        while(ticTacToe.winner == null) {
            // Getting current player
            currentPlayer = ticTacToe.getCurrentPlayer();
            System.out.println("Current Player - " + currentPlayer);

            try {
                // Making the move
                System.out.println("Please enter row");
                int row = sc.nextInt();
                System.out.println("Please enter col");
                int col = sc.nextInt();

                if (ticTacToe.board.makeMove(new Move(row, col, currentPlayer))) {
                    ticTacToe.winner = currentPlayer;
                } else {
                    ticTacToe.player1Turn = ticTacToe.player1Turn ? false : true;
                }
            }catch (Exception exception){
                System.out.println(exception);
            }
        }
        System.out.println("Winner : " + ticTacToe.winner);
    }
}
