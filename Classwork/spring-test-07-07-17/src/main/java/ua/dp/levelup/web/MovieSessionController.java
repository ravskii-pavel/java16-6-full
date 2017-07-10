package ua.dp.levelup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.levelup.core.model.Film;
import ua.dp.levelup.core.model.MovieSession;
import ua.dp.levelup.service.MovieSessionService;

import java.util.Date;
import java.util.List;

/**
 * Created by java on 04.07.2017.
 */
@Controller
@RequestMapping("/movie")
public class MovieSessionController {

    @Autowired
    private MovieSessionService movieSessionService;


    @RequestMapping(value = "/add-session", method = RequestMethod.GET)
    public ModelAndView getAddMovieSessionPage() {
        return new ModelAndView("add-movie-session");
    }

    @RequestMapping(value = "/add-session", method = RequestMethod.POST)
    public String addMovieSession(
            @RequestParam long filmId,
//            @RequestParam Date sessionStartDate,
//            @RequestParam Date sessionStartTime,
            @RequestParam int hallNumber,
            @RequestParam double standardTicketPrice,
            @RequestParam double comfortTicketPrice
            ) {
        movieSessionService.createMovieSession(
                new MovieSession(filmId, new Date(), new Date(), hallNumber, standardTicketPrice, comfortTicketPrice));

        return "redirect:list";
    }

    @RequestMapping("/")
    @ResponseBody
    public Film film() {
        return new Film("Bla", "Bla-bla", 24D);
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @RequestMapping("/list")
    public ModelAndView getAllMovieSessions() {
        List<MovieSession> allMovieSessions = movieSessionService.getAllMovieSessions();
        ModelAndView modelAndView = new ModelAndView("movie-session-page");

        modelAndView.addObject("allMovieSessions", allMovieSessions);

        return modelAndView;
    }
}
