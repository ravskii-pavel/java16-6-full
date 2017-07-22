package ua.com.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.tickets.core.model.User;
import ua.com.tickets.service.UserService;
import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("auth")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView signInUser(@RequestParam String userEmail,
                             @RequestParam String userPass,
                             @RequestHeader ("host") String hostName,
                             @RequestHeader ("referer") String referer,
                             @ModelAttribute("auth") User user,
                             HttpServletRequest req){

        User userDB = userService.getUserByEmail(userEmail);
        ModelAndView modelAndView = new ModelAndView("redirect:"+referer);
        if(null == referer || !referer.contains(hostName)){
            return new ModelAndView("redirect:error");
        }
        else if (null != userDB && userDB.getPassword().equals(userPass)){
            modelAndView.addObject("auth", userDB);
            return modelAndView;
        }
        else{
            return modelAndView;
        }
    }



        /*    @PathVariable("id") long id,
                                   HttpServletRequest req,
                                   Model model,
                                   @RequestHeader ("host") String hostName,
                                   @RequestHeader ("referer") String referer,
                                   @RequestHeader ("Accept") String acceptType,
                                   @RequestHeader ("Accept-Language") String acceptLang,
                                   @RequestHeader ("Accept-Encoding") String acceptEnc,
                                    *//*@RequestHeader ("Cache-Control") String cacheCon,*//*
                                   @RequestHeader ("Cookie") String cookie,
                                   @RequestHeader ("User-Agent") String userAgent)
    {
        String referer = req.getHeader("referer");
//        System.out.println("reqFrom : " + req.getHeader("referer"));
        System.out.println("referer : " + referer);
        System.out.println("req : " + req.getRemoteHost());
        System.out.println("req0 : " + req.getQueryString());
        System.out.println("req1 : " + req.getServletPath());
        System.out.println("req2 : " + req.getContextPath());
        System.out.println("To : " + req.getRequestURL());
        System.out.println("To (without hostName) : " + req.getRequestURI());
        System.out.println("Host : " + hostName);
        System.out.println("Accept : " + acceptType);
        System.out.println("Accept Language : " + acceptLang);
        System.out.println("Accept Encoding : " + acceptEnc);
        *//*System.out.println("Cache-Control : " + cacheCon);*//*
        System.out.println("Cookie : " + cookie);
        System.out.println("User-Agent : " + userAgent);
        Film film = filmService.getFilmById(id);
        //        model.addAttribute("auth", userDB);
        //Film film = allMovieSessions.get(0).getFilm();
        ModelAndView modelAndView = new ModelAndView("filmPage");
        GregorianCalendar calendar = new GregorianCalendar();
        modelAndView.addObject("film", film);

        return modelAndView;
    }*/

//          req.getSession().setAttribute("auth", userDB);
//          return "redirect:"+referer;
//          return "redirect:"+req.getRequestURL().toString();



   /* @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUses() {
        List<User> allUsers = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView("user-page");
        modelAndView.addObject("allUsers", allUsers);
        return modelAndView;
    }*/
}
