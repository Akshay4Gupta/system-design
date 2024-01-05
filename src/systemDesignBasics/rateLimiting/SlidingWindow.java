package systemDesignBasics.rateLimiting;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow implements RateLimitAlgorithm {
    int threshold;
    long range;

    Deque<RateLimitAlgorithm> timestampList;

    SlidingWindow(int threshold, long range) {
        this.threshold = threshold;
        this.range = range;
        timestampList = new LinkedList<>();
    }

    @Override
    public void add() {
        if (notWithinRange()) {
            System.out.println("SlidingWindow1 " + getCount() + " " + getTimestamp());
            throw new RuntimeException("Rate limit exceeded");
        }

        if (timestampList.isEmpty() || timestampList.getLast().notWithinRange()) {
            RateLimitAlgorithm rateLimitAlgorithm = new FixedWindow(threshold, range);
            rateLimitAlgorithm.add();
            timestampList.add(rateLimitAlgorithm);
        } else {
            if (timestampList.getLast().getCount() >= threshold) {
                System.out.println("SlidingWindow2 " + getCount() + " " + getTimestamp());
                throw new RuntimeException("Rate limit exceeded");
            }
            timestampList.getLast().add();
        }

    }

    @Override
    public int getCount() {
        int size = 0;
        for(RateLimitAlgorithm f: timestampList) {
            size += f.getCount();
        }
        return size;
    }

    @Override
    public long getTimestamp() {
        return timestampList.getLast().getTimestamp();
    }

    public boolean notWithinRange() {
        while (!timestampList.isEmpty() && timestampList.getFirst().getTimestamp() + range <= System.currentTimeMillis())
            timestampList.pop();

        return getCount() >= threshold * (timestampList.size() + 1);
    }
}
