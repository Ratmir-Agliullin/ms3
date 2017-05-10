package main.servlets;

import main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 22.04.2017.
 */
@Controller
public class DeleteUserServlet {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping(value = "deleteUser",method = RequestMethod.GET )
    public String getLoginAndPass(@RequestParam int id){
        ModelAndView mav = new ModelAndView();
        userService.DeleteUsers(id);
        mav.setViewName("deleteUser");
        return "redirect:allUsers";
    }

}
