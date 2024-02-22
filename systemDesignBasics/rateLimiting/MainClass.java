package systemDesignBasics.rateLimiting;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        int threshold = 2;
        int range = 1000;
        String[] choice = {"FixedWindow", "SlidingLog", "SlidingWindow"};
        RateLimiter window = new RateLimiter(threshold, range, choice[1]);
        window.hitApi("user1");
        Thread.sleep(400);
        window.hitApi("user1");
        Thread.sleep(400);
        window.hitApi("user1");
        Thread.sleep(400);
        window.hitApi("user1");
        Thread.sleep(400);
        window.hitApi("user1");
        Thread.sleep(400);
        window.hitApi("user1");
        Thread.sleep(400);
        window.hitApi("user1");
        Thread.sleep(400);
        window.hitApi("user1");
        Thread.sleep(400);
        window.hitApi("user1");
    }
}
