package es.cifpcm.wilsonline.webmodel;

import es.cifpcm.wilsonline.dao.DaoFactory;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.Flight;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Cristina
 */
@Named(value = "flightBean")
@SessionScoped
public class FlightBean extends Flight implements Serializable
{
    private List<Flight> flights = new ArrayList<>();
    
    /**
     * Creates a new instance of FlightBean
     */
    public FlightBean()
    {
        
    }
    
    public List<Flight> getFlights()
    {
        return flights;
    }

    public void setFlights(List<Flight> flights)
    {
        this.flights = flights;
    }
    
    public String search(String id)
    {
        this.setGenericFlightId(id);
        
        if(this.getGenericFlightId() != null)
        {
            String condition = " where genericFlight_generic_flight_id=" + this.getGenericFlightId() +
                                    " and free_seatings>0";
            
            GenericDao dao = DaoFactory.getInstance().getFlightDao();
            this.flights = dao.selectByCriteria(condition);
            
            if(this.flights != null && this.flights.size() > 0)
            {
                return "flight.xhtml?faces-redirect=true";
            }
        }
        
        return "t_error.xhtml?faces-redirect=true";
    }
}