package ua.dp.levelup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dp.levelup.core.model.MovieSession;
import ua.dp.levelup.dao.MovieSessionDao;
import ua.dp.levelup.service.MovieSessionService;

import java.util.List;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
@Service
public class MovieSessionServiceImpl implements MovieSessionService {

  private MovieSessionDao movieSessionDao;

  @Autowired
  public void setMovieSessionDao(final MovieSessionDao movieSessionDao) {
    this.movieSessionDao = movieSessionDao;
  }

  @Override
  public void createMovieSession(MovieSession session) {
    movieSessionDao.createMovieSession(session);
  }

  @Override
  public MovieSession getMovieSessionById(long sessionId) {
    return movieSessionDao.getMovieSessionById(sessionId);
  }

  @Override
  public List<MovieSession> getAllMovieSessions() {
    return movieSessionDao.getAllMovieSessions();
  }
}
