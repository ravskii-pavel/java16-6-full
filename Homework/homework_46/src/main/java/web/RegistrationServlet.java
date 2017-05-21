package web;

import javax.servlet.ServletException;
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
public class RegistrationServlet extends HttpServlet {
    String enter = "Введите Ваш логин и пароль";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        req.setAttribute("enterSystem", enter);
        if (path.contains("registration")) {
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        HttpSession session = req.getSession(true);
        if (path.contains("registration")) {
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            session.setAttribute("userName", name);
            session.setAttribute("userLogin", login);
            session.setAttribute("userEmail", email);
            session.setAttribute("userPassword", password);
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
        else if(req.getParameter("enterEmail").equals(session.getAttribute("userEmail")) &&
                req.getParameter("enterPassword").equals(session.getAttribute("userPassword"))) {
                req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
        else {
             req.setAttribute("enterSystem", "<span style='color: red;'>Incorrect email or password</span>");
             req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
