package web;

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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("registration.jsp").forward(req, resp);
        //String path = req.getServletPath();
        //req.setAttribute("enterSystem", enter);
        /*if (path.contains("registration")) {
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }*/
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     /*   String path = req.getServletPath();
        if (path.contains("registration")) {*/
        HttpSession session = req.getSession(true);

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
}
