package src.lld.ticTacToe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Player {
    private TicTacToePieceEnum pieceEnum;
    private String name;
}
