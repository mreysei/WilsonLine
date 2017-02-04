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
    private GenericFlight genericFlightSelected;
    
    /**
     * Creates a new instance of ReservationsBean
     */
    public ReservationsBean()
    {
        
    }
    
    public GenericFlight getGenericFlightSelected()
    {
        return genericFlightSelected;
    }

    public void setGenericFlightSelected(GenericFlight genericFlightSelected)
    {
        this.genericFlightSelected = genericFlightSelected;
    }
    
    public String makeReservation(Integer number)
    {
        this.setFlightNumber(number);
        
        if(this.getFlightNumber() != null)
        {
            Flight flight;
            
            GenericDao dao = DaoFactory.getInstance().getFlightDao();
            flight = (Flight) dao.select(this.getFlightNumber());
            
            dao = DaoFactory.getInstance().getGenericFlightDao();
            this.genericFlightSelected = (GenericFlight) dao.select(Integer.parseInt(flight.getGenericFlightId()));
            
            this.setDate(flight.getDate());
            this.setPrice(this.genericFlightSelected.getPrice());
            
            return "reservation.xhtml?faces-redirect=true";
        }
        
        return "t_error.xhtml?faces-redirect=true";
    }
}