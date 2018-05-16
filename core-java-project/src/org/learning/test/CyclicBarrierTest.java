package org.learning.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static class SolveInSteps implements Runnable {
		
		private String solverName;
		private int increment = 0;
		private CyclicBarrier cb;

		SolveInSteps(String solverName,CyclicBarrier cb) {
			this.solverName=solverName;
			this.cb = cb;
		}

		public void setStepIncrement(int increment) {
			this.increment = increment;
		}

		@Override
		public void run() {

			try {

				int ctr = 0;

				while (true) {
					System.out.format("Thread: %s - Solver:%s - Solving step: Step %s%n ", Thread.currentThread().getName(), solverName, increment);
					if (ctr > 2) {
						if(increment == 3)
							break;
						cb.await();

						ctr = 0;
					}
					
					
					
					ctr++;
					
				}

			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}
	
	
	public static class StepIncrementer implements Runnable {
		
		List<SolveInSteps> list;
		
		int ctr = 1;
		StepIncrementer(List list){
			this.list=list;
		}

		@Override
		public void run() {
			for(SolveInSteps s:list){
				System.out.format("Incrementing step for %s%n",s.solverName);
				s.setStepIncrement(ctr);
			}
			ctr++;
			
		}
		
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Hi");
		

		
		List<SolveInSteps> list = new ArrayList<>();
		StepIncrementer si = new StepIncrementer(list);
		
		CyclicBarrier cb = new CyclicBarrier(3,si);
		SolveInSteps ss1 = new SolveInSteps("Solver 1",cb);
		SolveInSteps ss2 = new SolveInSteps("Solver 2",cb);
		SolveInSteps ss3 = new SolveInSteps("Solver 3",cb);
		
		list.add(ss1);
		list.add(ss2);
		list.add(ss3);
		
		Thread t1 = new Thread(ss1);
		Thread t2 = new Thread(ss2);
		Thread t3 = new Thread(ss3);
		
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t3.setName("Thread 3");
		
		t1.start();
		t2.start();
		t3.start();
		
	
		//t1.join();
		System.out.println("Done");

	}

}
