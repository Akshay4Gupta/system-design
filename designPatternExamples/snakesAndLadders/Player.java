package snakesAndLadders;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class Player {
    private final int id;
    private final String name;
    private final Board board;
    private final Dice dice;
    private int position;

    private final Logger logger;

    Player(Board board, int startingPosition, int id, String name) {
        this.board = board;
        this.position = startingPosition;
        this.id = id;

        int numberOfFaces = Constants.DEFAULT_DICE_FACES;
        this.dice = new Dice(numberOfFaces);
        this.name = name;
        this.logger = LoggerFactory.getLogger(Player.class);
    }

    int move() throws Exception {
//        logger.debug(name + " started playing");
        System.out.println(name + " started playing");
        int steps = dice.roll();
        return board.movePlayer(this, position, steps);
    }

    int move(int n) throws Exception {
//        logger.debug(name + " started playing");
        System.out.println(name + " started playing");
        int steps = dice.roll(n);
        return board.movePlayer(this, position, steps);
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void resetPosition() {
//        logger.debug("\t*resetting position for " + name + " to "
//        + Constants.DEFAULT_STARTING_POSITION);
        System.out.println("\t* resetting position for " + name + " to "
                + Constants.DEFAULT_STARTING_POSITION);
        this.setPosition(Constants.DEFAULT_STARTING_POSITION);
    }

    public boolean hasWon() {
        return board.getLastPosition() == this.getPosition();
    }
}
