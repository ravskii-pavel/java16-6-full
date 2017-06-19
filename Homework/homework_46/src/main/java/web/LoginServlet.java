package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    String enter = "Введите Ваш логин и пароль";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("enterSystem", enter);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        if(req.getParameter("enterEmail").equals(session.getAttribute("userEmail")) &&
           req.getParameter("enterPassword").equals(session.getAttribute("userPassword"))) {
           req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("enterSystem", "<span style='color: red;'>Incorrect email or password</span>");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

}
