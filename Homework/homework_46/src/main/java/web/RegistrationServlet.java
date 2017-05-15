package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by java on 12.05.2017.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
//        PrintWriter writer = resp.getWriter();
//        writer.println("<h1>Hello World!</h1>");
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
//        PrintWriter writer = resp.getWriter();
//        writer.println("<h1>Hello World!</h1>");
        if (path.contains("registration")) {
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            req.setAttribute("userName", name);
            req.setAttribute("userLogin", login);
            req.setAttribute("userEmail", email);
            req.setAttribute("userPassword", password);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        else {

           // req.setAttribute("userName", req.getAttribute("userName"));
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }


//        PrintWriter writer = resp.getWriter();
//        writer.println(String.format("Hello, %s! Your password length is: %d", login, password.length()));

        //req.setAttribute("userName", login);
        //req.setAttribute("balance", "100$");


    }
}
