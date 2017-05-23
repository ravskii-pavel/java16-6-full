package web.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import web.dao.DAO;
import web.dao.DataProvider;

import java.util.ArrayList;
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
        
    }

    @Override
    public Map<String, User> read() {
        String login;
        Map<String, User> users;
        return users;
    }

    @Override
    public void update(User user) {

        Transaction transaction = session.getTransaction();
        transaction.begin();
        /*Employee employee = new Employee("Iosiph", "Stalin", "Moiseevich", 55000, department, post);
            employee.setSex(Sex.MALE);
            employee.setCity("Dnepr");
            employee.setZipCode("49000");
            employee.setStreetName("Gagarina");
           */


        session.save(user);
        user.setPhoneNumber(phoneNumber);
        user.setCar(car);
        session.update(user);

        session.save(yacht);
        transaction.commit();
        Query<User> userQuery = session.createQuery("update User where id = :id", Department.class);
        departmentQuery.setParameter("id", 1L);
        Department department = departmentQuery.uniqueResult()
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
