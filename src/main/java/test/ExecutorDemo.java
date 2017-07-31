package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorDemo {

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(10);
    List<String> names= Arrays.asList("Prem","Kumar","Bharti","naveen");
    List<Future<String>> results = new ArrayList<>();
    for (String name : names) {
      results.add(service.submit(new Workers(name)));
    }

    for (Future<String> result : results) {
      try {
        System.out.println(result.get(3000, TimeUnit.MILLISECONDS));
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
}


class Workers implements Callable<String>{
  private String name;

  public Workers(){

  }

  public Workers(String name){
    this.name=name;
  }


  @Override
  public String call() throws Exception {
    Thread.sleep(2000);

    return "Mr. "+name;
  }
}
