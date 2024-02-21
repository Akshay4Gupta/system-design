package snakesAndLadders;

public class Jump {
    private final int startPosition;
    private final int endPosition;

    Jump(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }
}
