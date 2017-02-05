package es.cifpcm.wilsonline.daoimpl;

import es.cifpcm.wilsonline.abstraction.BaseDao;
import es.cifpcm.wilsonline.interfaces.ConnectionProvider;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.User;
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
public class ReservationsDao extends BaseDao implements GenericDao<User>
{
    private static final Logger LOG = LoggerFactory.getLogger(GenericFlightDao.class);
    
    public ReservationsDao(ConnectionProvider conn)
    {
        super(conn);
    }

    /**
     * 
     * @param id the value of the element we are looking for.
     * @return a <i>User</i> object.
     */    
    @Override
    public User select(Integer id)
    {
        String text = "select reservation_number, name, surname, telephone," +
                        " credit_card_type, credit_card_number, total_price," +
                        " flight_flight_number from reservations" + id;
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            User user = new User();
            
            results.next();
            
            user.setReservationNumber(results.getInt("reservation_number"));
            user.setName(results.getString("name"));
            user.setSurname(results.getString("surname"));
            user.setTelephone(results.getString("telephone"));
            user.setCreditCardType(results.getString("credit_card_type"));
            user.setCreditCardNumber(results.getString("credit_card_number"));
            user.setTotalPrice(results.getDouble("total_price"));
            user.setFlightNumber(results.getInt("flight_flight_number"));
            
            return user;
            
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return null;
    }

    /**
     * 
     * @param condition the condition of the query to filter in the database.
     * @return a List of User objects.
     */
    @Override
    public List<User> selectByCriteria(String condition)
    {
        String text = "select reservation_number, name, surname, telephone," +
                        " credit_card_type, credit_card_number, total_price," +
                        " flight_flight_number from reservations" +
                        condition;
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            List<User> users = new ArrayList<>();
            User user;
            
            while(results.next())
            {
                user = new User();
                
                user.setReservationNumber(results.getInt("reservation_number"));
                user.setName(results.getString("name"));
                user.setSurname(results.getString("surname"));
                user.setTelephone(results.getString("telephone"));
                user.setCreditCardType(results.getString("credit_card_type"));
                user.setCreditCardNumber(results.getString("credit_card_number"));
                user.setTotalPrice(results.getDouble("total_price"));
                user.setFlightNumber(results.getInt("flight_flight_number"));
                
                users.add(user);
            }
            
            return users;
            
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return null;
    }

    /**
     * 
     * @return a List of User objects without condition.
     */
    @Override
    public List<User> selectAll()
    {
        String text = "select reservation_number, name, surname, telephone," +
                        " credit_card_type, credit_card_number, total_price," +
                        " flight_flight_number from reservations";
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            List<User> users = new ArrayList<>();
            User user;
            
            while(results.next())
            {
                user = new User();
                
                user.setReservationNumber(results.getInt("reservation_number"));
                user.setName(results.getString("name"));
                user.setSurname(results.getString("surname"));
                user.setTelephone(results.getString("telephone"));
                user.setCreditCardType(results.getString("credit_card_type"));
                user.setCreditCardNumber(results.getString("credit_card_number"));
                user.setTotalPrice(results.getDouble("total_price"));
                user.setFlightNumber(results.getInt("flight_flight_number"));
                
                users.add(user);
            }
            
            return users;
            
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
    public boolean insert(User element)
    {
        String text = "insert into reservations(name, surname, telephone," +
                        " credit_card_type, credit_card_number, total_price," +
                        " flight_flight_number) values(?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text))
        {
            query.setString(1, element.getName());
            query.setString(2, element.getSurname());
            query.setString(3, element.getTelephone());
            query.setString(4, element.getCreditCardType());
            query.setLong(5, Long.parseLong(element.getCreditCardNumber()));
            query.setDouble(6, element.getTotalPrice());
            query.setInt(7, element.getFlightNumber());
            
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
        String text = "update reservations" + condition;
        
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
        String text = "delete from reservations" + condition;
        
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