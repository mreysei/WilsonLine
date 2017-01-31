package es.cifpcm.wilsonline.interfaces;

import java.util.List;

/**
 *
 * @author Cristina
 * @param <E>
 */
public interface GenericDao <E>
{
    public E select(Integer id);
    public List<E> selectByCriteria(String condition);
    public List<E> selectAll();
    public boolean insert(E element);
    public boolean update();
    public boolean delete();
}