package snakesAndLadders;

import com.sun.org.slf4j.internal.Logger;

public class Util {
    public static void logAndThrowException(Logger logger,
                                            String errorMessage) throws Exception {
        logger.error(errorMessage);
        throw new Exception(errorMessage);
    }
}
