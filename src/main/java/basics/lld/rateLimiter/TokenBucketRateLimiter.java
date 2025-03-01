package basics.lld.rateLimiter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * How it Works: A fixed-size bucket holds tokens, and each request consumes one token. Tokens replenish at a fixed rate.
 * Use Case: Best for scenarios where bursty traffic is allowed, such as APIs that experience sudden spikes.
 * Pros:
 * Allows bursts while maintaining a steady refill rate.
 * More flexible than a leaky bucket.
 * Cons:
 * Slightly complex to implement due to token regeneration.
 */
public class TokenBucketRateLimiter {
    private final int capacity;
    private final int refillRate;
    private final AtomicInteger tokens;
    private long lastRefillTimestamp;

    public TokenBucketRateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = new AtomicInteger(capacity);
        this.lastRefillTimestamp = System.nanoTime();
    }

    private void refill() {
        long now = System.nanoTime();
        int newTokens = (int) ((now - lastRefillTimestamp) / 1_000_000_000L * refillRate);
        if (newTokens > 0) {
            tokens.getAndUpdate(curr -> Math.min(capacity, curr + newTokens));
            lastRefillTimestamp = now;
        }
    }

    public boolean allowRequest() {
        refill();
        return tokens.getAndDecrement() > 0;
    }

    public static void main(String[] args) {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(10, 5);
        for (int i = 0; i < 15; i++) {
            System.out.println("Request " + i + ": " + limiter.allowRequest());
        }
    }
}