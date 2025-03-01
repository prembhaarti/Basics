package basics.lld.stockTrading;

public class StockExchange {
    public static void main(String[] args) {
        OrderBook orderBook = new OrderBook();

        // Sellers place orders
        orderBook.placeOrder(new StockOrder("AAPL", 150, 10, StockOrder.OrderType.SELL));
        orderBook.placeOrder(new StockOrder("AAPL", 155, 5, StockOrder.OrderType.SELL));

        // Buyers place orders
        orderBook.placeOrder(new StockOrder("AAPL", 160, 8, StockOrder.OrderType.BUY));
        orderBook.placeOrder(new StockOrder("AAPL", 145, 6, StockOrder.OrderType.BUY));

        // Another seller order that matches with an existing buy order
        orderBook.placeOrder(new StockOrder("AAPL", 149, 4, StockOrder.OrderType.SELL));

        orderBook.printOrderBook(); // Display remaining orders
    }
}