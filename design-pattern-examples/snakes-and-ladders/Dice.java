package snakesAndLadders;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Random;

public class Dice {
    Random ranNum;
    int numberOfFaces;

    Logger logger;

    Dice(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
        this.ranNum = new Random();
        this.logger = LoggerFactory.getLogger(Dice.class);
    }

    int roll(int face) throws Exception {
//        logger.debug("\trolling dice");
        System.out.println("\trolling dice");
        if (face <= 0 || face > numberOfFaces) {
            String errorMessage = "\tPlease Enter the valid face";
            Util.logAndThrowException(logger, errorMessage);
        }
//        logger.debug("\tdice rolled, got number: " + face);
        System.out.println("\tdice rolled, got number: " + face);
        return face;
    }

    int roll() {
//        logger.debug("\trolling dice");
        System.out.println("\trolling dice");
        int number = ranNum.nextInt(numberOfFaces) + 1;
//        logger.debug("\tdice rolled, got number: " + number);
        System.out.println("\tdice rolled, got number: " + number);
        return number;
    }
}
