package src.lld.snakeAndLadders;

import java.util.Scanner;

public class SnakeAndLadderApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board Size");
//        int boardSize = scanner.nextInt();
        int boardSize = 100;
        System.out.println("Enter number of players");
//        int numberOfPlayers = scanner.nextInt();
        int numberOfPlayers = 2;
        System.out.println("Enter number of snakes");
//        int numSnakes = scanner.nextInt();
        int numSnakes = 7;
        System.out.println("Enter number of ladders");
//        int numLadders = scanner.nextInt();
        int numLadders = 5;

        Game game = new Game(numLadders, numSnakes, boardSize);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter player name");
//            String pName = scanner.next();
            String pName = "player" + (i+1);
            Player player = new Player(pName);
            game.addPlayer(player);
        }
        game.playGame();
    }
}
