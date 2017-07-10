package ua.com.tickets.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import ua.com.tickets.core.model.Film;
import ua.com.tickets.dao.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.tickets.service.FilmService;

import java.util.List;

@Service(value = "filmService")
public class FilmServiceImpl implements FilmService{

    private FilmDao filmDao;

    @Autowired
    @Qualifier("filmDao")
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
