package org.learning.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class BlockingQueueImplTest<T> {

	//Queue<T> queue = new LinkedList<>();
	Queue<T> queue = new ConcurrentLinkedQueue<>(); //Thread-safe implementation of queue
	int ctr = 0;
	int size = 5;
	Semaphore empty = new Semaphore(size);
	Semaphore full = new Semaphore(0);

	public T take() throws Exception {
		// check size and block until available
		// using semaphores

		full.acquire();
		T obj = queue.poll();
		empty.release();

		return obj;
	}

	public void put(T obj) throws Exception {
		// check size and block until available
		// using semaphores

		empty.acquire();
		queue.add(obj);
		full.release();

	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("Hi");
		
		BlockingQueueImplTest<String> bq = new BlockingQueueImplTest<>();
		bq.put("1");
		bq.put("1");
		bq.put("1");
		bq.put("1");
		bq.put("1");
		bq.take();
		bq.take();
		bq.take();
		bq.take();
		bq.take();
		bq.put("1");
		bq.put("1");
		bq.put("1");
		bq.take();
		bq.take();
		bq.take();
		

		
		System.out.println("Done");
	}

}
