package src.lld.ticTacToe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Move {
//    private int id;//incremental to tell which move it is

    private int row;
    private int col;
    @Setter
    private Player player;
}
