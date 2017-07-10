package ua.dp.levelup.service;

import ua.dp.levelup.core.model.MovieSession;

import java.util.List;

public interface MovieSessionService {

    void createMovieSession(MovieSession session);

    MovieSession getMovieSessionById(long sessionId);

    List<MovieSession> getAllMovieSessions();
}
