package service.impl;

import core.model.Film;
import dao.FilmDao;
import service.FilmService;

import java.util.List;

public class FilmServiceImpl implements FilmService{

    private FilmDao filmDao;

    public void setFilmDao(final FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @Override
    public void createFilm(Film film) {
        filmDao.createFilm(film);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmDao.getAllFilms();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmDao.getFilmById(id);
    }

    @Override
    public void updateFilm(Film film) {
        filmDao.updateFilm(film);
    }

    @Override
    public void deleteFilm(Film film) {
        filmDao.deleteFilm(film);
    }

}
