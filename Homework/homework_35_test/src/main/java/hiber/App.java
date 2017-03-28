package hiber;
import org.hibernate.SessionFactory;

import static hiber.HibernateUtil.getSessionFactory;

/**
 * Created by java on 28.03.2017.
 */
public class App {

    public static void main(String[] args) {
        SessionFactory sessionFactory = getSessionFactory();

    }
}
