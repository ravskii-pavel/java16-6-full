package hiber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

import static hiber.HibernateUtil.getSessionFactory;

/**
 * Created by java on 28.03.2017.
 */
public class App {

    public static void main(String[] args) {
        SessionFactory sessionFactory = getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            Employee emp = new Employee("Fedor", "Emelyanenko", "Albertovich", 9000);

            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.save(emp);
            transaction.commit();


            Query<Employee> query = session.createQuery("from Employee", Employee.class);
            List<Employee> list = query.list();

        for (Employee e: list){
            System.out.println(e);
        }
            //Employee employee = new Employee();
        }
        finally {
            System.out.println("Good_bye");
        }
    }
}
