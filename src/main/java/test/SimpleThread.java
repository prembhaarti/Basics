package test;

import java.util.Arrays;
import java.util.List;

public class SimpleThread {

  public static void main(String[] args) {
    List<String> nums= Arrays.asList("1","2","3");
    for(String num:nums){
      new Thread(new SRunnable(num),"ThreadName:"+num).start();
    }
  }


}

class SRunnable implements Runnable{
  private String name;

  public SRunnable(String name){
    this.name=name;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(this.name);
  }
}
