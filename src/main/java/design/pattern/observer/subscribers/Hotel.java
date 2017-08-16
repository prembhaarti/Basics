package design.pattern.observer;

public class Hotel extends Subscriber {

    public Hotel(Booking booking) {
        super(booking);
    }

    @Override
    public int getPrice() {
        return getBooking().getPaxCount()*1000;
    }
}
