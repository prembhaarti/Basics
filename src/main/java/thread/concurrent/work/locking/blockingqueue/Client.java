package thread.concurrent.work.locking;

import sun.misc.Cleaner;

import java.util.ArrayList;
import java.util.List;

public class Client {
    List<Producer> producers = new ArrayList<>();
    List<Consumer> consumers = new ArrayList<>();
    BlockingQueue<Integer> sharedQueue = new BlockingQueue<>(4);


    public void play(){
        for(int i=0;i<producers.size();i++) {
            Runnable producer = producers.get(i);
            Runnable consumer = consumers.get(i);
            new Thread(producer).start();
            new Thread(consumer).start();
        }
    }


    public void getProducersConsumers(){
        for(int i=0;i<6;i++) {
            producers.add(new Producer("Producer-" + i, sharedQueue));
            consumers.add(new Consumer("Consumer-" + i, sharedQueue));
        }
    }

    public static void main(String[] args) {
        Client client= new Client();
        client.getProducersConsumers();
        client.play();
    }
}
