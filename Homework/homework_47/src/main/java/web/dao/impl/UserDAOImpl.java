package web.dao.impl;

import web.dao.DAO;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ravskiy on 22.05.2017.
 */
public class UserDAOImpl<User> implements DAO<User> {
    protected final DBDataProviderImpl dbDataProvider = ;

    @Override
    public void create(User user) {
        
    }

    @Override
    public Map<String, User> read() {
        String login;
        Map<String, User> users;


        return users;
    }

    @Override
    public void update(Object o) {
        read();
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public Object getOneById(long id) {
        return null;
    }

    @Override
    public Object getOneByEmail(long id) {
        return null;
    }

    @Override
    public Object getOneByLogin(String login) {
        return null;
    }
}
