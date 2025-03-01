package basics.lld.rateLimiter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * How it Works: Stores timestamps of each request and allows only a set number of requests in a rolling time window.
 * Use Case: More precise rate limiting than fixed window counters.
 * Pros:
 * Accurate tracking of request rates.
 * Prevents artificial limits caused by fixed windows.
 * Cons:
 * Requires more memory since timestamps are stored for every request.
 */
public class SlidingWindowLogRateLimiter {
    private final int limit;
    private final long windowSize;
    private final Queue<Long> timestamps;

    public SlidingWindowLogRateLimiter(int limit, int windowSizeInSeconds) {
        this.limit = limit;
        this.windowSize = windowSizeInSeconds * 1_000L;
        this.timestamps = new LinkedList<>();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        while (!timestamps.isEmpty() && now - timestamps.peek() > windowSize) {
            timestamps.poll();
        }
        if (timestamps.size() < limit) {
            timestamps.offer(now);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingWindowLogRateLimiter limiter = new SlidingWindowLogRateLimiter(5, 10);
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + ": " + limiter.allowRequest());
        }
    }
}