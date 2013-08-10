package models;

import java.util.List;

/**
 * User: Zack Smith
 * Date: 8/9/13
 * Time: 4:30 PM
 */
public class Restaurant {

    private List<Food> foods;
    private String name;

    public Restaurant() {
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant(String name, List<Food> foods) {
        this.name = name;
        this.foods = foods;
    }
}
