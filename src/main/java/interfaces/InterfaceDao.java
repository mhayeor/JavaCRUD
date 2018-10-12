package interfaces;

import java.util.List;

/**
 * Created by User on 10/12/2018.
 */
public interface InterfaceDao<T> {
     void save(T t);
    void update(T t, long id);
    List<T> list();
     T getById(long id);
    void delete(long id);
}
