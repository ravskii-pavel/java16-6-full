package ua.dp.levelup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBDataProvider {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public Session getSession (){
        return sessionFactory.getCurrentSession();
    }

}