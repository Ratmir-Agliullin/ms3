package main.servlets;

import main.DAO.UsersDAO;
import main.models.Users;
import main.services.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 23.04.2017.
 */
public class NewUserAdd extends HttpServlet{
    /**
     * Create new user
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/newUserAdd.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDAO usersDAO = new UsersDAO();
        String pass1 = req.getParameter("password");
        String pass = BCrypt.hashpw(pass1, BCrypt.gensalt());
        String login = req.getParameter("username");
        Users users = new Users();
        users.setUserName(login);
        users.setPassName(pass);
        UserService userService = new UserService();
        if(userService.UserLoginRepeatCheck(login)==false) {
        usersDAO.InsertUserTable(users);
        req.getSession().setAttribute("newuser", "Новый пользователь: "+ login+" успешно добавлен");
        resp.sendRedirect(req.getContextPath() + "/newUserAdded");}
        else {
            req.getSession().setAttribute("check", "Ваш логин уже есть в списке пользователей. Выберете другой логин");
            resp.sendRedirect(req.getContextPath() + "/repeatLoginUser");
        }
    }
}
