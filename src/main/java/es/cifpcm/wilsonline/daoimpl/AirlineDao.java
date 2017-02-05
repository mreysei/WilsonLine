/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.wilsonline.daoimpl;

import es.cifpcm.wilsonline.abstraction.BaseDao;
import es.cifpcm.wilsonline.interfaces.ConnectionProvider;
import es.cifpcm.wilsonline.interfaces.GenericDao;
import es.cifpcm.wilsonline.model.Airline;
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
public class AirlineDao extends BaseDao implements GenericDao<Airline>
{
    private static final Logger LOG = LoggerFactory.getLogger(Airline.class);
    
    public AirlineDao(ConnectionProvider conn)
    {
        super(conn);
    }

    /**
     * 
     * @param id the value of the element we are looking for.
     * @return an <i>Airline</i> object.
     */
    @Override
    public Airline select(Integer id) {
        //Cannot be implemented since the view "v_airline" doesn't have a code.
        //This fact can change in the lifecycle of the application so is not a problem.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param condition the condition of the query to filter in the database.
     * @return a List of Airline objects.
     */
    @Override
    public List<Airline> selectByCriteria(String condition)
    {
        String text = "select name from v_airline" + condition;
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            List<Airline> airlines = new ArrayList<>();
            Airline airline;
            
            while(results.next())
            {
                airline = new Airline();
                airline.setName(results.getString("name"));
                
                airlines.add(airline);
            }
            
            return airlines;
            
        } catch(SQLException ex)
        {
            LOG.error(ex.getMessage());
        }
        
        return null;
    }

    /**
     * 
     * @return a List of Airline objects without condition.
     */
    @Override
    public List<Airline> selectAll()
    {
        String text = "select name from v_airline";
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text);
                ResultSet results = query.executeQuery())
        {
            List<Airline> airlines = new ArrayList<>();
            Airline airline;
            
            while(results.next())
            {
                airline = new Airline();
                airline.setName(results.getString("name"));
                
                airlines.add(airline);
            }
            
            return airlines;
            
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
    public boolean insert(Airline element)
    {
        String text = "insert into airline(name) values(?)";
        
        try(Connection conn = super.connProvider.getConnection();
                PreparedStatement query = conn.prepareStatement(text))
        {
            query.setString(1, element.getName());
            
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
        String text = "update v_airline" + condition;
        
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
        String text = "delete from v_airline" + condition;
        
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