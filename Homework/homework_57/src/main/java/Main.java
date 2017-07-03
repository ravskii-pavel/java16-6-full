
import core.model.*;

import org.hibernate.Hibernate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        UserService userServiceBean = (UserService) context.getBean("userService");
        FilmService filmServiceBean = (FilmService) context.getBean("filmService");
        HallService hallServiceBean = (HallService) context.getBean("hallService");
        OrderService orderServiceBean = (OrderService) context.getBean("orderService");
        TicketService ticketServiceBean = (TicketService) context.getBean("ticketService");
        MovieSessionService sessionsServiceBean = (MovieSessionService) context.getBean("movieSessionService");
        List<User> allUsers = userServiceBean.getAllUsers();
        //User newUser = new User("New User - 4", "user4@gmail.com", "0775588899", Role.ADMIN);
       // userServiceBean.createUser(newUser);
        //System.out.println(newUser);
        /*allUsers = userServiceBean.getAllUsers();*/
        MovieSession movieSession = sessionsServiceBean.getSessionById(42L);
        User user = userServiceBean.getUserByEmail("user2@gmail.com");
        Order order = new Order(user, 240);
       // Order order = orderServiceBean.getOrderById(51L);
        orderServiceBean.createOrder(order);
        List<Ticket> ticketList = new ArrayList<>();
        Ticket ticket1 = new Ticket(8L, movieSession, order, 12, 15, 80);
        Ticket ticket2 = new Ticket(9L, movieSession, order, 13, 15, 80);
        Ticket ticket3 = new Ticket(10L, movieSession, order, 14, 15, 80);
        ticketServiceBean.createTicket(ticket1);
        ticketServiceBean.createTicket(ticket2);
        ticketServiceBean.createTicket(ticket3);
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);
        order.setTicketList(ticketList);

        /*Film film = new Film("The Hateful Eight", "Легендарный охотник за головами Джон Рут по кличке Вешатель конвоирует заключенную. " +
                "По пути к ним прибивается еще один охотник.",
                2.37D);*/
        //filmServiceBean.createFilm(film);
        //List<MovieSession> allSession = sessionsServiceBean.getAllSession();
        //Film film = filmServiceBean.getAllFilms().get(2);
        Film film = filmServiceBean.getFilmById(23L);
        Hall hall = new Hall("Hall 2",10, 16);
        //Hall hall = hallServiceBean.getHallById(37L);
        //System.out.println(hall);
        hallServiceBean.createHall(hall);
        //List<MovieSession> filmSession = film.getSessionList();

        //System.out.println(filmSession);
        //filmServiceBean.createFilm(film);

        //MovieSession movieSession = new MovieSession(film, new Date(), new Date(), 4, 150, 80);
        //MovieSession movieSession = new MovieSession(film, new Date(117, 6, 15), new Date(2017, 7, 15, 14, 25, 30), 6, 150, 80);
        //MovieSession filmSession = sessionsServiceBean.getSessionById(42L);
//        filmSession.setSessionStartDate(new Date(117, 7, 15, 14, 25, 30));
        Calendar calendarDate = new GregorianCalendar();
        Calendar calendarTime = new GregorianCalendar();
        //calendarDate.getTimeZone();
        calendarDate.set(Calendar.YEAR, 2017);
        calendarDate.set(Calendar.MONTH, Calendar.JULY); // если указывть цифрами, то нумерация начинается с 0
        calendarDate.set(Calendar.DAY_OF_MONTH, 11);
        calendarTime.set(Calendar.HOUR_OF_DAY, 24);
        calendarTime.set(Calendar.AM_PM, Calendar.AM);
        calendarTime.set(Calendar.HOUR, 17);
        calendarTime.set(Calendar.MINUTE, 30);
        calendarTime.set(Calendar.SECOND, 00);
        /*filmSession.setSessionStartDate(calendarDate);
        filmSession.setSessionStartTime(calendarTime);
        sessionsServiceBean.updateSession(filmSession);
        System.out.println();*/
        //filmServiceBean.deleteFilm(film);
        //System.out.println(allSession);
        /*MovieSession movieSession1 = new MovieSession(film, calendarDate, calendarTime, hall, 150, 80);
        sessionsServiceBean.createSession(movieSession1);*/
        /*MovieSession movieSession1 = sessionsServiceBean.getSessionById(28L);
        MovieSession movieSession2 = sessionsServiceBean.getSessionById(29L);*/
       /* List<Film> allFilms = filmServiceBean.getAllFilms();
        System.out.println(allFilms);*/
       /* System.out.println(movieSession1);
        movieSession1.setHallNumber(11);
        movieSession1.setFilm(film);
        sessionsServiceBean.updateSession(movieSession1);
        System.out.println(sessionsServiceBean.getSessionById(22L).toString());*/
        /*User user = userServiceBean.getAllUsers().get(0);


        //context.close();
       /* UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.doMagic();*/
        ((ConfigurableApplicationContext)context).close();
    }
}