package jbasic.pattern.observer.subscribers;

import jbasic.pattern.observer.Booking;
import jbasic.pattern.observer.Subscriber;

public class Flight extends Subscriber {

    public Flight(Booking booking) {
        super(booking);
    }

    @Override
    public int getPrice() {
        return getBooking().getPaxCount()*5000;
    }
}
