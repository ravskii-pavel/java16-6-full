package web;

import web.dao.DataProvider;
import web.dao.impl.DBDataProviderImpl;
import web.dao.impl.UserDAOImpl;
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
    private DBDataProviderImpl dbDataProvider;
    String enter = "Введите Ваш логин и пароль";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("enterSystem", enter);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HttpSession session = req.getSession(true);
        String login = req.getParameter("enterLogin");
        String password = req.getParameter("enterPassword");
        dbDataProvider.getSession();//!!!!!!!!!!!!!!!!
        UserDAOImpl userDAO = new UserDAOImpl(getDB);
        ArrayList<User> listUsers = userDAO.getByLogin(login);

        if(req.getParameter("enterLogin").equals(getBy) &&
           req.getParameter("enterPassword").equals(session.getAttribute("userPassword"))) {
           req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("enterSystem", "<span style='color: red;'>Incorrect email or password</span>");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

}
