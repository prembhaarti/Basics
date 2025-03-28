package basics.lld.lift;
/**
 * ==============================================
 *  Lift Management System - End-to-End Flow
 * ==============================================
 *
 * 1. A user presses a button to request a lift from floor A to B.
 * 2. Controller receives the request and sends it to LiftService.
 * 3. LiftService selects the best lift using a scheduling strategy.
 * 4. The request is added to the lift's queue.
 * 5. Lift thread continuously checks and processes requests.
 * 6. DAO can be expanded to store lift states (mocked for now).
 * 7. All actions are logged; exceptions are handled gracefully.
 */
public class LiftSystemApp {
    public static void main(String[] args) throws InterruptedException {
        LiftDAO dao = new LiftDAO();
        LiftService service = new LiftService(dao);
        LiftController controller = new LiftController(service);

        // Register Lifts
        Lift lift1 = new Lift(1);
        dao.save(lift1);

        // Simulate requests
        controller.requestLift(0, 5);
        controller.requestLift(3, 2);
        controller.requestLift(4, 6);
        controller.requestLift(2, 6);

        // Start processing
        service.startAllLifts();

        // Allow time for processing
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        service.shutdown();
    }
}
