package es.cifpcm.wilsonline.daoimpl;

import es.cifpcm.wilsonline.abstraction.BaseDao;
import es.cifpcm.wilsonline.interfaces.ConnectionProvider;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public User select(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param condition the condition of the query to filter in the database.
     * @return a List of User objects.
     */
    @Override
    public List<User> selectByCriteria(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return a List of User objects without condition.
     */
    @Override
    public List<User> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            query.setInt(5, element.getCreditCardNumber());
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