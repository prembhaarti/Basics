package lld.cabManagement.manager;

import lld.cabManagement.constants.Strategy;
import lld.cabManagement.entities.Cab;

public interface BookingManager {

    public Cab bookCab(String citySource, String cityDestination, Strategy strategy);


    public boolean changeCabCity(Cab cab, String destinationCity);

    public Cab endTrip(Cab cab);
}
