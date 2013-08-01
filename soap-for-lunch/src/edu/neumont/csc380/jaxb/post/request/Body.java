
package edu.neumont.csc380.jaxb.post.request;

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
 *         &lt;element ref="{http://neumont.edu/zsmith/lunch/restaurant}PostPlaceOrder"/>
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
    "postPlaceOrder"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(name = "PostPlaceOrder", namespace = "http://neumont.edu/zsmith/lunch/restaurant", required = true)
    protected PostPlaceOrder postPlaceOrder;

    /**
     * Gets the value of the postPlaceOrder property.
     * 
     * @return
     *     possible object is
     *     {@link PostPlaceOrder }
     *     
     */
    public PostPlaceOrder getPostPlaceOrder() {
        return postPlaceOrder;
    }

    /**
     * Sets the value of the postPlaceOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostPlaceOrder }
     *     
     */
    public void setPostPlaceOrder(PostPlaceOrder value) {
        this.postPlaceOrder = value;
    }

}
