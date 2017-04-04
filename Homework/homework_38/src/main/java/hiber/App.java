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
        try (SessionFactory sessionFactory = getSessionFactory(); Session session = sessionFactory.openSession();) {

            Query<Department> departmentQuery = session.createQuery("from Department where id = :id", Department.class);
            departmentQuery.setParameter("id", 1L);

            Department department = departmentQuery.uniqueResult();

            Query<Post> postQuery = session.createQuery("from Post where id = :id", Post.class);
            postQuery.setParameter("id", 9L);

            Post post = postQuery.uniqueResult();

            Employee employee = new Employee("Andrey", "Ivanov", "Robertovich", 55000, department, post);

            PhoneNumber phoneNumber = new PhoneNumber("380930000000", employee);

            Transaction transaction = session.getTransaction();

            transaction.begin();
            session.save(employee);
            session.save(phoneNumber);
            employee.setPhoneNumber(phoneNumber);

            session.update(employee);
            transaction.commit();

            Query<Employee> query = session.createQuery("from Employee", Employee.class);
            List<Employee> list = query.list();

            for (Employee e : list) {
                System.out.println(e);
            }

        } finally {
            System.out.println("Good bye!");
        }
    }
}