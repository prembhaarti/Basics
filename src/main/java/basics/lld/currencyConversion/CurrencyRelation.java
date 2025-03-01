package basics.lld.currencyConversion;

import java.util.HashMap;
import java.util.Map;

class CurrencyRelation {
    private final Map<String, Map<String, Double>> currencyRateMap;

    public CurrencyRelation() {
        this.currencyRateMap = new HashMap<>();
    }

    public void addExchangeRate(String from, String to, double rate) {
        currencyRateMap.putIfAbsent(from, new HashMap<>());
        currencyRateMap.putIfAbsent(to, new HashMap<>());
        currencyRateMap.get(from).put(to, rate);
        currencyRateMap.get(to).put(from, 1.0 / rate); // Reverse conversion
    }

    public Double getConvertedRate(String from, String to) {
        return currencyRateMap.getOrDefault(from, new HashMap<>()).get(to);
    }

    public Map<String, Map<String, Double>> getCurrencyRateMap() {
        return currencyRateMap;
    }
}