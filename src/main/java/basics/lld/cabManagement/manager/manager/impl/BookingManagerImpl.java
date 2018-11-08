package basics.lld.cabManagement.manager.manager.impl;

import basics.lld.cabManagement.constants.CabState;
import basics.lld.cabManagement.constants.Strategy;
import basics.lld.cabManagement.dao.dao.impl.CabDaoImpl;
import basics.lld.cabManagement.entities.Cab;
import basics.lld.cabManagement.manager.AvailabilityManager;
import basics.lld.cabManagement.manager.BookingManager;

import java.util.Date;
import java.util.Set;

public class BookingManagerImpl implements BookingManager{

    AvailabilityManager availabilityManager= new AvailabilityManagerImpl();
    CabDaoImpl cabDao= new CabDaoImpl();
    @Override
    public Cab bookCab(String citySource, String cityDestination, Strategy strategy) {
        Cab cab=null;
        Set<String> cities=CabDaoImpl.cityCabStore.keySet();
        if(!(cities.contains(citySource)&& cities.contains(cityDestination))){
            return cab;
        }

        if(strategy==Strategy.LEAST_TRAVELLED){
            cab=cabDao.getCabByCity(citySource,strategy);
            if(null!=cab) {
                cab.setLastBookedTime(new Date(System.currentTimeMillis()));
                cab.setDestinationCity(cityDestination);
                cab.setState(CabState.ON_TRIP);
            }
            return cab;
        }
        else if(strategy==Strategy.MOST_IDEAL){
            cab=cabDao.getCabByCity(citySource,strategy);
            if(null!=cab) {
                cab.setState(CabState.ON_TRIP);
                cab.setDestinationCity(cityDestination);
            }
            return cab;
        }
        return cab;
    }

    @Override
    public boolean changeCabCity(Cab cab, String destinationCity) {
        if(!cab.getSourceCity().equalsIgnoreCase(destinationCity)){
            cab.setDestinationCity(destinationCity);
            return true;
        }
        return false;
    }

    @Override
    public Cab endTrip(Cab cab) {
        CabDaoImpl cabDaoImpl= new CabDaoImpl();
        cab.setSourceCity(cab.getDestinationCity());
        cab.setDestinationCity(null);
        cab.setTripsCovered(cab.getTripsCovered()+1);
        cab.setState(CabState.IDLE);
        cab.setLastIdleTime(new Date(System.currentTimeMillis()));
        cabDaoImpl.addCab(cab.getSourceCity(),cab);
        return cab;
    }
}
