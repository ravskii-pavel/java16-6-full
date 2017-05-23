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
    private Session session = sessionFactory.openSession();
    //ConnectionType connectionType = ConnectionType.MYSQL;
    public Session getSession (){
        return session;
    }

    @Override
    public void openConnection() {
        if (session.isOpen()){}
        else {
            session = sessionFactory.openSession();
        }
    }

    @Override
    public void closeConnection() {
        session.close();
    }
}
