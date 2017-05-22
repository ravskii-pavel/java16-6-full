package web.dao;

import java.util.ArrayList;

/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */
public interface DAO<T> {

    void create(T t);
    ArrayList<T> read();
    void update(T t);
    void delete(T t);
    T getOneById(long id);
    T getOneByEmail(long id);
    T getOneByLogin(String login);
}
