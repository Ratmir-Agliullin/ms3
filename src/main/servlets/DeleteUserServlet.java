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
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String[] id =    req.getParameterValues("value");
        req.setAttribute("id",id[0]);
       // req.getQueryString();
        int delete_id = Integer.parseInt(id[0]);
        UsersDAO usersDAO = new UsersDAO();
        usersDAO.DeleteUserTable(delete_id);
        getServletContext().getRequestDispatcher("/allUsers.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
