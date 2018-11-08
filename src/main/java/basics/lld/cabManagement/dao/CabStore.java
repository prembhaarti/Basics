package basics.lld.cabManagement.dao;

import basics.lld.cabManagement.entities.Cab;
import basics.lld.cabManagement.strategies.LeastTripComparator;
import basics.lld.cabManagement.strategies.MostIdealComparator;

import java.util.PriorityQueue;

public class CabStore {

    private PriorityQueue<Cab> mostIdleCabs ;
    private PriorityQueue<Cab> leastTripCabs;


    public CabStore() {
        this.mostIdleCabs = new PriorityQueue<>(new MostIdealComparator());
        this.leastTripCabs = new PriorityQueue<>(new LeastTripComparator());
    }

    public PriorityQueue<Cab> getMostIdleCabs() {
        return mostIdleCabs;
    }

    public void setMostIdleCabs(PriorityQueue<Cab> mostIdleCabs) {
        this.mostIdleCabs = mostIdleCabs;
    }

    public PriorityQueue<Cab> getLeastTripCabs() {
        return leastTripCabs;
    }

    public void setLeastTripCabs(PriorityQueue<Cab> leastTripCabs) {
        this.leastTripCabs = leastTripCabs;
    }
}
