package org.learning.cxfjaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWorldService {
	
	@WebMethod
	public String greeting();
	
	@WebMethod
	public GreetingMsg detailGreeting();

}
