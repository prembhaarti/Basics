package basics.lld.currencyConversion;

public class App {

    public static void main(String[] args) {
        CurrencyRelation graph = new CurrencyRelation();
        graph.addExchangeRate("USD", "EUR", 0.85);
        graph.addExchangeRate("EUR", "GBP", 0.75);
        graph.addExchangeRate("USD", "JPY", 110.0);
        graph.addExchangeRate("JPY", "INR", 0.65);
        graph.addExchangeRate("EUR", "INR", 88.0);
        graph.addExchangeRate("INR", "PK", 3.0);

        ExchangeService exchangeService = new ExchangeService(graph);

        System.out.println("100 USD to EUR: " + exchangeService.convert("USD", "EUR", 100));
        System.out.println("50 EUR to GBP: " + exchangeService.convert("EUR", "GBP", 50));
        System.out.println("10 USD to INR (via best path): " + exchangeService.convert("USD", "INR", 90));
        System.out.println("1 GBP to JPY (No direct path): " + exchangeService.convert("GBP", "JPY", 2));

    }
}
