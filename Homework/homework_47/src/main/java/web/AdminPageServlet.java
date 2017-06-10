package web;

import web.dao.DataProvider;
import web.dao.impl.DBDataProviderImpl;
import web.dao.impl.UserDAOImpl;
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
    String actionUser;
    ArrayList<User> listUsers;
    ArrayList<User> allUsers;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("authUser") != null &&
                ((boolean)req.getSession().getAttribute("authUser") != false) &&
                (req.getSession().getAttribute("userRole")).equals(Role.ADMIN)) {

            listUsers = (ArrayList<User>) (req.getSession().getAttribute("user"));
            allUsers = (ArrayList<User>) (req.getSession().getAttribute("allUsersList"));
            req.setAttribute("userList", listUsers);
            req.setAttribute("userListAll", allUsers);
            req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //--------- for request update user through javascript
        resp.setHeader("Access-Control-Allow-Origin", "*");
        actionUser = req.getParameter("action");
        if (null != actionUser && actionUser.equals("create")){

        }
        else if (null != actionUser && actionUser.equals("update")) {
            //User oldUser = ((ArrayList<User>)req.getSession().getAttribute("userFromJSP")).get(0);
            String login = req.getParameter("login");
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User updateUser = new User(login, name, age, phone, email, password);
            userDAO.update(updateUser);
            req.getSession().setAttribute("userList", updateUser);
            //resp.sendRedirect("/userpage");
            //req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
    }
}
