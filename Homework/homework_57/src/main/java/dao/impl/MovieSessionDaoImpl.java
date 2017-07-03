package dao.impl;

import core.model.MovieSession;
import dao.MovieSessionDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public class MovieSessionDaoImpl implements MovieSessionDao{

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void createSession(MovieSession movieSession) { hibernateTemplate.save(movieSession); }

    @Override
    public List<MovieSession> getAllSession() {
       /* Session session = hibernateTemplate.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();*/
        List<MovieSession> listMovieSessions = hibernateTemplate.loadAll(MovieSession.class);
        for (MovieSession ms : listMovieSessions){
            System.out.println(ms); //Ели Fetch - Lazy, Чтобы не получать LazyInitializationException - не обязательно создавать новую сессию и открывать транзакцию. Достаточно сделать sout map или каждого объекта в цикле foreach, который лежит в map. (или FetchType = EGER)
        }
        //transaction.commit();
        return listMovieSessions;
    }

    @Override
    public MovieSession getSessionById(Long id) {
        MovieSession movieSession = hibernateTemplate.get(MovieSession.class, id);
        movieSession.toString();
        return movieSession;
    }

    @Override
    public void updateSession(MovieSession movieSession) {
        hibernateTemplate.update(movieSession);
    }

    @Override
    public void deleteSession(MovieSession movieSession) {
        hibernateTemplate.delete(movieSession);
    }
}
