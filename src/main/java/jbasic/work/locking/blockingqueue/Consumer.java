package jbasic.work.locking.blockingqueue;

public class Consumer implements Runnable{

    private String name;
    private BlockingQueue<Integer> queue;

    public Consumer(String name,BlockingQueue<Integer> queue) {
        this.name=name;
        this.queue=queue;
    }

    public int consume(){
        int num=queue.remove();
        System.out.println(num+": removed");
        return num;
    }


    @Override
    public void run() {
        consume();
    }
}
