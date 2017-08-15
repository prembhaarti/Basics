package thread.concurrent.work.locking.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

    Queue<T> queue = new LinkedList<>();
    private int size;

    public BlockingQueue(int size) {
        this.size=size;
    }

    public synchronized void add(T data) {
        if(queue.size()==size){
            System.out.println("Queue is full");
        }
        else{
            queue.add(data);
            notifyAll();
        }
    }

    public synchronized T remove() {
        if(queue.isEmpty()){
            System.out.println("Queue is empty");
            try {
                System.out.println("Waiting for producers to produce");
                wait();
                System.out.println("Releasing wait state.");
            } catch (InterruptedException e) {

            }
        }
            return queue.remove();
    }
}