package src.lld.chess.piece;

import src.lld.chess.ChessBoard;
import src.lld.chess.ChessBox;

public class Pawn extends ChessPiece {
    public Pawn(boolean white) {
        super(white, ChessPieceType.PAWN);
    }

    @Override
    public boolean canMove(ChessBoard board, ChessBox start, ChessBox end) {
        return false;
    }
}
