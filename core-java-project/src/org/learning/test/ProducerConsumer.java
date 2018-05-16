package org.learning.test;


import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
	
	private final BlockingQueue<Message<String>> messageQueue = new ArrayBlockingQueue<>(5);

	
	public static class MessageProducer<V> implements Runnable{
		
		BlockingQueue<Message<V>> queue ;
		
		MessageProducer(BlockingQueue<Message<V>> queue){
			this.queue=queue;
		}

		@Override
		public void run() {
			
			while(true){
				String uuid = UUID.randomUUID().toString();
				System.out.format("Producing msg:%s%n",uuid);
				Message<V> msg = (Message<V>) new Message<>(uuid);
				try {
					queue.put(msg);
				} catch (InterruptedException e) {
					System.out.println("Producer Stopped");
					break;
				}
			}
		}
		
	}
	
	public static class MessageConsumer<R>  implements Runnable{

		BlockingQueue<Message<R>> queue ;
		
		MessageConsumer(BlockingQueue<Message<R>> queue){
			this.queue=queue;
		}

		@Override
		public void run() {
			while(true){
				Message<R> msg =null;
				try {
					msg = queue.take();
					System.out.format("Consuming msg:%s%n",msg.getMessage());
				} catch (InterruptedException e) {
					System.out.println("Consumer Stopped");
					break;
				}
			}
		}
		
	}
	
	public static class Message <T> {
		
		private T msg;
		
		Message(T msg){
			this.msg = msg;
		}
		
		public T getMessage(){
			return msg;
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hi");
		
		ProducerConsumer pc = new ProducerConsumer();
		Thread stringProducer = new Thread( new MessageProducer<String>(pc.messageQueue) );
		Thread stringConsumer = new Thread( new MessageConsumer<String>(pc.messageQueue) );

		stringProducer.start();
		stringConsumer.start();
		
		Thread.sleep(200);
		stringProducer.interrupt();
		stringConsumer.interrupt();
		System.out.println("Done");
		
	}

}
