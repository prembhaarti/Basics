package basics.lld.lift;

import java.util.List;

public interface LiftSchedulingStrategy {
    Lift selectBestLift(List<Lift> lifts, Request request);
}
