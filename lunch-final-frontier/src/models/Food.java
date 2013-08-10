package models;

import java.util.List;

/**
 * User: Zack Smith

 * Date: 8/9/13
 * Time: 4:31 PM
 */
public class Food {
    private String name;
    private List<String> ingredients;

    public Food(){}

    public Food(String name, List<String> ingredients){
        this.name = name;
        this.ingredients = ingredients        ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
