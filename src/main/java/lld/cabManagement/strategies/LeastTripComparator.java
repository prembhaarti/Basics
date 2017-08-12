package lld.cabManagement.strategies;

import lld.cabManagement.entities.Cab;

import java.util.Comparator;

public class LeastTripComparator implements Comparator<Cab>{
    @Override
    public int compare(Cab cab1, Cab cab2) {
        return cab2.getTripsCovered()-cab1.getTripsCovered();
    }
}