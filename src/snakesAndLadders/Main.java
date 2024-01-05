package snakesAndLadders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void startGame() throws Exception {
        Board board = new Board(Constants.BOARD_SIZE, Constants.NUMBER_OF_SNAKES,
                Constants.NUMBER_OF_LADDERS, Constants.NUMBER_OF_PLAYERS);

        System.out.println("enter the values");

        int numberOfSnakes = scanner.nextInt();
        board.setNumberOfSnakes(numberOfSnakes);
        for(int i = 0; i < numberOfSnakes; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            board.addSnake(start, end);
        }

        int numberOfLadders = scanner.nextInt();
        board.setNumberOfLadders(numberOfLadders);
        for(int i = 0; i < numberOfLadders; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            board.addLadder(start, end);
        }

        int numberOfPlayers = scanner.nextInt();
        board.setNumberOfPlayers(numberOfPlayers);
        List<Player> playerList = new ArrayList<>(numberOfPlayers);
        for(int i = 0; i < numberOfPlayers; i++) {
            String name = scanner.next();
            int position = scanner.nextInt();
            Player player = board.addPlayer(name, position);
            playerList.add(player);
        }

        // start the game
        while(true) {
            String input = scanner.next();
            if ("automated".equalsIgnoreCase(input)) {
                for(Player player: playerList) {
                    player.move();
                    if (player.hasWon()) {
                        System.out.println("\tCongratulations " + player.getName() + " is the Winner");
                        return;
                    }
                }
                continue;
            } else if ("dieValues".equalsIgnoreCase(input)) {
                for(int i = 0; i < Constants.NUMBER_OF_DIES; i++) {
                    for(Player player: playerList) {
                        int dieValue = scanner.nextInt();
                        player.move(dieValue);
                    }
                }
            }
            break;
        }
    }
    public static void main(String[] args) throws Exception {
        startGame();
    }
}