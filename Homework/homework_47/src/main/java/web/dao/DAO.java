package web.dao;

import web.entity.Role;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */
public interface DAO<T> {

    void create(T t);
    ArrayList<T> read();
    void update(T t);
    void delete(long t);
    /*T getOneById(long id);*/
    ArrayList <T> getByLogin(String searchLogin);
    ArrayList <T> getByPhone(String searchPhone);
}
