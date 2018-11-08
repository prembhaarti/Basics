package jbasic.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private int bookingId;
    private int paxCount;
    private int totalPrice;

    List<Subscriber> subscribers = new ArrayList<>();

    public Booking(int bookingId) {
        this.bookingId = bookingId;
    }


    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public boolean deSubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        return true;
    }

    public void informAll() {
        totalPrice=0;
        for (Subscriber subscriber : subscribers) {
            totalPrice+=subscriber.getPrice();
        }
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getPaxCount() {
        return paxCount;
    }

    public void setPaxCount(int paxCount) {
        this.paxCount = paxCount;
        informAll();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", paxCount=" + paxCount +
                '}';
    }
}
