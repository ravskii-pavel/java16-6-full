package ua.com.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.tickets.core.model.Film;
import ua.com.tickets.core.model.MovieSession;
import ua.com.tickets.core.model.User;
import ua.com.tickets.core.model.filters.MovieSessionFilter;
import ua.com.tickets.service.FilmService;
import ua.com.tickets.service.HallService;
import ua.com.tickets.service.MovieSessionService;
import ua.com.tickets.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("")
public class FilmController {

    @Autowired
    private MovieSessionService movieSessionService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private HallService hallService;

    /*@RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getAllMovieSessions() {
        List<Film> allFilms = filmService.getAllFilms();
        //Film film = allMovieSessions.get(0).getFilm();
        ModelAndView modelAndView = new ModelAndView("index-films-page");
        GregorianCalendar calendar = new GregorianCalendar();
        modelAndView.addObject("allFilms", allFilms);

        return modelAndView;
    }*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllFilms( HttpSession httpSession ) {
        httpSession.setAttribute("auth", new User() );
//        httpSession.setAttribute("auth", new User() );
       /* if(!user.containsAttribute("mycounter")) {
            model.addAttribute("mycounter", new MyCounter(0));
        }*/
        List<Film> allFilms = filmService.getAllFilms();
        //Film film = allMovieSessions.get(0).getFilm();
        ModelAndView modelAndView = new ModelAndView("allFilmsPage");
        modelAndView.addObject("allFilms", allFilms);

        return modelAndView;
    }

    @RequestMapping(value = "/film/{id}", method = RequestMethod.GET)
    public ModelAndView getFilmById( @PathVariable("id") long id)
    {
        Film film = filmService.getFilmById(id);
        MovieSessionFilter movieSessionFilter = new MovieSessionFilter();
        Collections.sort(film.getSessionList(), movieSessionFilter.sessionDayComparator());
        ModelAndView modelAndView = new ModelAndView("filmPage");
        modelAndView.addObject("film", film);
        Set<MovieSession> setSessions = new TreeSet<>(movieSessionFilter.sessionDayComparator());
        setSessions.addAll(film.getSessionList());
        Set<Calendar> uniqueDateDay = new TreeSet<>();

        for (MovieSession ms: setSessions) {
            uniqueDateDay.add(ms.getSessionStartDate());
        }
        modelAndView.addObject("uniqueDates", uniqueDateDay);
        return modelAndView;
    }
}

            /*System.out.println(ms.getSessionStartDate().get(Calendar.MONTH));
            System.out.println(ms.getSessionStartDate().get(Calendar.DAY_OF_MONTH));
            ms.getSessionStartDate().set(Calendar.HOUR_OF_DAY, 0);
            ms.getSessionStartDate().set(Calendar.MINUTE, 0);
            ms.getSessionStartDate().set(Calendar.SECOND, 0);
            @RequestParam long id
            */