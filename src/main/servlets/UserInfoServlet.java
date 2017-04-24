package main.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 23.04.2017.
 */
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  String login = (String) req.getAttribute("login");
      //  String pass = (String) req.getAttribute("pass");
      //  req.getSession().setAttribute("check", login+" 1013 "+ pass);//+" "+userService.UserAuthCheck(login,pass));
        req.getRequestDispatcher("/userInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
