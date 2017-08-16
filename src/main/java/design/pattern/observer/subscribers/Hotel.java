package design.pattern.observer.subscribers;

import design.pattern.observer.Booking;
import design.pattern.observer.Subscriber;

public class Hotel extends Subscriber {

    public Hotel(Booking booking) {
        super(booking);
    }

    @Override
    public int getPrice() {
        return getBooking().getPaxCount()*1000;
    }
}
