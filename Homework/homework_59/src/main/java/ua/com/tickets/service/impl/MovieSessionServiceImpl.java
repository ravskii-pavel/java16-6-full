package ua.com.tickets.service.impl;

import ua.com.tickets.core.model.MovieSession;
import ua.com.tickets.dao.MovieSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.tickets.service.MovieSessionService;

import java.util.List;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {

    private MovieSessionDao movieSessionDao;

    @Autowired
    public void setMovieSessionDao(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public void createSession(MovieSession movieSession) {
        movieSessionDao.createSession(movieSession);
    }

    @Override
    public List<MovieSession> getAllSession() {
        return movieSessionDao.getAllSession();
    }

    @Override
    public MovieSession getSessionById(Long id) {
        return movieSessionDao.getSessionById(id);
    }

    @Override
    public void updateSession(MovieSession movieSession) {
        movieSessionDao.updateSession(movieSession);
    }

    @Override
    public void deleteSession(MovieSession movieSession) {
        movieSessionDao.deleteSession(movieSession);
    }
}
