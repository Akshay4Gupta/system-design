package systemDesignBasics.rateLimiting;

public class RateLimitAlgoFactory {
    public static RateLimitAlgorithm getInstance(String choice,
                                                 int threshold,
                                                 long range) {
        if (choice.equals("FixedWindow")) {
            return new FixedWindow(threshold, range);
        } else if (choice.equals("SlidingLog")) {
            return new SlidingLog(threshold, range);
        } else if (choice.equals("SlidingWindow")) {
            return new SlidingWindow(threshold, range);
        }
        throw new RuntimeException("Algorithm Not designed");
    }
}
