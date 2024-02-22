package snakesAndLadders;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class Ladder {
    Board board;
    Jump jump;
    private final Logger logger;

    Ladder(Board board) {
        this.board = board;
        this.logger = LoggerFactory.getLogger(Board.class);
    }

    public void initialise(int start, int end) throws Exception {
        if (board.isInvalidPosition(start)) {
            String errorMessage = "Invalid Start Position for a Ladder";
            Util.logAndThrowException(logger, errorMessage);
        }
        if (board.isInvalidPosition(end)) {
            String errorMessage = "Invalid End Position for a Ladder";
            Util.logAndThrowException(logger, errorMessage);
        }
        if (start >= end) {
            String errorMessage = "Ladder will only go upwards, please swap the values";
            Util.logAndThrowException(logger, errorMessage);
        }

        this.jump = new Jump(start, end);
    }
}
