package jbasic.pattern.observer.subscribers;

import jbasic.pattern.observer.Booking;
import jbasic.pattern.observer.Subscriber;

public class Hotel extends Subscriber {

    public Hotel(Booking booking) {
        super(booking);
    }

    @Override
    public int getPrice() {
        return getBooking().getPaxCount()*1000;
    }
}
