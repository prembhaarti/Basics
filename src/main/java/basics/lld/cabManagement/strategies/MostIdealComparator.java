package basics.lld.cabManagement.strategies;

import basics.lld.cabManagement.entities.Cab;

import java.util.Comparator;

public class MostIdealComparator implements Comparator<Cab> {

    @Override
    public int compare(Cab cab1, Cab cab2) {
        if(cab2.getLastIdleTime().getTime()-cab1.getLastIdleTime().getTime()>0){
            return -1;
        }
        else if(cab1.getLastIdleTime().getTime()-cab2.getLastIdleTime().getTime()>0){
            return 1;
        }
        else {
            return 0;
        }
    }
}
