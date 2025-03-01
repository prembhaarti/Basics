package basics.lld.rateLimiter;

/**
 * How it Works: Similar to Fixed Window, but instead of resetting at the window boundary, it keeps a moving average of requests.
 * Use Case: Helps smooth out sudden bursts while being memory-efficient.
 * Pros:
 * Avoids fixed-window issues while being lightweight.
 * Cons:
 * Less accurate than a log-based sliding window.
 */
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowCounterRateLimiter {
    private final int limit;
    private final long windowSizeInMillis;
    private final int bucketCount;
    private final long bucketSize;
    private final Map<Long, Integer> buckets;

    public SlidingWindowCounterRateLimiter(int limit, int windowSizeInSeconds, int bucketCount) {
        this.limit = limit;
        this.windowSizeInMillis = windowSizeInSeconds * 1000L;
        this.bucketCount = bucketCount;
        this.bucketSize = windowSizeInMillis / bucketCount;
        this.buckets = new ConcurrentHashMap<>();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        long currentBucket = now / bucketSize;

        // Remove expired buckets
        long minValidBucket = currentBucket - bucketCount;
        buckets.keySet().removeIf(bucket -> bucket < minValidBucket);

        // Calculate total requests in the sliding window
        int totalRequests = buckets.values().stream().mapToInt(Integer::intValue).sum();

        System.out.println("Bucket:"+ buckets);
        // Check if the request can be allowed
        if (totalRequests < limit) {
            buckets.put(currentBucket, buckets.getOrDefault(currentBucket, 0) + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowCounterRateLimiter limiter = new SlidingWindowCounterRateLimiter(6, 2, 4); // 5 requests per 2 seconds, 4 buckets

        for (int i = 0; i < 10; i++) {
            System.out.println("Request " + i + ": " + limiter.allowRequest());
            Thread.sleep(250); // Simulate some delay between requests
        }
    }
}