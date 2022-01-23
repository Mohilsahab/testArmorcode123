package src.lld.ticTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private TicTacToePieceEnum[][] board;
    private List<Move> moves;
    private final int boardDimensions;
    private int rowSum[], colSum[];
    private int diagonalSum, revDiagonalSum;

    public Board(int boardDimensions) {
        this.boardDimensions = boardDimensions;
        rowSum = new int[boardDimensions];
        colSum = new int[boardDimensions];
        initialise();
    }

    public void initialise() {
        this.board = new TicTacToePieceEnum[boardDimensions][boardDimensions];
        this.moves = new ArrayList<>(boardDimensions * boardDimensions);
        for(int i = 0; i < boardDimensions; i++) {
            for(int j = 0; j < boardDimensions; j++) {
                this.board[i][j] = TicTacToePieceEnum.EMPTY;
            }
        }
    }

    public List<Move> getAllMoves() {
        return this.moves;
    }

    public void getBoard() {
        for(int i = -1; i < boardDimensions; i++) {
            for(int j = -1; j < boardDimensions; j++) {
                if (i == -1 && j == -1) {
                    System.out.print(" \t");
                }else if(i == -1) {
                    System.out.print(j + "\t");
                }else if(j == -1){
                    System.out.print(i + "\t");
                }else {
                    System.out.print(this.board[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    /**
     *
     * @param move on location where move need to be made
     * @param move which player made the move on which box
     * @return true if pieceEnum Player wins else false to continue
     */
    public boolean makeMove(final Move move) {
        int row = move.getRow();
        int col = move.getCol();
        if (row < 0 || col < 0 || row >= boardDimensions || col >= boardDimensions) {
            throw new IllegalArgumentException("Move out of boundary");
        } else if (board[row][col] != TicTacToePieceEnum.EMPTY) {
            throw new IllegalArgumentException("Square is already occupied");
        } else {
            moves.add(move);
            Player player = move.getPlayer();
            board[row][col] = player.getPieceEnum();
            rowSum[row] += player.getPieceEnum() == TicTacToePieceEnum.CROSS ? 1 : -1;
            colSum[col] += player.getPieceEnum() == TicTacToePieceEnum.CROSS ? 1 : -1;
            if (row == col) {
                diagonalSum += player.getPieceEnum() == TicTacToePieceEnum.CROSS ? 1 : -1;
            }
            if (row == boardDimensions - 1 -col) {
                revDiagonalSum += player.getPieceEnum() == TicTacToePieceEnum.CROSS ? 1 : -1;
            }
            if (rowSum[row]==Math.abs(boardDimensions) || colSum[col]==Math.abs(boardDimensions) || diagonalSum==Math.abs(boardDimensions) || revDiagonalSum==Math.abs(boardDimensions)) {
                return true;
            }
        }
        return false;
    }
}
