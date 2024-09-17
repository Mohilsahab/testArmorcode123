package src.lld.chess.piece;

import src.lld.chess.ChessBoard;
import src.lld.chess.ChessBox;

public class Bishop extends ChessPiece {
    public Bishop(boolean white) {
        super(white, ChessPieceType.BISHOP);
    }

    @Override
    public boolean canMove(ChessBoard board, ChessBox start, ChessBox end) {
        return false;
    }
}
