package main.servlets;

import main.services.AdminService;
import main.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 20.04.2017.
 */
//@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    /**
     *
     * Login for users and admins
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
       req.getRequestDispatcher("/login.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass = req.getParameter("password");
        String login = req.getParameter("username");

        UserService userService = new UserService();
        AdminService adminService = new AdminService();
        String checkUserAdmin = "Не авторизованный пользователь. Авторизуйтесь!";
        String afterAuthURL = "/newUserAdd";
        if (userService.UserAuthCheck(login,pass)){
            checkUserAdmin = "Пользователь";
            afterAuthURL = "/userInfo";
        } else
        if (adminService.AdminAuthCheck(login,pass)) {
            checkUserAdmin = "Администратор";
            afterAuthURL = "/allUsers";
        } else
        if(userService.UserLoginRepeatCheck(login)==true){
            req.getSession().setAttribute("check", "Ваш логин уже есть в списке пользователей. Выберете другой логин");
                afterAuthURL = "/repeatLoginUser";
        }

        req.getSession().setAttribute("check", checkUserAdmin);
        resp.sendRedirect(req.getContextPath() + afterAuthURL);
    }
}
