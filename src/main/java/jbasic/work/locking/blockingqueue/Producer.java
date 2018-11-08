package jbasic.work.locking.blockingqueue;

public class Producer implements Runnable{

    private String name;
    private BlockingQueue<Integer> queue;
    private static int count;

    public Producer(String name,BlockingQueue<Integer> queue) {
        this.name=name;
        this.queue=queue;
    }

    public void produce(int i){
        System.out.println(i+": added");
        queue.add(i);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BlockingQueue<Integer> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        produce(count++);
    }
}
