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
    
    public String commit(String flightNumber, Double price)
    {
        this.setFlightNumber(Integer.parseInt(flightNumber));
        this.setTotalPrice(price);
        
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