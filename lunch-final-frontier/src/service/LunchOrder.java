package service;

import models.Food;
import models.Restaurant;

import javax.jws.WebService;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Zack Smith
 * Date: 8/9/13
 * Time: 4:36 PM
 */
@WebService(endpointInterface = "service.ILunchOrder", serviceName = "LunchService")
public class LunchOrder implements ILunchOrder {

    private static final List<Restaurant> restaurants;

    static {
        restaurants = new ArrayList<>();
        ArrayList<Food> foods = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            foods.add(new Food("Restaurant " + i + ",", null));
        for (int i = 0; i < 10; i++)
            restaurants.add(new Restaurant(i + "", foods));
    }

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public String order(Restaurant r, Food f) {
        try (PrintWriter writer = new PrintWriter("order.txt")) {
            String order = "Restaurant: " + r.getName() + " Food: " + f.getName();
            writer.println(order);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "Order Confirmed";
    }
}
