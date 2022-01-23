package src.lld.chess.piece;

import src.lld.chess.ChessBoard;
import src.lld.chess.ChessBox;

public class Knight extends ChessPiece {

    public Knight(boolean white) {
        super(white, ChessPieceType.KNIGHT);
    }

    @Override
    public boolean canMove(ChessBoard board, ChessBox start, ChessBox end) {
        return false;
    }
}
