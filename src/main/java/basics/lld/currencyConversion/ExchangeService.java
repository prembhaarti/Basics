package basics.lld.currencyConversion;

class ExchangeService {
    private final CurrencyRelation graph;

    public ExchangeService(CurrencyRelation graph) {
        this.graph = graph;
    }

    public double convert(String from, String to, double amount) {
        if (from.equals(to)) return amount;

        Double rate = graph.getConvertedRate(from, to);
        if (rate != null) {
            return amount * rate;
        }

        Double bestRate = findBestConversionRate(from, to);
        return bestRate != null ? amount * bestRate : -1; // -1 indicates conversion not possible
    }

    private Double findBestConversionRate(String from, String to) {
        return DijkstraAlgorithm.findBestRate(graph.getCurrencyRateMap(), from, to);
    }
}