package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by java on 12.05.2017.
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.println("<h1>Hello World!</h1>");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String name = req.getParameter("login");
        req.setAttribute("userName", name);*/

//        PrintWriter writer = resp.getWriter();
//        writer.println(String.format("Hello, %s! Your password length is: %d", login, password.length()));

        //req.setAttribute("userName", login);
        //req.setAttribute("balance", "100$");
        /*if(req.getParameter("sign in").equals("Sign in")){
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else if(req.getParameter("registration").equals("Registration")){
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }*/
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
