package service;

import core.model.Film;

import java.util.List;

public interface FilmService {
    void createFilm(Film film);
    List<Film> getAllFilms();
    Film getFilmById(Long id);
    void updateFilm(Film film);
    void deleteFilm(Film film);
}
