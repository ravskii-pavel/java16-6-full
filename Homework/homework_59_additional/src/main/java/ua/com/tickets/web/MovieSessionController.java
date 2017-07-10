package ua.com.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.tickets.core.model.Film;
import ua.com.tickets.core.model.Hall;
import ua.com.tickets.core.model.MovieSession;
import ua.com.tickets.service.MovieSessionService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
            @RequestParam int standardTicketPrice,
            @RequestParam int comfortTicketPrice
            ) {

        Calendar calendarDate = new GregorianCalendar();
        Calendar calendarTime = new GregorianCalendar();
        //calendarDate.getTimeZone();
        calendarDate.set(Calendar.YEAR, 2017);
        calendarDate.set(Calendar.MONTH, Calendar.AUGUST); // если указывть цифрами, то нумерация начинается с 0
        calendarDate.set(Calendar.DAY_OF_MONTH, 19);
        calendarTime.set(Calendar.HOUR_OF_DAY, 24);
        calendarTime.set(Calendar.AM_PM, Calendar.AM);
        calendarTime.set(Calendar.HOUR, 22);
        calendarTime.set(Calendar.MINUTE, 15);
        calendarTime.set(Calendar.SECOND, 00);
        movieSessionService.createSession(
                new MovieSession(new Film("Terminator", "1991", 24D), calendarDate, calendarTime, new Hall(), comfortTicketPrice, standardTicketPrice));

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
        List<MovieSession> allMovieSessions = movieSessionService.getAllSessions();
        ModelAndView modelAndView = new ModelAndView("movie-session-page");

        modelAndView.addObject("allMovieSessions", allMovieSessions);

        return modelAndView;
    }
}
