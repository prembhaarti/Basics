package thread.concurrent.work.executers;

public class MyJob {

    private String name;
    private int timeInterval;

    public MyJob(String name) {
        this.name = name;
    }

    public MyJob(String name, int timeInterval) {
        this.name = name;
        this.timeInterval = timeInterval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }
}