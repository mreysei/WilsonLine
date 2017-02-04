package es.cifpcm.wilsonline.webmodel;

import es.cifpcm.wilsonline.model.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Cristina
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean extends User implements Serializable
{
    /**
     * Creates a new instance of ConfirmationBean
     */
    public UserBean()
    {
        String text = "?faces-redirect=true";
    }
    
    
}