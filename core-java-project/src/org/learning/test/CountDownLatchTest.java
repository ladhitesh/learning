package org.learning.test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	
	
	public static class ComputeTask implements Runnable {
		
		int computetime;
		CountDownLatch latch;
		
		public ComputeTask(int computetime, CountDownLatch latch) {
			this.computetime=computetime;
			this.latch=latch;
		}
		
		@Override
		public void run() {
			
			try {
				
				Thread.sleep(computetime);
				System.out.println("Woke up after "+computetime);
				latch.countDown();
			} catch (InterruptedException e) {
				//ignore
			}
			
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Hi");
		
		CountDownLatch latch = new CountDownLatch(3);
		
		ComputeTask task1 = new ComputeTask(10,latch);
		ComputeTask task2 = new ComputeTask(100,latch);
		ComputeTask task3 = new ComputeTask(1000,latch);
		
		new Thread(task1).start();
		new Thread(task2).start();
		new Thread(task3).start();
		
		latch.await();
		
		System.out.println("All tasks completed. Collect result and do further computation");
		System.out.println("Done");
	}

}
