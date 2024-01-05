package systemDesignBasics.rateLimiting;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingLog implements RateLimitAlgorithm {
    Deque<Long> timestampList;
    int threshold;
    Long range;

    SlidingLog(int threshold, Long range) {
        this.timestampList = new ArrayDeque<>();
        this.threshold = threshold;
        this.range = range;
    }

    @Override
    public void add() {
        if (notWithinRange()) {
            System.out.println("SlidingLog " + getCount() + " " + getTimestamp());
            throw new RuntimeException("Rate limit exceeded");
        }
        timestampList.add(System.currentTimeMillis());
    }

    @Override
    public int getCount() {
        return timestampList.size();
    }

    @Override
    public long getTimestamp() {
        return timestampList.getLast();
    }

    public boolean notWithinRange() {
        while (!timestampList.isEmpty() && timestampList.getFirst() + range <= System.currentTimeMillis())
            timestampList.pop();
        return timestampList.size() >= threshold;
    }
}
