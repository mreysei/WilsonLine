/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.wilsonline.dao;

import es.cifpcm.wilsonline.daoimpl.AirlineDao;
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
    
    /**
     * Constructor set as private to implement <i>singleton pattern</i>.
     */
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
    
    /**
     * Will return the current instance in memory of the factory due to singleton pattern.
     * @return the instance of the current Factory.
     */
    public static synchronized DaoFactory getInstance()
    {
        if(instance == null)
        {
            instance = new DaoFactory();
        }
        
        return instance;
    }

    /**
     * 
     * @return the <i>datasource</i> connection.
     */
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
    
    /**
     * 
     * @return a <i>GenericDao</i>.
     */
    public GenericDao getGenericFlightDao()
    {
        return new GenericFlightDao(instance);
    }
    
    /**
     * 
     * @return a <i>GenericDao</i>.
     */
    public GenericDao getFlightDao()
    {
        return new FlightDao(instance);
    }
    
    /**
     * 
     * @return a <i>GenericDao</i>.
     */
    public GenericDao getReservationsDao()
    {
        return new ReservationsDao(instance);
    }
    
    /**
     * 
     * @return a <i>GenericDao</i>.
     */
    public GenericDao getAirlineDao()
    {
        return new AirlineDao(instance);
    }
}