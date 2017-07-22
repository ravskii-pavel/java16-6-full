package ua.com.tickets.service;


import ua.com.tickets.core.model.MovieSession;

import java.util.List;

public interface MovieSessionService {
    void createSession(MovieSession movieSession);
    List<MovieSession> getAllSessions();
    MovieSession getSessionById(Long id);
    void updateSession(MovieSession movieSession);
    void deleteSession(MovieSession movieSession);
}
