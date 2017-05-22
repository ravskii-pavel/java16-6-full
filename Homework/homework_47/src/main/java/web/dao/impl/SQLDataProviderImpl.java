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
public class SQLDataProviderImpl implements DataProvider {

    //ConnectionType connectionType = ConnectionType.MYSQL;
    SessionFactory sessionFactory = getSessionFactory();
    Session session = sessionFactory.openSession();
    EntityManager entityManager = sessionFactory.createEntityManager();

}
