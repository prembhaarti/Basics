package jbasic.work.executers.threadpool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Master {
    static List<String> jobs = Arrays.asList("Prem","Satish","Ashish","Gaurav");

    public void completeWithSingleThread() throws InterruptedException {
        List<Worker> workers=getWorkersWithJob();
        for (Worker worker : workers) {
            worker.work();
        }
    }

    public void completeWithMultipleThread(){
        List<Worker> workers= getWorkersWithJob();
        for (Worker worker : workers) {
            new Thread(worker).start();
        }
    }

    public void completeWithFixedThreadPool(){
        List<Worker> workers= getWorkersWithJob();
        ExecutorService service = Executors.newFixedThreadPool(jobs.size());
        List<Future<String>> results = new ArrayList<>();
        for (Callable<String> callableWorker : workers) {
            results.add(service.submit(callableWorker));
        }
        for (Future<String> result : results) {
            try {
                System.out.println(result.get(2, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }



    public void completeWithThreadPoolExecutor() throws InterruptedException {
        List<Worker> workers= getWorkersWithJob();
        ThreadPoolExecutor poolExecutor= new ThreadPoolExecutor(3,4,0,TimeUnit.SECONDS,new ArrayBlockingQueue<>(workers.size()));
        for (Runnable worker : workers) {
            poolExecutor.execute(worker);
        }
        while (poolExecutor.getActiveCount()>0){
            Thread.sleep(1000);
            System.out.println(poolExecutor);
        }
        poolExecutor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        Master master= new Master();
//        master.completeWithSingleThread();
//        master.completeWithMultipleThread();
//        master.completeWithFixedThreadPool();
          master.completeWithThreadPoolExecutor();
    }

    public static List<Worker> getWorkersWithJob(){
        List<Worker> workers = new ArrayList<>();
        int i=2;
        for (String job : jobs) {
            workers.add(new Worker(new MyJob(job,i)));
        }
        return workers;
    }
}