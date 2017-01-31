package es.cifpcm.wilsonline.mock.pojo;

import java.sql.Time;

/**
 *
 * @author Cristina
 */
public class GenericFlight
{
    private Integer genericFlightId;
    private String origin;
    private String destiny;
    private Time arriveTime;
    private Time departureTime;
    private Double price;
    private String airline;
    
    public GenericFlight()
    {
        
    }

    public Integer getGenericFlightId() {
        return genericFlightId;
    }

    public void setGenericFlightId(Integer genericFlightId) {
        this.genericFlightId = genericFlightId;
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

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
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
}