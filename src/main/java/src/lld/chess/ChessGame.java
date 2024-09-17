package src.lld.chess;

import lombok.Getter;
import src.lld.chess.player.ChessPlayer;

import java.util.List;

@Getter
public class ChessGame {
    private List<ChessPlayer> chessPlayers;
    private ChessBoard chessBoard;
    private List<ChessMove> movesPlayed;
    private ChessPlayer currentPlayer;
    private GameStatus gameStatus;

    private void initialise(ChessPlayer player1, ChessPlayer player2) {

    }

    public boolean isGameActive() {
        return this.gameStatus == GameStatus.ACTIVE;
    }


}
