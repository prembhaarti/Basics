package jbasic.pattern.observer.subscribers;

import jbasic.pattern.observer.Booking;
import jbasic.pattern.observer.Subscriber;

public class Car extends Subscriber {

    public Car(Booking booking) {
        super(booking);
    }

    @Override
    public int getPrice() {
        return getBooking().getPaxCount()*100;
    }
}
