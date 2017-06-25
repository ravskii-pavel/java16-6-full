package ua.dp.levelup.service.impl;

import ua.dp.levelup.dao.MovieSessionDao;
import ua.dp.levelup.service.MovieSessionService;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public class MovieSessionServiceImpl implements MovieSessionService {

  private MovieSessionDao movieSessionDao;

  public void setMovieSessionDao(final MovieSessionDao movieSessionDao) {
    this.movieSessionDao = movieSessionDao;
  }
}
