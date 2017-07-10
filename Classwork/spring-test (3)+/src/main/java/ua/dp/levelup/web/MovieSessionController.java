package ua.dp.levelup.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieSessionController   {

    @RequestMapping("/")
    public ModelAndView welcome(){
        return new ModelAndView("welcome");
    }

    @RequestMapping("/movies")
    public ModelAndView getAllMovieSessions(){
        return new ModelAndView("movie-session-page");
    }
}
