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
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ravskiy on 26.05.2017.
 */

@WebServlet(urlPatterns = {"/userpage"})
public class UserPageServlet extends HttpServlet {
    private DataProvider dataProvider = new DBDataProviderImpl();
    private UserDAOImpl userDAO = new UserDAOImpl(dataProvider);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("authUser") != null &&
                ((boolean)req.getSession().getAttribute("authUser") != false)){
            req.getRequestDispatcher("userPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User oldUser = ((ArrayList<User>)req.getSession().getAttribute("userFromJSP")).get(0);
        String loginOldUser = oldUser.getLogin();
        String name = req.getParameter("fullName");
        int age = Integer.parseInt(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        ArrayList<User> updateUser = new ArrayList<>();
        updateUser.add(new User(loginOldUser, name, age, phone, email, password));
        userDAO.update(updateUser.get(0));
        req.getSession().setAttribute("userList", updateUser);
        //resp.sendRedirect("/userpage");
        req.getRequestDispatcher("userPage.jsp").forward(req, resp);

        //ArrayList<User> listUsers = userDAO.getByLogin(login); //Exception if haven't user

        //User userFromDB = listUsers.get(0);
        //String loginDB = userFromDB.getLogin();
        //String passwordDB = userFromDB.getPassword();

        //req.getRequestDispatcher("userPage.jsp").forward(req, resp);
      /*  ArrayList<User> userList = (ArrayList<User>)req.getSession().getAttribute("userjsp");
        System.out.println(userList.get(0).getLogin());
        System.out.println(userList.get(0).getId());
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println(age);
        req.getRequestDispatcher("userPage.jsp").forward(req, resp);*/
    }
}
