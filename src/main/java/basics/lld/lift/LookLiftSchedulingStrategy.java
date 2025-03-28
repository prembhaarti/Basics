package basics.lld.lift;

import java.util.List;

public class LookLiftSchedulingStrategy implements LiftSchedulingStrategy {

    @Override
    public Lift selectBestLift(List<Lift> lifts, Request request) {
        Lift bestLift = null;
        int minDistance = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            int currentFloor = lift.getCurrentFloor();
            Direction liftDir = lift.getDirection();
            Direction reqDir = request.getDirection();
            int sourceFloor = request.getSource();

            boolean isMovingTowardRequest =
                    (liftDir == Direction.UP && currentFloor <= sourceFloor) ||
                            (liftDir == Direction.DOWN && currentFloor >= sourceFloor);

            boolean isIdleOrMatchingDirection =
                    liftDir == Direction.IDLE || liftDir == reqDir;

            if (isIdleOrMatchingDirection && isMovingTowardRequest) {
                int distance = Math.abs(currentFloor - sourceFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestLift = lift;
                }
            }
        }

        // fallback to closest lift if no ideal one is found
        if (bestLift == null) {
            for (Lift lift : lifts) {
                int distance = Math.abs(lift.getCurrentFloor() - request.getSource());
                if (distance < minDistance) {
                    minDistance = distance;
                    bestLift = lift;
                }
            }
        }

        return bestLift;
    }
}
