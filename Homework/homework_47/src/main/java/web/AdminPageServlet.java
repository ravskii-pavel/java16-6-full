package web;

import web.dao.DataProvider;
import web.dao.impl.DBDataProviderImpl;
import web.dao.impl.UserDAOImpl;
import web.entity.Gender;
import web.entity.Role;
import web.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ravskiy on 26.05.2017.
 */

@WebServlet(urlPatterns = {"/adminpage"})
public class AdminPageServlet extends HttpServlet {
    /*private DataProvider dataProvider = new DBDataProviderImpl();*/
    private UserDAOImpl userDAO = new UserDAOImpl();
    ArrayList<User> listUsers;
    ArrayList<User> allUsers;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("authUser") != null &&
                ((boolean)req.getSession().getAttribute("authUser") != false) &&
                (req.getSession().getAttribute("userRole")).equals(Role.ADMIN)) {

            listUsers = (ArrayList<User>) (req.getSession().getAttribute("user"));
            allUsers = userDAO.read();
            //allUsers = (ArrayList<User>) (req.getSession().getAttribute("allUsers"));
            req.setAttribute("userList", listUsers);
            req.removeAttribute("userListAll");
            req.setAttribute("userListAll", allUsers);
            req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //--------- for request update user through javascript
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Role role = Role.valueOf(req.getParameter("role"));
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        String actionUser = req.getParameter("action");
        User user = new User(login, name, age, phone, email, password, role, gender);

        if (null != actionUser && actionUser.equals("add")){
            userDAO.create(user);
        }
        else if (null != actionUser && actionUser.equals("update")) {
            //User oldUser = ((ArrayList<User>)req.getSession().getAttribute("userFromJSP")).get(0);

            userDAO.update(user);
            req.getSession().removeAttribute("userList");
            req.getSession().setAttribute("userList", user);
            resp.sendRedirect("/adminpage");
            //req.getRequestDispatcher("/adminpage").forward(req, resp);
            //req.sendRedirect("/adminpage");
            //req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
    }
}
