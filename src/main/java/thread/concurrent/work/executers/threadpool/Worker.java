package thread.concurrent.work.executers;

import java.util.Date;
import java.util.concurrent.Callable;

public class Worker implements Callable<String>,Runnable{
    private MyJob job;

    public Worker(MyJob job) {
        this.job = job;
    }

    public String work() throws InterruptedException {
        System.out.println(job.getName()+" Started");
        Thread.sleep(2000);
        return job.getName()+" Completed";
    }

    @Override
    public String call() throws Exception {
       return work();
    }

    @Override
    public void run(){
        try {
            System.out.println(job.getName()+" started:"+new Date(System.currentTimeMillis()));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(work()+": "+new Date(System.currentTimeMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}