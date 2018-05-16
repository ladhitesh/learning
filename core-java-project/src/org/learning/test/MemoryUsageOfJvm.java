package org.learning.test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryNotificationInfo;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.lang.management.MemoryUsage;
import java.util.Iterator;
import java.util.List;

import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;

public class MemoryUsageOfJvm {
	
	public static void main(String[] args) throws Exception {
		
		//set Xmx40m before running this program
		addThresholdReachedWarningListener();
		usageUsingRuntime();
		usageusingJmx();
		int[] test = new int[6931500];
		usageUsingRuntime();
		usageusingJmx();
		Thread.sleep(1000L);
		
	}

	private static void addThresholdReachedWarningListener() {
		MemoryMXBean memBean = ManagementFactory.getMemoryMXBean() ;
		NotificationEmitter emitter = (NotificationEmitter) memBean;
		emitter.addNotificationListener(new NotificationListener() {
			
			@Override
			public void handleNotification(Notification notification, Object hb) {
				System.out.println("Notification type:"+notification.getType());
				if(notification.getType().equals(MemoryNotificationInfo.MEMORY_THRESHOLD_EXCEEDED)){
					System.out.println("Threshold reached");
				}
			}
		}, null, null);
		
		List<MemoryPoolMXBean> memPools = ManagementFactory.getMemoryPoolMXBeans() ;
		for(MemoryPoolMXBean pool:memPools){
			if(pool.getType() == MemoryType.HEAP && pool.isUsageThresholdSupported()){
				pool.setUsageThreshold((int)Math.floor(pool.getUsage().getMax()*0.5));
				System.out.println(pool.getName()+" Threshold set at (MB):"+(pool.getUsageThreshold()/(1024*1024)));
			} 
		}
		
	}

	private static void usageusingJmx() {
		MemoryMXBean memBean = ManagementFactory.getMemoryMXBean() ;
		MemoryUsage heap = memBean.getHeapMemoryUsage();
		MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();

		// Retrieve the four values stored within MemoryUsage:
		// init: Amount of memory in bytes that the JVM initially requests from the OS.
		// used: Amount of memory used.
		// committed: Amount of memory that is committed for the JVM to use.
		// max: Maximum amount of memory that can be used for memory management.
		System.out.println(String.format("Heap: Init: %d, Used: %d, Committed: %d, Max.: %d",
		  heap.getInit(), heap.getUsed(), heap.getCommitted(), heap.getMax()));
		System.out.println(String.format("Non-Heap: Init: %d, Used: %d, Committed: %d, Max.: %d",
		  nonHeap.getInit(), nonHeap.getUsed(), nonHeap.getCommitted(), nonHeap.getMax()));
		
		
	}

	private static void usageUsingRuntime() {
		System.out.println("Total(MB):"+(Runtime.getRuntime().totalMemory()/(1024*1024)));
		System.out.println("Free(MB):"+(Runtime.getRuntime().freeMemory()/(1024*1024)));
		
	}

}
