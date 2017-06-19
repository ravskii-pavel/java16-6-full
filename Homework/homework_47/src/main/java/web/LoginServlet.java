package web;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
import java.util.ArrayList;

/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private DAO<User> userDAO = new UserDAOImpl();
    private String enter = "Введите Ваш логин и пароль";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("enterSystem", enter);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("enterLogin");
        String password = req.getParameter("enterPassword");
        ArrayList<User> listUsers = userDAO.getByLogin(login); //Exception if haven't user
        //ArrayList<User> allUsers = userDAO.read();
        User userFromDB = listUsers.get(0);
        Role userRole = userFromDB.getRoleUser();
        String loginDB = userFromDB.getLogin();
        String passwordDB = userFromDB.getPassword();

        if(login.equals(loginDB) &&  password.equals(passwordDB)) {
            if (userRole.equals(Role.GUEST)){
                req.getSession().setAttribute("user", listUsers);
                req.getSession().setAttribute("userLogin", loginDB);
                req.getSession().setAttribute("userRole", userRole);
                req.getSession().setAttribute("authUser", true);
                resp.sendRedirect("/userpage");
            }
            else if (userRole.equals(Role.ADMIN)){
                req.getSession().setAttribute("user", listUsers);
                req.getSession().setAttribute("userLogin", loginDB);
                req.getSession().setAttribute("userRole", userRole);
                req.getSession().setAttribute("authUser", true);
                resp.sendRedirect("/adminpage");
            }
        }
        else {
            req.setAttribute("enterSystem", "<span style='color: red;'>Incorrect email or password</span>");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}

/*
session.invalidate();*/
