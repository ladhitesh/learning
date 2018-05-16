package org.learning.cxfclient;

import org.learning.cxfjaxws.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JaxwsServiceConsumer {
	
	@Autowired
	HelloWorldService client;
	
	

}
