/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.wilsonline.abstraction;

import es.cifpcm.wilsonline.interfaces.ConnectionProvider;

/**
 *
 * @author Cristina
 */
public abstract class BaseDao
{
    /**
     * Protected property to provide all subclasses a connection method.
     */
    protected final ConnectionProvider connProvider;
    
    /**
     * 
     * @param conn
     * Obtains a <i>ConnectionProvider</i>.
     */
    public BaseDao(ConnectionProvider conn)
    {
        this.connProvider = conn;
    }
}