package basics.lld.stockTrading;

import java.util.PriorityQueue;

public class OrderBook {
    private final PriorityQueue<StockOrder> bo;
    private final PriorityQueue<StockOrder> so;

    public OrderBook() {
        bo = new PriorityQueue<>((a, b) -> b.compareTo(a)); // Max Heap for BUY
        so = new PriorityQueue<>(StockOrder::compareTo); // Min Heap for SELL
    }

    public void placeOrder(StockOrder order) {
        if (order.getType() == StockOrder.OrderType.BUY) {
            matchBuyOrder(order);
        } else {
            matchSellOrder(order);
        }
    }

    private void matchBuyOrder(StockOrder buyOrder) {
        while (!so.isEmpty() && so.peek().getPrice() <= buyOrder.getPrice()) {
            StockOrder sellOrder = so.poll();
            int tradeQuantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());

            System.out.println("TRADE EXECUTED: " + tradeQuantity + " shares @ $" + sellOrder.getPrice());

            buyOrder.reduceQuantity(tradeQuantity);
            sellOrder.reduceQuantity(tradeQuantity);

            if (sellOrder.getQuantity() > 0) so.offer(sellOrder);
            if (buyOrder.getQuantity() == 0) return;
        }
        bo.offer(buyOrder);
    }

    private void matchSellOrder(StockOrder sellOrder) {
        while (!bo.isEmpty() && bo.peek().getPrice() >= sellOrder.getPrice()) {
            StockOrder buyOrder = bo.poll();
            int tradeQuantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());

            System.out.println("TRADE EXECUTED: " + tradeQuantity + " shares @ $" + buyOrder.getPrice());

            buyOrder.reduceQuantity(tradeQuantity);
            sellOrder.reduceQuantity(tradeQuantity);

            if (buyOrder.getQuantity() > 0) bo.offer(buyOrder);
            if (sellOrder.getQuantity() == 0) return;
        }
        so.offer(sellOrder);
    }

    public void printOrderBook() {
        System.out.println("\n--- Order Book ---");
        System.out.println("BUY ORDERS:");
        bo.forEach(System.out::println);
        System.out.println("SELL ORDERS:");
        so.forEach(System.out::println);
    }
}