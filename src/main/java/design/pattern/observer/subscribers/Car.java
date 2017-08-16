package design.pattern.observer.subscribers;

import design.pattern.observer.Booking;
import design.pattern.observer.Subscriber;

public class Car extends Subscriber {

    public Car(Booking booking) {
        super(booking);
    }

    @Override
    public int getPrice() {
        return getBooking().getPaxCount()*100;
    }
}
