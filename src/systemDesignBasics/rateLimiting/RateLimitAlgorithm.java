package systemDesignBasics.rateLimiting;

public interface RateLimitAlgorithm {
    void add();

    int getCount();

    long getTimestamp();
    public boolean notWithinRange();
}
