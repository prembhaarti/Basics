package basics.lld.currencyConversion;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class DijkstraAlgorithm {

    /**
     * Map<String, Map<String, Double>> currencyRateMap
     * USD - EUR (100)
     *     - INR (90)
     * GBP - JPY (2)
     * INR - PK (3)
     * source - USD
     * target - PK
     *
     * return USD - PK converted rate
     */
    public static Double findBestRate(Map<String, Map<String, Double>> currencyRateMap, String source, String target) {
        //if source or target not available then can't convert
        if (!currencyRateMap.containsKey(source) || !currencyRateMap.containsKey(target)) return null;


        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(currency -> -currency.rate));
        Map<String, Double> bestRates = new HashMap<>();

        pq.offer(new Pair(source, 1.0));
        bestRates.put(source, 1.0);

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            String currency = current.currency;
            double rate = current.rate;

            if (currency.equals(target)) return rate;

            for (Map.Entry<String, Double> neighbor : currencyRateMap.get(currency).entrySet()) {
                double newRate = rate * neighbor.getValue();
                if (newRate > bestRates.getOrDefault(neighbor.getKey(), 0.0)) {
                    bestRates.put(neighbor.getKey(), newRate);
                    pq.offer(new Pair(neighbor.getKey(), newRate));
                }
            }
        }
        return null; // No conversion path found
    }
}
