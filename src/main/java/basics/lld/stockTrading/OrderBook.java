package basics.lld.stockTrading;

import java.util.PriorityQueue;

public class OrderBook {
    private final PriorityQueue<StockOrder> buyOrders;
    private final PriorityQueue<StockOrder> sellOrders;

    public OrderBook() {
        buyOrders = new PriorityQueue<>((a, b) -> b.compareTo(a)); // Max Heap for BUY
        sellOrders = new PriorityQueue<>(StockOrder::compareTo); // Min Heap for SELL
    }

    public void placeOrder(StockOrder order) {
        if (order.getType() == StockOrder.OrderType.BUY) {
            matchBuyOrder(order);
        } else {
            matchSellOrder(order);
        }
    }

    private void matchBuyOrder(StockOrder buyOrder) {
        while (!sellOrders.isEmpty() && sellOrders.peek().getPrice() <= buyOrder.getPrice()) {
            StockOrder sellOrder = sellOrders.poll();
            int tradeQuantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());

            System.out.println("TRADE EXECUTED: " + tradeQuantity + " shares @ $" + sellOrder.getPrice());

            buyOrder.reduceQuantity(tradeQuantity);
            sellOrder.reduceQuantity(tradeQuantity);

            if (sellOrder.getQuantity() > 0) sellOrders.offer(sellOrder);
            if (buyOrder.getQuantity() == 0) return;
        }
        buyOrders.offer(buyOrder);
    }

    private void matchSellOrder(StockOrder sellOrder) {
        while (!buyOrders.isEmpty() && buyOrders.peek().getPrice() >= sellOrder.getPrice()) {
            StockOrder buyOrder = buyOrders.poll();
            int tradeQuantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());

            System.out.println("TRADE EXECUTED: " + tradeQuantity + " shares @ $" + buyOrder.getPrice());

            buyOrder.reduceQuantity(tradeQuantity);
            sellOrder.reduceQuantity(tradeQuantity);

            if (buyOrder.getQuantity() > 0) buyOrders.offer(buyOrder);
            if (sellOrder.getQuantity() == 0) return;
        }
        sellOrders.offer(sellOrder);
    }

    public void printOrderBook() {
        System.out.println("\n--- Order Book ---");
        System.out.println("BUY ORDERS:");
        buyOrders.forEach(System.out::println);
        System.out.println("SELL ORDERS:");
        sellOrders.forEach(System.out::println);
    }
}