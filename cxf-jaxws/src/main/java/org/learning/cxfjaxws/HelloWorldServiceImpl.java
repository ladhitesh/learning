package org.learning.cxfjaxws;

import javax.jws.WebService;

@WebService(endpointInterface="org.learning.cxfjaxws.HelloWorldService",serviceName="HelloWorldService", portName="HelloWorldServiceImplPort")
public class HelloWorldServiceImpl implements HelloWorldService{

	public String greeting() {
		
		return "Hello World from webservice";
	}

	public GreetingMsg detailGreeting() {
		GreetingMsg g = new GreetingMsg();
		g.setMessage("Message from pojo");
		return g;
	}

}
