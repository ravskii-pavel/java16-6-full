package ua.com.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.tickets.core.model.*;
import ua.com.tickets.service.HallService;
import ua.com.tickets.service.RowService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @Autowired
    private RowService rowService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getAllHalls(HttpServletRequest req,
                                    @RequestHeader("host") String hostName)
    {
        List<Hall> hallList = hallService.getAllHalls();

        ModelAndView modelAndView = new ModelAndView("management-halls");
        modelAndView.addObject("allHalls", hallList);


       /* for (MovieSession ms: setSessions) {
            uniqueDateDay.add(ms.getSessionStartDate());
        }
        modelAndView.addObject("uniqueDates", uniqueDateDay);*/
        return modelAndView;
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public ModelAndView chengedHall(HttpServletRequest req,
                                   @RequestParam long hallId)
    {
        List<Hall> hallList = hallService.getAllHalls();

        ModelAndView modelAndView = new ModelAndView("management-halls");
        modelAndView.addObject("allHalls", hallList);

       /* for (MovieSession ms: setSessions) {
            uniqueDateDay.add(ms.getSessionStartDate());
        }
        modelAndView.addObject("uniqueDates", uniqueDateDay);*/
        return modelAndView;
    }

    @RequestMapping(value = "/create-rows", method = RequestMethod.POST)
    public ModelAndView createHall(HttpServletRequest req,
                                   @RequestHeader ("referer") String referer,
                                   @RequestParam String hallName,
                                   @RequestParam int quantityRowsInHall){
        Hall hall = new Hall(hallName, quantityRowsInHall);
        hallService.createHall(hall);
        rowService.createListRows(quantityRowsInHall, hall);
        ModelAndView modelAndView = new ModelAndView("management-rows");
        modelAndView.addObject("hall", hall);
        modelAndView.addObject("hall", hall);
       /* for (MovieSession ms: setSessions) {
            uniqueDateDay.add(ms.getSessionStartDate());
        }
        modelAndView.addObject("uniqueDates", uniqueDateDay);*/
        return modelAndView;
    }

    @RequestMapping(value = "/create-seats", method = RequestMethod.POST,  consumes = "application/json")
    public ModelAndView createHall(HttpServletRequest req,
                                   @RequestHeader ("referer") String referer,
                                   @RequestBody List<Seat> seatList){
        /*hall = new Hall(hallName, quantityRowsInHall);
        hallService.createHall(hall);
        rowService.createListRows(quantityRowsInHall, hall);*/
        ModelAndView modelAndView = new ModelAndView("management-rows");
//        modelAndView.addObject("hall", hall);

        return modelAndView;
    }


}
