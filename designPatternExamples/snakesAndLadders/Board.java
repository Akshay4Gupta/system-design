package designPatternExamples.snakesAndLadders;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int boardSize;

    private int numberOfSnakes;
    private final List<Jump> snakes;

    private int numberOfLadders;
    private final List<Jump> ladders;

    private int numberOfPlayers;
    private final List<Player> players;

    private final Logger logger;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders, int numberOfPlayers) {
        this.boardSize = boardSize;

        this.numberOfSnakes = numberOfSnakes;
        this.snakes = new ArrayList<>();

        this.numberOfLadders = numberOfLadders;
        this.ladders = new ArrayList<>();

        this.numberOfPlayers = numberOfPlayers;
        this.players = new ArrayList<>();

        this.logger = LoggerFactory.getLogger(Board.class);
    }

    private void conveyPosition(Player player) {
        for(Player otherPlayer: players) {
            if (otherPlayer.getId() == player.getId()) continue;
            if (player.getPosition() == otherPlayer.getPosition()
                    && player.getPosition() != this.getLastPosition()) {
//                logger.debug("\t" + player.getName() + " has cut the player "
//                        + otherPlayer.getName());
                System.out.println("\t" + player.getName() + " has cut the player "
                        + otherPlayer.getName());
                otherPlayer.resetPosition();
            }
        }
    }

    public int movePlayer(Player player, int startingPosition, int steps) {
//        logger.debug("\tstarted moving from position " + startingPosition
//                + " by steps " + steps);
        System.out.println("\tstarted moving from position " + startingPosition
                + " by steps " + steps);
        int nextPosition = startingPosition + steps;
        int nextNextPosition = nextPosition;

        do {
            nextPosition = nextNextPosition;
            nextNextPosition = getPositionIfBittenBySnake(nextPosition); // priority 1
            nextNextPosition = getPositionIfGotStairs(nextNextPosition); // priority 2
        } while(nextPosition != nextNextPosition);

        nextPosition = this.getValidPosition(nextPosition);

        // anounce the winner and end the game

        player.setPosition(nextPosition);

//        logger.debug("\tstarted moving from position " + startingPosition
//                + " by steps " + steps);
        System.out.println("\tnew position is " + player.getPosition());

        this.conveyPosition(player);

        return nextPosition;
    }

    public int getPositionIfBittenBySnake(int position) {
        // can be optimised by binary search of taking hash map;
        for(Jump snake: snakes) {
            if (snake.getStartPosition() == position) {
//                logger.debug("\t\t bitten by snake, down from position: "
//                        + position + ", to position " + snake.getEndPosition());
                System.out.println("\t\t bitten by snake, down from position: "
                        + position + ", to position " + snake.getEndPosition());
                return snake.getEndPosition();
            }
        }
        return position;
    }

    public int getPositionIfGotStairs(int position) {
        // can be optimised by binary search of taking hash map;
        for(Jump ladder: ladders) {
            if (ladder.getStartPosition() == position) {
//                logger.debug("\t\t up the ladder from position: "
//                        + position + ", to position " + ladder.getEndPosition());
                System.out.println("\t\t up the ladder from position: "
                        + position + ", to position " + ladder.getEndPosition());
                return ladder.getEndPosition();
            }
        }
        return position;
    }

    public Player addPlayer(String name, int position) throws Exception {
        if (players.size() >= numberOfPlayers) {
            String errorMessage = "No More Players allowed";
            Util.logAndThrowException(logger, errorMessage);
        }
        int playerId = players.size();
        Player player = new Player(this, position, playerId, name);
        players.add(player);
        return player;
    }

    public Player addPlayer(String name) throws Exception {
        return this.addPlayer(name, Constants.DEFAULT_STARTING_POSITION);
    }

    public void addSnake(int start, int end) throws Exception {
        if (snakes.size() == numberOfSnakes) return;

        if (this.isInvalidPosition(start)) {
            String errorMessage = "Invalid Start Position for a snake";
            Util.logAndThrowException(logger, errorMessage);
        }
        if (this.isInvalidPosition(end)) {
            String errorMessage = "Invalid End Position for a snake";
            Util.logAndThrowException(logger, errorMessage);
        }
        if (start <= end) {
            String errorMessage = "tail should be before the mouth for a snake";
            Util.logAndThrowException(logger, errorMessage);
        }

        Jump jump = new Jump(start, end);
        snakes.add(jump);
    }

    public void addLadder(int start, int end) throws Exception {
        if (ladders.size() == numberOfLadders) return;

        if (this.isInvalidPosition(start)) {
            String errorMessage = "Invalid Start Position for a Ladder";
            Util.logAndThrowException(logger, errorMessage);
        }
        if (this.isInvalidPosition(end)) {
            String errorMessage = "Invalid End Position for a Ladder";
            Util.logAndThrowException(logger, errorMessage);
        }
        if (start >= end) {
            String errorMessage = "Ladder will only go upwards, please swap the values";
            Util.logAndThrowException(logger, errorMessage);
        }

        Jump jump = new Jump(start, end);
        ladders.add(jump);
    }

    public int getLastPosition() {
        return boardSize * boardSize;
    }

    public int getValidPosition(int position) {
        position = Math.min(this.getLastPosition(), position);
        position = Math.max(Constants.DEFAULT_STARTING_POSITION, position);
        return position;
    }

    public boolean isInvalidPosition(int position) {
        return position < Constants.DEFAULT_STARTING_POSITION || position > this.getLastPosition();
    }

    public void setNumberOfSnakes(int numberOfSnakes) {
        this.numberOfSnakes = numberOfSnakes;
    }

    public void setNumberOfLadders(int numberOfLadders) {
        this.numberOfLadders = numberOfLadders;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
