package org.learning.test;

import org.junit.Test;

public class EnumSingletonTest {
	
	@Test
	public void testEnumSingleton(){
		System.out.println(EnumSingleton.INSTANCE);
	}

}
