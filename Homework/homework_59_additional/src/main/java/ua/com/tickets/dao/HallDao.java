package ua.com.tickets.dao;

import ua.com.tickets.core.model.Hall;

import java.util.List;


public interface HallDao {
    void createHall(Hall hall);
    List<Hall> getAllHalls();
    Hall getHallById(Long id);
    void updateHall(Hall hall);
    void deleteHall(Hall hall);
}
