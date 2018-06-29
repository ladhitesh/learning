package org.learning.other;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleExample {
	
	public static void main(String[] args) throws Throwable{
		System.out.println("Hi");
		
		MethodType printMe = MethodType.methodType(void.class);
		MethodHandle mh = MethodHandles.lookup().findVirtual(MethodHandleExample.class, "printMe", printMe);
		MethodHandleExample obj = new MethodHandleExample();
		mh.invoke(obj);
		System.out.println("Done");
	}
	
	public void printMe(){
		System.out.println("Hello World!!!");
	}

}
