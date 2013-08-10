
package generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _GetRestaurantsResponse_QNAME = new QName("http://localhost/LunchOrderService", "getRestaurantsResponse");
    private final static QName _OrderResponse_QNAME = new QName("http://localhost/LunchOrderService", "orderResponse");
    private final static QName _GetRestaurants_QNAME = new QName("http://localhost/LunchOrderService", "getRestaurants");
    private final static QName _Order_QNAME = new QName("http://localhost/LunchOrderService", "order");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderResponse }
     * 
     */
    public OrderResponse createOrderResponse() {
        return new OrderResponse();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link GetRestaurants }
     * 
     */
    public GetRestaurants createGetRestaurants() {
        return new GetRestaurants();
    }

    /**
     * Create an instance of {@link GetRestaurantsResponse }
     * 
     */
    public GetRestaurantsResponse createGetRestaurantsResponse() {
        return new GetRestaurantsResponse();
    }

    /**
     * Create an instance of {@link Food }
     * 
     */
    public Food createFood() {
        return new Food();
    }

    /**
     * Create an instance of {@link Restaurant }
     * 
     */
    public Restaurant createRestaurant() {
        return new Restaurant();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/LunchOrderService", name = "getRestaurantsResponse")
    public JAXBElement<GetRestaurantsResponse> createGetRestaurantsResponse(GetRestaurantsResponse value) {
        return new JAXBElement<GetRestaurantsResponse>(_GetRestaurantsResponse_QNAME, GetRestaurantsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/LunchOrderService", name = "orderResponse")
    public JAXBElement<OrderResponse> createOrderResponse(OrderResponse value) {
        return new JAXBElement<OrderResponse>(_OrderResponse_QNAME, OrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurants }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/LunchOrderService", name = "getRestaurants")
    public JAXBElement<GetRestaurants> createGetRestaurants(GetRestaurants value) {
        return new JAXBElement<GetRestaurants>(_GetRestaurants_QNAME, GetRestaurants.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Order }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/LunchOrderService", name = "order")
    public JAXBElement<Order> createOrder(Order value) {
        return new JAXBElement<Order>(_Order_QNAME, Order.class, null, value);
    }

}
