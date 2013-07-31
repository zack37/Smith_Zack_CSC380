
package edu.neumont.csc380.jaxb;

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
 *         &lt;element ref="{http://neumont.edu/zsmith/lunch/restaurants}GetFood"/>
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
    "getFood"
})
@XmlRootElement(name = "body", namespace = "http://www.w3.org/2003/12/soap-envelope")
public class Body {

    @XmlElement(name = "GetFood", namespace = "http://neumont.edu/zsmith/lunch/restaurants", required = true)
    protected GetFood getFood;

    /**
     * Gets the value of the getFood property.
     * 
     * @return
     *     possible object is
     *     {@link GetFood }
     *     
     */
    public GetFood getGetFood() {
        return getFood;
    }

    /**
     * Sets the value of the getFood property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFood }
     *     
     */
    public void setGetFood(GetFood value) {
        this.getFood = value;
    }

}
