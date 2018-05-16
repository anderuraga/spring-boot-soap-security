//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.05.16 a las 10:24:12 AM CEST 
//


package com.memorynotfound.beer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beer" type="{http://memorynotfound.com/beer}beer"/>
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
    "beer"
})
@XmlRootElement(name = "getBeerResponse")
public class GetBeerResponse {

    @XmlElement(required = true)
    protected Beer beer;

    /**
     * Obtiene el valor de la propiedad beer.
     * 
     * @return
     *     possible object is
     *     {@link Beer }
     *     
     */
    public Beer getBeer() {
        return beer;
    }

    /**
     * Define el valor de la propiedad beer.
     * 
     * @param value
     *     allowed object is
     *     {@link Beer }
     *     
     */
    public void setBeer(Beer value) {
        this.beer = value;
    }

}
