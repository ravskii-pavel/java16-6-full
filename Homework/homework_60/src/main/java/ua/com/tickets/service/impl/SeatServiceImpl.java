package ua.com.tickets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.tickets.core.model.Row;
import ua.com.tickets.core.model.Seat;
import ua.com.tickets.core.model.TypeRow;
import ua.com.tickets.dao.SeatDao;
import ua.com.tickets.service.SeatService;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class SeatServiceImpl implements SeatService {

    private SeatDao seatDao;

    @Autowired
    public void setSeatDao(SeatDao seatDao) {
        this.seatDao = seatDao;
    }

    @Override
    public void createSeat(Seat seat) {
        seatDao.createSeat(seat);
    }

    @Override
    public void createListSeats(int quantitySeatsInRow, Row row) {
        Seat seat;
        List<Seat> seatList = new ArrayList<>();
        for (int num = 1; num <= quantitySeatsInRow; num++) {
            seat = new Seat(num, row);
            this.createSeat(seat);
            seatList.add(seat);
        }
        row.setSeatList(seatList);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatDao.getAllSeats();
    }

    @Override
    public Seat getSeatById(Long id) {
        return seatDao.getSeatById(id);
    }

    @Override
    public void updateSeat(Seat seat) {
        seatDao.updateSeat(seat);
    }

    @Override
    public void deleteSeat(Seat seat) {
        seatDao.deleteSeat(seat);
    }
}
