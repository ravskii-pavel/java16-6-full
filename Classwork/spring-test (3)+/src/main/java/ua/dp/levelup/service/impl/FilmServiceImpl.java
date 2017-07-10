package ua.dp.levelup.service.impl;

import ua.dp.levelup.dao.FilmDao;
import ua.dp.levelup.service.FilmService;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public class FilmServiceImpl implements FilmService {

  private FilmDao filmDao;

  public void setFilmDao(final FilmDao filmDao) {
    this.filmDao = filmDao;
  }
}
