package es.cifpcm.wilsonline.interfaces;

import java.sql.Connection;

/**
 *
 * @author Cristina
 */
public interface ConnectionProvider
{
    public Connection getConnection();
}