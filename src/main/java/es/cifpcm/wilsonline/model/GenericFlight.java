/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.wilsonline.model;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> refs/remotes/origin/master
/**
 *
 * @author maike
 */
public class GenericFlight {
    private String genericFlightId;
<<<<<<< HEAD
    private Integer departureHours;
    private Integer departureMinutes;
    private Integer arriveHours;
    private Integer arriveMinutes;
=======
    private String arriveTime;
    private String departuraTime;
>>>>>>> refs/remotes/origin/master
    private String origin;
    private String destiny;
    private Double price;
    private String airline;
<<<<<<< HEAD
    private List<String> airlines;
=======
>>>>>>> refs/remotes/origin/master

    public GenericFlight(){
        
    }
    
    public String getGenericFlightId() {
        return genericFlightId;
    }

<<<<<<< HEAD
    public Integer getDepartureHours() {
        return departureHours;
    }

    public void setDepartureHours(Integer departureHours) {
        this.departureHours = departureHours;
    }

    public Integer getDepartureMinutes() {
        return departureMinutes;
    }

    public void setDepartureMinutes(Integer departureMinutes) {
        this.departureMinutes = departureMinutes;
    }

    public Integer getArriveHours() {
        return arriveHours;
    }

    public void setArriveHours(Integer arriveHours) {
        this.arriveHours = arriveHours;
    }

    public Integer getArriveMinutes() {
        return arriveMinutes;
    }

    public void setArriveMinutes(Integer arriveMinutes) {
        this.arriveMinutes = arriveMinutes;
    }

    public void setGenericFlightId(String genericFlightId) {
        this.genericFlightId = genericFlightId;
=======
    public void setGenericFlightId(String genericFlightId) {
        this.genericFlightId = genericFlightId;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getDeparturaTime() {
        return departuraTime;
    }

    public void setDeparturaTime(String departuraTime) {
        this.departuraTime = departuraTime;
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD

    public List<String> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<String> airlines) {
        this.airlines = airlines;
    }
=======
    
    
>>>>>>> refs/remotes/origin/master
}
