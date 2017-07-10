package ua.com.tickets.dao.impl;

import org.springframework.context.annotation.Scope;
import ua.com.tickets.core.model.MovieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.tickets.core.model.Film;
import ua.com.tickets.dao.FilmDao;

import java.util.List;

@Repository(value = "filmDao")
@Scope("singleton")
@Transactional
public class FilmDaoImpl implements FilmDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createFilm(Film film) {  hibernateTemplate.save(film); }

    @Override
    public List<Film> getAllFilms() {
        List<Film> listFilms = hibernateTemplate.loadAll(Film.class);
        for (Film f : listFilms){
            List<MovieSession> movieSessionList = f.getSessionList();
            movieSessionList.toString();
        }
        return listFilms;
    }

    @Override
    public Film getFilmById(Long id) {
        Film film = hibernateTemplate.load(Film.class, id);
        film.toString();
        return film;
    }

    @Override
    public void updateFilm(Film film) {
        hibernateTemplate.update(film);
    }

    @Override
    public void deleteFilm(Film film) {
        hibernateTemplate.delete(film);
    }
}
