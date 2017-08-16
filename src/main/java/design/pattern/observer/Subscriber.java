package design.pattern.observer;

public abstract class Subscriber {

    private Booking booking;

    public Subscriber(Booking booking) {
        this.booking=booking;
    }

    public abstract int getPrice();

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}