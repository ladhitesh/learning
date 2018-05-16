
package org.learning.cxfjaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.learning.cxfjaxws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Greeting_QNAME = new QName("http://cxfjaxws.learning.org/", "greeting");
    private final static QName _DetailGreeting_QNAME = new QName("http://cxfjaxws.learning.org/", "detailGreeting");
    private final static QName _DetailGreetingResponse_QNAME = new QName("http://cxfjaxws.learning.org/", "detailGreetingResponse");
    private final static QName _GreetingResponse_QNAME = new QName("http://cxfjaxws.learning.org/", "greetingResponse");
    private final static QName _GreetingMessage_QNAME = new QName("http://cxfjaxws.learning.org/", "GreetingMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.learning.cxfjaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DetailGreeting }
     * 
     */
    public DetailGreeting createDetailGreeting() {
        return new DetailGreeting();
    }

    /**
     * Create an instance of {@link GreetingResponse }
     * 
     */
    public GreetingResponse createGreetingResponse() {
        return new GreetingResponse();
    }

    /**
     * Create an instance of {@link GreetingMsg }
     * 
     */
    public GreetingMsg createGreetingMsg() {
        return new GreetingMsg();
    }

    /**
     * Create an instance of {@link Greeting }
     * 
     */
    public Greeting createGreeting() {
        return new Greeting();
    }

    /**
     * Create an instance of {@link DetailGreetingResponse }
     * 
     */
    public DetailGreetingResponse createDetailGreetingResponse() {
        return new DetailGreetingResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Greeting }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfjaxws.learning.org/", name = "greeting")
    public JAXBElement<Greeting> createGreeting(Greeting value) {
        return new JAXBElement<Greeting>(_Greeting_QNAME, Greeting.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetailGreeting }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfjaxws.learning.org/", name = "detailGreeting")
    public JAXBElement<DetailGreeting> createDetailGreeting(DetailGreeting value) {
        return new JAXBElement<DetailGreeting>(_DetailGreeting_QNAME, DetailGreeting.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetailGreetingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfjaxws.learning.org/", name = "detailGreetingResponse")
    public JAXBElement<DetailGreetingResponse> createDetailGreetingResponse(DetailGreetingResponse value) {
        return new JAXBElement<DetailGreetingResponse>(_DetailGreetingResponse_QNAME, DetailGreetingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfjaxws.learning.org/", name = "greetingResponse")
    public JAXBElement<GreetingResponse> createGreetingResponse(GreetingResponse value) {
        return new JAXBElement<GreetingResponse>(_GreetingResponse_QNAME, GreetingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GreetingMsg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxfjaxws.learning.org/", name = "GreetingMessage")
    public JAXBElement<GreetingMsg> createGreetingMessage(GreetingMsg value) {
        return new JAXBElement<GreetingMsg>(_GreetingMessage_QNAME, GreetingMsg.class, null, value);
    }

}
