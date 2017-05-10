package main.servlets;

import main.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 01.05.2017.
 */
@Controller
public class DeleteAdmin {
    private AdminService adminService;
    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "deleteAdmin",method = RequestMethod.GET )
    public String getLoginAndPass(@RequestParam int id){
        ModelAndView mav = new ModelAndView();
        adminService.DeleteAdminById(id);
        mav.setViewName("deleteAdmin");
        return "redirect:allAdmins";
    }

}
