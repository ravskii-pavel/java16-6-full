package ua.com.tickets.service.impl;

import ua.com.tickets.core.model.Hall;
import ua.com.tickets.dao.HallDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.tickets.service.HallService;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    private HallDao hallDao;

    @Autowired
    public void setHallDao(HallDao hallDao) { this.hallDao = hallDao; }

    @Override
    public void createHall(Hall hall) { hallDao.createHall(hall); }

    @Override
    public List<Hall> getAllHalls() {
        return hallDao.getAllHalls();
    }

    @Override
    public Hall getHallById(Long id) {
        return hallDao.getHallById(id);
    }

    @Override
    public void updateHall(Hall hall) { hallDao.updateHall(hall); }

    @Override
    public void deleteHall(Hall hall) { hallDao.deleteHall(hall); }
}
