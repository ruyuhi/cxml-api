//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.23 at 11:07:02 AM CEST 
//


package org.cxml.catalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rangeBegin",
    "rangeEnd"
})
@XmlRootElement(name = "Range")
public class Range {

    @XmlElement(name = "RangeBegin", required = true)
    protected RangeBegin rangeBegin;
    @XmlElement(name = "RangeEnd", required = true)
    protected RangeEnd rangeEnd;

    /**
     * Gets the value of the rangeBegin property.
     * 
     * @return
     *     possible object is
     *     {@link RangeBegin }
     *     
     */
    public RangeBegin getRangeBegin() {
        return rangeBegin;
    }

    /**
     * Sets the value of the rangeBegin property.
     * 
     * @param value
     *     allowed object is
     *     {@link RangeBegin }
     *     
     */
    public void setRangeBegin(RangeBegin value) {
        this.rangeBegin = value;
    }

    /**
     * Gets the value of the rangeEnd property.
     * 
     * @return
     *     possible object is
     *     {@link RangeEnd }
     *     
     */
    public RangeEnd getRangeEnd() {
        return rangeEnd;
    }

    /**
     * Sets the value of the rangeEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link RangeEnd }
     *     
     */
    public void setRangeEnd(RangeEnd value) {
        this.rangeEnd = value;
    }

}
