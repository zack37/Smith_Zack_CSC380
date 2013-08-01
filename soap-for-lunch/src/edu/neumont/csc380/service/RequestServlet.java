package edu.neumont.csc380.service;

import edu.neumont.csc380.jaxb.request.Envelope;
import edu.neumont.csc380.jaxb.response.Food;
import edu.neumont.csc380.jaxb.response.Restaurant;
import edu.neumont.csc380.jaxb.response.RestaurantResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

/**
 * User: Zack Smith
 * Date: 7/31/13
 * Time: 6:03 PM
 */
@WebServlet(name = "RequestServlet", urlPatterns = "/restaurant")
public class RequestServlet extends HttpServlet {

    public RequestServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JAXBContext jaxb = JAXBContext.newInstance("edu.neumont.csc380");
            Unmarshaller requestUnmarshaller = jaxb.createUnmarshaller();
            edu.neumont.csc380.jaxb.post.request.Envelope requestEnvelope = (edu.neumont.csc380.jaxb.post.request.Envelope) requestUnmarshaller.unmarshal(request.getInputStream());

            response.getWriter().write("Order successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/xml");
            JAXBContext jaxb = JAXBContext.newInstance("edu.neumont.csc380");
            Unmarshaller soapRequestUnmarshaller = jaxb.createUnmarshaller();
            Envelope soapRequestEnvelope = (Envelope) soapRequestUnmarshaller.unmarshal(request.getInputStream());

            Marshaller m = jaxb.createMarshaller();
            edu.neumont.csc380.jaxb.response.Envelope responseEnvelope = new edu.neumont.csc380.jaxb.response.Envelope();
            edu.neumont.csc380.jaxb.response.Body responseBody = new edu.neumont.csc380.jaxb.response.Body();
            RestaurantResponse restaurantResponse = new RestaurantResponse();
            Restaurant r = new Restaurant();
            r.setName("Rubio's");
            r.getFood().add(new Food());
            restaurantResponse.setRestaurant(r);
            responseBody.setRestaurantResponse(restaurantResponse);
            responseEnvelope.setBody(responseBody);

            m.marshal(responseEnvelope, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
