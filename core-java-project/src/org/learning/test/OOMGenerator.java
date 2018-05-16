package org.learning.test;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class OOMGenerator {
	
	public static void main(String[] args) {
		System.out.println("Hi");
		int [] oomArray;
		
		//OOM using array
		oomArray = new int[Integer.MAX_VALUE];
		
		ArrayList<Integer> oomArrayList;
		//oomArrayList = new ArrayList<>(Integer.MAX_VALUE);
		
		ArrayBlockingQueue<Integer> oomArrayQueue;
		//oomArrayQueue = new ArrayBlockingQueue<>(Integer.MAX_VALUE);

		System.out.println("Done");
	}

}
