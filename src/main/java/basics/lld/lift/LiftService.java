package basics.lld.lift;

import java.util.List;

public class LiftService {
    private final LiftSchedulingStrategy liftSchedulingStrategy = new LookLiftSchedulingStrategy();
    private final LiftDAO liftDAO;

    public LiftService(LiftDAO dao) {
        this.liftDAO = dao;
    }

    public void handleRequest(Request req) {
        Lift bestLift = findBestLift(req);
        if (bestLift == null) {
            throw new LiftOperationException("No suitable lift found");
        }
        bestLift.addRequest(req);
    }

    public Lift getLiftById(int liftId){
        return liftDAO.getById(liftId);
    }

    private Lift findBestLift(Request req) {
        List<Lift> lifts = liftDAO.getAll();
        Lift lift = liftSchedulingStrategy.selectBestLift(lifts, req);
        if (lift == null) {
            throw new LiftOperationException("No lift available for request.");
        }
        return lift;
    }

    public void startAllLifts() {
        for (Lift lift : liftDAO.getAll()) {
            lift.setRunning(true);
            new Thread(lift::processRequests).start();
        }
    }

    public void shutdown() {
        liftDAO.getAll().forEach(Lift::stop);
    }




//    private void requestFloor(Request request) {
//        int floor = request.getDestination();
//        if (floor > ) {
//            upRequests.add(floor);
//        } else if (floor < currentFloor) {
//            downRequests.add(floor);
//        } else {
//            System.out.println("Already at requested floor: " + floor);
//        }
//    }
}
