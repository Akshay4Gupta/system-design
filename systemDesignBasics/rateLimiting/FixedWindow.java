package systemDesignBasics.rateLimiting;

public class FixedWindow implements RateLimitAlgorithm {
    int count;
    long timestamp;
    long range;
    int threshold;

    FixedWindow(int threshold, long range) {
        this.range = range;
        this.threshold = threshold;
        reset();
    }

    @Override
    public void add() {
        if (notWithinRange()) reset();
        if (count >= threshold) {
            System.out.println("FixedWindow " + getCount() + " " + getTimestamp());
            throw new RuntimeException("Rate limit exceeded");
        }
        count++;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }

    private void reset() {
        this.count = 0;
        this.timestamp = (System.currentTimeMillis() / range) * range;
    }

    public boolean notWithinRange() {
        return System.currentTimeMillis() - timestamp > range;
    }
}
