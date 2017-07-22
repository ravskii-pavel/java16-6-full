package ua.com.tickets.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.tickets.core.model.Film;
import ua.com.tickets.core.model.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ErrorController {

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView getError(HttpSession httpSession ) {

        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}
