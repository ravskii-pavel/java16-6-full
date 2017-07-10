package ua.com.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.tickets.core.model.Film;
import ua.com.tickets.core.model.MovieSession;
import ua.com.tickets.service.FilmService;
import ua.com.tickets.service.HallService;
import ua.com.tickets.service.MovieSessionService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping("/movie-session")
public class MovieSessionController {

    @Autowired
    private MovieSessionService movieSessionService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private HallService hallService;


    /*@RequestMapping(value = "/addMovieSession", method = RequestMethod.POST)
    public ModelAndView getAddMovieSessionPage() {
        return new ModelAndView("add-movie-session");
    }
*/
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String addMovieSession(
            @RequestParam long newFilmId,
            @RequestParam long newHallId,
            /*@RequestParam Date newDate,
            @RequestParam Date newTime,*/
            @RequestParam int newStandardPrice,
            @RequestParam int newComfortPrice
            ) {
        GregorianCalendar gcd = new GregorianCalendar();
        GregorianCalendar gct = new GregorianCalendar();
       /* gcd.setTime(newDate);
        gct.setTime(newTime);*/
        movieSessionService.createSession(
                new MovieSession(filmService.getFilmById(newFilmId), gcd, gct, hallService.getHallById(newHallId), newStandardPrice, newComfortPrice));

        return "redirect:list";
    }

    @RequestMapping("")
    @ResponseBody
    public Film film() {
        return new Film("Bla", "Bla-bla", 24D);
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAllMovieSessions() {
        List<MovieSession> allMovieSessions = movieSessionService.getAllSessions();
        //Film film = allMovieSessions.get(0).getFilm();
        ModelAndView modelAndView = new ModelAndView("movie-session-page");

        modelAndView.addObject("allMovieSessions", allMovieSessions);

        return modelAndView;
    }
}
