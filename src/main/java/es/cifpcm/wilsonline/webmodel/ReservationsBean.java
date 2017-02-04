package es.cifpcm.wilsonline.webmodel;

import es.cifpcm.wilsonline.dao.DaoFactory;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.Flight;
import es.cifpcm.wilsonline.model.GenericFlight;
import es.cifpcm.wilsonline.model.Reservations;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Cristina
 */
@Named(value = "reservationsBean")
@SessionScoped
public class ReservationsBean extends Reservations implements Serializable
{
    /**
     * Creates a new instance of ReservationsBean
     */
    public ReservationsBean()
    {
        
    }
    
    public String makeReservation(Integer number)
    {
        this.setFlightNumber(number);
        
        if(this.getFlightNumber() != null)
        {
            Flight flight;
            GenericFlight genericFlight;
            
            GenericDao dao = DaoFactory.getInstance().getFlightDao();
            flight = (Flight) dao.select(this.getFlightNumber());
            
            dao = DaoFactory.getInstance().getGenericFlightDao();
            genericFlight = (GenericFlight) dao.select(Integer.parseInt(flight.getGenericFlightId()));
            
            this.setDate(flight.getDate());
            this.setPrice(genericFlight.getPrice());
            
            return "reservation.xhtml?faces-redirect=true";
        }
        
        return "t_error.xhtml?faces-redirect=true";
    }
}