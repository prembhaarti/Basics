package basics.lld.rateLimiter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * How it Works: Divides time into fixed intervals (e.g., 1 minute) and allows a fixed number of requests per interval.
 * Use Case: Simple and commonly used in API rate limiting.
 * Pros:
 * Easy to implement.
 * Works well when request traffic is predictable.
 * Cons:
 * Traffic spikes at the start of a window can lead to system overload.
 * Doesn't handle gradual increases in load well.
 *
 * Tracks requests in a fixed time window (e.g., 1 second).
 * If the window expires, it resets the counter.
 * Allows up to limit requests within the current window.
 * Rejects additional requests if the limit is reached.
 * Resets automatically after the time window expires.
 *
 */
public class FixedWindowRateLimiter {
    private final int limit; //Maximum number of requests allowed per window (e.g., 5 requests per second).
    private final long windowSize; //Duration of the time window in milliseconds (converted from seconds).
    private long windowStart; //Timestamp when the current window started (in milliseconds).
    private AtomicInteger counter; // Keeps track of how many requests have been made within the current window.

    public FixedWindowRateLimiter(int limit, int windowSizeInSeconds) {
        this.limit = limit;
        this.windowSize = windowSizeInSeconds * 1_000L;
        this.windowStart = System.currentTimeMillis();
        this.counter = new AtomicInteger(0);
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        if (now - windowStart > windowSize) {
            windowStart = now;
            counter.set(0);
        }
        if (counter.incrementAndGet() <= limit) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(5, 1);
        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + ": " + limiter.allowRequest());
        }
    }
}