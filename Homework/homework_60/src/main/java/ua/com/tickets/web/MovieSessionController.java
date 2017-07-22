package ua.com.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.tickets.core.model.MovieSession;
import ua.com.tickets.service.FilmService;
import ua.com.tickets.service.HallService;
import ua.com.tickets.service.MovieSessionService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
        movieSessionService.createSession(
                new MovieSession(filmService.getFilmById(newFilmId), gcd, hallService.getHallById(newHallId), newStandardPrice, newComfortPrice));

        return "redirect:list";
    }

    @RequestMapping("")
    @ResponseBody
    public MovieSession movieSession() {
//        return new Film("Bla", "Bla-bla", 24D);
        MovieSession sessionById = movieSessionService.getSessionById(1L);
        return sessionById;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getMovieSessionById( @PathVariable("id") long id,
                                    HttpServletRequest req,
                                    @RequestHeader ("host") String hostName,
                                    @RequestHeader ("referer") String referer)
    {
        MovieSession movieSession = movieSessionService.getSessionById(id);

        ModelAndView modelAndView = new ModelAndView("reserved-seat-page");
        modelAndView.addObject("movieSession", movieSession);


       /* for (MovieSession ms: setSessions) {
            uniqueDateDay.add(ms.getSessionStartDate());
        }
        modelAndView.addObject("uniqueDates", uniqueDateDay);*/
        return modelAndView;
    }
}
