package es.cifpcm.wilsonline.mock.pojo;

import java.sql.Date;

/**
 *
 * @author Cristina
 */
public class Flight
{
    private Integer flightNumber;
    private Integer freeSeatings;
    private Date date;
    private Integer genericFlightId;
    
    public Flight()
    {
        
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getGenericFlightId() {
        return genericFlightId;
    }

    public void setGenericFlightId(Integer genericFlightId) {
        this.genericFlightId = genericFlightId;
    }
}