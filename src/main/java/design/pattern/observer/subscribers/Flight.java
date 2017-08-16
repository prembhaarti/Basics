package design.pattern.observer;

public class Flight extends Subscriber {

    public Flight(Booking booking) {
        super(booking);
    }

    @Override
    public int getPrice() {
        return getBooking().getPaxCount()*5000;
    }
}
