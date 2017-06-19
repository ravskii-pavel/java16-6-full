package ua.dp.levelup;

import java.util.ArrayList;

/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */
public interface DAO<T> {

    void create(T t);
    ArrayList<T> read();
    void update(T t);
    void delete(long t);
    ArrayList <T> getByLogin(String searchLogin);
    ArrayList <T> getByPhone(String searchPhone);
    /*T getOneById(long id);*/
}
