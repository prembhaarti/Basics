package design.pattern.observer;

public class Car extends Subscriber {

    public Car(Booking booking) {
        super(booking);
    }

    @Override
    public int getPrice() {
        return getBooking().getPaxCount()*100;
    }
}
