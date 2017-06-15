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

    public UserDAOImpl(){
        super();
    }

    @Override
    public ArrayList<User> read() {
       Transaction transaction = dbDataProvider.getSession().getTransaction();
       transaction.begin();
       Query<User> userQuery = dbDataProvider.getSession().createQuery("from User", User.class);
       List<User> listUsers = userQuery.list();
       //session.flush(для синхронизации данных объекта в кеше уровня сессий с БД);
       transaction.commit();
       return (ArrayList<User>)listUsers;
    }

    @Override
    public void update(User user) {
        Transaction transaction = dbDataProvider.getSession().getTransaction();
        transaction.begin();
        Query userQuery = dbDataProvider.getSession().createQuery("update User set fullName = :userFullName, age = :userAge," +
                "phoneNumber = :userPhone, email = :userEmail, password = :userPassword, gender = :userGender, roleUser = :userRoleUser where login = :userLogin");
        userQuery.setParameter("userFullName", user.getFullName());
        userQuery.setParameter("userAge", user.getAge());
        userQuery.setParameter("userPhone", user.getPhoneNumber());
        userQuery.setParameter("userEmail", user.getEmail());
        userQuery.setParameter("userPassword", user.getPassword());
        userQuery.setParameter("userLogin", user.getLogin());
        userQuery.setParameter("userGender", user.getGender());
        userQuery.setParameter("userRoleUser", user.getRoleUser());
        userQuery.executeUpdate();
        //session.flush(для синхронизации данных объекта в кеше уровня сессий с БД);
        transaction.commit();
    }

    @Override
    public void delete(long userId) {
        Transaction transaction = dbDataProvider.getSession().getTransaction();
        Query<User> userQuery = dbDataProvider.getSession().createQuery("delete User WHERE id = :id", User.class);
        userQuery.setParameter("id", userId).executeUpdate();
        //session.flush(для синхронизации данных объекта в кеше уровня сессий с БД);
        transaction.commit();
    }

    @Override
    public ArrayList<User> getByLogin(String searchLogin) {
        Transaction transaction = dbDataProvider.getSession().getTransaction();
        transaction.begin();
        Query<User> userQuery = dbDataProvider.getSession().createQuery("from User WHERE login like :login", User.class);
        userQuery.setParameter("login", "%" + searchLogin + "%");
        List<User> listUsers = userQuery.getResultList();
        //session.flush(для синхронизации данных объекта в кеше уровня сессий с БД);
        transaction.commit();
        return (ArrayList<User>)listUsers;
    }

    @Override
    public  ArrayList<User> getByPhone(String searchPhone) {
        Transaction transaction = dbDataProvider.getSession().getTransaction();
        Query<User> userQuery = dbDataProvider.getSession().createQuery("from User WHERE phoneNumber like :phone", User.class);
        userQuery.setParameter("phone", "%" + searchPhone + "%");
        List<User> listUsers = userQuery.getResultList();
        /*List<User> listUsers = userQuery.list();*/
        //session.flush(); (для синхронизации данных объекта в кеше уровня сессий с БД)
        transaction.commit();
        return (ArrayList<User>)listUsers;
    }

    @Override
    public void create(User user) {
        Transaction transaction = dbDataProvider.getSession().getTransaction();
        transaction.begin();
        dbDataProvider.getSession().save(user);/*session.update(user); */
        transaction.commit();
    }
}
