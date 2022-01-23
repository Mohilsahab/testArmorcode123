package src.lld.chess.piece;

import lombok.Getter;
import lombok.Setter;
import src.lld.chess.ChessBoard;
import src.lld.chess.ChessBox;

@Getter
public abstract class ChessPiece {
    @Setter
    private boolean killed = false;
    private boolean white = false;
    private ChessPieceType pieceType;

    public ChessPiece(boolean white, ChessPieceType pieceType) {
        this.white = white;
        this.pieceType = pieceType;
    }

    public abstract boolean canMove(ChessBoard board, ChessBox start, ChessBox end);
}
