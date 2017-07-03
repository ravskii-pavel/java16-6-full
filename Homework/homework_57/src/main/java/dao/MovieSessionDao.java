package dao;

import core.model.MovieSession;

import java.util.List;

public interface MovieSessionDao{

    void createSession(MovieSession movieSession);
    List<MovieSession> getAllSession();
    MovieSession getSessionById(Long id);
    void updateSession(MovieSession movieSession);
    void deleteSession(MovieSession movieSession);
}
