package service.impl;

import core.model.Hall;
import dao.HallDao;
import service.HallService;

import java.util.List;

public class HallServiceImpl implements HallService {

    private HallDao hallDao;

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
