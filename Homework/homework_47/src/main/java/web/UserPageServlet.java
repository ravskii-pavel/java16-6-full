package web;

import web.dao.DAO;
import web.dao.DataProvider;
import web.dao.impl.DBDataProviderImpl;
import web.dao.impl.UserDAOImpl;
import web.entity.Role;
import web.entity.User;

import javax.inject.Scope;
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
@WebServlet(urlPatterns = {"/userpage"})
public class UserPageServlet extends HttpServlet {
    /*private DataProvider dataProvider = new DBDataProviderImpl();*/
    private UserDAOImpl userDAO = new UserDAOImpl();
    ArrayList<User> listUsers;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("authUser") != null &&
                ((boolean)req.getSession().getAttribute("authUser") != false) &&
                (req.getSession().getAttribute("userRole")).equals(Role.GUEST)){

            listUsers = (ArrayList<User>)(req.getSession().getAttribute("user"));
            req.setAttribute("userList", listUsers);
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //--------- for request update user through javascript
        resp.setHeader("Access-Control-Allow-Origin", "*");

        long id = Long.parseLong(req.getParameter("id"));
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User updateUser = new User(id, login, name, age, phone, email, password);
        userDAO.update(updateUser);
        listUsers.set(0, updateUser);
        req.removeAttribute("userList");
        req.setAttribute("userList", listUsers);
    }
}
