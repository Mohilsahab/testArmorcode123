package src.lld.chess.piece;

import lombok.Getter;
import lombok.Setter;
import src.lld.chess.ChessBoard;
import src.lld.chess.ChessBox;

@Getter
@Setter
public class King extends ChessPiece {
    private boolean castlingDone = false;

    public King(boolean white) {
        super(white, ChessPieceType.KING);
    }

    @Override
    public boolean canMove(ChessBoard board, ChessBox start, ChessBox end) {
        return false;
    }

    private boolean isValidCastling(ChessBoard board, ChessBox start, ChessBox end) {
        //check valid castling
        return true;
    }

    public boolean isCastlingMove(ChessBox start, ChessBox end) {
        // check castling move
        return false;
    }
}
