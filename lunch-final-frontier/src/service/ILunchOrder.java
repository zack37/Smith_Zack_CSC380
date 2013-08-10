package service;

import models.Food;
import models.Restaurant;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * User: Zack Smith
 * Date: 8/9/13
 * Time: 4:27 PM
 */
@WebService(name = "/LunchOrderService", targetNamespace = "http://localhost/LunchOrderService")
public interface ILunchOrder {

    @WebMethod(operationName = "getRestaurants")
    public @WebResult(name = "Restaurant") List<Restaurant> getRestaurants();

    @WebMethod(operationName = "order")
    public @WebResult(name="Confirmation") String order(Restaurant r, Food f);
}
