/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.wilsonline.model;

/**
 *
 * @author maike
 */
public class Flight {
    private Integer flightNumber;
    private Integer freeSeatings;
    private String Date;
    private String genericFlightId;
    private String airlineCode;

    public Flight(){
        
    }
    
    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getFreeSeatings() {
        return freeSeatings;
    }

    public void setFreeSeatings(Integer freeSeatings) {
        this.freeSeatings = freeSeatings;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getGenericFlightId() {
        return genericFlightId;
    }

    public void setGenericFlightId(String genericFlightId) {
        this.genericFlightId = genericFlightId;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }
}