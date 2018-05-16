package org.learning.test;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static class OddNumberGenerator implements Runnable {
		private int oddctr = 1;

		Semaphore oddsignal;
		Semaphore evensignal;

		public OddNumberGenerator(Semaphore oddsignal, Semaphore evensignal) {
			this.oddsignal = oddsignal;
			this.evensignal = evensignal;
		}

		@Override
		public void run() {
			while (true) {
				try {

					oddsignal.acquire(); //I can run now
					System.out.println(oddctr);
					oddctr = oddctr + 2;
					evensignal.release(); //Let even run next

				} catch (InterruptedException ex) {
					break;
				}
			}
		}

	}

	public static class EvenNumberGenerator implements Runnable {

		private int evenctr = 0;

		Semaphore oddsignal;
		Semaphore evensignal;

		public EvenNumberGenerator(Semaphore oddsignal, Semaphore evensignal) {
			this.oddsignal = oddsignal;
			this.evensignal = evensignal;
		}

		@Override
		public void run() {
			while (true) {
				try {

					evensignal.acquire(); //I can run now
					System.out.println(evenctr);
					evenctr = evenctr + 2;
					oddsignal.release(); //Let odd run next

				} catch (InterruptedException ex) {
					break;
				}
			}

		}

	}

	public static void main(String[] args) throws InterruptedException{
		System.out.println("Hi");

		Semaphore oddsignal = new Semaphore(0); //Binary semaphores are basically locks.
		Semaphore evensignal = new Semaphore(1); //This can also be implemented using reentrant locks

		 //even should start first. start with 0
		OddNumberGenerator odd = new OddNumberGenerator(oddsignal, evensignal);
		EvenNumberGenerator even = new EvenNumberGenerator(oddsignal,evensignal);
		
		
		Thread t1 = new Thread(even);t1.start();
		Thread t2 = new Thread(odd);t2.start();
		
		Thread.sleep(5);
		
		t1.interrupt();
		t2.interrupt();

		System.out.println("Done");
	}
	
	public static void main1(String[] args) {
		System.out.println("Hi");
		Semaphore test = new Semaphore(1);
		test.release();test.release();test.release();test.release();test.release();
		System.out.println(test.availablePermits());
		//Final output is 6. it keeps on increasing permits for every release
		System.out.println("Done");
	}

}
