package ua.com.tickets.service;

import ua.com.tickets.core.model.Row;
import ua.com.tickets.core.model.Seat;

import java.util.List;

public interface SeatService {
    void createSeat(Seat seat);
    void createListSeats(int quantitySeatsInRow, Row row);
    List<Seat> getAllSeats();
    Seat getSeatById(Long id);
    void updateSeat(Seat seat);
    void deleteSeat(Seat seat);
}
