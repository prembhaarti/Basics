package basics.lld.stockTrading;

import java.util.concurrent.atomic.AtomicInteger;

public class StockOrder implements Comparable<StockOrder> {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private final int orderId;
    private final String stockSymbol;
    private final double price;
    private int quantity;
    private final OrderType type;
    private final long timestamp;

    public enum OrderType { BUY, SELL }

    public StockOrder(String stockSymbol, double price, int quantity, OrderType type) {
        this.orderId = idGenerator.incrementAndGet();
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.timestamp = System.nanoTime();
    }

    public int getOrderId() { return orderId; }
    public String getStockSymbol() { return stockSymbol; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public OrderType getType() { return type; }
    public long getTimestamp() { return timestamp; }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    @Override
    public int compareTo(StockOrder other) {
        if (this.type == OrderType.BUY) {
            return Double.compare(other.price, this.price); // Higher price first
        } else {
            return Double.compare(this.price, other.price); // Lower price first
        }
    }

    @Override
    public String toString() {
        return String.format("Order[%d]: %s %d @ $%.2f", orderId, type, quantity, price);
    }
}