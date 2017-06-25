package ua.dp.levelup.dao.impl;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.core.model.Film;
import ua.dp.levelup.dao.FilmDao;

/**
 * @author Alexandr Shegeda on 23.06.17.
 */
@Transactional
public class FilmDaoImpl implements FilmDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void createFilm(Film film) {
        hibernateTemplate.save(film);
    }
}
