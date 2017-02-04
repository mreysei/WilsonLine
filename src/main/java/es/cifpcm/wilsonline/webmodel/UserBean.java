package es.cifpcm.wilsonline.webmodel;

import es.cifpcm.wilsonline.dao.DaoFactory;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.Flight;
import es.cifpcm.wilsonline.model.GenericFlight;
import es.cifpcm.wilsonline.model.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristina
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean extends User implements Serializable
{
    private static final Logger LOG = LoggerFactory.getLogger(GenericFlightBean.class);
    private GenericFlight genericFlightSelected;
    private Flight flightSelected;
    
    /**
     * Creates a new instance of ConfirmationBean
     */
    public UserBean()
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
    
    public Flight getFlightSelected()
    {
        return flightSelected;
    }

    public void setFlightSelected(Flight flightSelected)
    {
        this.flightSelected = flightSelected;
    }    
    
    /**
     * 
     * @param flightNumber the flight selected by the user.
     * @param price the total price of the flight selected.
     * @return 
     */
    public String commit(String flightNumber, Double price)
    {
        try
        {
            this.setFlightNumber(Integer.parseInt(flightNumber));
            this.setTotalPrice(price);
        } catch(NumberFormatException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        if(this.validate())
        {
            GenericDao dao = DaoFactory.getInstance().getReservationsDao();
            
            if(dao.insert(this))
            {
                dao = DaoFactory.getInstance().getFlightDao();
                this.flightSelected = (Flight) dao.select(this.getFlightNumber());
                
                dao = DaoFactory.getInstance().getGenericFlightDao();
                this.genericFlightSelected = (GenericFlight) dao.select(Integer.parseInt(this.flightSelected.getGenericFlightId()));
                
                return "confirmation.xhtml?faces-redirect=true";
                
            }
        }
        
        return "t_error.xhtml?faces-redirect=true";
    }
    
    /**
     * 
     * @return a <i>boolean<i> that indicates if the data was correct or not.
     */
    private boolean validate()
    {
        if(this.getName() != null && this.getSurname() != null
                && this.getCreditCardType() != null && this.getTotalPrice() != null)
        {
            if(this.validateNumericProperties())
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 
     * @return a <i>boolean<i> that indicates if the data was correct or not.
     */
    private boolean validateNumericProperties()
    {
        try
        {
            Integer.parseInt(this.getTelephone());
            return true;
            
        } catch(NumberFormatException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return false;
    }
}