package systemDesignBasics.rateLimiting;

import java.util.HashMap;

public class RateLimiter {
    private final HashMap<String, RateLimitAlgorithm> apiHits;
    private final int threshold;
    private final long range;
    private final String rateLimitAlgorithm;

    RateLimiter(int threshold, long range, String choice) {
        apiHits = new HashMap<>();
        this.threshold = threshold;
        this.range = range;
        this.rateLimitAlgorithm = choice;
    }

    public void hitApi(String userId) {
        if (!apiHits.containsKey(userId)) {
            apiHits.put(userId, RateLimitAlgoFactory.getInstance(
                    rateLimitAlgorithm, threshold, range));
        }
        apiHits.get(userId).add();
        System.out.println("hit successful " + apiHits.get(userId).getCount() +
                " " + apiHits.get(userId).getTimestamp());
    }
}
