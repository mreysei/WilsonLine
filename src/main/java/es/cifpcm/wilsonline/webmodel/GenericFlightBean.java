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
    private List<GenericFlight> genericFlightsSelected;
    
    private boolean timeSelected;
    private String arriveTime;
    private String departureTime;
    
    /**
     * Creates a new instance of GenericFlightBean
     */
    public GenericFlightBean()
    {
        
    }
    
    public List<GenericFlight> getGenericFlightsSelected()
    {
        return genericFlightsSelected;
    }

    public void setGenericFlightsSelected(List<GenericFlight> genericFlightsSelected)
    {
        this.genericFlightsSelected = genericFlightsSelected;
    }
    
    public String getArriveTime()
    {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime)
    {
        this.arriveTime = arriveTime;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }

    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }
    
    public String search()
    {
        if(validate())
        {
            String condition = " where";
            
            if(this.getPrice() != null)
            {
                condition += " price<=" + this.getPrice() + " and";
            }
            
            if(this.timeSelected)
            {
                condition += " departure_hour>=" + this.getDepartureHours() + " and";
                
                condition += " arrive_hour<=" + this.getArriveHours() + " and";
                condition += " arrive_minutes<=" + this.getArriveMinutes() + " and";
            }
            
            if(this.getAirlines().size() > 0)
            {
                condition += " (";
                
                for(String value : this.getAirlines())
                {
                    condition += " airline like '%" + value + "%' or";
                }
                
                condition = condition.substring(0, condition.lastIndexOf(" "));
                
                condition += ")";
            }
            else if(condition.length() > 0)
            {
                condition = condition.substring(0, condition.lastIndexOf(" "));
            }
            
            GenericDao dao = DaoFactory.getInstance().getGenericFlightDao();
            this.genericFlightsSelected = dao.selectByCriteria(condition);
            
            if(this.genericFlightsSelected.size() > 0)
            {
                return "genericFlight.xhtml";
            }
        }
        
        return "t_error.xhtml";
    }
    
    private boolean validate()
    {
        this.timeSelected = false;
        
        //If the user wants to find by the time, we check if the time is correct.
        if(this.getDepartureTime() != null && this.getArriveTime() != null)
        {
            if(!this.validateDepartureTime(this.getDepartureTime())
                    || !this.validateArriveTime(this.getArriveTime()))
            {
                return false;
            }
            else
            {
                this.timeSelected = true;
            }
        }
        
        return true;
    }
    
    private boolean validateDepartureTime(String timeSelected)
    {
        String[] time = timeSelected.split(":");
        
        try
        {
            this.setDepartureHours(Integer.parseInt(time[0]));
            this.setDepartureMinutes(Integer.parseInt(time[1]));
            
            if(this.getDepartureHours() >= 0 && this.getDepartureHours() <= 23
                    && this.getDepartureMinutes() >= 0 && this.getDepartureMinutes() <= 59)
            {
                return true;
            }
        } catch(NumberFormatException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return false;
    }
    
    private boolean validateArriveTime(String timeSelected)
    {
        String[] time = timeSelected.split(":");
        
        try
        {
            this.setArriveHours(Integer.parseInt(time[0]));
            this.setArriveMinutes(Integer.parseInt(time[1]));
            
            if(this.getArriveHours() >= 0 && this.getArriveHours() <= 23
                    && this.getArriveMinutes() >= 0 && this.getArriveMinutes() <= 59)
            {
                return true;
            }
        } catch(NumberFormatException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return false;
    }
    
    public List<Airline> getAllAirlines()
    {
        GenericDao dao = DaoFactory.getInstance().getAirlineDao();
        
        return dao.selectAll();
    }
}