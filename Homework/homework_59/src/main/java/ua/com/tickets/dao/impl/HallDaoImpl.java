package ua.com.tickets.dao.impl;

import ua.com.tickets.core.model.Hall;
import ua.com.tickets.core.model.MovieSession;
import ua.com.tickets.dao.HallDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HallDaoImpl implements HallDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

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
