package ua.com.tickets.dao;

import ua.com.tickets.core.model.Seat;

import java.util.List;

/**
 * Created by ravskiy on 20.07.17.
 */
public interface SeatDao {
    void createSeat(Seat seat);
    List<Seat> getAllSeats();
    Seat getSeatById(Long id);
    void updateSeat(Seat seat);
    void deleteSeat(Seat seat);
}
