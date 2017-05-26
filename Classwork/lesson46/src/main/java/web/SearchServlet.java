package web;

import com.google.gson.Gson;
import core.entity.Address;
import core.entity.Gender;
import core.entity.Lang;
import core.entity.User;
import core.entity.UserDetails;
import core.entity.UserType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shegeda Alexandr (https://www.luxoft.com).
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

  @Override
  protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    String query = req.getParameter("query");

    System.out.println("query: " + query);

    resp.setContentType("application/json");

    PrintWriter out = resp.getWriter();
    Gson gson = new Gson();

    List<User> userList = Arrays.asList(
      new User(1, "user1@yopmail.com", "****", "user1@yopmail.com", UserType.ADMIN,
               new Address("Ukraine", "Dnepr", "Krasnaya", "21", "341"),
               new UserDetails("Alexandr", "Shegeda", 26, Gender.MALE, Lang.RU, "093-**-**-***"), new Date()),
      new User(1, "user2@yopmail.com", "****", "user2@yopmail.com", UserType.SIMPLE,
               new Address("Ukraine", "Kiev", "Shevchenko", "12", "2"),
               new UserDetails("Petr", "Petrov", 41, Gender.MALE, Lang.RU, "067-**-**-***"), new Date()));

    gson.toJson(filterListByQuery(userList, query), out);
  }

  private List<User> filterListByQuery(final List<User> userList, final String query) {
    List<User> result = new ArrayList<>();
    for (User u : userList) {
      if(u.getLogin().contains(query)) result.add(u);
    }
    return result;
  }
}
