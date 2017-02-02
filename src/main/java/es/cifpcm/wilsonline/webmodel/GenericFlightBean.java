package es.cifpcm.wilsonline.webmodel;

import es.cifpcm.wilsonline.dao.DaoFactory;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.Airline;
import es.cifpcm.wilsonline.model.GenericFlight;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristina
 */
@Named(value = "genericFlightBean")
@RequestScoped
public class GenericFlightBean extends GenericFlight implements Serializable
{
    private static final Logger LOG = LoggerFactory.getLogger(GenericFlightBean.class);
    private List<GenericFlight> airlinesSelected;
    
    /**
     * Creates a new instance of GenericFlightBean
     */
    public GenericFlightBean()
    {
        
    }

    public List<GenericFlight> getAirlinesSelected()
    {
        return airlinesSelected;
    }

    public void setAirlinesSelected(List<GenericFlight> airlinesSelected) 
    {
        this.airlinesSelected = airlinesSelected;
    }
    
    public String search()
    {
        if(validate())
        {
            String condition = "";
            
            if(this.getAirlines().size() > 0)
            {
                /*for(String value : this.getAirlines())
                {
                    condition += " v_generic_flight like '%" + value + "%'";
                }*/
            }
            else
            {
                condition = " where v_generic_flight.price<=" + this.getPrice() +
                    " and v_generic_flight.departure_time<=" + this.getDepartureTime() +
                    " and v_generic_flight.arrive_time<=" + this.getArriveTime();
            }
            
            GenericDao dao = DaoFactory.getInstance().getGenericFlightDao();
            this.setAirlinesSelected(dao.selectByCriteria(condition));
            
            return "t_temporal1.xhtml";
        }
        
        return "notFound.xhtml";
    }
    
    private boolean validate()
    {
        if(this.getPrice() != null && this.getDepartureTime() != null
                && this.getArriveTime() != null && this.getAirlines() != null)
        {
            if(this.validateTimeProperties())
            {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean validateTimeProperties()
    {
        try
        {
            java.sql.Time.valueOf(this.getDepartureTime());
            java.sql.Time.valueOf(this.getArriveTime());
            
            return true;
        } catch(NumberFormatException ex)
        {
            LOG.error(ex.getMessage());
            
            return false;
        }
    }
    
    public List<Airline> getAllAirlines()
    {
        GenericDao dao = DaoFactory.getInstance().getAirlineDao();
        
        return dao.selectAll();
    }
}