package dao.impl;

import core.model.Hall;
import core.model.MovieSession;
import dao.HallDao;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class HallDaoImpl implements HallDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void createHall(Hall hall) { hibernateTemplate.save(hall); }

    @Override
    public List<Hall> getAllHalls() {
        List<Hall> listHals = hibernateTemplate.loadAll(Hall.class);
        for (Hall h : listHals){
            List<MovieSession> movieSessionList = h.getMovieSessions();
            movieSessionList.toString();
        }
        return listHals;
    }

    @Override
    public Hall getHallById(Long id) {
        Hall hall = hibernateTemplate.load(Hall.class, id);
        hall.toString();
        return hall;
    }

    @Override
    public void updateHall(Hall hall) { hibernateTemplate.update(hall); }

    @Override
    public void deleteHall(Hall hall) { hibernateTemplate.delete(hall); }
}
