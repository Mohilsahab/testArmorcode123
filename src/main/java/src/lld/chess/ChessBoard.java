package src.lld.chess;

import src.lld.chess.piece.*;

public class ChessBoard {
    private ChessBox[][] boxes;

    public ChessBoard() {
        this.resetBoard();
    }

    private void resetBoard() {
        //initialise white pieces
        boxes[0][0] = new ChessBox(0, 0, new Rook(true));
        boxes[0][1] = new ChessBox(0, 1, new Knight(true));
        boxes[0][2] = new ChessBox(0, 2, new Bishop(true));
        boxes[0][3] = new ChessBox(0, 3, new Queen(true));
        boxes[0][4] = new ChessBox(0, 4, new King(true));
        boxes[0][5] = new ChessBox(0, 5, new Bishop(true));
        boxes[0][6] = new ChessBox(0, 6, new Knight(true));
        boxes[0][7] = new ChessBox(0, 7, new Rook(true));

        for (int i=0; i<8; i++) {
            boxes[1][i] = new ChessBox(1, i, new Pawn(true));
        }

        // initialize black pieces
        boxes[7][0] = new ChessBox(7, 0, new Rook(false));
        boxes[7][1] = new ChessBox(7, 1, new Knight(false));
        boxes[7][2] = new ChessBox(7, 2, new Bishop(false));
        boxes[7][3] = new ChessBox(7, 3, new Queen(false));
        boxes[7][4] = new ChessBox(7, 4, new King(false));
        boxes[7][5] = new ChessBox(7, 5, new Bishop(false));
        boxes[7][6] = new ChessBox(7, 6, new Knight(false));
        boxes[7][7] = new ChessBox(7, 7, new Rook(false));

        for (int i=0; i<8; i++) {
            boxes[6][i] = new ChessBox(6, i, new Pawn(false));
        }

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new ChessBox(i, j, null);
            }
        }
    }

    public ChessBox getBox(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return boxes[x][y];
    }
}
