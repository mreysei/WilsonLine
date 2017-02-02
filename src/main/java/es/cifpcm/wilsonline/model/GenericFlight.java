/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.wilsonline.model;

import java.util.List;

/**
 *
 * @author maike
 */
public class GenericFlight {
    private String genericFlightId;
    private String arriveTime;
    private String departureTime;
    private String origin;
    private String destiny;
    private Double price;
    private String airline;
    private List<String> airlines;

    public GenericFlight(){
        
    }
    
    public String getGenericFlightId() {
        return genericFlightId;
    }

    public void setGenericFlightId(String genericFlightId) {
        this.genericFlightId = genericFlightId;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departuraTime) {
        this.departureTime = departuraTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public List<String> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<String> airlines) {
        this.airlines = airlines;
    }
}
