package web.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import web.dao.AbstractDBDAO;
import web.dao.DAO;
import web.dao.DataProvider;
import web.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravskiy on 22.05.2017.
 */
public class UserDAOImpl extends AbstractDBDAO<User> {

    public UserDAOImpl(DataProvider dataProvider) {
        super(dataProvider);
    }

    @Override
    public ArrayList<User> read() {
       Query<User> userQuery = session.createQuery("from User", User.class);
       List<User> listUsers = userQuery.list();
       return (ArrayList<User>)listUsers;
    }

    @Override
    public void update(User user) {
        Transaction transaction = session.getTransaction();
        transaction.begin();
         Query userQuery = session.createQuery("update User set fullName = :userFullName, age = :userAge," +
                "phoneNumber = :userPhone, email = :userEmail where login = :userLogin", User.class);
        userQuery.setParameter("userFullName", user.getFullName());
        userQuery.setParameter("userAge", user.getAge());
        userQuery.setParameter("userPhone", user.getPhoneNumber());
        userQuery.setParameter("userEmail", user.getEmail());
        userQuery.executeUpdate();
        transaction.commit();
    }

    @Override
    public void delete(long userId) {
        Query<User> userQuery = session.createQuery("delete User WHERE id = :id", User.class);
        userQuery.setParameter("id", userId).executeUpdate();
    }

    @Override
    public ArrayList<User> getByLogin(String searchLogin) {
        Query<User> userQuery = session.createQuery("from User WHERE login like (\'%\' + :login + \'%\')", User.class);
        userQuery.setParameter("login", searchLogin);
        List<User> listUsers = userQuery.list();
        return (ArrayList<User>)listUsers;
    }

    @Override
    public  ArrayList<User> getByPhone(String searchPhone) {
        Query<User> userQuery = session.createQuery("from User WHERE phoneNumber like (\'%\' + :phone + \'%\')", User.class);
        userQuery.setParameter("phone", searchPhone);
        List<User> listUsers = userQuery.list();
        return (ArrayList<User>) listUsers;
    }
}
