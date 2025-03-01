package basics.lld.rateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * How it Works: Requests enter a bucket at any rate, but they are processed at a fixed rate (like a leaking bucket).
 * Use Case: Helps smooth out sudden bursts and prevents server overload.
 * Pros:
 * Ensures a constant request processing rate.
 * Prevents resource exhaustion due to sudden spikes.
 * Cons:
 * Can lead to delays in request processing.
 */
public class LeakyBucketRateLimiter {
    private final int capacity; //Maximum number of requests the bucket can hold before rejecting new ones.
    private final int leakRate; // Requests per second - How fast the bucket "leaks" requests (processed per second).
    private AtomicLong lastRequestTime; //Stores the timestamp of the last processed request.
    private AtomicInteger water; // Current number of requests in the bucket.

    public LeakyBucketRateLimiter(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.water = new AtomicInteger(0);
        this.lastRequestTime = new AtomicLong(System.nanoTime());
    }

    private void leak() {
        long now = System.nanoTime();
        long elapsed = (now - lastRequestTime.get()) / 1_000_000_000L;
        int leaked = (int) (elapsed * leakRate);
        if (leaked > 0) {
            water.getAndUpdate(curr -> Math.max(0, curr - leaked));
            lastRequestTime.set(now);
        }
    }

    public boolean allowRequest() {
        leak();
        if (water.get() < capacity) {
            water.incrementAndGet();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeakyBucketRateLimiter limiter = new LeakyBucketRateLimiter(10, 3);
        for (int i = 0; i < 15; i++) {
            System.out.println("Request " + i + ": " + limiter.allowRequest());
        }
    }
}