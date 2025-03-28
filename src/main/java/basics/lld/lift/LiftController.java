package basics.lld.lift;

public class LiftController {
    private final LiftService liftService;

    public LiftController(LiftService service) {
        this.liftService = service;
    }

    public void requestLift(final int source, final int destination) {
        if (source == destination) throw new IllegalArgumentException("Same floor");
        liftService.handleRequest(new Request(source, destination));
    }

    public int getLiftCurrentFloor(int liftId){
        Lift lift  = liftService.getLiftById(liftId);
        System.out.println(lift.getCurrentFloor());
        System.out.println(lift.getDirection());
        return lift.getCurrentFloor();
    }

    public void shudownLift(int liftId){
        Lift lift  = liftService.getLiftById(liftId);
        lift.stop();
    }


}