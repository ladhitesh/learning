package org.learning.cxfjaxws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2018-05-16T21:35:52.200+05:30
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://cxfjaxws.learning.org/", name = "HelloWorldService")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWorldService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "detailGreeting", targetNamespace = "http://cxfjaxws.learning.org/", className = "org.learning.cxfjaxws.DetailGreeting")
    @WebMethod
    @ResponseWrapper(localName = "detailGreetingResponse", targetNamespace = "http://cxfjaxws.learning.org/", className = "org.learning.cxfjaxws.DetailGreetingResponse")
    public org.learning.cxfjaxws.GreetingMsg detailGreeting();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "greeting", targetNamespace = "http://cxfjaxws.learning.org/", className = "org.learning.cxfjaxws.Greeting")
    @WebMethod
    @ResponseWrapper(localName = "greetingResponse", targetNamespace = "http://cxfjaxws.learning.org/", className = "org.learning.cxfjaxws.GreetingResponse")
    public java.lang.String greeting();
}
