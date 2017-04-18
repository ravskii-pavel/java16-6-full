package hiber;

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

            Query<Department> departmentQuery = session.createQuery("from Department where id = :id", Department.class);
            departmentQuery.setParameter("id", 1L);
            Department department = departmentQuery.uniqueResult();

            Query<Post> postQuery = session.createQuery("from Post where id = :id", Post.class);
            postQuery.setParameter("id", 9L);
            Post post = postQuery.uniqueResult();

            /*Query<WorkDay> workDayQuery = session.createQuery("from WorkDay where id = :id", WorkDay.class);
            workDayQuery.setParameter("id", 22L);
            WorkDay workDay = workDayQuery.uniqueResult();

            Query<Salary> salaryQuery = session.createQuery("from Salary where id = :id", Salary.class);
            salaryQuery.setParameter("id", 23L);
            Salary salary = salaryQuery.uniqueResult();*/

            Employee employee = new Employee("Andrey2", "Ivanov2", "Robertovich2", 470, department, post);

            PhoneNumber phoneNumber = new PhoneNumber("380930000000", employee);
            employee.setPhoneNumber(phoneNumber);
            WorkDay workDay = new WorkDay(employee ,  new Date(), new Date(), new Date());

            Salary salary = new Salary(employee, 8765D, new Date(), new Date());

            Transaction transaction = session.getTransaction();

            transaction.begin();

            session.save(employee);
            session.save(workDay);
            session.save(salary);
            session.save(phoneNumber);


            /*session.save(phoneNumber);
            session.save(phoneNumber);*/


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
