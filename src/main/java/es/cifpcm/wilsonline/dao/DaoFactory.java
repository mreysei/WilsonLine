package es.cifpcm.wilsonline.dao;

import es.cifpcm.wilsonline.daoimpl.FlightDao;
import es.cifpcm.wilsonline.daoimpl.GenericFlightDao;
import es.cifpcm.wilsonline.daoimpl.ReservationsDao;
import es.cifpcm.wilsonline.interfaces.ConnectionProvider;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristina
 */
public class DaoFactory implements ConnectionProvider
{
    private static final Logger LOG = LoggerFactory.getLogger(DaoFactory.class);
    private static DaoFactory instance;
    private DataSource ds;
    
    private DaoFactory()
    {
        try
        {
            Context ctx = new InitialContext();
            
            //We cast the jdbc resource name into a DataSource datatype.
            this.ds = (DataSource) ctx.lookup("jdbc/flight_reservations");
        } catch(NamingException ex)
        {
            LOG.error(ex.getMessage());
        }
    }
    
    public synchronized DaoFactory getInstance()
    {
        if(instance == null)
        {
            instance = new DaoFactory();
        }
        
        return instance;
    }

    @Override
    public Connection getConnection()
    {
        try
        {
            return this.ds.getConnection();
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
            
            return null;
        }
    }
    
    public GenericDao getGenericFlight()
    {
        return new GenericFlightDao(instance);
    }
    
    public GenericDao getFlight()
    {
        return new FlightDao(instance);
    }
    
    public GenericDao getReservations()
    {
        return new ReservationsDao(instance);
    }
}