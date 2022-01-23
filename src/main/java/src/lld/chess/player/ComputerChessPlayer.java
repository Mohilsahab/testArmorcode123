package src.lld.chess.player;

public class ComputerChessPlayer extends ChessPlayer {

    public ComputerChessPlayer(boolean whiteSide) {
        this.whiteSide = whiteSide;
        this.humanPlayer = false;
    }
}
