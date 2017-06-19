package hiber;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.List;

import static hiber.HibernateUtil.getSessionFactory;

/**
 * Created by java on 28.03.2017.
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException {


        try (SessionFactory sessionFactory = getSessionFactory();
             Session session = sessionFactory.openSession();) {

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            /* ---1) Query<Department> departmentQuery = session.createQuery("from Department where id = :id", Department.class);
            departmentQuery.setParameter("id", 1L);
            Department department = departmentQuery.uniqueResult();

            ---2) Query<Department> departmentQuery = session.createQuery("from Department where id = ?", Department.class);
            departmentQuery.setParameter(0, 1L);
            Department department = departmentQuery.uniqueResult()

            Query<Post> postQuery = session.createQuery("from Post where id = :id", Post.class);
            postQuery.setParameter("id", 9L);
            Post post = postQuery.uniqueResult();

            *//*Query<WorkDay> workDayQuery = session.createQuery("from WorkDay where id = :id", WorkDay.class);
            workDayQuery.setParameter("id", 22L);
            WorkDay workDay = workDayQuery.uniqueResult();

            Query<Salary> salaryQuery = session.createQuery("from Salary where id = :id", Salary.class);
            salaryQuery.setParameter("id", 23L);
            Salary salary = salaryQuery.uniqueResult();*//*

            Employee employee = new Employee("Andrey2", "Ivanov2", "Robertovich2", 470, department, post);

            PhoneNumber phoneNumber = new PhoneNumber("380930000000", employee);
            //employee.setPhoneNumber(phoneNumber);
            WorkDay workDay = new WorkDay(employee, new Date(), new Date(), new Date());

            Salary salary = new Salary(employee, 8765D, new Date(), new Date());

            Tangible tangible = new Tangible("Системный блок - Core i7",  8800, "new1");


            Transaction transaction = session.getTransaction();

            transaction.begin();

            session.save(employee);
            session.save(workDay);
            session.save(salary);
            session.save(phoneNumber);
            session.save(tangible);


            *//*session.save(phoneNumber);
            session.save(phoneNumber);*//*


            session.update(employee);
            session.update(tangible);
            transaction.commit();*/

            /*Query<Employee> query = session.createQuery("from Employee", Employee.class);
            List<Employee> list = query.list();

            for (Employee e : list) {
                System.out.println(e);
            }*/

      /*      Query<Tangible> queryT = session.createQuery("from Tangible", Tangible.class);
            List<Tangible> listT = queryT.list();

            for (Tangible e : listT) {
                System.out.println(e);
            }*/

            Query<Course> courseQuery = session.createQuery("from Course WHERE title like \'%Ubuntu%\' and price > 500", Course.class);
            List<Course> listC = courseQuery.list();


            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<> criteriaQuery = criteriaBuilder.createQuery(.class);
            Root<> yachtRoot = criteriaQuery.from(.class);


            for (Course course : listC) {
                System.out.println(course);
            }

        } finally {
            System.out.println("Good bye!");
        }
    }
}
