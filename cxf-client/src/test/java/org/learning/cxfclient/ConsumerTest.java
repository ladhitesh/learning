package org.learning.cxfclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.cxfjaxws.DetailGreeting;
import org.learning.cxfjaxws.GreetingMsg;
import org.learning.cxfjaxws.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ConsumerTest {
	
	@Autowired
	HelloWorldService client;
	
	@Test
	public void greetingcomsumer(){
		String result = client.greeting();
		System.out.println(result);
	}
	
	@Test
	public void detailgreetingcomsumer(){
		GreetingMsg result = client.detailGreeting();
		System.out.println(result.getMessage());
	}

}
