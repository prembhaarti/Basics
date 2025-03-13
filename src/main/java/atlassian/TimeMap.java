package atlassian;

import java.util.*;

class TimeMap {
    private Map<String, List<Pair>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new ArrayList<>());
        store.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }

        List<Pair> values = store.get(key);
        int index = binarySearch(values, timestamp);

        return index >= 0 ? values.get(index).value : "";
    }

    private int binarySearch(List<Pair> values, int timestamp) {
        int left = 0, right = values.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid).timestamp == timestamp) {
                return mid;
            } else if (values.get(mid).timestamp < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right; // Return the largest timestamp ≤ given timestamp
    }

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));  // Output: "bar"
        System.out.println(timeMap.get("foo", 3));  // Output: "bar"
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));  // Output: "bar2"
        System.out.println(timeMap.get("foo", 5));  // Output: "bar2"
    }
}