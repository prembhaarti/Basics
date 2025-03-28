package basics.lld.lift;

import java.util.Comparator;
import java.util.List;

public class SimpleLiftSchedulingStrategy implements LiftSchedulingStrategy{

    @Override
    public Lift selectBestLift(List<Lift> lifts, Request request) {
        return lifts.stream()
                .min(Comparator.comparingInt(l -> Math.abs(l.getCurrentFloor() - request.getSource())))
                .orElse(null);
    }
}
