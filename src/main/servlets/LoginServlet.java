package main.servlets;

import main.models.pojo.HashCode;
import main.services.AdminService;
import main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 20.04.2017.
 */

@Controller

public class LoginServlet  {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

private HashCode hashCode;
@Autowired
    public void setHashCode(HashCode hashCode) {
        this.hashCode = hashCode;
    }

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView getLoginAndPass(){
        ModelAndView mav = new ModelAndView();


        mav.setViewName("login");
        return mav;
    }




}
