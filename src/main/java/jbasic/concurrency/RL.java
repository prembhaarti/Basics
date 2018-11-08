package jbasic.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RL {
	private Lock lock= new ReentrantLock(true);
	private Counter count=new Counter(0);
	
	public static void main(String[] args) {
		RL rl = new RL();
		for(int i=0;i<10;i++){
			new Thread(new Adder(rl.count,rl.lock)).start();
			new Thread(new Adder(rl.count,rl.lock)).start();
			new Thread(new Adder(rl.count,rl.lock)).start();
			new Thread(new Substractor(rl.count,rl.lock)).start();
		}
	}
}

final class Counter{
	private int count;
	public Counter(int count) {
		this.count=count;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}

class Adder implements Runnable{
	private Counter count;
	private Lock lock;
	public Adder(Counter count,Lock lock){
		this.count=count;
		this.lock=lock;
	}
	public void run() {
		lock.lock();
		count.setCount(count.getCount()+1);
		System.out.println("Adder Count:"+count.getCount());
		lock.unlock();
	}
}

class Substractor implements Runnable{
	private Counter count;
	private Lock lock;
	public Substractor(Counter count,Lock lock) {
		this.count=count;
		this.lock=lock;
	}
	public void run() {
		lock.lock();
		count.setCount(count.getCount()-1);
		System.out.println("Substractor Count:"+count.getCount());
		lock.unlock();
	}
}