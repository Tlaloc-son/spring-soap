//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.28 at 04:23:21 PM CDT 
//


package pokemon.api.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for held complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="held"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="item" type="{http://www.api.pokemon/jaxb/}value"/&gt;
 *         &lt;element name="versionDetails" type="{http://www.api.pokemon/jaxb/}versionDetail" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "held", propOrder = {
    "item",
    "versionDetails"
})
public class Held {

    @XmlElement(required = true)
    protected Value item;
    @XmlElement(required = true)
    protected List<VersionDetail> versionDetails;

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link Value }
     *     
     */
    public Value getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link Value }
     *     
     */
    public void setItem(Value value) {
        this.item = value;
    }

    /**
     * Gets the value of the versionDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versionDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersionDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VersionDetail }
     * 
     * 
     */
    public List<VersionDetail> getVersionDetails() {
        if (versionDetails == null) {
            versionDetails = new ArrayList<VersionDetail>();
        }
        return this.versionDetails;
    }

}
