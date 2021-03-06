package generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-09T19:19:33.650-06:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://localhost/LunchOrderService", name = "/LunchOrderService")
@XmlSeeAlso({ObjectFactory.class})
public interface _002fLunchOrderService {

    @WebResult(name = "Confirmation", targetNamespace = "")
    @RequestWrapper(localName = "order", targetNamespace = "http://localhost/LunchOrderService", className = "generated.Order")
    @WebMethod
    @ResponseWrapper(localName = "orderResponse", targetNamespace = "http://localhost/LunchOrderService", className = "generated.OrderResponse")
    public java.lang.String order(
        @WebParam(name = "restaurant", targetNamespace = "")
        generated.Restaurant restaurant,
        @WebParam(name = "food", targetNamespace = "")
        generated.Food food
    );

    @WebResult(name = "Restaurant", targetNamespace = "")
    @RequestWrapper(localName = "getRestaurants", targetNamespace = "http://localhost/LunchOrderService", className = "generated.GetRestaurants")
    @WebMethod
    @ResponseWrapper(localName = "getRestaurantsResponse", targetNamespace = "http://localhost/LunchOrderService", className = "generated.GetRestaurantsResponse")
    public java.util.List<generated.Restaurant> getRestaurants();
}
