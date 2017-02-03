package es.cifpcm.wilsonline.webmodel;

import es.cifpcm.wilsonline.dao.DaoFactory;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.Flight;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristina
 */
@Named(value = "flightBean")
@RequestScoped
public class FlightBean extends Flight implements Serializable
{
    private static final Logger LOG = LoggerFactory.getLogger(GenericFlightBean.class);
    private List<Flight> flights;
    
    /**
     * Creates a new instance of FlightBean
     */
    public FlightBean()
    {
        
    }
    
    public void search()
    {
        if(this.getGenericFlightId() != null)
        {
            GenericDao dao = DaoFactory.getInstance().getFlightDao();
            
            
        }
    }
}