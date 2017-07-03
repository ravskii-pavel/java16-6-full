package ua.dp.levelup.dao;

import ua.dp.levelup.core.model.MovieSession;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
public interface MovieSessionDao {

    void createMovieSession(MovieSession session);

    MovieSession getMovieSessionById(long sessionId);
}
