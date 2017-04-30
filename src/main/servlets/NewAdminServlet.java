package main.servlets;

import main.models.pojo.Admin;
import main.servlets.services.AdminService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 24.04.2017.
 */
@Component
public class NewAdminServlet extends HttpServlet {

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/newAdmin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pass1 = req.getParameter("password");
        String pass = BCrypt.hashpw(pass1, BCrypt.gensalt());
        String login = req.getParameter("username");
        Admin admin = new Admin();
        admin.setAdminName(login);
        admin.setAdminPass(pass);
       // AdminService adminService = new AdminService(adminDAO);
        adminService.InsertInAdmin(admin);

    }
}
