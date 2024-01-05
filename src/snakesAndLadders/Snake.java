package snakesAndLadders;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class Snake {
    Board board;
    Jump jump;
    private final Logger logger;

    Snake(Board board) {
        this.board = board;
        this.logger = LoggerFactory.getLogger(Board.class);
    }

    public void initialise(int start, int end) throws Exception {
        if (board.isInvalidPosition(start)) {
            String errorMessage = "Invalid Start Position for a snake";
            Util.logAndThrowException(logger, errorMessage);
        }
        if (board.isInvalidPosition(end)) {
            String errorMessage = "Invalid End Position for a snake";
            Util.logAndThrowException(logger, errorMessage);
        }
        if (start <= end) {
            String errorMessage = "tail should be before the mouth for a snake";
            Util.logAndThrowException(logger, errorMessage);
        }

        this.jump = new Jump(start, end);
    }
}
