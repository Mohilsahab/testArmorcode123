package src.lld.chess.piece;

import src.lld.chess.ChessBoard;
import src.lld.chess.ChessBox;

public class Queen extends ChessPiece {
    public Queen(boolean white) {
        super(white, ChessPieceType.QUEEN);
    }

    @Override
    public boolean canMove(ChessBoard board, ChessBox start, ChessBox end) {
        return false;
    }
}
