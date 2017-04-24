package main.servlets;

import main.DAO.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 22.04.2017.
 */
public class allUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersDAO usersDAO = new UsersDAO();
        req.setAttribute("users",usersDAO.SelectUserTable());
        getServletContext().getRequestDispatcher("/allUsers.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UsersDAO usersDAO = new UsersDAO();
//       int id = (Integer) req.getAttribute("delete_id");
//        usersDAO.DeleteUserTable(id);

    }
}
