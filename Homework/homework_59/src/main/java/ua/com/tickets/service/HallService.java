package ua.com.tickets.service;

import ua.com.tickets.core.model.Hall;

import java.util.List;

public interface HallService {
    void createHall(Hall hall);
    List<Hall> getAllHalls();
    Hall getHallById(Long id);
    void updateHall(Hall hall);
    void deleteHall(Hall hall);
}
