package basics.lld.cabManagement.dao.dao.impl;

import basics.lld.cabManagement.constants.Strategy;
import basics.lld.cabManagement.dao.CabDao;
import basics.lld.cabManagement.dao.CabStore;
import basics.lld.cabManagement.entities.Cab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CabDaoImpl implements CabDao{
    public static Map<Integer, Cab> cabStore = new HashMap<>();
    public static Map<String, CabStore> cityCabStore = new HashMap<>();

    @Override
    public boolean addCab(String sourceCity,Cab cab) {
        CabStore cabStore=cityCabStore.get(sourceCity);
        cabStore.getLeastTripCabs().add(cab);
        cabStore.getMostIdleCabs().add(cab);
        return true;
    }

    public Cab getCabByCity(String city, Strategy strategy){
        CabStore cabStore=cityCabStore.get(city);
        Cab cab=null;
        if(strategy==Strategy.LEAST_TRAVELLED){
            cab=cabStore.getLeastTripCabs().poll();
        }
        else if(strategy==Strategy.MOST_IDEAL){
            cab=cabStore.getMostIdleCabs().poll();
        }
        return cab;
    }


    @Override
    public boolean loadCabs(List<Cab> cabs) {
        for(Cab cab: cabs){
            CabStore cabStore1= cityCabStore.get(cab.getSourceCity());
            if(cabStore1==null) {
                cabStore1 = new CabStore();
            }
                PriorityQueue<Cab> mostIdleCabs = cabStore1.getMostIdleCabs();
                PriorityQueue<Cab> leastTripCabs = cabStore1.getLeastTripCabs();
                mostIdleCabs.offer(cab);
                leastTripCabs.offer(cab);
                cityCabStore.put(cab.getSourceCity(), cabStore1);
                cabStore.put(cab.getCabId(), cab);
            /*
            cabStore.put(cab.getCabId(),cab);
            mostIdleCabs.add(cab);
            leastTripCabs.add(cab);
*/
        }
        return true;
    }

/*
    public Cab getLeastTripCab(){
        Cab cab=leastTripCabs.poll();

        */
/*cab.setTripsCovered(cab.getTripsCovered()+1);
        leastTripCabs.offer(cab);*//*

        return cab;
    }

    public Cab getMostIdleCabs(){
        Cab cab= mostIdleCabs.poll();
        return cab;
    }
*/

    public static Map<Integer, Cab> getCabStore() {
        return cabStore;
    }

    public static void setCabStore(Map<Integer, Cab> cabStore) {
        CabDaoImpl.cabStore = cabStore;
    }

    public static Map<String, CabStore> getCityCabStore() {
        return cityCabStore;
    }

    public static void setCityCabStore(Map<String, CabStore> cityCabStore) {
        CabDaoImpl.cityCabStore = cityCabStore;
    }
}