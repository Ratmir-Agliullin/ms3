package main.servlets;

import main.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 01.05.2017.
 */
@Controller
public class AllAdmins {
    private AdminService adminService;
    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }



    @RequestMapping(value = "allAdmins",method = RequestMethod.GET)
    public ModelAndView getLoginAndPass(){
        ModelAndView mav = new ModelAndView();


        mav.addObject("users",adminService.SelectAdminsFromTable());
        mav.setViewName("allAdmins");
        return mav;
    }
}
