package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shegeda Alexandr (https://www.luxoft.com).
 */
@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {

  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("../userTable.jsp").forward(req, resp);
  }
}
