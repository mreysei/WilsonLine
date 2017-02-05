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

    /**
     * 
     * @param id the value of the element we are looking for.
     * @return a <i>GenericFlight</i> object.
     */
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

    /**
     * 
     * @param condition the condition of the query to filter in the database.
     * @return a List of GenericFlight objects.
     */
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

    /**
     * 
     * @return a List of GenericFlight objects without condition.
     */
    @Override
    public List<GenericFlight> selectAll()
    {
        String text = "select origin, destiny, generic_flight_id, arrive_hour," +
                        " arrive_minutes, departure_hour, departure_minutes, price, airline" +
                        " from v_generic_flight";
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            List<GenericFlight> genericFlights = new ArrayList<>();
            GenericFlight genericFlight;
            
            while(results.next())
            {
                genericFlight = new GenericFlight();
                
                genericFlight.setDestiny(results.getString("destiny"));
                genericFlight.setOrigin(results.getString("origin"));
                genericFlight.setGenericFlightId(results.getString("generic_flight_id"));
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

    /**
     * 
     * @param element the element we are going to insert in the database.
     * @return a <i>boolean</i> that indicates if the operation went well or not.
     */
    @Override
    public boolean insert(GenericFlight element)
    {
        String text = "insert into genericFlight(departure_time, arrive_time," +
                        " price, capacity, generic_flight_id, airline_code, origin," +
                        " destiny) values(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text))
        {
            String departureTime = element.getDepartureHours().toString() + ":" +
                                    element.getDepartureMinutes().toString();
            
            String arriveTime = element.getArriveHours().toString() + ":" +
                                    element.getArriveMinutes();
            
            query.setString(1, departureTime);
            query.setString(2, arriveTime);
            query.setDouble(3, element.getPrice());
            //query.setInt(4, element.getCapacity());
            query.setString(5, element.getGenericFlightId());
            //query.setString(6, element.getAirlineCode());
            query.setString(7, element.getOrigin());
            query.setString(8, element.getDestiny());
            
            if(query.executeUpdate() > 0)
            {
                return true;
            }
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return false;
    }

    /**
     * 
     * @param condition the condition of the query to filter in the database.
     * @return a <i>boolean</i> that indicates if the operation went well or not.
     */
    @Override
    public boolean update(String condition)
    {
        String text = "update genericFlight" + condition;
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text))
        {
            if(query.executeUpdate() > 0)
            {
                return true;
            }
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return false;
    }

    /**
     * 
     * @param condition the condition of the query to filter in the database.
     * @return a <i>boolean</i> that indicates if the operation went well or not.
     */
    @Override
    public boolean delete(String condition)
    {
        String text = "delete from genericFlight" + condition;
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text))
        {
            if(query.executeUpdate() > 0)
            {
                return true;
            }
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return false;
    }
}