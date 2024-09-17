package src.lld.chess;

import lombok.Getter;
import lombok.Setter;
import src.lld.chess.piece.ChessPiece;
import src.lld.chess.player.ChessPlayer;

@Getter
public class ChessMove {
    private ChessPlayer chessPlayer;
    private ChessBox start;
    private ChessBox end;
    private ChessPiece pieceMoved;
    @Setter
    private ChessPiece pieceKilled;
    @Setter
    private boolean castlingMove = false;

    public ChessMove(ChessPlayer chessPlayer, ChessBox start, ChessBox end) {
        this.chessPlayer = chessPlayer;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }
}
