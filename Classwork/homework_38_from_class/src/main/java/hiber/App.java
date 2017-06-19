package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.CriteriaSubqueryImpl;
import org.hibernate.query.criteria.internal.path.RootImpl;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

            /*Employee employee = new Employee("Iosiph", "Stalin", "Moiseevich", 55000, department, post);
            employee.setSex(Sex.MALE);
            employee.setCity("Dnepr");
            employee.setZipCode("49000");
            employee.setStreetName("Gagarina");
            Car car = new Car ("BMW", Color.BLACK, 270);
            PhoneNumber phoneNumber = new PhoneNumber("380930000000", employee);*/

            Yacht yacht = new Yacht("Elan", 5, 10, 22);
            Transaction transaction = session.getTransaction();

            transaction.begin();
      /*      session.save(employee);
            session.save(phoneNumber);
            employee.setPhoneNumber(phoneNumber);
            employee.setCar(car);

            session.update(employee);*/

            session.save(yacht);
            transaction.commit();

            /*Query<Employee> query = session.createQuery("from Employee", Employee.class);
            List<Employee> list = query.list();

            for (Employee e : list) {
                System.out.println(e);
            }*/

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Yacht> criteriaQuery = session.getCriteriaBuilder().createQuery(Yacht.class);
            Root<Yacht> yachtRoot = criteriaQuery.from(Yacht.class);

            criteriaQuery.select(yachtRoot);
            criteriaQuery.where(criteriaBuilder.equal(yachtRoot.get("model"), "2247"));
            EntityManager entityManager = sessionFactory.createEntityManager();

            Yacht yacht1 = entityManager.createQuery(criteriaQuery).getSingleResult();



        } finally {
            System.out.println("Good bye!");
        }
    }
}
