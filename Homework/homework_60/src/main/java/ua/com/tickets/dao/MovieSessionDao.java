package ua.com.tickets.dao;

import ua.com.tickets.core.model.MovieSession;

import java.util.List;

public interface MovieSessionDao{

    void createSession(MovieSession movieSession);
    List<MovieSession> getAllSessions();
    MovieSession getSessionById(Long id);
    void updateSession(MovieSession movieSession);
    void deleteSession(MovieSession movieSession);
}
