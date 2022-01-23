package src.lld.chess.piece;

import src.lld.chess.ChessBoard;
import src.lld.chess.ChessBox;

public class Rook extends ChessPiece {

    public Rook(boolean white) {
        super(white, ChessPieceType.ROOK);
    }

    @Override
    public boolean canMove(ChessBoard board, ChessBox start, ChessBox end) {
        return false;
    }
}
