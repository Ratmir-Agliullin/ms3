package main.servlets;

import main.models.pojo.Admin;
import main.models.pojo.LoginEntity;
import main.services.AdminService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 01.05.2017.
 */
@Controller
public class NewAdminAdd extends HttpServlet{
    private AdminService adminService;
    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }


    @RequestMapping(value = "/newAdminAdd",method = RequestMethod.GET)
    public ModelAndView getLoginAndPass(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", new LoginEntity());
        mav.setViewName("newAdminAdd");
        return mav;
    }


    @RequestMapping(value = "/newAdminAdd",method = RequestMethod.POST)
    public String checkLAP(@ModelAttribute("user") LoginEntity loginEntity, HttpServletRequest req){
        ModelAndView mav = new ModelAndView();
        String pass = BCrypt.hashpw(loginEntity.getPassword(), BCrypt.gensalt());

        Admin admin = new Admin();
        admin.setAdminName(loginEntity.getUsername());
        admin.setAdminPass(pass);
        String nextPath = null;
        if(adminService.AdminLoginRepeatCheck(loginEntity.getUsername())==false) {
            adminService.InsertInAdmin(admin);
            req.getSession().setAttribute("newuser", "Новый администратор: " + loginEntity.getUsername() + " успешно добавлен");
            nextPath = "redirect:newAdminAdded";
        }
        else {
            req.getSession().setAttribute("check", "Ваш логин уже есть в списке пользователей. Выберете другой логин");

            nextPath = "repeatLoginUser";
        }

        return nextPath;

    }

}
