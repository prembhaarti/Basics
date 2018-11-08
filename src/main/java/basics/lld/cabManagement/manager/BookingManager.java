package basics.lld.cabManagement.manager;

import basics.lld.cabManagement.constants.Strategy;
import basics.lld.cabManagement.entities.Cab;

public interface BookingManager {

    public Cab bookCab(String citySource, String cityDestination, Strategy strategy);


    public boolean changeCabCity(Cab cab, String destinationCity);

    public Cab endTrip(Cab cab);
}
