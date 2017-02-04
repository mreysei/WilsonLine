package es.cifpcm.wilsonline.daoimpl;

import es.cifpcm.wilsonline.abstraction.BaseDao;
import es.cifpcm.wilsonline.interfaces.ConnectionProvider;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.GenericFlight;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristina
 */
public class GenericFlightDao extends BaseDao implements GenericDao<GenericFlight>
{
    private static final Logger LOG = LoggerFactory.getLogger(GenericFlightDao.class);
    
    public GenericFlightDao(ConnectionProvider conn)
    {
        super(conn);
    }

    @Override
    public GenericFlight select(Integer id)
    {
        String text = "select generic_flight_id, origin, destiny, arrive_hour," + 
                        " arrive_minutes, departure_hour, departure_minutes," +
                        " price, airline from v_generic_flight" +
                        " where generic_flight_id=" + id;
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            GenericFlight genericFlight = new GenericFlight();
            
            results.next();
            
            genericFlight.setGenericFlightId(results.getString("generic_flight_id"));
            genericFlight.setOrigin(results.getString("origin"));
            genericFlight.setDestiny(results.getString("destiny"));
            genericFlight.setArriveHours(results.getInt("arrive_hour"));
            genericFlight.setArriveMinutes(results.getInt("arrive_minutes"));
            genericFlight.setDepartureHours(results.getInt("departure_hour"));
            genericFlight.setDepartureMinutes(results.getInt("departure_minutes"));
            genericFlight.setPrice(results.getDouble("price"));
            genericFlight.setAirline(results.getString("airline"));
            
            return genericFlight;
            
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return null;
    }

    @Override
    public List<GenericFlight> selectByCriteria(String condition)
    {
        String text = "select generic_flight_id, origin, destiny, arrive_hour," +
                        " arrive_minutes, departure_hour, departure_minutes," +
                        " price, airline from v_generic_flight" +
                        condition;
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            GenericFlight genericFlight;
            List<GenericFlight> genericFlights = new ArrayList<>();
            
            while(results.next())
            {
                genericFlight = new GenericFlight();
                
                genericFlight.setGenericFlightId(results.getString("generic_flight_id"));
                genericFlight.setOrigin(results.getString("origin"));
                genericFlight.setDestiny(results.getString("destiny"));
                genericFlight.setArriveHours(results.getInt("arrive_hour"));
                genericFlight.setArriveMinutes(results.getInt("arrive_minutes"));
                genericFlight.setDepartureHours(results.getInt("departure_hour"));
                genericFlight.setDepartureMinutes(results.getInt("departure_minutes"));
                genericFlight.setPrice(results.getDouble("price"));
                genericFlight.setAirline(results.getString("airline"));
                
                genericFlights.add(genericFlight);
            }
            
            return genericFlights;
            
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return null;
    }

    @Override
    public List<GenericFlight> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(GenericFlight element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}