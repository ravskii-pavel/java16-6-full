package web;

import web.dao.DAO;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.awt.Color.red;

/**
 * Created by java on 12.05.2017.
 */

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    DataProvider dataProvider = new DBDataProviderImpl();
    DAO<User> userDAO = new UserDAOImpl(dataProvider);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     /*   String path = req.getServletPath();
        if (path.contains("registration")) {
        //HttpSession session = req.getSession(true);
        session.setAttribute("userName", name);
        session.setAttribute("userLogin", login);
        session.setAttribute("userEmail", email);
        session.setAttribute("userPassword", password);

        int age1 = Integer.valueOf(req.getParameter("age"));
        int age1 = Integer.valueOf(req.getParameter("age")).intValue() // intValue;
        int age2 = new Integer(req.getParameter("age"));*/

        String login = req.getParameter("login");
        String name = req.getParameter("fullName");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Role role = Role.valueOf(req.getParameter("role"));

        userDAO.create(new User(login, name, age, phone, email, password, role));
        req.getRequestDispatcher("userPage.jsp").forward(req, resp);
     }
}
