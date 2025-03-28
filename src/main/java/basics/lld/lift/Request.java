package basics.lld.lift;

public class Request {
    private final int source;
    private final int destination;
    private boolean inProcessing;
    private boolean isProcessed;

    public Request(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() { return source; }
    public int getDestination() { return destination; }
    public Direction getDirection() {
        return destination > source ? Direction.UP : Direction.DOWN;
    }

    public boolean isInProcessing() {
        return inProcessing;
    }

    public void setInProcessing(boolean inProcessing) {
        this.inProcessing = inProcessing;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    @Override
    public String toString() {
        return "Request{" +
                "source=" + source +
                ", destination=" + destination +
                ", inProcessing=" + inProcessing +
                ", isProcessed=" + isProcessed +
                '}';
    }
}
