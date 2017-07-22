package ua.com.tickets.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.tickets.core.model.Seat;
import ua.com.tickets.dao.SeatDao;

import java.util.List;


@Repository
@Transactional
public class SeatDaoImpl implements SeatDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createSeat(Seat seat) {
        hibernateTemplate.save(seat);
    }

    @Override
    public List<Seat> getAllSeats() {
        return hibernateTemplate.loadAll(Seat.class);
    }

    @Override
    public Seat getSeatById(Long id) {
        return hibernateTemplate.load(Seat.class, id);
    }

    @Override
    public void updateSeat(Seat seat) {
        hibernateTemplate.update(seat);
    }

    @Override
    public void deleteSeat(Seat seat) {
        hibernateTemplate.delete(seat);
    }
}
