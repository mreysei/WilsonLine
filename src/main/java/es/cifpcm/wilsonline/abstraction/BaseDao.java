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
    //We set this property only in one place, so all child classes could use it.
    protected final ConnectionProvider connProvider;
    
    public BaseDao(ConnectionProvider conn)
    {
        this.connProvider = conn;
    }
}