
package edu.neumont.csc380.jaxb.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://neumont.edu/zsmith/lunch/restaurant}RestaurantResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "restaurantResponse"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(name = "RestaurantResponse", namespace = "http://neumont.edu/zsmith/lunch/restaurant", required = true)
    protected RestaurantResponse restaurantResponse;

    /**
     * Gets the value of the restaurantResponse property.
     * 
     * @return
     *     possible object is
     *     {@link RestaurantResponse }
     *     
     */
    public RestaurantResponse getRestaurantResponse() {
        return restaurantResponse;
    }

    /**
     * Sets the value of the restaurantResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link RestaurantResponse }
     *     
     */
    public void setRestaurantResponse(RestaurantResponse value) {
        this.restaurantResponse = value;
    }

}
