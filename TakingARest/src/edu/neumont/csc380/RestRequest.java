package edu.neumont.csc380;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Zack Smith
 * Date: 7/23/13
 * Time: 6:02 PM
 */
public class RestRequest extends HttpServlet {

    private Menu menu;
    private Gson gson;

    public RestRequest() {
        gson = new Gson();
        menu = new Menu();
        for (int i = 0; i < 10; i++) {
            Restaurant r = new Restaurant();
            r.setName(i + "");
            for (int j = 0; j < 5; j++) {
                Food f = new Food();
                f.setName(j + "");
                f.setRestaurant(r);
                r.getFoods().add(f);
            }
            menu.getRestaurant().add(r);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml");
        response.getWriter().write(gson.toJson(menu));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter p = new PrintWriter("orders.txt")) {
            String restaurant = req.getHeader("restaurant");
            String food = req.getHeader("food");

            p.println("Restaurant: " + restaurant + " Food: " + food);
        }
        resp.getWriter().write("Order Placed");
    }
}
