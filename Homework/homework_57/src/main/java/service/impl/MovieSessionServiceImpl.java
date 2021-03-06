package service.impl;

import core.model.MovieSession;
import dao.MovieSessionDao;
import service.MovieSessionService;

import java.util.List;

public class MovieSessionServiceImpl implements MovieSessionService {

    private MovieSessionDao movieSessionDao;
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
