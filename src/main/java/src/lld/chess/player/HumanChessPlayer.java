package src.lld.chess.player;

public class HumanChessPlayer extends ChessPlayer {
    public HumanChessPlayer(boolean whiteSide) {
        this.whiteSide = whiteSide;
        this.humanPlayer = true;
    }
}
