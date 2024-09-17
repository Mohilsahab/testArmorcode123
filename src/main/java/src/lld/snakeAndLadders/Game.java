package src.lld.snakeAndLadders;

import lombok.Getter;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;

@Getter
public class Game {
    int noOfSnakes;
    int noOfLadders;
    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Board board;
    private Dice dice;

//    noOfSnakes  + noOfLadders < boardSize/5 -> for better play
    public Game(int noOfSnakes, int noOfLadders, int boardSize) {
        this.noOfSnakes = noOfSnakes;
        this.noOfLadders = noOfLadders;
        this.players = new LinkedList<>();
        this.snakes = new ArrayList<>(noOfSnakes);
        this.ladders = new ArrayList<>(noOfLadders);
        this.board = new Board(boardSize);
        this.dice = new Dice(1,6, 2);
        initBoard();
    }

    private void initBoard() {
        Set<Integer> occupiedPaces = new HashSet<>();
        int i=0;
        while (i < noOfSnakes) {
            int snakeHead = RandomUtils.nextInt(board.getStart(), board.getEnd());
            int snakeTail = RandomUtils.nextInt(board.getStart(), board.getEnd());
            if (snakeTail < snakeHead) {
                if (!occupiedPaces.contains(snakeHead)
                    && !occupiedPaces.contains(snakeTail)) {
                    occupiedPaces.add(snakeTail);
                    occupiedPaces.add(snakeHead);
                    snakes.add(new Snake(snakeHead, snakeTail));
                    i++;
                }
            }
        }

        i=0;
        while (i < noOfLadders) {
            int ladderStart = RandomUtils.nextInt(board.getStart(), board.getEnd());
            int ladderEnd = RandomUtils.nextInt(board.getStart(), board.getEnd());
            if (ladderEnd > ladderStart) {
                if (!occupiedPaces.contains(ladderStart)
                        && !occupiedPaces.contains(ladderEnd)) {
                    occupiedPaces.add(ladderEnd);
                    occupiedPaces.add(ladderStart);
                    ladders.add(new Ladder(ladderStart, ladderEnd));
                    i++;
                }
            }
        }
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void playGame() {
        while (players.size() > 1) {
            Player player = players.poll();
            int diceValue = dice.roll();
            int newPos = player.getPosition() + diceValue;
            if (newPos > board.getEnd()) {
                player.setPosition(player.getPosition());
                players.add(player);
            } else {
                player.setPosition(getNewPosition(newPos));
                if (player.getPosition() == board.getEnd()) {
                    player.setWon(true);
                    System.out.println("Player won - " + player.getName());
                } else {
                    System.out.println("Player " + player.getName() + " moved to pos - " + player.getPosition());
                    players.offer(player);
                }
            }
        }
    }

    private int getNewPosition(int newPos) {
        for (Snake snake : snakes) {
            if (snake.getHead() == newPos) {
                System.out.println("Snake Bite");
                return snake.getTail();
            }
        }
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == newPos) {
                System.out.println("Ladder Climbed");
                return ladder.getEnd();
            }
        }
        return newPos;
    }
}
