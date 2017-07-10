package ua.dp.levelup.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.levelup.core.model.Film;

/**
 * Created by java on 04.07.2017.
 */
@Controller
@RequestMapping("/movie")
public class MovieSessionController {

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
        return new ModelAndView("movie-session-page");
    }
}
