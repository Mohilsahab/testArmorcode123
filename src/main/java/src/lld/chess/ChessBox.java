package src.lld.chess;

import lombok.AllArgsConstructor;
import lombok.Getter;
import src.lld.chess.piece.ChessPiece;

@AllArgsConstructor
@Getter
public class ChessBox {
    private int x;
    private int y;
    private ChessPiece piece;
}
