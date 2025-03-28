package basics.lld.lift;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static basics.lld.lift.Direction.DOWN;
import static basics.lld.lift.Direction.UP;

public class Lift {
    public static final int FLR_MOVEMENT_TIME_IN_MILLIS = 1;
    private final int id;
    private int currentFloor;
    private int lowestFloor = 0;
    private int ceil = 6;
    private Direction direction;
    private final Queue<Request> requests;
    private final Set<Request> upRequests = new TreeSet<>(Comparator.comparingInt(Request::getSource));
    private final Set<Request> downRequests = new TreeSet<>(Comparator.comparingInt(Request::getDestination).reversed());
    private final Lock lock;
    private boolean running;

    public Lift(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.requests = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.running = true;
    }

    //# # 3 # # 6 # # #

    public void addRequest(Request request) {
        //validate request also, if source and destination is not out of bound.
        lock.lock();
        try {
            if (request.getSource() < request.getDestination()) {
                upRequests.add(request);
            } else if ((request.getDestination() < request.getSource())) {
                downRequests.add(request);
            } else if (request.getDestination() == currentFloor) {
                System.out.println("Already at requested floor: " + request.getDestination());
            }
        } finally {
            lock.unlock();
        }
    }

    public void stop() {
        running = false;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

    public void processRequests() {
        System.out.println("-UpRequests:"+ upRequests);
        System.out.println("-DownRequests:"+ downRequests);
        while (running) {
//            lock.lock();
            if (!upRequests.isEmpty() || !downRequests.isEmpty()) {
                if (direction == UP || direction == Direction.IDLE) {
                    direction = UP;
                    serveUpRequests();
                    direction = Direction.DOWN;
                }

                if (direction == Direction.DOWN) {
                    direction = DOWN;
                    serveDownRequests();
                    direction = UP;
                }
            }
            else {
//            lock.unlock();
                direction = Direction.IDLE;
            }
//            System.out.println("Elevator is now idle at floor: " + currentFloor);
        }


//        while (running) {
//            Request req = null;
//            lock.lock();
//            try {
//                if (!requests.isEmpty()) req = requests.poll();
//            } finally {
//                lock.unlock();
//            }
//
//            if (req != null) {
//                this.direction = req.getDirection();
//                moveTo(req.getSource());
//                moveTo(req.getDestination());
//                this.direction = Direction.IDLE;
//            }
//
//            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
//        }
    }

    private void serveUpRequests() {
        Iterator<Request> iterator = upRequests.iterator();
        while (iterator.hasNext()) {
            Request request = iterator.next();
            if(request.isProcessed()){
                iterator.remove();
                continue;
            }
            int source = request.getSource();
            int destination = request.getDestination();
            if (currentFloor <= source) {
                moveToFloor(source, UP, false);
                request.setInProcessing(true);
            }
            if(currentFloor <= destination && request.isInProcessing()) {
                moveToFloor(destination, UP, true);
                iterator.remove();
            }
        }
    }

    private void serveDownRequests() {
        Iterator<Request> iterator = downRequests.iterator();
        while (iterator.hasNext()) {
            Request request = iterator.next();
            int source = request.getSource();
            if (currentFloor >= source) {
                moveToFloor(source, DOWN, false);
                int destination = request.getDestination();
                moveToFloor(destination, DOWN, true);
                iterator.remove();
            }
        }
    }

    private void moveToFloor(int floor, Direction direction, boolean destination) {
        System.out.println("Moving from floor " + currentFloor + " to " + floor);
        lock.lock();
        while (currentFloor != floor && currentFloor >= lowestFloor && currentFloor <= ceil) {
            try {
                Thread.sleep(FLR_MOVEMENT_TIME_IN_MILLIS);
                if (direction == UP) {
                    isAnySourceMatched(upRequests);
                    isAnyDestinationMatched(upRequests);
                    currentFloor++;
                } else if (direction == DOWN) {
                    isAnySourceMatched(downRequests);
                    isAnyDestinationMatched(downRequests);
                    currentFloor--;
                } else {
                    break;
                }
                    System.out.println("Moving from floor " + currentFloor + " to " + floor);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            lock.unlock();

        System.out.println("Arrived at " + (destination ? "destination " : "source ") + "floor " + floor);
    }

    private boolean isAnySourceMatched(Set<Request> requests){
        Optional<Request> request = requests.stream().filter(req -> req.getSource()==currentFloor).findAny();
        if(request.isPresent()){
            System.out.println(request.get().getSource() + " is in processing");
            request.get().setInProcessing(true);
        }
        return true;
    }

    private boolean isAnyDestinationMatched(Set<Request> requests){
        Optional<Request> request = requests.stream().filter(req -> req.getDestination()==currentFloor && req.isInProcessing()).findAny();
        if(request.isPresent()){
//            System.out.println("UpRequests:"+ upRequests);
//            System.out.println("DownRequests:"+ downRequests);
            request.get().setProcessed(true);
        }
        return true;
    }

//    private void moveTo(int floor) {
//        if(!running){
//            return;
//        }
//        while (currentFloor != floor) {
//            currentFloor += floor > currentFloor ? 1 : -1;
//            System.out.println("Lift " + id + " at floor " + currentFloor);
//            try {
//                Thread.sleep(500);
//                if(!running){
//                    break;
//                }
//            } catch (InterruptedException ignored) {}
//        }
//    }


    public void setRunning(boolean running) {
        this.running = running;
    }
}
