package main.servlets;

import main.DAO.AdminDAO;
import main.models.Admin;
import main.services.AdminService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 24.04.2017.
 */
public class NewAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/newAdmin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminDAO adminDAO = new AdminDAO();
        String pass1 = req.getParameter("password");
        String pass = BCrypt.hashpw(pass1, BCrypt.gensalt());
        String login = req.getParameter("username");
        Admin admin = new Admin();
        admin.setAdminName(login);
        admin.setAdminPass(pass);
        AdminService adminService = new AdminService();
        adminDAO.InsertAdminTable(admin);

    }
}
