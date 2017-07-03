package dao.impl;

import core.model.MovieSession;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import core.model.Film;
import dao.FilmDao;

import java.io.Serializable;
import java.util.List;

@Transactional
public class FilmDaoImpl implements FilmDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

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
