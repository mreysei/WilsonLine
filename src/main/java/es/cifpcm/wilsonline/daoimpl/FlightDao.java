package es.cifpcm.wilsonline.daoimpl;

import es.cifpcm.wilsonline.abstraction.BaseDao;
import es.cifpcm.wilsonline.interfaces.ConnectionProvider;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.Flight;
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
public class FlightDao extends BaseDao implements GenericDao<Flight>
{
    private static final Logger LOG = LoggerFactory.getLogger(GenericFlightDao.class);
    
    public FlightDao(ConnectionProvider conn)
    {
        super(conn);
    }

    /**
     * 
     * @param id the value of the element we are looking for.
     * @return a <i>Flight</i> object.
     */
    @Override
    public Flight select(Integer id)
    {
        String text = "select flight_number, date, free_seatings," +
                        " genericFlight_generic_flight_id from v_flight" +
                        " where flight_number=" + id;
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            Flight flight = new Flight();
            
            results.next();
            
            flight.setFlightNumber(results.getInt("flight_number"));
            flight.setDate(results.getString("date"));
            flight.setFreeSeatings(results.getInt("free_seatings"));
            flight.setGenericFlightId(results.getString("genericFlight_generic_flight_id"));
            
            return flight;
            
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return null;
    }

    /**
     * 
     * @param condition the condition of the query to filter in the database.
     * @return a List of Flight objects.
     */
    @Override
    public List<Flight> selectByCriteria(String condition)
    {
        String text = "select flight_number, free_seatings, date," +
                        " genericFlight_generic_flight_id from v_flight " +
                        condition;
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            Flight flight;
            List<Flight> flights = new ArrayList<>();
            
            while(results.next())
            {
                flight = new Flight();
                
                flight.setFlightNumber(results.getInt("flight_number"));
                flight.setFreeSeatings(results.getInt("free_seatings"));
                flight.setDate(results.getString("date"));
                flight.setGenericFlightId(results.getString("genericFlight_generic_flight_id"));
                
                flights.add(flight);
            }
            
            return flights;
            
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return null;
    }

    /**
     * 
     * @return a List of Flight objects without condition.
     */
    @Override
    public List<Flight> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param element the element we are going to insert in the database.
     * @return a <i>boolean</i> that indicates if the operation went well or not.
     */
    @Override
    public boolean insert(Flight element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return a <i>boolean</i> that indicates if the operation went well or not.
     */
    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return a <i>boolean</i> that indicates if the operation went well or not.
     */
    @Override
    public boolean delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}