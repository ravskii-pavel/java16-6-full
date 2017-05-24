package web.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import web.dao.DAO;
import web.dao.DataProvider;
import web.entity.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by ravskiy on 22.05.2017.
 */
public class UserDAOImpl<User> implements DAO<User> {
    protected final DBDataProviderImpl dbDataProvider;
    protected final Session session;

    public UserDAOImpl(DataProvider dataProvider) {
        this.dbDataProvider = (DBDataProviderImpl) dataProvider;
        this.session = dbDataProvider.getSession();
    }

    @Override
    public void create(User user) {
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(user);
        /*session.update(user);*/
        transaction.commit();
    }

    @Override
    public ArrayList<User> read() {
        String login;
        ArrayList<User> users = new ArrayList<>();
        return users;
    }

    @Override
    public void update(User user) {

        Transaction transaction = session.getTransaction();
        transaction.begin();

        Query query = session.createQuery("update User set fullName = :userFullName" +
                "where stockCode = :stockCode");
        query.setParameter("userFullName", user.);
        query.setParameter("stockCode", "7277");
        int result = query.executeUpdate();
        /*Employee employee = new Employee("Iosiph", "Stalin", "Moiseevich", 55000, department, post);
         employee.setSex(Sex.MALE);
         employee.setCity("Dnepr");
         employee.setZipCode("49000");
         employee.setStreetName("Gagarina");
        */
        session.save(user);
        transaction.commit();
        Query<User> userQuery = session.createQuery("update User set where id = :id", Department.class);
        departmentQuery.setParameter("id", 1L);
        Department department = departmentQuery.uniqueResult()
    }

    @Override
    public void delete(long userId) {
        Query<User> userQuery = session.createQuery("delete User WHERE id = :id", User.class);
        userQuery.setParameter("id", userId).executeUpdate();
        /*session.delete();*/
    }

    /*@Override
    public Object getOneById(long id) {
        return null;
    }*/

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
