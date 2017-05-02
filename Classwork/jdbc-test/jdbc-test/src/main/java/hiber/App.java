package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaSubqueryImpl;

import javax.persistence.criteria.*;
import java.awt.*;
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
            postQuery.setParameter("id", 1L);

            Post post = postQuery.uniqueResult();

//            Employee employee = new Employee("Adolf", "Ivanov", "Robertovich", 55000, department, post);
//
//            employee.setSex(Sex.MALE);
//            employee.setCity("Dnepr");
//            employee.setStreetName("Krasnaya");
//            employee.setZipCode("49000");
//
//            Car car = new Car("BMW", 270);
//            employee.setCar(car);

            Yacht yacht = new Yacht("2247", 5, 10, 15);


//            PhoneNumber phoneNumber = new PhoneNumber("380930000000", employee);

            Transaction transaction = session.getTransaction();

            transaction.begin();
//            employee.setPhoneNumber(phoneNumber);
//            session.save(employee);
//            session.save(phoneNumber);

//            session.update(employee);

//            session.save(yacht);
            transaction.commit();

//            Query<Employee> query = session.createQuery("from Employee", Employee.class);
//            List<Employee> list = query.list();
//
//            for (Employee e : list) {
//                System.out.println(e);
//            }

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Yacht> criteriaQuery = criteriaBuilder.createQuery(Yacht.class);
            Root<Yacht> yachtRoot = criteriaQuery.from(Yacht.class);

            Predicate predicate = criteriaBuilder.equal(yachtRoot.get("model"), "2247");
//
//            CriteriaQuery<Yacht> query = criteriaQuery.where(predicate);
//            query.g

        } finally {
            System.out.println("Good bye!");
        }
    }
}
