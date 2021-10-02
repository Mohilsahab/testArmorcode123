package src.lld.snakeAndLadders;

import lombok.Getter;

@Getter
public class Board {
    private int start;
    private int end;

    public Board(int end) {
        this.start = 1;
        this.end = end;
    }
}
