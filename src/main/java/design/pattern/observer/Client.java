package design.pattern.observer;

import design.pattern.observer.subscribers.Car;
import design.pattern.observer.subscribers.Flight;
import design.pattern.observer.subscribers.Hotel;

public class Client {

    public static void main(String[] args) {
        Booking booking= new Booking(1);
        booking.subscribe(new Flight(booking));
        booking.subscribe(new Car(booking));
        booking.subscribe(new Hotel(booking));
        System.out.println(booking.getTotalPrice());
        booking.setPaxCount(1);
        System.out.println(booking.getTotalPrice());
        booking.setPaxCount(2);
        System.out.println(booking.getTotalPrice());

    }
}
