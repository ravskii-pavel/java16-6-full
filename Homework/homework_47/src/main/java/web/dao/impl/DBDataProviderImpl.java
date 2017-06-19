package web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.dao.DataProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static web.dao.impl.HibernateUtil.getSessionFactory;

/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */
public class DBDataProviderImpl implements DataProvider {

    private SessionFactory sessionFactory = getSessionFactory();
    private Session session = sessionFactory.getCurrentSession();
    //ConnectionType connectionType = ConnectionType.MYSQL;
    public Session getSession (){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void openConnection() {
            session = sessionFactory.getCurrentSession();
    }

    @Override
    public void closeConnection() {
        session.close();
    }
}
